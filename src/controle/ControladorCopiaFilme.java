package controle;

import dao.CopiaFilmeDao;
import dao.ReservaDao;
import entidade.CopiaFilme;
import interfaces.JanelaCadastroCopiasFilmes;
import java.util.ArrayList;

/**
 *
 * @author juarez
 */
public class ControladorCopiaFilme {

   public ControladorCopiaFilme(){
      new JanelaCadastroCopiasFilmes(this).setVisible(true);
   }
   
   public boolean inserir(CopiaFilme copia, int quantidade){
      if(CopiaFilmeDao.inserir(copia, quantidade)){
         return true;
      }
      return false;
   }
   public boolean remover(int id){
      if(CopiaFilmeDao.remover(id))
         return true;
      return false;
   }
   public boolean alterar(CopiaFilme copia){
      if(CopiaFilmeDao.alterar(copia))
         return true;
      return false;
   }
   public ArrayList<CopiaFilme>  getCopiasFilmes(int idFilme){
      return CopiaFilmeDao.getCopiasFilmes(idFilme);
   }
   public CopiaFilme getCopiaFilme(int idCopia){
      return CopiaFilmeDao.getCopiaFilme(idCopia);
   }
           
}
