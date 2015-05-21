package entidade;

public class Categorias {
   
   Filme.Categoria categoria;
   float valor;

   public Categorias(Filme.Categoria categoria, float valor) {
      this.categoria = categoria;
      this.valor = valor;
   }

   public Categorias(){}

   public Filme.Categoria getCategoria() {
      return categoria;
   }

   public void setCategoria(Filme.Categoria categoria) {
      this.categoria = categoria;
   }

   public float getValor() {
      return valor;
   }

   public void setValor(float valor) {
      this.valor = valor;
   }
   
   
}
