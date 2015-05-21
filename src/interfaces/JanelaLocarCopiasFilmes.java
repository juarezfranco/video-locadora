package interfaces;

import controle.ControladorLocarCopias;
import dao.ClienteDao;
import dao.CopiaFilmeDao;
import dao.CopiasReservadasDao;
import entidade.Cliente;
import entidade.CopiaFilme;
import entidade.Locacao;
import entidade.Visao;
import interfaces.dialogo.DialogLocarCopia;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;



/**
 *
 * @author juarez
 */
public class JanelaLocarCopiasFilmes extends javax.swing.JDialog{
   private ControladorLocarCopias controlador;
   
   public JanelaLocarCopiasFilmes(ControladorLocarCopias controlador) {
      super(new javax.swing.JFrame(), true);
      this.controlador = controlador;
      initComponents();
      limpaCampos();
      
      
      
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        homePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCarrinho = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCopias = new javax.swing.JList();
        filmesComboBox = new javax.swing.JComboBox();
        filmesLabel = new javax.swing.JLabel();
        adicionarButton = new javax.swing.JButton();
        carrinhoLabel = new javax.swing.JLabel();
        locarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        clientesComboBox = new javax.swing.JComboBox();
        clienteLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Locar Filme");
        setType(java.awt.Window.Type.UTILITY);

        homePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        listaCarrinho.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaCarrinho);

        listaCopias.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaCopias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(listaCopias);

        filmesComboBox.setModel(new DefaultComboBoxModel(new dao.FilmeDao().getVisoes()));
        filmesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionaFilmeComBox(evt);
            }
        });

        filmesLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        filmesLabel.setText("Filmes");

        adicionarButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        adicionarButton.setText("+");
        adicionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarAoCarrinhoEVT(evt);
            }
        });

        carrinhoLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        carrinhoLabel.setText("CARRINHO");

        locarButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        locarButton.setText("LOCAR");
        locarButton.setToolTipText("");
        locarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocarCopiasEVT(evt);
            }
        });

        cancelarButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cancelarButton.setText("cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarLocacaoEVT(evt);
            }
        });

        removerButton.setFont(new java.awt.Font("Ubuntu", 1, 22)); // NOI18N
        removerButton.setText("-");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerDoCarrinhoItemSelecionadoEVT(evt);
            }
        });

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filmesLabel)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                            .addComponent(filmesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(adicionarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                            .addComponent(removerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addComponent(locarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                            .addGroup(homePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(carrinhoLabel))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filmesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filmesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carrinhoLabel))
                .addGap(18, 18, 18)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addComponent(adicionarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        clientesComboBox.setModel(new DefaultComboBoxModel(new dao.ClienteDao().getVisoes()));
        clientesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecionaClienteComboBox(evt);
            }
        });

        clienteLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        clienteLabel.setText("Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clienteLabel)
                    .addComponent(clientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clienteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(homePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void selecionaFilmeComBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionaFilmeComBox
      if(filmesComboBox.getSelectedIndex()==-1){
         return;
      }
      Visao<Integer> visaoFilme = (Visao<Integer>)filmesComboBox.getSelectedItem();
      ArrayList<CopiaFilme> arrayCopias = CopiaFilmeDao.getCopiasFilmes(visaoFilme.getChave());
      
      //Popula listaCopias com todas as copias do filmes selecionado no comboBox de filmes
      DefaultListModel modeloList = new DefaultListModel();
      for(CopiaFilme c: arrayCopias){
         modeloList.addElement(c.getVisao());
      }
      listaCopias.setModel(modeloList);
   }//GEN-LAST:event_selecionaFilmeComBox

   private void adicionarAoCarrinhoEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarAoCarrinhoEVT
      if(listaCopias.getSelectedIndex()==-1){
         return;
      }
      
      Visao<Integer> visaoCopia = (Visao<Integer>)listaCopias.getSelectedValue();
      
      if(!verificaSePodeLocar(visaoCopia)){
         JOptionPane.showMessageDialog(this, "Já existe uma cópia deste filme no carrinho.");
         return;
      }
      if(!verificaEstadoDaCopia(visaoCopia)){
         JOptionPane.showMessageDialog(this, "Cópia Indisponível no momento.");
         return;
      }
      
      DefaultListModel modeloCarrinho = new DefaultListModel();
      modeloCarrinho = (DefaultListModel) listaCarrinho.getModel();
      modeloCarrinho.addElement(visaoCopia);
      listaCarrinho.setModel(modeloCarrinho);
      selecionaFilmeComBox(null);
      
   }//GEN-LAST:event_adicionarAoCarrinhoEVT

   private void removerDoCarrinhoItemSelecionadoEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerDoCarrinhoItemSelecionadoEVT
      if(listaCarrinho.getSelectedIndex()==-1){
         return;
      }
      
      int indiceRemovido = listaCarrinho.getSelectedIndex();
      Visao<Integer> visaoCopiaSelecionada = (Visao<Integer>)listaCarrinho.getSelectedValue();
      CopiaFilme copia = CopiaFilmeDao.getCopiaFilme(visaoCopiaSelecionada.getChave());
      if(copia.getEstado()==CopiaFilme.Estado.reservada){
         return;
      }
      ListModel tempModel = listaCarrinho.getModel();
      DefaultListModel modelo = new DefaultListModel();
      
      for(int i=0; i<tempModel.getSize();i++){
         listaCarrinho.setSelectedIndex(i);
         Visao<Integer> visao = (Visao<Integer>)listaCarrinho.getSelectedValue();
         if(listaCarrinho.getSelectedIndex()!=indiceRemovido)
            modelo.addElement(visao);
         
      }
      
      listaCarrinho.setModel(modelo);
      selecionaFilmeComBox(null);
   }//GEN-LAST:event_removerDoCarrinhoItemSelecionadoEVT

   private void cancelarLocacaoEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarLocacaoEVT
      limpaCampos();
   }//GEN-LAST:event_cancelarLocacaoEVT

   private void LocarCopiasEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocarCopiasEVT
      if(isCamposVazio()){
         JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
         return;
      }
      
      //Extrai visao do cliente do comboBox de clientes
      Visao<String> visaoCliente = (Visao<String>)clientesComboBox.getSelectedItem();
      //Instancia cliente apartir da chave que foi pego na visao
      Cliente cliente = ClienteDao.getCliente(visaoCliente.getChave());
      
      
      ArrayList<CopiaFilme> arrayCopias = new ArrayList<CopiaFilme>();
      DefaultListModel modelo = (DefaultListModel)listaCarrinho.getModel();
      //adiciona todos os itens do carrinho para um array
      for(int i=0 ; i<modelo.getSize();i++){
         listaCarrinho.setSelectedIndex(i);
         Visao<Integer> visaoCopia = (Visao<Integer>)listaCarrinho.getSelectedValue();
         CopiaFilme copia = CopiaFilmeDao.getCopiaFilme(visaoCopia.getChave());
         arrayCopias.add(copia);
      }
      
      Calendar calend = Calendar.getInstance();
      Timestamp data = new Timestamp(calend.getTimeInMillis());
      
      DialogLocarCopia dialogo = new DialogLocarCopia(arrayCopias);
      if(dialogo.isConfirm){
         if(controlador.inserir(new Locacao(cliente, arrayCopias, data))){
            JOptionPane.showMessageDialog(this, "Gravado com sucesso.");
            limpaCampos();
         }
         else{
            JOptionPane.showMessageDialog(null, "Não foi possível gravar!", "Informação", JOptionPane.ERROR_MESSAGE);   
         }
      }else{
         JOptionPane.showMessageDialog(this, "Operação cancelada");
      }
   }//GEN-LAST:event_LocarCopiasEVT

   /**
   *Pegar todas as reservas do cliente selecionado e colocar no carrinho as copias reservadas
   */
   private void selecionaClienteComboBox(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecionaClienteComboBox
     if(clientesComboBox.getSelectedIndex()==-1)
        return;
     limpaCamposMenosCliente();
     Visao<String> visaoCliente = (Visao<String>)clientesComboBox.getSelectedItem();
     ArrayList<CopiaFilme> arrayCopiasReservadas = CopiasReservadasDao.getTodasAsCopiasReservadasDoCliente(visaoCliente.getChave());
     
     DefaultListModel modeloCarrinho = new DefaultListModel();
     for(CopiaFilme copia : arrayCopiasReservadas){
        modeloCarrinho.addElement(copia.getVisao());
     }
     
     
     
     listaCarrinho.setModel(modeloCarrinho);
   }//GEN-LAST:event_selecionaClienteComboBox
   private boolean verificaEstadoDaCopia(Visao<Integer> visao){
      CopiaFilme copia = CopiaFilmeDao.getCopiaFilme(visao.getChave());
      if((copia.getEstado() == CopiaFilme.Estado.locada) || (copia.getEstado() == CopiaFilme.Estado.reservada))
         return false;
      
      
      return true;
   }
   private boolean verificaSePodeLocar(Visao<Integer> visaoItemCopia){
      DefaultListModel modeloLista = (DefaultListModel)listaCarrinho.getModel();
      CopiaFilme copiaParaAdicionar = CopiaFilmeDao.getCopiaFilme(visaoItemCopia.getChave());
      
      for(int i=0; i<modeloLista.size();i++){
         listaCarrinho.setSelectedIndex(i);
         Visao<Integer> visaoItemCarrinho = (Visao<Integer>)listaCarrinho.getSelectedValue();
         CopiaFilme copiaNoCarrinho = CopiaFilmeDao.getCopiaFilme(visaoItemCarrinho.getChave());
         
         
         if(copiaParaAdicionar.getFilme().getId()==copiaNoCarrinho.getFilme().getId()){
            return false;
         }
      }
      return true;
   }
   private void limpaCampos(){
      clientesComboBox.setSelectedIndex(-1);
      filmesComboBox.setSelectedIndex(-1);
      
      DefaultListModel modelo = new DefaultListModel();
      modelo.removeAllElements();
      listaCarrinho.setModel(modelo);
      listaCopias.setModel(modelo);
   }
   private void limpaCamposMenosCliente(){
      filmesComboBox.setSelectedIndex(-1);
      
      DefaultListModel modelo = new DefaultListModel();
      modelo.removeAllElements();
      listaCarrinho.setModel(modelo);
      listaCopias.setModel(modelo);
   }
   private boolean isCamposVazio(){
      DefaultListModel modelo = (DefaultListModel)listaCarrinho.getModel();
     
      
      if(clientesComboBox.getSelectedIndex()==-1 || modelo.size()==0)
         return true;
      return false;
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel carrinhoLabel;
    private javax.swing.JLabel clienteLabel;
    private javax.swing.JComboBox clientesComboBox;
    private javax.swing.JComboBox filmesComboBox;
    private javax.swing.JLabel filmesLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listaCarrinho;
    private javax.swing.JList listaCopias;
    private javax.swing.JButton locarButton;
    private javax.swing.JButton removerButton;
    // End of variables declaration//GEN-END:variables
}