package dao;

import entidade.Cliente;
import entidade.Visao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import persistencia.Bd;
import util.MensagensPopup;

/**
 *
 * @author juarez
 */
public class ClienteDao {

   private static PreparedStatement comando = null;
   private static String sql;

   public static boolean inserir(Cliente cliente) {
     
      
      sql = "INSERT INTO clientes (cpf, nome, endereco, telefone)"
              + "VALUES (?,?,?,?);";
      
      try {
         //prepara comando para inserção
         comando = Bd.getConexao().prepareStatement(sql);

         //insere valores no lugar da interrogação (?) do sql 
         comando.setString(1, cliente.getCpf());
         comando.setString(2, cliente.getNome());
         comando.setString(3, cliente.getEndereco());
         comando.setString(4, cliente.getTelefone());

         comando.execute();
         comando.close();
         
         return true;
      } catch (SQLException e) {
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: inserir", e);
         return false;
      }

   }
   
   public static boolean alterar(Cliente cliente){
      
      sql = "UPDATE clientes SET nome = ? , endereco = ? , telefone = ? WHERE cpf = ?";
      
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, cliente.getNome());
         comando.setString(2, cliente.getEndereco());
         comando.setString(3, cliente.getTelefone());
         comando.setString(4, cliente.getCpf());
         
         comando.executeUpdate();
         
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: alterar", e);
         return false;
      }
   }
   
   public static boolean deletar(String cpf){
      if(verificaDependencia(cpf)){
         
         return false;
      }
      sql = "DELETE FROM clientes where cpf = ?";
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, cpf);
         
         comando.executeUpdate();
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: deletar", e);
         return false;
      }
   }
   
   public static Cliente getCliente(String cpf){
      sql = "SELECT * FROM clientes WHERE cpf = ? LIMIT 1";
      
      ResultSet result = null;
      try{
         //prepara comando sql
         comando = Bd.getConexao().prepareStatement(sql);
         //substitui pontos de interrogação da String sql
         comando.setString(1, cpf);
         
         //executa comando sql e filtra clientes com cpf igual.
         result = comando.executeQuery();
         //caso ouver algum cliente com cpf identico ao que foi passado no paramentro entao o laço a seguir será executado
         while(result.next()){
            Cliente cliente= new Cliente();
            cliente.setNome(result.getString("nome"));
            cliente.setCpf(result.getString("cpf"));
            cliente.setEndereco(result.getString("endereco"));
            cliente.setTelefone(result.getString("telefone"));
            
            result.close();
            comando.close();
            return cliente;
         }
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: getCliente", e);
         return null;
      }
      return null;
   }
   
   public static ArrayList<Cliente> getClientes(String campo,  String str, int pontoInicial, int quantidade){
      
      if(campo.compareToIgnoreCase("cpf")==0)
         sql = "SELECT * FROM clientes WHERE cpf LIKE ? ORDER BY cpf LIMIT ?,?";
      else
         sql = "SELECT * FROM clientes WHERE nome LIKE ? ORDER BY nome LIMIT ?,?";
      
      ArrayList<Cliente> clientes = new ArrayList();
      ResultSet resultado = null;
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, str+"%");
         comando.setInt(2, pontoInicial);
         comando.setInt(3, quantidade);
         resultado = comando.executeQuery();
         
         while(resultado.next()){
            Cliente cliente = new Cliente();
            cliente.setCpf(resultado.getString("cpf"));
            cliente.setNome(resultado.getString("nome"));
            cliente.setEndereco(resultado.getString("endereco"));
            cliente.setTelefone(resultado.getString("telefone"));
            clientes.add(cliente);
         }
         resultado.close();
         comando.close();
         return clientes;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: getClientes", e);
         return null;
      }
   }
   
   public static ArrayList<Cliente> getClientes(String campo, String str) {
      
      //verificar se o valor de campo é cpf ou nome 
      if(campo.compareToIgnoreCase("cpf")==0)
         sql = "SELECT * FROM clientes WHERE cpf LIKE ? ORDER BY cpf";
      else
         sql = "SELECT * FROM clientes WHERE nome LIKE ? ORDER BY nome";
      
      ArrayList<Cliente> clientes = new ArrayList();
      ResultSet resultado = null;
      try {
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, str + "%"); //a concatenação do porcento deve ser feito aqui
         resultado = comando.executeQuery();

         while (resultado.next()) {
            Cliente cliente = new Cliente();
            cliente.setCpf(resultado.getString("cpf"));
            cliente.setNome(resultado.getString("nome"));
            cliente.setEndereco(resultado.getString("endereco"));
            cliente.setTelefone(resultado.getString("telefone"));

            clientes.add(cliente);
         }

         resultado.close();
         comando.close();
         return clientes;
      } catch (SQLException e) {
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: getClientes", e);
         return null;
      }
      
   }
   
   public static int getTotalRegistros(){
      sql = "SELECT COUNT(cpf) FROM clientes";
      ResultSet resultado = null;
      int total=0;
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         resultado = comando.executeQuery();
         while(resultado.next()){
            total=resultado.getInt(1);
         }
         resultado.close();
         comando.close();
         return total;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: getTotalRegistros", e);
         return 0;
      }
   }
   
   public static Vector<Visao<String>> getVisoes(){
      sql = "SELECT cpf, nome FROM clientes";
      Vector<Visao<String>> visoes = new Vector<Visao<String>>();
      String cpf, nome;
      ResultSet resultado = null;
      
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         resultado = comando.executeQuery();
         
         while(resultado.next()){
            cpf = resultado.getString("cpf");
            nome = resultado.getString("nome");
            visoes.addElement(new Visao(cpf, nome+" - ("+cpf+")"));
         }
         resultado.close();
         comando.close();
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: getVisões", e);
      }
      return visoes;
   }
   
   private static boolean verificaDependencia(String cpf_cliente){
      String sql = "SELECT r.id "
            + "FROM reservas r, clientes c "
            + "WHERE r.clienteId = c.cpf AND r.clienteId = ? "
            + "LIMIT 1";
      
      //verifica dependencias em Reservas
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, cpf_cliente);
         ResultSet resultado;
         resultado= comando.executeQuery();
         while(resultado.next()){
            comando.close();
            resultado.close();
            return true;
         }
         comando.close();
         resultado.close();
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: verificaDependencia", e);
         return false;
      }
      
      // verifica dependencias em locacao
      sql = "SELECT id FROM locacao WHERE clienteId = ? LIMIT 1";
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, cpf_cliente);
         ResultSet resultado;
         resultado= comando.executeQuery();
         while(resultado.next()){
            comando.close();
            resultado.close();
            return true;
         }
         comando.close();
         resultado.close();
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe ClienteDao -> método: verificaDependencia", e);
         return false;
      }
      return false;
   }

}
