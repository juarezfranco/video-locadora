package dao;


import entidade.Cliente;
import entidade.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.Bd;
import util.MensagensPopup;
/**
 *
 * @author juarez
 */
public class ReservaDao {
   public static int getUltimoSequencial(){
      String sql = "SELECT MAX(id) FROM reservas";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         ResultSet resultado = comando.executeQuery();
         int ultimoSequencial=-1;
         while(resultado.next()){
            ultimoSequencial = resultado.getInt(1);
         }
         resultado.close();
         comando.close();
         return ultimoSequencial;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: ultimoSequencia", e);
         return -1;
      }
   }
   
   
   
   public static boolean inserir(Reserva reserva){
      String sql = "INSERT INTO reservas (clienteId, filmeId, data) VALUES (?,?,?)";
     
      try{
         PreparedStatement  comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, reserva.getCliente().getCpf());
         comando.setInt(2, reserva.getFilme().getId());
         comando.setTimestamp(3, reserva.getData());
         comando.executeUpdate();
         comando.close();
         
         CopiasReservadasDao.tentaReservarAlgumaCopia(getReserva(getUltimoSequencial()));
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: inserirReserva", e);
         return false;
      }
   }
   
   public static boolean alterar(Reserva reserva){
      String sql = "UPDATE reservas SET clienteId =? , filmeId = ? WHERE id = ?";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, reserva.getCliente().getCpf());
         comando.setInt(2, reserva.getFilme().getId());
         comando.setInt(3, reserva.getId());
         comando.executeUpdate();
         comando.close();
        
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: alterarReserva", e);
         return false;
      }
         
      
   }
   public static boolean remover(String idCliente, int idFilme){
      Reserva reserva = getReserva(idCliente, idFilme);
      String sql = "DELETE FROM reservas WHERE clienteId = ? AND filmeId = ?";
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, idCliente);
         comando.setInt(2, idFilme);
         ListaEsperaDeReservasDao.remover(reserva);
         comando.executeUpdate();
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: removerReserva.", e);
         return false;
      }
   }
   public static boolean remover(int id){
      String sql="DELETE FROM reservas WHERE id = ? ";
      Reserva reserva = getReserva(id);
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, id);
         CopiasReservadasDao.remover(reserva.getCliente().getCpf(), reserva.getFilme().getId());
         ListaEsperaDeReservasDao.remover(reserva);
         comando.executeUpdate();
         comando.close();
         
         
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: removerReserva", e);
         return false;
      }
   }
   public static Reserva getReserva(String idCliente, int idFilme){
      String sql = "SELECT * FROM reservas WHERE clienteId = ? AND filmeId = ?";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, idCliente);
         comando.setInt(2, idFilme);
         ResultSet resultado;
         resultado = comando.executeQuery();
         Reserva reserva = new Reserva();
         while(resultado.next()){
            reserva.setId(resultado.getInt("id"));
            reserva.setCliente(ClienteDao.getCliente(resultado.getString("clienteId")));
            reserva.setFilme(FilmeDao.getFilme(resultado.getInt("filmeId")));
            reserva.setData(resultado.getTimestamp("data"));
         }
         resultado.close();
         comando.close();
         return reserva;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: getReservas", e);
         return null;
      }
   }
   public static Reserva getReserva(int id){
      String sql = "SELECT * FROM reservas WHERE id = ? LIMIT 1";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, id);
         ResultSet resultado;
         resultado = comando.executeQuery();
         Reserva reserva = new Reserva();
         while(resultado.next()){
            reserva.setId(resultado.getInt("id"));
            reserva.setCliente(ClienteDao.getCliente(resultado.getString("clienteId")));
            reserva.setFilme(FilmeDao.getFilme(resultado.getInt("filmeId")));
            reserva.setData(resultado.getTimestamp("data"));
         }
         resultado.close();
         comando.close();
         return reserva;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: getReservas", e);
         return null;
      }
   }
   public static Reserva getReservaDoFilme(int idCopiaFilme){
      String sql = "SELECT id, clienteId FROM reservas WHERE filmeId=? LIMIT 1";
      Reserva reservaDaCopia = null;
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, idCopiaFilme);
         ResultSet resultado;
         resultado = comando.executeQuery();
         while(resultado.next()){
            reservaDaCopia = new Reserva();
            reservaDaCopia.setId(resultado.getInt("id"));
            reservaDaCopia.setCliente(ClienteDao.getCliente(resultado.getString("clienteId")));
            reservaDaCopia.setFilme(FilmeDao.getFilme(idCopiaFilme));
            
         }
         comando.close();
         resultado.close();
         return reservaDaCopia;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: getReservaDaCopia", e);
         return reservaDaCopia;
      }
   }
   
   
   public static ArrayList<Object[]> consultarReservas(String cpf_cliente, int id_filme, String assunto_filme, int pontoInicial, int quantidade){
      String sql = "SELECT r.id, cli.nome, f.id, f.titulo, f.assunto, r.data "
              + " FROM clientes cli, filmes f, reservas r "
              + " WHERE "
              + " r.clienteId = cli.cpf AND";
      
      ArrayList<Object[]> reservasSelecionadas = new ArrayList();
      
      if(cpf_cliente!=null){
         sql+=" r.clienteId = ? AND ";
      }
      if(id_filme!=-1){
         sql+=" f.id = ? AND ";
      }
      if(assunto_filme!=null){
         sql+=" f.assunto = ? AND ";
      }
      
      sql+=" r.filmeId = f.id ORDER BY cli.nome LIMIT ?,? ";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
      
         int index=0;
         if(cpf_cliente!=null){
            index++;
            comando.setString(index, cpf_cliente);
         }
         if(id_filme!=-1){
            index++;
            comando.setInt(index, id_filme);
         }
         if(assunto_filme!=null){
            index++;
            comando.setString(index, assunto_filme);
         }
         index++;
         comando.setInt(index, pontoInicial);
         index++;
         comando.setInt(index, quantidade);
         ResultSet resultado = comando.executeQuery();
         while(resultado.next()){
            Object[] lista = new Object[6];
            lista[0] = resultado.getInt("r.id");
            lista[1] = resultado.getString("cli.nome");
            lista[2] = resultado.getString("f.id");
            lista[3] = resultado.getString("f.titulo");
            lista[4] = resultado.getString("f.assunto");
            lista[5] = resultado.getTimestamp("r.data");
            reservasSelecionadas.add(lista);
         }
         resultado.close();
         comando.close();
      return reservasSelecionadas;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: consultaReservas", e);
         return null;
      }
   }
   
   public static boolean verificaSeClienteLocouFilme(Reserva reserva){
      String sql = "SELECT * FROM reservas r, filmes f, clientes c "
              + " WHERE r.clienteId = c.cpf AND r.filmeId = f.id AND "
              + "r.filmeId = ? AND r.clienteId=? LIMIT 1";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, reserva.getFilme().getId());
         comando.setString(2, reserva.getCliente().getCpf());
         ResultSet resultado = comando.executeQuery();
         while(resultado.next()){
            comando.close();
            resultado.close();
            return true;
         }
         comando.close();
         resultado.close();
         return false;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ReservaDao -> Método: verificaSeClienteLocouFilme", e);
         return false;
      }
   
   }
}





