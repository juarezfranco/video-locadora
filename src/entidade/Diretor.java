package entidade;

import java.util.ArrayList;

public class Diretor {
   public enum  Premiacao{principal, coadjuvante};
   
   int id;
   String nome;
   ArrayList<Filme> filmeComOscar;

   public Diretor(int id, String nome, ArrayList<Filme> filmeComOscar) {
      this.id = id;
      this.nome = nome;
      this.filmeComOscar = filmeComOscar;
   }

   
   
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public ArrayList<Filme> getFilmeComOscar() {
      return filmeComOscar;
   }

   public void setFilmeComOscar(ArrayList<Filme> filmeComOscar) {
      this.filmeComOscar = filmeComOscar;
   }
   
   
}
