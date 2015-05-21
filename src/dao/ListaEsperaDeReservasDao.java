package dao;

import entidade.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import persistencia.Bd;
import util.MensagensPopup;

public class ListaEsperaDeReservasDao {
   private static final String TABLE = "lista_espera_de_reservas";
   
   public static boolean atenderListaDeEsperaDeReservas(int idFilme, int idCopia){
      //BUSCA RESERVA QUE ESTA NA ESPERA DE RESERVAS.
      
      String sql = "SELECT * FROM "+TABLE+" l, filmes f, reservas r, clientes c "
                 + "WHERE  l.reservaId = r.id AND r.clienteId = c.cpf AND r.filmeId =f.id AND f.id=? ORDER BY l.id ";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, idFilme);
         ResultSet resultado = comando.executeQuery();
         while(resultado.next()){
            String idCliente = resultado.getString("c.cpf");
            CopiasReservadasDao.inserir(idCliente, idCopia);
            remover(resultado.getInt("l.id"));
            comando.close();
            resultado.close();
            return true;
         }
         comando.close();
         resultado.close();
         return false;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ListEsperaDeReservasDao -> Método: atenderListaDeReservas", e);
         return false;
      }
      
   }
   
   
   public static boolean inserir(int idReserva){
      String sql = "INSERT INTO "+TABLE+" (reservaId) VALUES(?)";
      Calendar calendar = Calendar.getInstance();
      
      Timestamp data = new Timestamp(calendar.getTimeInMillis());
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, idReserva);
         comando.executeUpdate();
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ListEsperaDeReservasDao -> Método: inserir", e);
         return false;
      }
   }
   public static boolean remover(Reserva reserva){
      String sql = "DELETE FROM "+TABLE+" WHERE reservaId = ?";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, reserva.getId());
         comando.executeUpdate();
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ListEsperaDeReservasDao -> Método: remover", e);
         return false;
      }
      
   }
   public static boolean remover(int idEsperaDeReservas){
      String sql = "DELETE FROM "+TABLE+" WHERE id = ?";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, idEsperaDeReservas);
         comando.executeUpdate();
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: ListEsperaDeReservasDao -> Método: remover", e);
         return false;
      }
      
   }
}
