package interfaces;

import dao.CategoriaDao;
import entidade.Categorias;
import entidade.Filme;
import persistencia.Bd;

public class JanelaCategoria extends javax.swing.JDialog {

  
   public JanelaCategoria() {
      super( new javax.swing.JFrame(), true);
      initComponents();
      iniciarValores();
   }

   
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      precoLancamentoText = new javax.swing.JFormattedTextField();
      precoPromocaoText = new javax.swing.JFormattedTextField();
      precoCatalagoText = new javax.swing.JFormattedTextField();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      confirmarjButton = new javax.swing.JButton();
      jLabel3 = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Configurar preço ");
      setModal(true);

      jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      jLabel5.setText("R$");

      jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      jLabel6.setText("R$");

      jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      jLabel7.setText("R$");

      confirmarjButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      confirmarjButton.setText("CONFIRMAR");
      confirmarjButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            confirmarPressButton(evt);
         }
      });

      jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      jLabel3.setText("lançamento");

      jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      jLabel1.setText("promoção");

      jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      jLabel2.setText("catálago");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(38, 38, 38)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(1, 1, 1)
                  .addComponent(confirmarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addGap(2, 2, 2)
                        .addComponent(precoLancamentoText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                           .addComponent(jLabel6)
                           .addGap(0, 0, Short.MAX_VALUE)
                           .addComponent(precoCatalagoText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                           .addComponent(jLabel5)
                           .addGap(3, 3, 3)
                           .addComponent(precoPromocaoText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel1)
                     .addComponent(jLabel2)
                     .addComponent(jLabel3))))
            .addContainerGap(42, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(27, 27, 27)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(precoPromocaoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel5)
                     .addComponent(jLabel1))
                  .addGap(153, 153, 153))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel2)
                     .addComponent(precoCatalagoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel6))
                  .addGap(25, 25, 25)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel3)
                     .addComponent(precoLancamentoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(jLabel7))
                  .addGap(18, 18, 18)
                  .addComponent(confirmarjButton)))
            .addContainerGap(28, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents
   
   private void iniciarValores(){
      Categorias catalago = CategoriaDao.getCategoria(Filme.Categoria.catálogo);
      Categorias promocao = CategoriaDao.getCategoria(Filme.Categoria.promoção);
      Categorias lancamento = CategoriaDao.getCategoria(Filme.Categoria.lançamento);
      
      precoCatalagoText.setText(catalago.getValor()+"");
      precoPromocaoText.setText(promocao.getValor()+"");
      precoLancamentoText.setText(lancamento.getValor()+"");
   }
           
   private void confirmarPressButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarPressButton
      float precoPromocao = Float.parseFloat(precoPromocaoText.getText());
      float precoCatalago = Float.parseFloat(precoCatalagoText.getText());
      float precoLancamento = Float.parseFloat(precoLancamentoText.getText());
      
      Categorias catalago = new Categorias(Filme.Categoria.catálogo, precoCatalago);
      Categorias promocao = new Categorias(Filme.Categoria.promoção, precoPromocao);
      Categorias lancamento = new Categorias(Filme.Categoria.lançamento, precoLancamento);
      
      CategoriaDao.alterar(catalago);
      CategoriaDao.alterar(promocao);
      CategoriaDao.alterar(lancamento);
      
   }//GEN-LAST:event_confirmarPressButton

   

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton confirmarjButton;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JFormattedTextField precoCatalagoText;
   private javax.swing.JFormattedTextField precoLancamentoText;
   private javax.swing.JFormattedTextField precoPromocaoText;
   // End of variables declaration//GEN-END:variables
}
