package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import util.MensagensPopup;

/**
 * Classe responsável fazer comunicação com arquivo de configuração externo para inicializar
 * o sistema informações da conexão com o banco de dados.
 * @author juarez
 */
public final class BDpropertyes {
   //configurações padrão
   String arquivo="config.properties";
   String endereco = "jdbc:mysql://localhost/locadoralp2";
   String usuario = "root";
   String senha = "123";
   Properties prop = new Properties();
   FileOutputStream output = null;
   
   public BDpropertyes(){
      //carrega arquivo de configuração     
      loadFileProperties();
   }
   
   /**
    * Método cria arquivo de configuração.
    */
   public void criaFileProperties(){
      try{
         output = new FileOutputStream(arquivo);

         prop.setProperty("database", endereco);
         prop.setProperty("dbusuario", usuario);
         prop.setProperty("dbsenha", senha);

         prop.store(output, null);
         output.close();
      }catch(IOException e){
         MensagensPopup.showMensagemErro("Erro na classe: LocalDataBase -> método: criarFileProperties", e);
         System.exit(1);
      }
   }
   
   public void loadFileProperties(){
      FileInputStream input = null;
      try{
         input = new FileInputStream(arquivo);
         
         prop.load(input);
         endereco = prop.getProperty("database");
         usuario = prop.getProperty("dbusuario");
         senha = prop.getProperty("dbsenha");
         input.close();
      }catch(IOException e){
         
         JOptionPane.showMessageDialog(null, "O Sistema não encontrou o arquivo de configuração \"config.properties\"."
                 + "\nSistema sera encerrado", "Erro", JOptionPane.ERROR_MESSAGE);
         int a=JOptionPane.showConfirmDialog(null, "Deseja criar um arquivo de configuração com valores \"default\"?", 
                                             "Erro", JOptionPane.YES_NO_OPTION);
         if(a==JOptionPane.YES_OPTION){
            criaFileProperties();
            loadFileProperties();
            return;
         }
         System.exit(1);
      }
      
      
   }

   public String getEndereco() {
      return endereco;
   }

   public String getUsuario() {
      return usuario;
   }

   public String getSenha() {
      return senha;
   }
}
