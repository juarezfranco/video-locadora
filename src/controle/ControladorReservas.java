package controle;



import dao.ReservaDao;
import entidade.Reserva;
import interfaces.JanelaCadastroReservas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juarez
 */
public class ControladorReservas {
   
   public ControladorReservas(){
      new JanelaCadastroReservas(this).setVisible(true);
   }
   
   public boolean inserir(Reserva reserva){
      
      if(verificaSePodeGravar(reserva)){   
         if(ReservaDao.inserir(reserva)){
            JOptionPane.showMessageDialog(null, "Gravado com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
               return true;
         }else{
            JOptionPane.showMessageDialog(null, "Não foi possível gravar.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return false;
         }
      }
      else{
         JOptionPane.showMessageDialog(null, "Não foi possível gravar pois cliente ja reservou este filme!", "Informação", JOptionPane.ERROR_MESSAGE);
         return false;
      }
   }
   
   public boolean alterar(Reserva reserva){
      
      if(verificaSePodeGravar(reserva)){
         if(ReservaDao.alterar(reserva)){
            JOptionPane.showMessageDialog(null, "Registro atualizado com Sucesso!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return true;
         }else{
            JOptionPane.showMessageDialog(null, "Não foi possível alterar registro!", "Informação", JOptionPane.ERROR_MESSAGE);   
            return false;
         }
      }else{
         JOptionPane.showMessageDialog(null, "Não foi possível gravar pois cliente ja reservou este filme!", "Informação", JOptionPane.ERROR_MESSAGE);
         return false;
      }
   }
   
   public boolean remover(int id){
      
      
       if(ReservaDao.remover(id)){
            JOptionPane.showMessageDialog(null, "deletado com sucesso");
            return true;
        }
       return false;
   }
   
   public Reserva getReserva(int sequencial){
      return ReservaDao.getReserva(sequencial);
   }
   
   public ArrayList<Object[]> consultaReservas(String cpf_cliente, int id_filme, String assunto_filme, int pontoInicial, int quantidade){
      return ReservaDao.consultarReservas(cpf_cliente, id_filme, assunto_filme, pontoInicial, quantidade);
   }
   
   public int getUltimoSequencial(){
      return ReservaDao.getUltimoSequencial();
   }
   
   private boolean verificaSePodeGravar(Reserva reserva){
      if(ReservaDao.verificaSeClienteLocouFilme(reserva))
         return false;
      return true;
   }
}
