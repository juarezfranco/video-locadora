package controle;

import dao.FilmeDao;
import entidade.Filme;
import entidade.Visao;
import interfaces.JanelaCadastroFilmes;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author juarez
 */
public class ControladorCadastroFilme {
   
   public ControladorCadastroFilme(){
      new JanelaCadastroFilmes(this).setVisible(true);
   }
   
   public boolean inserir(Filme filme){  
      //verifica se ja existe um filme com titulo, assunto, categoria iguais.
      if(verifica_se_filme_existe(filme)){
         return false;
      }  
      
      if(FilmeDao.inserir(filme)){
         JOptionPane.showMessageDialog(null, "Gravado com sucesso!");
         return true;
      }
      else{
         JOptionPane.showMessageDialog(null, "Erro ao inserir filme na base de dados");
         return false;
      }
         
   }
   
   public boolean alterar(Filme filme){
      if(verifica_se_filme_existe(filme)){
         return false;
      }  
      
      if (FilmeDao.alterar(filme)){
         JOptionPane.showMessageDialog(null, "Filme alterado com sucesso");
         return true;
      }
      else{
         JOptionPane.showMessageDialog(null, "Erro ao alterar verifique dados de entrada");
         return false;
      }
   }
   
   /**
    *
    * @param id
    * @return
    */
   public Filme getFilme(int id){
      return FilmeDao.getFilme(id);
   }
   
   public ArrayList<Filme> getFilmes(String titulo){
      return  FilmeDao.getFilmes(titulo);
   }
   
   public boolean deletar(int id){
      int a = JOptionPane.showConfirmDialog(null, "Deseja remover filme?", "Deletar", JOptionPane.YES_NO_OPTION);
      if(a==JOptionPane.YES_OPTION){
         if(FilmeDao.deletar(id)){
            JOptionPane.showMessageDialog(null, "Filme foi removido com sucesso");
            return true;
         }
         else{
            JOptionPane.showMessageDialog(null, "Não foi possível deletar, Filme existe dependencias "
                    + "em Reservas ou em Cópias");
            return false;
         }
      }
      else
         JOptionPane.showMessageDialog(null, "Operação cancelada");
      return false;
   }
   
   //comparaFilmes retorna true se forem 2 filmes iguais 
   private static boolean verifica_se_filme_existe(Filme filme){
      
      for(Filme f : FilmeDao.getFilmes(filme.getTitulo())){  //pega todos os filmes com o mesmo titulo(filtra) para depois comparar os demais atributos
         if((f.getTitulo().compareToIgnoreCase(filme.getTitulo())==0)      //compara titulos
                 && (f.getAssunto() == filme.getAssunto())                 //compara assunto
                 && (f.getCategoria() == filme.getCategoria())
                 && (f.isOscar_melhor_filme()==filme.isOscar_melhor_filme())){            //compara categoria
            JOptionPane.showMessageDialog(null, "Não foi possível gravar/alterar, FILME JÁ EXISTE!");
            return true;
         }
      }
      return false;
   }
   
   public Vector<Visao<Integer>> getVisoes(){
      return FilmeDao.getVisoes();
   }
   public int getUltimoSequencial(){
      return FilmeDao.getUltimoSequencial();
   }
}
