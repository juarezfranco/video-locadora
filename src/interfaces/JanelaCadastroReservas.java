package interfaces;

import controle.ControladorReservas;
import entidade.Cliente;
import entidade.Filme;
import entidade.Reserva;
import entidade.Visao;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juarez
 */
public class JanelaCadastroReservas extends javax.swing.JDialog {
   
   private enum Estado{inserindo, editando}
   ControladorReservas controlador;
   Util util = new Util();
   Estado estado=Estado.inserindo;
   int quantidade, ponteiro;
   
   
   public JanelaCadastroReservas(ControladorReservas controlador) {
      super(new javax.swing.JFrame(), true);
      this.controlador = controlador;
      initComponents();
      util.limpaCampos();
      quantidade = (int)quantidade_resultadosSpinner.getValue();
      construirTabela();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      cadastroTabbedPane = new javax.swing.JTabbedPane();
      consultaPanel = new javax.swing.JPanel();
      clienteLabel = new javax.swing.JLabel();
      filmeLabel = new javax.swing.JLabel();
      assunto_filmeLabel = new javax.swing.JLabel();
      filmes_consultaComboBox = new javax.swing.JComboBox();
      assuntos_filmes_consultaComboBox = new javax.swing.JComboBox();
      clientes_consultaComboBox = new javax.swing.JComboBox();
      jScrollPane1 = new javax.swing.JScrollPane();
      resultadoTable = new javax.swing.JTable();
      consultar_reservaButton = new javax.swing.JButton();
      proximoButton = new javax.swing.JButton();
      anteriorButton = new javax.swing.JButton();
      quantidade_resultadosSpinner = new javax.swing.JSpinner();
      nova_consultaButton = new javax.swing.JButton();
      cadastroPanel = new javax.swing.JPanel();
      grupo_botoesPanel = new javax.swing.JPanel();
      remover_reservaButton = new javax.swing.JButton();
      gravar_reservaButton = new javax.swing.JButton();
      nova_reservaButton = new javax.swing.JButton();
      ordem_reservaLabel = new javax.swing.JLabel();
      id_reservaTextField = new javax.swing.JTextField();
      filmes_cadastroComboBox = new javax.swing.JComboBox();
      filmeLabel1 = new javax.swing.JLabel();
      clienteLabel1 = new javax.swing.JLabel();
      clientes_cadastroComboBox = new javax.swing.JComboBox();
      dataTextField = new javax.swing.JTextField();
      dataLabel = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Cadastro de Reservas");

      cadastroTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
      cadastroTabbedPane.setFocusable(false);
      cadastroTabbedPane.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

      clienteLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      clienteLabel.setText("Cliente");

      filmeLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      filmeLabel.setText("Filme");

      assunto_filmeLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      assunto_filmeLabel.setText("Assunto de filmes");

      filmes_consultaComboBox.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      filmes_consultaComboBox.setModel(new DefaultComboBoxModel(new dao.FilmeDao().getVisoes()));

      assuntos_filmes_consultaComboBox.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      assuntos_filmes_consultaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "aventura", "comédia", "drama", "faroeste", "ficção", "guerra", "romance", "suspense", "terror" }));
      assuntos_filmes_consultaComboBox.setSelectedIndex(-1);

      clientes_consultaComboBox.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      clientes_consultaComboBox.setModel(new DefaultComboBoxModel(new dao.ClienteDao().getVisoes()));

      resultadoTable.setModel(construirTabela());
      resultadoTable.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            click_resultadoTableEVT(evt);
         }
      });
      jScrollPane1.setViewportView(resultadoTable);

      consultar_reservaButton.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
      consultar_reservaButton.setText("consultar");
      consultar_reservaButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            consultarReservasButtonEVT(evt);
         }
      });

      proximoButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      proximoButton.setText("->");
      proximoButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            proximoButtonEVT(evt);
         }
      });

      anteriorButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
      anteriorButton.setText("<-");
      anteriorButton.setEnabled(false);
      anteriorButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            anteriorButtonEVT(evt);
         }
      });

      quantidade_resultadosSpinner.setModel(new javax.swing.SpinnerNumberModel(10, 0, 30, 1));
      quantidade_resultadosSpinner.setValue(10);

      nova_consultaButton.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
      nova_consultaButton.setText("+");
      nova_consultaButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            nova_consultaButtonEVT(evt);
         }
      });

      javax.swing.GroupLayout consultaPanelLayout = new javax.swing.GroupLayout(consultaPanel);
      consultaPanel.setLayout(consultaPanelLayout);
      consultaPanelLayout.setHorizontalGroup(
         consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaPanelLayout.createSequentialGroup()
            .addGap(366, 366, 366)
            .addComponent(anteriorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(quantidade_resultadosSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(proximoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGap(256, 256, 256))
         .addGroup(consultaPanelLayout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(clientes_consultaComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(filmes_consultaComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(assuntos_filmes_consultaComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(consultaPanelLayout.createSequentialGroup()
                  .addComponent(assunto_filmeLabel)
                  .addGap(18, 18, 18)
                  .addComponent(nova_consultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(6, 6, 6)
                  .addComponent(consultar_reservaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGap(8, 8, 8))
               .addGroup(consultaPanelLayout.createSequentialGroup()
                  .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(clienteLabel)
                     .addComponent(filmeLabel))
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
         .addComponent(jScrollPane1)
      );
      consultaPanelLayout.setVerticalGroup(
         consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(consultaPanelLayout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(clientes_consultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(clienteLabel))
            .addGap(20, 20, 20)
            .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(filmes_consultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(filmeLabel))
            .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(consultaPanelLayout.createSequentialGroup()
                  .addGap(6, 6, 6)
                  .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(consultaPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(assunto_filmeLabel))
                     .addComponent(nova_consultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(consultar_reservaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(consultaPanelLayout.createSequentialGroup()
                  .addGap(21, 21, 21)
                  .addComponent(assuntos_filmes_consultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
            .addGap(10, 10, 10)
            .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(quantidade_resultadosSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(proximoButton)
               .addComponent(anteriorButton))
            .addGap(8, 8, 8))
      );

      cadastroTabbedPane.addTab("    Consulta    ", consultaPanel);

      grupo_botoesPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

      remover_reservaButton.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
      remover_reservaButton.setText("remover");
      remover_reservaButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            remover_reservaButtonEVT(evt);
         }
      });

      gravar_reservaButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Nb.ScrollPane.Border.color"));
      gravar_reservaButton.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
      gravar_reservaButton.setText("reservar");
      gravar_reservaButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            gravar_reservaButtonEVT(evt);
         }
      });

      nova_reservaButton.setBackground(java.awt.Color.red);
      nova_reservaButton.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
      nova_reservaButton.setText("+");
      nova_reservaButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            nova_reservaButtunEVT(evt);
         }
      });

      javax.swing.GroupLayout grupo_botoesPanelLayout = new javax.swing.GroupLayout(grupo_botoesPanel);
      grupo_botoesPanel.setLayout(grupo_botoesPanelLayout);
      grupo_botoesPanelLayout.setHorizontalGroup(
         grupo_botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(grupo_botoesPanelLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(gravar_reservaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(nova_reservaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12)
            .addComponent(remover_reservaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
            .addGap(20, 20, 20))
      );
      grupo_botoesPanelLayout.setVerticalGroup(
         grupo_botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(grupo_botoesPanelLayout.createSequentialGroup()
            .addGroup(grupo_botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(grupo_botoesPanelLayout.createSequentialGroup()
                  .addGap(12, 12, 12)
                  .addComponent(gravar_reservaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(grupo_botoesPanelLayout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(grupo_botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(remover_reservaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(nova_reservaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap())
      );

      ordem_reservaLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      ordem_reservaLabel.setText("id");

      id_reservaTextField.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      id_reservaTextField.setEnabled(false);

      filmes_cadastroComboBox.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      filmes_cadastroComboBox.setModel(new DefaultComboBoxModel(new dao.FilmeDao().getVisoes()));
      filmes_cadastroComboBox.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            filmes_cadastroComboBoxActionPerformed(evt);
         }
      });

      filmeLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      filmeLabel1.setText("Filme");

      clienteLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      clienteLabel1.setText("Cliente");

      clientes_cadastroComboBox.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
      clientes_cadastroComboBox.setModel(new DefaultComboBoxModel(new dao.ClienteDao().getVisoes()));

      dataTextField.setEnabled(false);

      dataLabel.setText("Data");

      javax.swing.GroupLayout cadastroPanelLayout = new javax.swing.GroupLayout(cadastroPanel);
      cadastroPanel.setLayout(cadastroPanelLayout);
      cadastroPanelLayout.setHorizontalGroup(
         cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(grupo_botoesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(21, 21, 21))
         .addGroup(cadastroPanelLayout.createSequentialGroup()
            .addGap(52, 52, 52)
            .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(clienteLabel1, javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(filmeLabel1, javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(clientes_cadastroComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(filmes_cadastroComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastroPanelLayout.createSequentialGroup()
                     .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(id_reservaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ordem_reservaLabel))
                     .addGap(332, 332, 332)
                     .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dataLabel)
                        .addComponent(dataTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)))))
            .addGap(55, 55, 55))
      );
      cadastroPanelLayout.setVerticalGroup(
         cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastroPanelLayout.createSequentialGroup()
            .addGap(58, 58, 58)
            .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(dataLabel)
               .addComponent(ordem_reservaLabel))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(cadastroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(id_reservaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(dataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(58, 58, 58)
            .addComponent(clienteLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(clientes_cadastroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(94, 94, 94)
            .addComponent(filmeLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(filmes_cadastroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
            .addComponent(grupo_botoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
      );

      cadastroTabbedPane.addTab("    Cadastro    ", cadastroPanel);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(cadastroTabbedPane)
            .addGap(0, 0, 0))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(cadastroTabbedPane)
            .addGap(0, 0, 0))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void nova_reservaButtunEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nova_reservaButtunEVT
      util.limpaCampos();
      estado = Estado.inserindo;
   }//GEN-LAST:event_nova_reservaButtunEVT

   private void gravar_reservaButtonEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravar_reservaButtonEVT
      if(util.isCamposVazio()){
         JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de gravar.");
         return;
      }
      //extrai tds as entradas do usuario;
      Visao<String> visaoCliente = (Visao<String>)clientes_cadastroComboBox.getSelectedItem();
      Visao<Integer>visaoFilme = (Visao<Integer>)filmes_cadastroComboBox.getSelectedItem();
      Calendar dataAtual = Calendar.getInstance();
      Reserva reserva = new Reserva(new Cliente(visaoCliente.getChave()),
                                    new Filme(visaoFilme.getChave()), new Timestamp(dataAtual.getTimeInMillis()));
      
      if(estado==Estado.inserindo){
         if(controlador.inserir(reserva)){
            util.limpaTabela();
         }
         
      }
      else{//estado de EDIÇÃO
         reserva.setId(Integer.parseInt(id_reservaTextField.getText()));
         
         if(controlador.alterar(reserva)){
            atualizarTabela();
            
         }
      }
      
      
      
   }//GEN-LAST:event_gravar_reservaButtonEVT

   private void remover_reservaButtonEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover_reservaButtonEVT
      if(id_reservaTextField.getText().isEmpty()){
         util.limpaCampos();
         //JOptionPane.showMessageDialog(null, "Não foi possível excluir");
         return;
      }
      
      int a = JOptionPane.showConfirmDialog(null, "deseja realmente excluir?", "Cuidado!", JOptionPane.YES_NO_OPTION);
      
      if (a == JOptionPane.YES_OPTION){
         if(controlador.remover(Integer.parseInt(id_reservaTextField.getText()))){
            util.limpaCampos();
            estado=Estado.inserindo;
         }
         else{
            JOptionPane.showMessageDialog(null, "Não foi possível excluir");
         }
      }else{
         JOptionPane.showMessageDialog(null, "operação cancelada");
         
      }
      
      
   }//GEN-LAST:event_remover_reservaButtonEVT

   private void consultarReservasButtonEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarReservasButtonEVT
      ponteiro=0;
      quantidade=(int)quantidade_resultadosSpinner.getValue();
      anteriorButton.setEnabled(false);
      proximoButton.setEnabled(true);
      atualizarTabela();
   }//GEN-LAST:event_consultarReservasButtonEVT

   private void nova_consultaButtonEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nova_consultaButtonEVT
      util.limpaCampos();
   }//GEN-LAST:event_nova_consultaButtonEVT

    private void click_resultadoTableEVT(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_click_resultadoTableEVT
       int linhaSelecionada = resultadoTable.getSelectedRow();
       if(linhaSelecionada>=0){
          //captura id da reserva no campo da tabela de resultados
         int id_reserva = (int)resultadoTable.getValueAt(linhaSelecionada, 0);
         //busca reserva passando id 
         Reserva reserva = controlador.getReserva(id_reserva);
         
         //loop pelo comboBox de clientes
         for(int i=0 ; i<clientes_cadastroComboBox.getItemCount();i++){            
            clientes_cadastroComboBox.setSelectedIndex(i);//posiciona item do comboBox 1 de cada vez
            Visao<String> visaoCliente = (Visao<String>)clientes_cadastroComboBox.getSelectedItem();//captura item do comboBox que esta selecionado no momento
            if(visaoCliente.getChave().compareTo(reserva.getCliente().getCpf())==0){//compara chave do item do comboBox com a chave de clientes da reserva
               break;//sai do for e comboBox fica posicionado corretamente
            }
         }
         //Posiciona comboBox de filmes cadastrados
         for(int i=0 ; i<filmes_cadastroComboBox.getItemCount() ; i++){
            filmes_cadastroComboBox.setSelectedIndex(i);
            Visao<Integer> visaoFilme = (Visao<Integer>)filmes_cadastroComboBox.getSelectedItem();
            if(visaoFilme.getChave()==reserva.getFilme().getId())
               break;
         }
         id_reservaTextField.setText(Integer.toString(reserva.getId()));
         dataTextField.setText(reserva.getData().toString());
         estado = Estado.editando;
         cadastroTabbedPane.setSelectedIndex(1);
         
         
         
         estado = Estado.editando;
       }
    }//GEN-LAST:event_click_resultadoTableEVT

   private void proximoButtonEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximoButtonEVT
      
      
      
      if((int)quantidade_resultadosSpinner.getValue()<0)
         return;
      ponteiro+=quantidade;
      atualizarTabela();
      anteriorButton.setEnabled(true);
      if(resultadoTable.getRowCount()<quantidade)
         proximoButton.setEnabled(false);
      
   }//GEN-LAST:event_proximoButtonEVT

   private void anteriorButtonEVT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorButtonEVT
      
      
      if((int)quantidade_resultadosSpinner.getValue()<0||ponteiro<quantidade)
         return;
      
      ponteiro-=quantidade;
      
      atualizarTabela();
      proximoButton.setEnabled(true);
      if(resultadoTable.getRowCount()<=0)
         proximoButton.setEnabled(false);
   }//GEN-LAST:event_anteriorButtonEVT

   private void filmes_cadastroComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmes_cadastroComboBoxActionPerformed
      if(filmes_cadastroComboBox.getSelectedIndex()==-1){
         return;
      }
   }//GEN-LAST:event_filmes_cadastroComboBoxActionPerformed
   
   private void atualizarTabela(){
      String cpf_cliente, assunto_filme;
      int idFilme;
      Visao<Integer> visaoFilme = new Visao();
      Visao<String> visaoCliente = new Visao();
      
      if(clientes_consultaComboBox.getSelectedIndex()==-1)
         cpf_cliente=null;
      else{
         visaoCliente = (Visao<String>)clientes_consultaComboBox.getSelectedItem();
         cpf_cliente = visaoCliente.getChave();
      }
      
      if(filmes_consultaComboBox.getSelectedIndex()==-1)
         idFilme=-1;
      else{
         visaoFilme = (Visao<Integer>)filmes_consultaComboBox.getSelectedItem();
         idFilme = visaoFilme.getChave();
      }
      if(assuntos_filmes_consultaComboBox.getSelectedIndex()==-1)
      assunto_filme=null;
      else{
         assunto_filme = assuntos_filmes_consultaComboBox.getSelectedItem().toString();
      }
      
      
      
      quantidade = (int)quantidade_resultadosSpinner.getValue();
      ArrayList<Object[]> reservasSelecionadas = controlador.consultaReservas(cpf_cliente, idFilme, assunto_filme,ponteiro,quantidade);
      
      DefaultTableModel modelo = construirTabela();
      
      for(int i=0;i<reservasSelecionadas.size();i++){
         modelo.addRow(reservasSelecionadas.get(i));
      }
      
      resultadoTable.setModel(modelo);
   }
   
   private DefaultTableModel construirTabela(){
      DefaultTableModel modelo = new DefaultTableModel();
      modelo.addColumn("ID Reserva");
      modelo.addColumn("Cliente");
      modelo.addColumn("ID Filme");
      modelo.addColumn("Titulo");
      modelo.addColumn("Assunto");
      modelo.addColumn("Data da reservas");
      modelo.rowsRemoved(null);
      return modelo;
   }
   
   private class Util{
      public  void limpaCampos(){
         resultadoTable.setModel(construirTabela());
         clientes_consultaComboBox.setSelectedIndex(-1);
         filmes_consultaComboBox.setSelectedIndex(-1);
         id_reservaTextField.setText("");
         assuntos_filmes_consultaComboBox.setSelectedIndex(-1);
         clientes_cadastroComboBox.setSelectedIndex(-1);
         filmes_cadastroComboBox.setSelectedIndex(-1);
         estado = estado.inserindo;
         dataTextField.setText("");
         
      }
      public boolean isCamposVazio(){
         if(clientes_cadastroComboBox.getSelectedIndex()==-1 || filmes_cadastroComboBox.getSelectedIndex()==-1)
            return true;
         return false;
      }
      public void limpaTabela(){
         
         
         DefaultTableModel modelo = new DefaultTableModel();
         modelo.rowsRemoved(null);
         
         resultadoTable.setModel(modelo);
         clientes_cadastroComboBox.setSelectedIndex(-1);
         filmes_cadastroComboBox.setSelectedIndex(-1);
         
         
         
      }
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton anteriorButton;
   private javax.swing.JLabel assunto_filmeLabel;
   private javax.swing.JComboBox assuntos_filmes_consultaComboBox;
   private javax.swing.JPanel cadastroPanel;
   private javax.swing.JTabbedPane cadastroTabbedPane;
   private javax.swing.JLabel clienteLabel;
   private javax.swing.JLabel clienteLabel1;
   private javax.swing.JComboBox clientes_cadastroComboBox;
   private javax.swing.JComboBox clientes_consultaComboBox;
   private javax.swing.JPanel consultaPanel;
   private javax.swing.JButton consultar_reservaButton;
   private javax.swing.JLabel dataLabel;
   private javax.swing.JTextField dataTextField;
   private javax.swing.JLabel filmeLabel;
   private javax.swing.JLabel filmeLabel1;
   private javax.swing.JComboBox filmes_cadastroComboBox;
   private javax.swing.JComboBox filmes_consultaComboBox;
   private javax.swing.JButton gravar_reservaButton;
   private javax.swing.JPanel grupo_botoesPanel;
   private javax.swing.JTextField id_reservaTextField;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JButton nova_consultaButton;
   private javax.swing.JButton nova_reservaButton;
   private javax.swing.JLabel ordem_reservaLabel;
   private javax.swing.JButton proximoButton;
   private javax.swing.JSpinner quantidade_resultadosSpinner;
   private javax.swing.JButton remover_reservaButton;
   private javax.swing.JTable resultadoTable;
   // End of variables declaration//GEN-END:variables
}