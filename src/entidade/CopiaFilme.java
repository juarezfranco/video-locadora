package entidade;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author juarez
 */
public class CopiaFilme {

   
   public enum Estado{disponivel, locada, reservada}
   
   int id;
   Filme filme;
   float valorAquisicao;
   Estado estado;
   Timestamp dataAquisicao;
   String motivo_remocao;
   int quantidade;



   public CopiaFilme() {}
   
   public CopiaFilme(int idCopiaFilme){
      this.id = idCopiaFilme;
   }
   public CopiaFilme(Filme filme){
      this.filme = filme;
      this.valorAquisicao = 0;
      this.estado = null;
      this.dataAquisicao = new Timestamp(Calendar.getInstance().getTimeInMillis());
      this.motivo_remocao = null;
   }
   
   public CopiaFilme(Filme filme, float valorAquisicao, Estado estado, Timestamp dataAquisicao, String motivo_remocao) {
      this.filme = filme;
      this.valorAquisicao = valorAquisicao;
      this.estado = estado;
      this.dataAquisicao = dataAquisicao;
      this.motivo_remocao = motivo_remocao;
   }

   public Filme getFilme() {
      return filme;
   }

   public void setFilme(Filme filme) {
      this.filme = filme;
   }

   public int getId() {
      return id;
   }

   public String getMotivo_remocao() {
      return motivo_remocao;
   }

   public void setMotivo_remocao(String motivo_remocao) {
      this.motivo_remocao = motivo_remocao;
   }
   public void setId(int id) {
      this.id = id;
   }

   public Timestamp getDataAquisicao() {
      return dataAquisicao;
   }

   public void setDataAquisicao(Timestamp dataAquisicao) {
      this.dataAquisicao = dataAquisicao;
   }

   public float getValorAquisicao() {
      return valorAquisicao;
   }

   public void setValorAquisicao(float valorAquisicao) {
      this.valorAquisicao = valorAquisicao;
   }

   public Estado getEstado() {
      return estado;
   }

   public void setEstado(Estado estado) {
      this.estado = estado;
   }
   public void setEstado(String estado){
      if(estado.equals(Estado.disponivel+""))
         this.estado = Estado.disponivel;
      
      if(estado.equals(Estado.locada+""))
         this.estado = Estado.locada;
      
      if(estado.equals(Estado.reservada+""))
         this.estado = Estado.reservada;
   }
   public Visao<Integer> getVisao(){
      String estado = (this.estado+"").toUpperCase();
      return new Visao<Integer>(id, id+" - "+filme.getTitulo()+ ", "+filme.getAssunto()+" ("+estado+")");
   }
}
   
   

