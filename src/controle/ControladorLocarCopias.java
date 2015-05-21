/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import dao.LocacaoDao;
import entidade.Locacao;
import interfaces.JanelaLocarCopiasFilmes;

/**
 *
 * @author juarez
 */
public class ControladorLocarCopias {
   
   public ControladorLocarCopias(){
      new JanelaLocarCopiasFilmes(this).setVisible(true);
   }
   
   public boolean inserir(Locacao locacao){
      
      if(LocacaoDao.inserir(locacao)){
         
         return true;
         
      }
      return false;
   }
}
