package entidade;

/**
 *
 * @author juarez
 */
public class Visao<T> {
   T chave;
   String info;

   public Visao(T chave, String info) {
      this.chave = chave;
      this.info = info;
   }

   public Visao() {
      
   }

   public T getChave() {
      return chave;
   }

   public void setChave(T chave) {
      this.chave = chave;
   }

   public String getInfo() {
      return info;
   }

   public void setInfo(String info) {
      this.info = info;
   }
   
   @Override
   public String toString(){
      return info;
   }
   
}
