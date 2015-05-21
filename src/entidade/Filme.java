package entidade;

/**
 *
 * @author juarez
 */
public class Filme {

   
   public enum Categoria {catálogo,lançamento,promoção}
   public enum Assunto {aventura,comédia,drama,faroeste,ficção,guerra,romance,suspense,terror}
   
   int id;
   String titulo;
   Assunto assunto;
   Categoria categoria;
   boolean oscar_melhor_filme;
   public Assunto[] ASSUNTOS={Assunto.aventura,Assunto.comédia,Assunto.drama,Assunto.faroeste,
                              Assunto.ficção,Assunto.guerra,Assunto.romance,Assunto.suspense,
                              Assunto.terror};
   public Filme() {
      
   }
   public Filme(int id){
      this.id = id;
   }
   public Filme(int id, String titulo, Assunto assunto, Categoria categoria, boolean oscar_melhor_filme) {
      this.id = id;
      this.titulo = titulo;
      this.assunto = assunto;
      this.categoria = categoria;
      this.oscar_melhor_filme = oscar_melhor_filme;
   }
   public Visao<Integer> getVisao(){
      return new Visao(id, titulo);
   }
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public Assunto getAssunto() {
      return assunto;
   }

   public void setAssunto(Assunto assunto) {
      this.assunto = assunto;
   }
   public void setAssunto(String assunto){
      if(assunto.compareToIgnoreCase("aventura")==0){
         this.assunto = Assunto.aventura;
         return;
      }
      if(assunto.compareToIgnoreCase("comédia")==0){
         this.assunto = Assunto.comédia;
         return;
      }
      if(assunto.compareToIgnoreCase("drama")==0){
         this.assunto = Assunto.drama;
         return;
      }
      if(assunto.compareToIgnoreCase("faroeste")==0){
         this.assunto = Assunto.faroeste;
         return;
      }
      if(assunto.compareToIgnoreCase("ficção")==0){
         this.assunto = Assunto.ficção;
         return;
      }
      if(assunto.compareToIgnoreCase("guerra")==0){
         this.assunto = Assunto.guerra;
         return;
      }
      if(assunto.compareToIgnoreCase("romance")==0){
         this.assunto = Assunto.romance;
         return;
      }
      if(assunto.compareToIgnoreCase("suspense")==0){
         this.assunto = Assunto.suspense;
         return;
      }
      if(assunto.compareToIgnoreCase("terror")==0){
         this.assunto = Assunto.terror;
         return;
      }
   }
         
   public Categoria getCategoria() {
      return categoria;
   }

   public void setCategoria(Categoria categoria){
      this.categoria = categoria;
   }
   public void setCategoria(String categoria) {
      
      if(categoria.compareToIgnoreCase("catálogo")==0)
         this.categoria = Categoria.catálogo;
      if(categoria.compareToIgnoreCase("lançamento")==0)
         this.categoria = Categoria.lançamento;
      if(categoria.compareToIgnoreCase("promoção")==0)
         this.categoria = Categoria.promoção;
   }

   public boolean isOscar_melhor_filme() {
      return oscar_melhor_filme;
   }

   public void setOscar_melhor_filme(boolean oscar_melhor_filme) {
      this.oscar_melhor_filme = oscar_melhor_filme;
   }
   
   @Override
   public String toString(){
      String dados = titulo+", "+assunto+" ("+categoria+")";
      if (oscar_melhor_filme)
         dados+= " - Possui Oscar Melhor Filme";
      dados+="\n";
      return dados;
   }
   
}
