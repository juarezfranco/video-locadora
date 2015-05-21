package interfaces;

import dao.ClienteDao;
import dao.FilmeDao;
import dao.LocacaoDao;
import entidade.Locacao;
import entidade.Visao;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class JanelaConsultarLocacoes extends javax.swing.JDialog {

   public JanelaConsultarLocacoes() {
      super(new javax.swing.JFrame(), true);
      initComponents();
      limpaCampos();
   }

   
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      tabelarResultado = new javax.swing.JTable();
      clientesComboBox = new javax.swing.JComboBox();
      clienteLabel = new javax.swing.JLabel();
      filmesComboBox = new javax.swing.JComboBox();
      filmeLabel = new javax.swing.JLabel();
      novaPesquisaButton = new javax.swing.JButton();
      consultarButton = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Consultar Locações");

      tabelarResultado.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      tabelarResultado.setModel(construirTabela());
      tabelarResultado.setAutoscrolls(false);
      tabelarResultado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
      jScrollPane1.setViewportView(tabelarResultado);
      tabelarResultado.getAccessibleContext().setAccessibleDescription("");

      clientesComboBox.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      clientesComboBox.setModel(new DefaultComboBoxModel(ClienteDao.
         getVisoes()));

   clienteLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
   clienteLabel.setText("Cliente");

   filmesComboBox.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
   filmesComboBox.setModel(new DefaultComboBoxModel(FilmeDao.
      getVisoes()));

filmeLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
filmeLabel.setText("Filme");

novaPesquisaButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
novaPesquisaButton.setText("+");
novaPesquisaButton.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
      novaPesquisaButton(evt);
   }
   });

   consultarButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
   consultarButton.setText("CONSULTAR");
   consultarButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         consultarButtonEVT(evt);
      }
   });

   javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
   getContentPane().setLayout(layout);
   layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
         .addGap(27, 27, 27)
         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(filmeLabel)
                  .addComponent(clienteLabel))
               .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(clientesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(filmesComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
         .addComponent(novaPesquisaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
         .addComponent(consultarButton)
         .addGap(67, 67, 67))
   );
   layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
         .addGap(46, 46, 46)
         .addComponent(clienteLabel)
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
         .addComponent(clientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
         .addComponent(filmeLabel)
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(filmesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(novaPesquisaButton)
            .addComponent(consultarButton))
         .addGap(28, 28, 28)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
   );

   pack();
   setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void novaPesquisaButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaPesquisaButton
      limpaCampos();
   }//GEN-LAST:event_novaPesquisaButton

   private void consultarButtonEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonEVT
      atualizarTabela();
   }//GEN-LAST:event_consultarButtonEVT

   private void limpaCampos(){
      clientesComboBox.setSelectedIndex(-1);
      filmesComboBox.setSelectedIndex(-1);
      tabelarResultado.setModel(construirTabela());
   }
   private void atualizarTabela(){
      String cpfCliente;
      int idFilme;
      if(clientesComboBox.getSelectedIndex()==-1){
         cpfCliente=null;
      }else{
         Visao<String> visaoCliente = (Visao<String>) clientesComboBox.getSelectedItem();
         cpfCliente = visaoCliente.getChave();
      }
      if(filmesComboBox.getSelectedIndex()==-1){
         idFilme = -1;
      }else{
         Visao<Integer> visaoFilme = (Visao<Integer>) filmesComboBox.getSelectedItem();
         idFilme = visaoFilme.getChave();
      }
      
      ArrayList<Locacao> arrayLocacoes = LocacaoDao.getLocacoes(cpfCliente, idFilme);
      
      DefaultTableModel modelo = construirTabela();
      for(Locacao l : arrayLocacoes){
         modelo.addRow(new Object[]{l.getId(), l.getCliente().getNome(), l.getCopiaFilme().getFilme().getTitulo(), l.getData()});
      }
      tabelarResultado.setModel(modelo);
   }
   private DefaultTableModel construirTabela(){
      DefaultTableModel modelo = new DefaultTableModel();
      
      modelo.addColumn("ID LOCAÇÃO");
      modelo.addColumn("CLIENTES");
      modelo.addColumn("FILMES");
      modelo.addColumn("DATA");
      modelo.setNumRows(0);
      return modelo;
   }
           
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel clienteLabel;
   private javax.swing.JComboBox clientesComboBox;
   private javax.swing.JButton consultarButton;
   private javax.swing.JLabel filmeLabel;
   private javax.swing.JComboBox filmesComboBox;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JButton novaPesquisaButton;
   private javax.swing.JTable tabelarResultado;
   // End of variables declaration//GEN-END:variables
}
