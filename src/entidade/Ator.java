package entidade;

import java.util.ArrayList;

public class Ator {
   public enum  Premiacao{principal, coadjuvante};

   int id;
   String nome;
   ArrayList<Filme> filmesComOscar;
   Premiacao premiacao;

   
   public Ator(int id, String nome, ArrayList<Filme> filmesComOscar, Premiacao premiacao) {
      this.id = id;
      this.nome = nome;
      this.filmesComOscar = filmesComOscar;
      this.premiacao = premiacao;
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

   public ArrayList<Filme> getFilmesComOscar() {
      return filmesComOscar;
   }

   public void setFilmesComOscar(ArrayList<Filme> filmesComOscar) {
      this.filmesComOscar = filmesComOscar;
   }

   public Premiacao getPremiacao() {
      return premiacao;
   }

   public void setPremiacao(Premiacao premiacao) {
      this.premiacao = premiacao;
   }
   
   
   
}
