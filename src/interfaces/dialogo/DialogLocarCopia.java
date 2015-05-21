package interfaces.dialogo;

import dao.CategoriaDao;
import entidade.CopiaFilme;
import entidade.Filme;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DialogLocarCopia extends javax.swing.JDialog {
   public boolean isConfirm=false;
   private ArrayList<CopiaFilme> arrayCopias = new ArrayList<>();
   
   public DialogLocarCopia(ArrayList<CopiaFilme> arrayCopias){
      super(new javax.swing.JFrame(), true);
      this.arrayCopias = arrayCopias;
      initComponents();
      
      itemCarrinhoTable.setModel(construirTabela());
      atualizaTabela();
      setVisible(true);
   }
   
   private void atualizaTabela(){
      DefaultTableModel modelo = construirTabela();
      float valorTotal=0;
      for(CopiaFilme copia  :  arrayCopias){
         String titulo = copia.getFilme().getTitulo();
         Filme.Assunto assunto = copia.getFilme().getAssunto();
         Filme.Categoria categoria = copia.getFilme().getCategoria();
         float valor = CategoriaDao.getCategoria(categoria).getValor();
         valorTotal+=valor;
         
         modelo.addRow(new Object[]{titulo, assunto, categoria, valor});
      }
      precoLabel.setText(valorTotal+"0");
      itemCarrinhoTable.setModel(modelo);
      itemCarrinhoTable.setEnabled(false);
   }
   private DefaultTableModel construirTabela(){
      DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("Titulo");
      modelo.addColumn("Assunto");
      modelo.addColumn("Categoria");
      modelo.addColumn("Valor");
      modelo.setNumRows(0);
      
      return modelo;
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloValorLabel = new javax.swing.JLabel();
        precoLabel = new javax.swing.JLabel();
        simboloRSLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemCarrinhoTable = new javax.swing.JTable();
        confirmarButton = new javax.swing.JButton();
        tituloCarrinhoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                fecharJanela(evt);
            }
        });

        tituloValorLabel.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        tituloValorLabel.setText("VALOR TOTAL");

        precoLabel.setFont(new java.awt.Font("Ubuntu", 1, 60)); // NOI18N
        precoLabel.setText("00.00");

        simboloRSLabel.setFont(new java.awt.Font("Ubuntu", 1, 60)); // NOI18N
        simboloRSLabel.setText("R$");

        itemCarrinhoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(itemCarrinhoTable);

        confirmarButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        confirmarButton.setText("LOCAR");
        confirmarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarButtonActionPerformed(evt);
            }
        });

        tituloCarrinhoLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        tituloCarrinhoLabel.setText("CARRINHO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tituloValorLabel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(simboloRSLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(precoLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157)))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(tituloCarrinhoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(tituloCarrinhoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(tituloValorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precoLabel)
                    .addComponent(simboloRSLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void fecharJanela(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_fecharJanela
      dispose();
   }//GEN-LAST:event_fecharJanela

   private void confirmarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarButtonActionPerformed
      isConfirm = true;
      fecharJanela(null);
   }//GEN-LAST:event_confirmarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmarButton;
    private javax.swing.JTable itemCarrinhoTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel precoLabel;
    private javax.swing.JLabel simboloRSLabel;
    private javax.swing.JLabel tituloCarrinhoLabel;
    private javax.swing.JLabel tituloValorLabel;
    // End of variables declaration//GEN-END:variables
}
