package dao;

import entidade.CopiaFilme;
import entidade.Reserva;
import interfaces.JanelaCadastroReservas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.Bd;
import util.MensagensPopup;

public class CopiasReservadasDao {
   
   public static boolean tentaReservarAlgumaCopia(Reserva reserva){
     // se existir alguma copia disponivel entao reserva ela para o cliente
      String sql = "SELECT * FROM copia_filmes c, filmes f "
              + "WHERE f.id = c.filmeId AND c.estado = 'disponivel' AND f.id = ?";
      
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, reserva.getFilme().getId());
         ResultSet resultado = comando.executeQuery();
         
         while(resultado.next()){
            inserir(reserva.getCliente().getCpf(), resultado.getInt("c.id"));
            comando.close();
            resultado.close();
            JOptionPane.showMessageDialog(null, "Uma cópia foi reservada.");
            return true;
         }
         //se nao existir alguma copia para reservar entao deixa a reserva na lista de espera
         if(ListaEsperaDeReservasDao.inserir(reserva.getId())){
            JOptionPane.showMessageDialog(null, "No momento não existe cópias deste filme disponiveis, mas assim que alguma estiver disponivel automaticamente o sistema ira reserva-la");
         }
         comando.close();
         resultado.close();
         return true;
      }catch(SQLException e ){
         MensagensPopup.showMensagemErro("Erro Classe: CopiasReservadasDao -> Método: tentaReservar", e);
         return false;
      }
   }
   public static boolean inserir(String idCliente, int idCopia){
      String sql = "INSERT INTO copias_reservadas (clienteId, copia_filmeId) VALUES(?,?)";
      PreparedStatement comando;
      CopiaFilme copia = CopiaFilmeDao.getCopiaFilme(idCopia);
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, idCliente);
         comando.setInt(2, idCopia);
         comando.executeUpdate();
         comando.close();
         copia.setEstado(CopiaFilme.Estado.reservada);
         CopiaFilmeDao.alterar(copia);
         return true;
      }catch(SQLException e ){
         MensagensPopup.showMensagemErro("Erro Classe: CopiasReservadasDao -> Método: inserir", e);
         return false;
      }
      
   }
   public static boolean remover(String idCliente,int idFilme){
      String sql = "DELETE FROM copias_reservadas WHERE clienteId = ? AND copia_filmeId = ?";
      CopiaFilme copia = getCopiaReservada(idCliente, idFilme);
      String sql2 = "SELECT cr.copia_filmeId FROM copias_reservadas cr, filmes f WHERE clienteId = ? AND"
              + "f.id = ? AND";
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, idCliente);
         comando.setInt(2, copia.getId());
         
         
         
         ReservaDao.remover(idCliente,idFilme);
         copia.setEstado(CopiaFilme.Estado.disponivel);
         CopiaFilmeDao.alterar(copia);
         
         comando.executeUpdate();
         comando.close();
         
         return true;
      }catch(SQLException e ){
         MensagensPopup.showMensagemErro("Erro Classe: CopiasReservadasDao -> Método: remover", e);
         return false;
      }
   } 
   public static CopiaFilme getCopiaReservada(String idCliente, int idFilme){
      String sql = "SELECT cf.id FROM copias_reservadas cr, clientes cli, copia_filmes cf, filmes f WHERE"
                 + " cr.clienteId = cli.cpf AND cr.copia_filmeId = cf.id AND cr.clienteId = ? AND cf.filmeId = ? "
              + " LIMIT 1";
      CopiaFilme copia = null;
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, idCliente);
         comando.setInt(2, idFilme);
         ResultSet resultado = comando.executeQuery();
         while(resultado.next()){
            copia = CopiaFilmeDao.getCopiaFilme(resultado.getInt(1));
         }
         
         comando.close();
         resultado.close();
         return copia;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: CopiasReservadasDao -> Método: getCopiaReservada", e);
         return copia;
      }
   }
   public static ArrayList<CopiaFilme> getTodasAsCopiasReservadasDoCliente(String idCliente){
      String sql = "SELECT * FROM copias_reservadas WHERE clienteId = ?";
      CopiaFilme copia;
      ArrayList<CopiaFilme> arrayCopias= new ArrayList<CopiaFilme>();
      try{
         PreparedStatement comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, idCliente);
         ResultSet resultado = comando.executeQuery();
         while(resultado.next()){
            copia = new CopiaFilme();
            copia = CopiaFilmeDao.getCopiaFilme(resultado.getInt("copia_filmeId"));
            arrayCopias.add(copia);
         }
         comando.close();
         resultado.close();
         return arrayCopias;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro Classe: CopiasReservadasDao -> Método: getTodasAsCopiaReservada", e);
         return null;
      }
   }
}

