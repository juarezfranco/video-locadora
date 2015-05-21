package dao;

import entidade.Filme;
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
public class FilmeDao {
   static String sql ="";
   static PreparedStatement comando = null;
   
   public static int getUltimoSequencial(){
      sql = "SELECT MAX(id) FROM filmes";
      int ultimo_sequencial=0;
      ResultSet resultado = null;
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         resultado = comando.executeQuery();
         
         while(resultado.next()){
            ultimo_sequencial = resultado.getInt(1);         
         }
         
         resultado.close();
         resultado.close();
         return ultimo_sequencial;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe FilmeDao -> método: ultimoSequencial", e);
         e.printStackTrace();
      }
      return ultimo_sequencial;
   }
   
   public static boolean inserir(Filme filme){
      sql = "INSERT INTO filmes(titulo, assunto, categoria, oscar) VALUES(?,?,?,?)";
      
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, filme.getTitulo());
         comando.setString(2, filme.getAssunto()+"");
         comando.setString(3, filme.getCategoria()+"");
         comando.setBoolean(4, filme.isOscar_melhor_filme());
         
         comando.execute();
         
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe FilmeDao -> método: inserir", e);
         return false;
      }
   }
   
   public static Filme getFilme(int id){
      sql = "SELECT * FROM filmes WHERE id = ? LIMIT 1";
      ResultSet result = null;
      
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, id);

         result = comando.executeQuery();
         
         Filme filme = new Filme();
         while(result.next()){
            filme.setId(result.getInt("id"));
            filme.setTitulo(result.getString("titulo"));
            filme.setAssunto(result.getString("assunto"));
            filme.setCategoria(result.getString("categoria"));
            filme.setOscar_melhor_filme(result.getBoolean("oscar"));
         }
       


         result.close();
         comando.close();
         return filme;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe FilmeDao -> método: getFilme", e);
         return null;
      }
   
   }
   
   public static ArrayList<Filme> getFilmes(String titulo){
    sql = "SELECT * FROM filmes WHERE titulo like ?";
    ResultSet result = null;
    ArrayList<Filme> filmes_selecionados = new ArrayList();
    try{
       comando = Bd.getConexao().prepareStatement(sql);
       comando.setString(1, titulo+"%");
       
       result = comando.executeQuery();
       while(result.next()){
          Filme filme = new Filme();
          filme.setId(result.getInt("id"));
          filme.setTitulo(result.getString("titulo"));
          filme.setAssunto(result.getString("assunto"));
          filme.setCategoria(result.getString("categoria"));
          filme.setOscar_melhor_filme(result.getBoolean("oscar"));
          filmes_selecionados.add(filme);
       }
       
       
       result.close();
       comando.close();
       return filmes_selecionados;
    }catch(SQLException e){
       MensagensPopup.showMensagemErro("Erro classe FilmeDao -> método: getFilmes", e);
       return null;
    }
      
   }
   
   public static boolean deletar(int id){
      
      
      if(verificaDependenciaEmCopias(id))
         return false;
      
      sql = "DELETE FROM filmes WHERE id = ?";

      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, id);

         comando.executeUpdate();
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe FilmeDao -> método: deletar", e);
         return false;
      }
   }
   
   public static boolean alterar(Filme filme){
      sql = "UPDATE filmes SET titulo = ?, assunto = ?, categoria = ?, oscar = ? WHERE id = ?";
      
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, filme.getTitulo());
         comando.setString(2, filme.getAssunto()+"");
         comando.setString(3, filme.getCategoria()+"");
         comando.setBoolean(4, filme.isOscar_melhor_filme());
         comando.setInt(5, filme.getId());
         
         comando.executeUpdate();
         comando.close();
         return true;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe FilmeDao -> método: alterar", e);
         return false;
      }
      
   }
   
   public static Vector<Visao<Integer>> getVisoes(){
      sql = "SELECT id, titulo FROM filmes";
      ResultSet resultado = null;
      Vector<Visao<Integer>> visoes = new Vector<Visao<Integer>>();
      int id;
      String titulo;
      
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         resultado = comando.executeQuery();
         
         while(resultado.next()){
            id = resultado.getInt("id");
            titulo = resultado.getString("titulo");
            visoes.addElement(new Visao(id, titulo));
         }
         resultado.close();
         comando.close();
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe FilmeDao -> método: getVisões", e);
      }
      return visoes;
   }
   
   private static boolean verificaDependenciaEmCopias(int idFilme){
      //verifica se existe alguma dependencia de copias do filme.
      sql = "SELECT c.id FROM copia_filmes c, filmes f "
              + " WHERE "
              + " c.filmeId = f.id AND "
              + " c.filmeId = ? "
              + " LIMIT 1";
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setInt(1, idFilme);

         ResultSet resultado = comando.executeQuery();
         while(resultado.next()){
            comando.close();
            return true;
         }
         comando.close();
         return false;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe FilmeDao -> método: verificaDependenciaCopias", e);
         return false;
      }
   }
   
   public static ArrayList<Filme> getFilmesPorCategorias(Filme.Categoria categoria){
      ArrayList<Filme> arrayFilmes = new ArrayList<>();
      
      String sql = "SELECT * FROM filmes WHERE categoria = ?";
      
      try{
         PreparedStatement comando;
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, categoria+"");
         ResultSet resultado;
         resultado = comando.executeQuery();
         while(resultado.next()){
            Filme filme = new Filme();
            filme.setId(resultado.getInt("id"));
            filme.setTitulo(resultado.getString("titulo"));
            filme.setAssunto(resultado.getString("assunto"));
            filme.setCategoria(categoria);
            filme.setOscar_melhor_filme(resultado.getBoolean("oscar"));
            arrayFilmes.add(filme);
         }
         comando.close();
         resultado.close();
         return arrayFilmes;
      }catch(SQLException e){
         MensagensPopup.showMensagemErro("Erro classe FilmeDao -> método: getFilmesPorCategorias", e);
         return arrayFilmes;
      }
      
   }
      
}
