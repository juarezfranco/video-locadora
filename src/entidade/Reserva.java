package entidade;

import java.sql.Timestamp;

public class Reserva {
   int id;
   Cliente cliente;
   Filme filme;
   Timestamp data;

   public Reserva(){}
   
   public Reserva(Cliente cliente, Filme filme, Timestamp data){
      this.cliente = cliente;
      this.filme = filme;
      this.data = data;
   }
   public Reserva(int id, Cliente cliente, Filme filme, Timestamp data) {
      this.id = id;
      this.cliente = cliente;
      this.filme = filme;
      this.data = data;
   }

   public Timestamp getData() {
      return data;
   }

   public void setData(Timestamp data) {
      this.data = data;
   }
   
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Cliente getCliente() {
      return cliente;
   }

   public void setCliente(Cliente cliente) {
      this.cliente = cliente;
   }

   public Filme getFilme() {
      return filme;
   }

   public void setFilme(Filme filme) {
      this.filme = filme;
   }
   
   
}
