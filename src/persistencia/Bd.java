package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.MensagensPopup;

/**
 * Classe responsável por criar e fechar conexão com banco de dados
 * @author juarez
 */
public class Bd {
   
   private static Connection conexao;

   public static void abreConexao() {
      //instancia objeto responsável por ler arquivo de configuração
      BDpropertyes local = new BDpropertyes();
      try {
         //cria conexão
         conexao = DriverManager.getConnection(local.getEndereco(), local.getUsuario(), local.getSenha());
      } catch (SQLException e) {
         MensagensPopup.showMensagemErro("ERRO: classe Bd -> método abreConexao", e);
         System.exit(1);
         
      }
   }

   /**
    * Fecha conexão com bd
    */
   public static void fechaConexao() {
      try {
         conexao.close();
      } catch (SQLException e) {
         MensagensPopup.showMensagemErro("ERRO: classe Bd -> método fechaConexao", e);
         System.exit(1);
      }
   }

   public static Connection getConexao() {
      return conexao;
   }
}
