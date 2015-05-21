package interfaces;

import dao.CategoriaDao;
import dao.LocacaoDao;
import entidade.Categorias;
import entidade.Cliente;
import entidade.CopiaFilme;
import entidade.Filme;
import entidade.Locacao;
import entidade.Visao;
import interfaces.dialogo.DialogDevolverCopia;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JanelaDevolverCopiasFilmes extends javax.swing.JDialog {

   public JanelaDevolverCopiasFilmes() {
      super(new javax.swing.JFrame(), true);
      initComponents();
      limpaCampos();
      
   }
   
   private DefaultTableModel construirTabela(){
      DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("id");
      modelo.addColumn("Titulo");
      modelo.addColumn("Assunto");
      modelo.addColumn("Categoria");
      modelo.addColumn("Data da locação");
      modelo.addColumn("Valor");
      modelo.setNumRows(0);
      
      return modelo;
   }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLocacoes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        clientesComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        devolver_todasButton = new javax.swing.JButton();
        precoTotalLabel = new javax.swing.JLabel();
        LabelRS = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Devolver Cópias");
        setModal(true);

        tabelaLocacoes.setModel(construirTabela());
        tabelaLocacoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaLocacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaLocacoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaLocacoes);

        clientesComboBox.setModel(new DefaultComboBoxModel(new dao.ClienteDao().getVisoes()));
        clientesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clientesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(401, 401, 401))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        devolver_todasButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        devolver_todasButton.setText("DEVOLVER  TODAS");
        devolver_todasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolver_todasButtonActionPerformed(evt);
            }
        });

        precoTotalLabel.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        precoTotalLabel.setText("00.00");

        LabelRS.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        LabelRS.setText("R$");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("TOTAL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(devolver_todasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LabelRS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoTotalLabel)))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(devolver_todasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LabelRS)
                        .addComponent(precoTotalLabel)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void devolver_todasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolver_todasButtonActionPerformed
      if(clientesComboBox.getSelectedIndex()==-1)
         return;
      
      Visao<String> visaoCliente = (Visao<String>)clientesComboBox.getSelectedItem();
      ArrayList<Locacao> arrayLocacoes = LocacaoDao.getLocacaoCliente(visaoCliente.getChave());
      
      DialogDevolverCopia dialogo = 
              new DialogDevolverCopia("Devolver Todas as cópias locadas?", Float.parseFloat(precoTotalLabel.getText()));
      if(dialogo.isConfirm){
         for(Locacao locacao : arrayLocacoes){
            LocacaoDao.remover(locacao.getId());
         }
         atualizaTabela();
      }
   }//GEN-LAST:event_devolver_todasButtonActionPerformed

   private void clientesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesComboBoxActionPerformed
      if(clientesComboBox.getSelectedIndex()==-1)
         return;
      
      atualizaTabela();
      
   }//GEN-LAST:event_clientesComboBoxActionPerformed

   private void tabelaLocacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLocacoesMouseClicked
      int linhaSelecionada = tabelaLocacoes.getSelectedRow();
      int idLocacao = Integer.parseInt(tabelaLocacoes.getValueAt(linhaSelecionada, 0).toString());
      float valor = Float.parseFloat(tabelaLocacoes.getValueAt(linhaSelecionada, 5).toString());
      
      DialogDevolverCopia dialogo = 
              new DialogDevolverCopia(LocacaoDao.getLocacao(idLocacao).toString(), valor);
      if(dialogo.isConfirm){
         devolverCopia(idLocacao);
         atualizaTabela();
      }
   }//GEN-LAST:event_tabelaLocacoesMouseClicked
   private void devolverCopia(int idLocacao){
      if(LocacaoDao.remover(idLocacao))
         JOptionPane.showMessageDialog(this, "Devolução concluida");
   }
   private void atualizaTabela(){
      Visao<String> visaoCliente = (Visao<String>)clientesComboBox.getSelectedItem();
      ArrayList<Locacao> arrayLocacoes = LocacaoDao.getLocacaoCliente(visaoCliente.getChave());
      
      //atualiza tabela
      DefaultTableModel modelo = construirTabela();
      float precoTotal=0;
      for(Locacao locacao : arrayLocacoes){
         
         CopiaFilme copiaFilme = locacao.getCopiaFilme();
         
         int idLocacao= locacao.getId();
         String titulo = copiaFilme.getFilme().getTitulo();
         Filme.Assunto assunto = copiaFilme.getFilme().getAssunto();
         String data = locacao.getData().toString();
         Categorias categoria = CategoriaDao.getCategoria(copiaFilme.getFilme().getCategoria());
         float valor =categoria.getValor();
         precoTotal+=valor;
         
         modelo.addRow(new Object[]{idLocacao, titulo, assunto, categoria.getCategoria(), data, valor});
      }
      precoTotalLabel.setText(precoTotal+"0");
      tabelaLocacoes.setModel(modelo);
   }   
   public void limpaCampos(){
      clientesComboBox.setSelectedIndex(-1);
      tabelaLocacoes.setModel(construirTabela());
   }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelRS;
    private javax.swing.JComboBox clientesComboBox;
    private javax.swing.JButton devolver_todasButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel precoTotalLabel;
    private javax.swing.JTable tabelaLocacoes;
    // End of variables declaration//GEN-END:variables
}
