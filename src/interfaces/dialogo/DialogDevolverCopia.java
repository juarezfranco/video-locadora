package interfaces.dialogo;

import entidade.Locacao;

public class DialogDevolverCopia extends javax.swing.JDialog {

   public boolean isConfirm=false;
   public DialogDevolverCopia(String info, float valor) {
      super(new javax.swing.JFrame(), true);
      initComponents();
      
      infoLabel.setText(info);
      preçoLabel.setText(valor+"");
      setVisible(true);
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      devolverButton = new javax.swing.JButton();
      infoLabel = new javax.swing.JLabel();
      preçoLabel = new javax.swing.JLabel();
      LabelRS = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      devolverButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      devolverButton.setText("DEVOLVER");
      devolverButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            devolverButtonActionPerformed(evt);
         }
      });

      infoLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      infoLabel.setText("TEXTO");

      preçoLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      preçoLabel.setText("00.00");

      LabelRS.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      LabelRS.setText("R$");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(infoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(124, 124, 124)
                  .addComponent(devolverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(0, 115, Short.MAX_VALUE)))
            .addContainerGap())
         .addGroup(layout.createSequentialGroup()
            .addGap(195, 195, 195)
            .addComponent(LabelRS, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(preçoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(34, 34, 34)
            .addComponent(infoLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(preçoLabel)
               .addComponent(LabelRS))
            .addGap(29, 29, 29)
            .addComponent(devolverButton)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void devolverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverButtonActionPerformed
      isConfirm = true;
      dispose();
   }//GEN-LAST:event_devolverButtonActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel LabelRS;
   private javax.swing.JButton devolverButton;
   private javax.swing.JLabel infoLabel;
   private javax.swing.JLabel preçoLabel;
   // End of variables declaration//GEN-END:variables
}
