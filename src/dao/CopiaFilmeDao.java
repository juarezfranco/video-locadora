package dao;

import entidade.CopiaFilme;
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
public class CopiaFilmeDao {
   private static final String TABELA = "copia_filmes";
   private static PreparedStatement comando;
   private static ResultSet result;
   
   public static boolean inserir(CopiaFilme copiaFilme, int quantidade){
      String sql = "INSERT INTO copia_filmes (filmeId, valor_aquisicao, estado, data_aquisicao) "
              + "VALUES (?,?,?,?)";
      
              
       
      try{
            for(int i=0;i<quantidade;i++){
               comando = Bd.getConexao().prepareStatement(sql);
               comando.setInt(1, copiaFilme.getFilme().getId());
               comando.setFloat(2, copiaFilme.getValorAquisicao());
               if(copiaFilme.getEstado()==null)
                  comando.setString(3, "");
               else
                  comando.setString(3, copiaFilme.getEstado()+"");
               comando.setTimestamp(4, copiaFilme.getDataAquisicao());

               //Executa o comando de inserção de acordo com a quantidade que é pra ser inserido
                comando.executeUpdate();
               //verifica se existe alguma reserva na lista de espera
               ListaEsperaDeReservasDao.atenderListaDeEsperaDeReservas(copiaFilme.getFilme().getId(), getUltimoSequencial());
            }
         
         comando.close();
         
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe CopiaFilmeDao - Método: inserir", e);
         return false;
      }
      
      
   }
   public static boolean remover(int id){
      String sql = "DELETE FROM copia_filmes WHERE id=?";
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, id);
         comando.executeUpdate();
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe CopiaFilmeDao - Método: remover", e);
         return false;
      }
      
   }
   public static ArrayList<CopiaFilme> getCopiasFilmes(int idFilme){
      //retorna copia que possui id do filme
      //sql = "SELECT id, filmeId, data_aquisicao, valor_aquisicao, estado, motivo_remocao FROM "+TABELA+" WHERE filmeId=? ";
      String sql = "SELECT * FROM "+TABELA+" WHERE filmeId=? OR ?=?";
      int CONDICAO_PESQUISA_TODOS = -1;
      CopiaFilme copiaFilme = null;
      ArrayList<CopiaFilme> arrayCopias = new ArrayList<CopiaFilme>();
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, idFilme);
         comando.setInt(2, CONDICAO_PESQUISA_TODOS);
         comando.setInt(3, idFilme);
         result = comando.executeQuery();
         while( result.next() ){
            copiaFilme = new CopiaFilme();
            copiaFilme.setId(result.getInt("id"));
            copiaFilme.setFilme(FilmeDao.getFilme(result.getInt("filmeId")));
            copiaFilme.setDataAquisicao(result.getTimestamp("data_aquisicao"));
            copiaFilme.setEstado(result.getString("estado"));
            copiaFilme.setValorAquisicao(result.getFloat("valor_aquisicao"));
            copiaFilme.setMotivo_remocao(result.getString("motivo_remocao"));
            arrayCopias.add(copiaFilme);
         }
         result.close();
         comando.close();
         
         return arrayCopias;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe CopiaFilmeDao - Método: getCopiasFilmes", e);
         return arrayCopias;
      }
   }
   
   public static CopiaFilme getCopiaFilme(int idCopia){
      String sql = "SELECT * FROM "+TABELA+" WHERE id=? ";
      CopiaFilme copiaFilme = null;
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, idCopia);
         result = comando.executeQuery();
         while(result.next()){
            copiaFilme = new CopiaFilme();
            copiaFilme.setId(result.getInt("id"));
            copiaFilme.setFilme(FilmeDao.getFilme(result.getInt("filmeId")));
            copiaFilme.setDataAquisicao(result.getTimestamp("data_aquisicao"));
            copiaFilme.setEstado(result.getString("estado"));
            copiaFilme.setValorAquisicao(result.getFloat("valor_aquisicao"));
            copiaFilme.setMotivo_remocao(result.getString("motivo_remocao"));
         }
         result.close();
         comando.close();
         return copiaFilme;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe CopiaFilmeDao - Método: getCopiaFilme", e);
         return copiaFilme;
      }
      
   }
   
   public static boolean alterar(CopiaFilme copiaFilme){
      String sql = "UPDATE "+TABELA+" SET "
              + "filmeId=?, data_aquisicao=?, valor_aquisicao=?, estado=?, motivo_remocao=? "
              + "WHERE id= ?";
      try{
         comando = Bd.getConexao().prepareStatement(sql);
        
         comando.setInt(1, copiaFilme.getFilme().getId());
         comando.setTimestamp(2, copiaFilme.getDataAquisicao());
         comando.setFloat(3, copiaFilme.getValorAquisicao());
         comando.setString(4, copiaFilme.getEstado()+"");
         comando.setString(5, copiaFilme.getMotivo_remocao());
         comando.setInt(6,copiaFilme.getId());
         comando.executeUpdate();
         comando.close();
                
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe CopiaFilmeDao - Método: alterarCopiaFilme", e);
         return false;
      }
   }
   
   public static int getUltimoSequencial(){
      String sql = "SELECT MAX(id) FROM copia_filmes ";
      int ultimoSequencial;
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         ResultSet resultado = comando.executeQuery();
         while(resultado.next()){
            ultimoSequencial =resultado.getInt(1);
            comando.close();
            resultado.close();
            return ultimoSequencial;
         }
         comando.close();
         resultado.close();
         return 0;
      }catch(SQLException e ){
         MensagensPopup.showMensagemErro("Erro Classe: CopiaFilmeDao -> Método: getUltimoSequencial", e);
         return 0;
      }
   }
   
}

