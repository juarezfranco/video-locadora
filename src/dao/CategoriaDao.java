package dao;

import entidade.Categorias;
import entidade.Filme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.Bd;

/**
 * CRUD de Categoria 
 * @author juarez
 */
public class CategoriaDao {
   
   public static void alterar(Categorias categoria){
      String sql = "UPDATE categorias SET valor = ? WHERE categoria = ?";
      PreparedStatement comando;
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setFloat(1, categoria.getValor());
         comando.setString(2, categoria.getCategoria().toString());
         comando.executeUpdate();
         comando.close();
      }catch(SQLException e){
         e.printStackTrace();
      }
   }
   public static Categorias getCategoria(Filme.Categoria categoria){
         
      PreparedStatement comando;
      ResultSet resultado;
      Categorias c=null;
      String sql = "SELECT valor FROM categorias WHERE categoria = ?";
      try{
         comando = Bd.getConexao().prepareStatement(sql);
         comando.setString(1, categoria.toString());
         resultado = comando.executeQuery();
         while(resultado.next()){
            c = new Categorias();
            c.setCategoria(categoria);
            c.setValor(resultado.getFloat("valor"));
            
         }
         comando.close();
         resultado.close();
         return c;
      }catch(SQLException e){
         e.printStackTrace();
         return c;
      }
      
   }
}
