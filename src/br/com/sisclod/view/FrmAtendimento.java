/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.AtendimentoDAO;
import br.com.sisclod.dao.FuncionarioDAO;
import br.com.sisclod.model.Atendimento;
import br.com.sisclod.model.Funcionario;
import br.com.sisclod.model.ModeloTabela;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;
import br.com.sisclod.factory.Database;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Dih
 */

public class FrmAtendimento extends javax.swing.JFrame {

    static Database conexao = new Database();
    Atendimento atendimento = new Atendimento();
    AtendimentoDAO dao = new AtendimentoDAO();
    int flagIserir = 0;
    int flagAtender = 1;
    public static float primeiroItem;
    private Object FrmPrincipalPrincipal;

    public FrmAtendimento() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        popularTabela();
        popularComboFuncionario();
        jTextFieldCod.setEnabled(false);
        jTextFieldNomPaciente.setEditable(false);
        jDateChooser1.setMinSelectableDate(Calendar.getInstance().getTime());

        jBInserir.setEnabled(false);
        jBEditar.setEnabled(true);
        jbExcluir.setEnabled(true);
        jBBuscaCliente.setEnabled(false);
        limparCampos();
    }

    public static void recebendo(String recebe) {
        jTextFieldNomPaciente.setText(recebe);
    }

    public static void recebendo2(String recebe2) {
        jTextFieldCod.setText(recebe2);
    }
public void Habilitar(){
       jBInserir.setEnabled(true);
        jBEditar.setEnabled(true);
        jbExcluir.setEnabled(true);
        jBBuscaCliente.setEnabled(true);

}
public void Desabilitar(){
       jBInserir.setEnabled(false);
        jBEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jBBuscaCliente.setEnabled(false);

}
    public void popularComboFuncionario() {

        FuncionarioDAO dao = null;
        try {
            dao = new FuncionarioDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Funcionario> funcionarios = null;
        try {
            funcionarios = dao.listaOdontologista();
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        jComboBoxFuncionario.removeAllItems();
        for (int i = 0; i < funcionarios.size(); i++) {
            jComboBoxFuncionario.addItem(funcionarios.get(i).getNome());
            //jComboBoxUF.addItem(String.valueOf(estados.get(i).getId()+""));
            String valor = (String) jComboBoxFuncionario.getSelectedItem();
        }

    }

    private void popularTabela() throws SQLException {

        String[] coluna = new String[]{"ID", "NOME", "DATA", "HORA", "STATUS"};
        ArrayList dados = new ArrayList();
        AtendimentoDAO dao = new AtendimentoDAO();
        ArrayList<Atendimento> listagem;

        listagem = (ArrayList<Atendimento>) dao.getLista1();
        for (Atendimento atendimento : listagem) {
            dados.add(new Object[]{atendimento.getId(), atendimento.getNomePaciente(), atendimento.getData(), atendimento.getHora(), atendimento.getStatus()});
        }

        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTableAtendimento.setModel(modelo);
            jTableAtendimento.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableAtendimento.getColumnModel().getColumn(0).setResizable(false);
            jTableAtendimento.getColumnModel().getColumn(1).setPreferredWidth(380);
            jTableAtendimento.getColumnModel().getColumn(1).setResizable(false);
            jTableAtendimento.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableAtendimento.getColumnModel().getColumn(2).setResizable(false);
            jTableAtendimento.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableAtendimento.getColumnModel().getColumn(3).setResizable(false);
            jTableAtendimento.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTableAtendimento.getColumnModel().getColumn(4).setResizable(false);
            jTableAtendimento.getTableHeader().setReorderingAllowed(false);
            jTableAtendimento.setAutoResizeMode(jTableAtendimento.AUTO_RESIZE_OFF);
            jTableAtendimento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }

    }

    private void formatarCampoData(JFormattedTextField campo) {

        try {
            MaskFormatter novo = new MaskFormatter("##/##/####");
            novo.setValidCharacters("0123456789");
            novo.install(campo);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi poessível formatar campo \nDetalhes:" + ex, "Aviso!", WIDTH);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTextFieldNomPaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCod = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jBBuscaCliente = new javax.swing.JButton();
        jPanelAte = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAtendimento = new javax.swing.JTable();
        jComboBoxFuncionario = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxServico = new javax.swing.JComboBox();
        jToolBar1 = new javax.swing.JToolBar();
        jToolBar3 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxHora1 = new javax.swing.JComboBox();
        jComboBoxHora2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaOBs = new javax.swing.JTextArea();
        jBEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton3 = new javax.swing.JButton();
        jBInserir = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldNomPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomPacienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nome do Paciente:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Codigo:");

        jToolBar4.setBorder(null);
        jToolBar4.setRollover(true);

        jBBuscaCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBBuscaCliente.setText("Buscar");
        jBBuscaCliente.setToolTipText("Buscar Cliente");
        jBBuscaCliente.setMargin(new java.awt.Insets(3, 14, 3, 14));
        jBBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscaClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextFieldNomPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscaCliente)))
                    .addComponent(jLabel2))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNomPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jBBuscaCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanelAte.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableAtendimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableAtendimento);

        jComboBoxFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Odontologista.:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Descrição do Serviço:");

        jComboBoxServico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBoxServico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ATENDIMENTO ODONTOLÓGICO", "ORÇAMENTO ODONTOLÓGICO" }));

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);
        jToolBar1.setMargin(new java.awt.Insets(12, 14, 12, 14));

        jToolBar3.setBorder(null);
        jToolBar3.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Data:");

        jComboBoxHora1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "08", "09", "10", "11", "13", "14", "15", "16", " " }));

        jComboBoxHora2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "30" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Hora:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText(":");

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AGENDADA", "CONCLUIDA" }));
        jComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatusActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Status:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Observação:");

        jTextAreaOBs.setColumns(20);
        jTextAreaOBs.setRows(5);
        jTextAreaOBs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaOBsKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaOBs);

        jBEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\edit.png")); // NOI18N
        jBEditar.setToolTipText("Excluir Atendimento");
        jBEditar.setMargin(new java.awt.Insets(12, 14, 12, 14));
        jBEditar.setPreferredSize(new java.awt.Dimension(60, 60));
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\trash.png")); // NOI18N
        jbExcluir.setPreferredSize(new java.awt.Dimension(60, 60));
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Arrow-turn-left.png")); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jBInserir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBInserir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Save.png")); // NOI18N
        jBInserir.setToolTipText("Inserir Atendimento");
        jBInserir.setMargin(new java.awt.Insets(12, 14, 12, 14));
        jBInserir.setPreferredSize(new java.awt.Dimension(60, 60));
        jBInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInserirActionPerformed(evt);
            }
        });

        jButtonNovo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\add1.png")); // NOI18N
        jButtonNovo.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Agenda de Hoje");

        javax.swing.GroupLayout jPanelAteLayout = new javax.swing.GroupLayout(jPanelAte);
        jPanelAte.setLayout(jPanelAteLayout);
        jPanelAteLayout.setHorizontalGroup(
            jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAteLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jBInserir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAteLayout.createSequentialGroup()
                        .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelAteLayout.createSequentialGroup()
                                .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelAteLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(111, 111, 111)
                                        .addComponent(jLabel9))
                                    .addGroup(jPanelAteLayout.createSequentialGroup()
                                        .addGap(254, 254, 254)
                                        .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelAteLayout.createSequentialGroup()
                                        .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelAteLayout.createSequentialGroup()
                                                .addComponent(jComboBoxServico, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelAteLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(102, 102, 102)
                                                .addComponent(jLabel1)))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanelAteLayout.createSequentialGroup()
                                                .addComponent(jComboBoxHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8)
                                                .addGap(1, 1, 1)
                                                .addComponent(jComboBoxHora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelAteLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBoxFuncionario, 0, 377, Short.MAX_VALUE)))
                            .addGroup(jPanelAteLayout.createSequentialGroup()
                                .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))
                    .addGroup(jPanelAteLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelAteLayout.setVerticalGroup(
            jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAteLayout.createSequentialGroup()
                .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAteLayout.createSequentialGroup()
                        .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxServico, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelAteLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxHora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAteLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAteLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addGroup(jPanelAteLayout.createSequentialGroup()
                        .addGroup(jPanelAteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(jBEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBInserir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3))
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setText("Agenda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanelAte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanelAte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomPacienteActionPerformed

    private void jBBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscaClienteActionPerformed

        /*     FrmBuscarPaciente framePaciente = null;
         try {
         framePaciente = new FrmBuscarPaciente();
         } catch (SQLException ex) {
         Logger.getLogger(FrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
         }
       
         framePaciente.setVisible(true);
         */
        BuscarPaciente jdb = null;
        try {
            jdb = new BuscarPaciente(this, true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
        jdb.setVisible(true);
        String cod = jdb.getId2();
        String nome = jdb.getNome();

        jTextFieldCod.setText(cod);
        jTextFieldNomPaciente.setText(nome);
//String codigo =  frmlocal.ge
         /* FrmBuscarPaciente frm = null;
         try {
         frm = new FrmBuscarPaciente();
         } catch (SQLException ex) {
         Logger.getLogger(FrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
         }
         frm.toFront();
         frm.setVisible(true);
         */
    }//GEN-LAST:event_jBBuscaClienteActionPerformed

    private void jComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStatusActionPerformed

    private void jBInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInserirActionPerformed

        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(jDateChooser1.getDate());

        String data = simpleDate.format(jDateChooser1.getDate());
        String paciente = jTextFieldCod.getText().toUpperCase();
        String funcionario = (String) jComboBoxFuncionario.getSelectedItem();
        String servico = (String) jComboBoxServico.getSelectedItem();
           // String data = jFormattedTextFieldData.getText();
        //  String data = simpleDate.format(jDateChooser1);

        System.out.println(data);

        String hora1 = (String) jComboBoxHora1.getSelectedItem();
        String hora2 = (String) jComboBoxHora2.getSelectedItem();
        String obs = jTextAreaOBs.getText();
        String status = (String) jComboBoxStatus.getSelectedItem();

        String hora = hora1 + ":" + hora2;
        int idPaciente = Integer.parseInt(paciente);

        Atendimento atendimento = new Atendimento();

        atendimento.setIdPaciente(idPaciente);
        atendimento.setIdFuncionario(funcionario);
        atendimento.setServico(servico);
        atendimento.setData(data);
        atendimento.setHora(hora);
        atendimento.setStatus(status);
        atendimento.setObs(obs);

        AtendimentoDAO dao = null;
        try {
            dao = new AtendimentoDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

        }

        try {
            dao.gravar(atendimento);
            try {
                popularTabela();
                limparCampos();
                Desabilitar();
                JOptionPane.showMessageDialog(rootPane, "Agendado com sucesso!! ");

            } catch (SQLException ex) {
                Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

        }


    }//GEN-LAST:event_jBInserirActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        String id1 = "" + (jTableAtendimento.getValueAt(jTableAtendimento.getSelectedRow(), 0));
        int id = Integer.parseInt(id1);
        Atendimento atendimento = new Atendimento();
        atendimento.setId(id);
        AtendimentoDAO dao = null;

        try {
            dao = new AtendimentoDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Excluir o Agendamento", "Confirmar a Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                dao.excluir(atendimento);
                popularTabela();
                JOptionPane.showMessageDialog(rootPane, "Agendamento Excluido ");

            } catch (SQLException ex) {
                Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (resposta == JOptionPane.NO_OPTION) {


      }    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
limparCampos();

       
        try {
            String id1 = "" + (jTableAtendimento.getValueAt(jTableAtendimento.getSelectedRow(), 0));

            int id = Integer.parseInt(id1);
            Atendimento atendimento = new Atendimento();

            AtendimentoDAO dao = new AtendimentoDAO();
            dao.getAtendimento(id);

             int paciente = dao.paciente;
             String servico= dao.servico;
              String data = dao.data;
              String hora1= dao.hora1;
              String hora2= dao.hora2;

              String obs= dao.obs;
               String funcionario= dao.funcionario;
               String status= dao.status;
            

            this.jTextAreaOBs.setText(obs);
            this.jComboBoxFuncionario.setSelectedItem(funcionario);
             this.jComboBoxHora1.setSelectedItem(hora1);
             this.jComboBoxHora2.setSelectedItem(hora2);
              this.jComboBoxServico.setSelectedItem(servico);
               this.jComboBoxStatus.setSelectedItem(status);
               this.jDateChooser1.setDateFormatString(data);
        } catch (SQLException ex) {
            Logger.getLogger(FrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }




    }//GEN-LAST:event_jBEditarActionPerformed

    private void jTextAreaOBsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaOBsKeyTyped
        String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if (jTextAreaOBs.getText().length() >= limite) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextAreaOBsKeyTyped

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        limparCampos();
        Habilitar();

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void popularTabela(String data) throws SQLException {
        
       
            String[] coluna = new String[]{"NOME","SERVIÇO", "DATA","HORA"};
            ArrayList dados = new ArrayList();
            AtendimentoDAO dao = new AtendimentoDAO();
            ArrayList<Atendimento> listagem;
       
            //SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
              //     System.out.println(jDateChooserDataPesquisa.getDate());
 
    //    String data = simpleDate.format(jDateChooserDataPesquisa.getDate());
        
                listagem = (ArrayList<Atendimento>) dao.getListaJoinData(data);
                        for (Atendimento atendimento : listagem) {
                            dados.add(new Object[]{ atendimento.getNomePaciente(),atendimento.getServico(), atendimento.getData(),atendimento.getHora()});
                    }
        
           
       
                 ModeloTabela modelo = new ModeloTabela(dados, coluna);

                try {
                    jTableAtendimento.setModel(modelo);
                    jTableAtendimento.getColumnModel().getColumn(0).setPreferredWidth(300);
                    jTableAtendimento.getColumnModel().getColumn(0).setResizable(false);
                    jTableAtendimento.getColumnModel().getColumn(1).setPreferredWidth(200);
                    jTableAtendimento.getColumnModel().getColumn(1).setResizable(false);
                    jTableAtendimento.getColumnModel().getColumn(2).setPreferredWidth(100);
                    jTableAtendimento.getColumnModel().getColumn(2).setResizable(false);
                    jTableAtendimento.getColumnModel().getColumn(3).setPreferredWidth(100);
                    jTableAtendimento.getColumnModel().getColumn(3).setResizable(false);
                    jTableAtendimento.getTableHeader().setReorderingAllowed(false);
                    jTableAtendimento.setAutoResizeMode(jTableAtendimento.AUTO_RESIZE_OFF);
                    jTableAtendimento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            } catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }
        
    }
    public void limparCampos() {
        jTextFieldNomPaciente.setText(null);
        jTextAreaOBs.setText(null);
        jTextFieldCod.setText(null);
        jDateChooser1.setDate(null);
        jComboBoxFuncionario.setSelectedItem(null);
        jComboBoxHora1.setSelectedItem(null);
        jComboBoxHora2.setSelectedItem(null);
        jComboBoxServico.setSelectedItem(null);
        jComboBoxStatus.setSelectedItem(null);
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmAtendimento().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmAtendimento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscaCliente;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBInserir;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JComboBox jComboBoxFuncionario;
    private javax.swing.JComboBox jComboBoxHora1;
    private javax.swing.JComboBox jComboBoxHora2;
    private javax.swing.JComboBox jComboBoxServico;
    private javax.swing.JComboBox jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelAte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAtendimento;
    private javax.swing.JTextArea jTextAreaOBs;
    public static javax.swing.JTextField jTextFieldCod;
    public static javax.swing.JTextField jTextFieldNomPaciente;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JButton jbExcluir;
    // End of variables declaration//GEN-END:variables
}
