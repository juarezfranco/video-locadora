package dao;


import entidade.Cliente;
import entidade.CopiaFilme;
import entidade.Locacao;
import entidade.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import persistencia.Bd;

public class LocacaoDao {
   private static PreparedStatement comando;
   private static ResultSet resultado;
   private static String sql;
   private final static String TABELA = "locacao";
   
   public static boolean inserir(Locacao locacao){
      ArrayList<CopiaFilme> arrayCopias = locacao.getArrayCopiasFilmes();
      String sql = "INSERT INTO "+TABELA+" (clienteId, copia_filmesId, data) VALUES (?,?,?)";
      
      
         for(CopiaFilme copia : arrayCopias){
            try{
               PreparedStatement comando;
               comando = Bd.getConexao().prepareStatement(sql);
               comando.setString(1, locacao.getCliente().getCpf());
               comando.setInt(2, copia.getId());
               comando.setTimestamp(3, locacao.getData());
               comando.executeUpdate();
               comando.close();
               
            }catch(SQLException e){
               util.MensagensPopup.showMensagemErro("Erro classe: LocacaoDao -> Método: inserir", e);
               return false;
            }
            //remove reserva da copia caso estiver sido reservada
            if(copia.getEstado()==CopiaFilme.Estado.reservada){
               CopiasReservadasDao.remover(locacao.getCliente().getCpf(), copia.getFilme().getId());
            }
            copia.setEstado(CopiaFilme.Estado.locada);
            CopiaFilmeDao.alterar(copia);
            
         }
         return true;
   }
   public static boolean remover(int idLocacao){
      String sql = "DELETE FROM "+TABELA+" WHERE id = ? LIMIT 1";
      CopiaFilme copiaFilme = getLocacao(idLocacao).getCopiaFilme();
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, idLocacao);
         comando.executeUpdate();
         comando.close();
         //altera o estado da copia do filme para disponivel
         copiaFilme.setEstado(CopiaFilme.Estado.disponivel);
         CopiaFilmeDao.alterar(copiaFilme);
         ListaEsperaDeReservasDao.atenderListaDeEsperaDeReservas(copiaFilme.getFilme().getId(), copiaFilme.getId());
         return true;
      }catch(SQLException e){
         util.MensagensPopup.showMensagemErro("Erro classe: LocacaoDao -> Método: remover", e);
         return false;
      }
   }
   public static Locacao getLocacao(int idLocacao){
      sql = "SELECT id, clienteId, copia_filmesId, data FROM "+TABELA+" WHERE id =?";
      PreparedStatement comando=null;
      ResultSet resultado = null;
      Locacao locacao = new Locacao();
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, idLocacao);
         resultado = comando.executeQuery();
         while(resultado.next()){
            locacao = new Locacao();
            locacao.setId(idLocacao);
            locacao.setCliente(ClienteDao.getCliente(resultado.getString("clienteId")));
            locacao.setCopiaFilme(CopiaFilmeDao.getCopiaFilme(resultado.getInt("copia_filmesId")));
            locacao.setData(resultado.getTimestamp("data"));
         }
         comando.close();
         resultado.close();
         return locacao;
      }catch(SQLException e){
         util.MensagensPopup.showMensagemErro("Erro classe: LocacaoDao -> Método: geLocacao", e);
         return locacao;
      }
   }
   public static ArrayList<Locacao> getLocacaoCliente(String cpfCliente){
      String sql = "SELECT id, copia_filmesId, data FROM "+TABELA+" WHERE clienteId = ?";
      ResultSet resultado = null;
      ArrayList<Locacao> arrayLocacoes = new ArrayList<>();
      Cliente cliente = ClienteDao.getCliente(cpfCliente);
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, cpfCliente);
         resultado = comando.executeQuery();
         while(resultado.next()){
            Locacao locacao = new Locacao();
            locacao.setId(resultado.getInt("id"));
            locacao.setCliente(cliente);
            locacao.setCopiaFilme(CopiaFilmeDao.getCopiaFilme(resultado.getInt("copia_filmesId")));
            locacao.setData(resultado.getTimestamp("data"));
            arrayLocacoes.add(locacao);
         }
         comando.close();
         resultado.close();
         return arrayLocacoes;
      }catch(SQLException e){
         util.MensagensPopup.showMensagemErro("Erro classe: LocacaoDao -> Método: getLocacaoCliente", e);
         return arrayLocacoes;
      }
      
   }
   public static ArrayList<Locacao> getLocacoes(String cpfCliente, int idFilme){
      String sql= "SELECT l.id, c.cpf, cf.id, l.data FROM locacao l , clientes c, filmes f, copia_filmes cf WHERE l.clienteId = c.cpf AND l.copia_filmesId = cf.id AND ";
      ArrayList<Locacao> arrayLocacoes = new ArrayList<Locacao>();
      Locacao locacao;
      int index =0;
      if(cpfCliente!=null){
         sql+= "c.cpf = ? AND ";
      }
      if(idFilme!=-1){
         sql+= "f.id =? AND ";
      }
      sql+="cf.filmeId = f.id ORDER BY l.data ";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         if(cpfCliente!=null){
            index++;
            comando.setString(index, cpfCliente);
         }
         if(idFilme!=-1){
            index++;
            comando.setInt(index,idFilme);
         }
         ResultSet resultado = comando.executeQuery();
         while(resultado.next()){
            locacao = new Locacao();
            locacao.setId(resultado.getInt("l.id"));
            locacao.setCliente(ClienteDao.getCliente(resultado.getString("c.cpf")));
            locacao.setCopiaFilme(CopiaFilmeDao.getCopiaFilme(resultado.getInt("cf.id")));
            locacao.setData(resultado.getTimestamp("l.data"));
            arrayLocacoes.add(locacao);
         }
         comando.close();
         resultado.close();
         return arrayLocacoes;
      }catch(SQLException e){
         util.MensagensPopup.showMensagemErro("Erro classe: LocacaoDao -> Método: getLocacoes", e);
         return arrayLocacoes;
      }
   }
   

}

