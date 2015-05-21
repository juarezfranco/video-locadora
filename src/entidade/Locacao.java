package entidade;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Locacao {
   int id;
   Cliente cliente;
   CopiaFilme copiaFilme;
   Timestamp data;
   static ArrayList<CopiaFilme> arrayCopias = null;
   
   public Locacao(){}

   public Locacao(Cliente cliente, CopiaFilme copiaFilme, Timestamp data) {
      this.cliente = cliente;
      this.copiaFilme = copiaFilme;
      this.data = data;
   }
   
   public Locacao(Cliente cliente, ArrayList<CopiaFilme> arrayCopias, Timestamp data){
      this.cliente = cliente;
      Locacao.arrayCopias = new ArrayList<>();
      Locacao.arrayCopias = arrayCopias;
      this.data = data;
   }
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }
   public ArrayList<CopiaFilme> getArrayCopiasFilmes(){
      return arrayCopias;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public CopiaFilme getCopiaFilme() {
      return copiaFilme;
   }

   public void setCopiaFilme(CopiaFilme copiaFilme) {
      this.copiaFilme = copiaFilme;
   }

   public Timestamp getData() {
      return data;
   }

   public void setData(Timestamp data) {
      this.data = data;
   }
   
   @Override
   public String toString(){
      String info="";
      info+="ID: "+id+" - "+copiaFilme.getFilme().getTitulo()+" ("+
              copiaFilme.getFilme().getAssunto()+")";
      
      return info;
   }
   
   
}
