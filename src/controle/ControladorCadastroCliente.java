package controle;

import interfaces.JanelaCadastroClientes;
import entidade.Cliente;
import dao.ClienteDao;
import entidade.Visao;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author juarez
 */
public class ControladorCadastroCliente {
   
   public ControladorCadastroCliente(){
      new JanelaCadastroClientes(this).setVisible(true);
   }
   
   public boolean inserirCliente(Cliente cliente){
      
      //verifica se cpf do cliente ja existe.
      Cliente cliente_novo = ClienteDao.getCliente(cliente.getCpf());
      
      if(cliente_novo == null){ //se cliente_novo for null significa que nao existe cliente com este cpf cadastrado
         if(ClienteDao.inserir(cliente)){
            JOptionPane.showMessageDialog(null, "Gravado com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return true;
         }
      }
      else
         JOptionPane.showMessageDialog(null, "cpf duplicado. Tente novamente");
      return false;
      
   }
   
   public boolean alterarCliente(Cliente cliente){
      if(ClienteDao.alterar(cliente)){
         JOptionPane.showMessageDialog(null, "Registro atualizado com sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
         return true;
      }
      else 
         return false;
      
   }
   
   public boolean deletarCliente(String cpf){
      int a = JOptionPane.showConfirmDialog(null, "deseja realmente excluir?", "Cuidado!", JOptionPane.YES_NO_OPTION);
      
      if (a == JOptionPane.YES_OPTION){
         if(ClienteDao.deletar(cpf)){
            JOptionPane.showMessageDialog(null, "deletado com sucesso");
            return true;
         }
         else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir cadastro, pois existe dependencias em Reservas ou em Locações");
         }
      }
      else
         JOptionPane.showMessageDialog(null, "operação cancelada");
      return false;
      
   }
   
   public Cliente getCliente(String cpf){
      return ClienteDao.getCliente(cpf);
      
   }
   
   public int getTotalRegistros(){
      return ClienteDao.getTotalRegistros();
   }
   
   public ArrayList<Cliente> getClientes(String campo, String str, int qtdMin, int qtdMax){
      return ClienteDao.getClientes(campo, str, qtdMin, qtdMax);
   }
   public ArrayList<Cliente> getClientes(String campo, String str){
      
      return ClienteDao.getClientes(campo, str);
      
   }
   
   public Vector<Visao<String>> getVisoes(){
      return ClienteDao.getVisoes();
   }
   
}
