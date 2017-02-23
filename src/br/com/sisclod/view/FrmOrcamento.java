/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.FuncionarioDAO;
import br.com.sisclod.dao.OrcamentoDAO;
import br.com.sisclod.dao.PacienteDAO;
import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Funcionario;
import br.com.sisclod.model.ModeloTabela;
import br.com.sisclod.model.Orcamento;
import br.com.sisclod.relatorios.util.GeradorRelatorio;
import static br.com.sisclod.view.FrmAtendimento.jTextFieldCod;
import static br.com.sisclod.view.FrmAtendimento.jTextFieldNomPaciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rootux
 */
public class FrmOrcamento extends javax.swing.JFrame {

    public static int b;
    public static String a;

    /**
     * Creates new form FrmOrcamento
     */
    public FrmOrcamento() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        jButtonNovo.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonImprimir.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldCod.setEditable(false);
        jTextFieldnumeroOrca.setEditable(false);
        jTextFieldNomPaciente.setEditable(false);
        jTextFieldDesco.setVisible(false);
        //jTextFieldValor.setEditable(false);
    }

    public void popularTabela() throws SQLException {
        String[] coluna = new String[]{"ID", "PROCEDIMENTO", "QUANTIDADE", "VALOR", "TOTAL"};
        ArrayList dados = new ArrayList();
        OrcamentoDAO dao = new OrcamentoDAO();
        ArrayList<Orcamento> listagem;
        DecimalFormat df = new DecimalFormat("0.##");
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        String cod = jTextFieldnumeroOrca.getText();
        listagem = (ArrayList<Orcamento>) dao.lista(cod);
        for (Orcamento orcamento : listagem) {
            dados.add(new Object[]{orcamento.getNrOrcamento(), orcamento.getProcedimento(), orcamento.getQuantidade(), nf.format(orcamento.getValor()), nf.format(orcamento.getVlTotal())});
        }

        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTableOrcamento.setModel(modelo);
            jTableOrcamento.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableOrcamento.getColumnModel().getColumn(0).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTableOrcamento.getColumnModel().getColumn(1).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(2).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(3).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(4).setResizable(false);
            jTableOrcamento.getTableHeader().setReorderingAllowed(false);
            jTableOrcamento.setAutoResizeMode(jTableOrcamento.AUTO_RESIZE_OFF);
            jTableOrcamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }

    }

    public void LiberarCampos() {

        jButtonNovo.setEnabled(true);
        jButtonEditar.setEnabled(true);
        jButtonImprimir.setEnabled(true);
        jButtonExcluir.setEnabled(true);

    }

    public void getNome(String cod) {
        Connection conexao = null;
        try {
            conexao = Database.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = ("SELECT tbpaciente.noPaciente\n"
                + "FROM tbpaciente\n"
                + "INNER JOIN tborcamento ON tbpaciente.idPaciente = tborcamento.idPaciente where tborcamento.nrOrcamento = '" + cod + "' ");

        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                a = rs.getString("tbpaciente.noPaciente");

                jTextFieldNomPaciente.setText(a);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOrcamento = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jTextFieldNomPaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldCod = new javax.swing.JTextField();
        jToolBar4 = new javax.swing.JToolBar();
        jBBuscaCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldnumeroOrca = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldProcedimento = new javax.swing.JTextField();
        jtextQuant = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jTextFieldDesco = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orçamento");

        jTableOrcamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableOrcamento);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Orçamentos");

        jButtonNovo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\add1.png")); // NOI18N
        jButtonNovo.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\edit.png")); // NOI18N
        jButtonEditar.setMinimumSize(new java.awt.Dimension(60, 60));
        jButtonEditar.setPreferredSize(new java.awt.Dimension(60, 60));

        jButtonExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\trash.png")); // NOI18N
        jButtonExcluir.setPreferredSize(new java.awt.Dimension(60, 60));

        jButtonImprimir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Printer-blue.png")); // NOI18N
        jButtonImprimir.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextFieldNomPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomPacienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nome do Paciente:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Codigo:");

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

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Accept.png")); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\search.png")); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNomPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscaCliente))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCod, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jBBuscaCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonSair.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Arrow-turn-left.png")); // NOI18N
        jButtonSair.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("N° Orcamento.:");

        jTextFieldnumeroOrca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldnumeroOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldnumeroOrcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(280, 280, 280)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldnumeroOrca, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldnumeroOrca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Orçamento", jPanel1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Procedimento..:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Quantidade..:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Valor..:");

        jtextQuant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextQuantActionPerformed(evt);
            }
        });

        jTextFieldDesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDescoActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\add1.png")); // NOI18N
        jButton5.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Clockwise-arrow.png")); // NOI18N
        jButton6.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Arrow-turn-left.png")); // NOI18N
        jButton7.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setText("Buscar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton11))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldDesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtextQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtextQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jTextFieldDesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Adicionar", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDescoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDescoActionPerformed

    private void jtextQuantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextQuantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextQuantActionPerformed

    private void jTextFieldNomPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomPacienteActionPerformed

    private void jBBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscaClienteActionPerformed

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

    }//GEN-LAST:event_jBBuscaClienteActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        BuscarProcedimento jdb = null;
        try {
            jdb = new BuscarProcedimento(this, true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        DecimalFormat df = new DecimalFormat("0.##");

        jdb.setVisible(true);
        String cod = jdb.getId();
        String nome = jdb.getNome();
        String valore = jdb.getValor().replace("R", "");
        valore = valore.replace("$", "");
        valore = valore.replace(",", ".");

        jTextFieldValor.setText(valore);
        jTextFieldProcedimento.setText(nome);

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed

        jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        int codigo = Integer.parseInt(jTextFieldCod.getText());
        String procedimento = jTextFieldProcedimento.getText();
        double valor = Double.parseDouble(jTextFieldValor.getText());
        int quantidade = Integer.parseInt(jtextQuant.getText());
        double VlTotal = quantidade * valor;
        int numeroOrcamento = Integer.parseInt(a);

        Orcamento orcamento = new Orcamento();

        orcamento.setIdPaciente(codigo);
        orcamento.setProcedimento(procedimento);
        orcamento.setValor(valor);
        orcamento.setQuantidade(quantidade);
        orcamento.setVlTotal(VlTotal);
        orcamento.setNrOrcamento(numeroOrcamento);

        OrcamentoDAO dao = null;
        try {
            dao = new OrcamentoDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            dao.gravar(orcamento);
            popularTabela();
            limparCampos();

        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextFieldnumeroOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldnumeroOrcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldnumeroOrcaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LiberarCampos();

        Connection conexao = null;
        try {
            conexao = Database.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = ("SELECT  nrOrcamento \n"
                + "FROM  tborcamento\n"
                + "ORDER BY  nrOrcamento DESC \n"
                + "LIMIT 1");

        PreparedStatement stmt = null;
        try {
            stmt = conexao.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultSet rs = null;
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                a = rs.getString("nrOrcamento");
                b = Integer.parseInt(a) + 1;
                a = "" + b;
                jTextFieldnumeroOrca.setText(a);

            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
dispose();    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jdialogNumeroOrcamentoAbrir jdb = null;
        jdb = new jdialogNumeroOrcamentoAbrir(this, true);
        jdb.setVisible(true);
        String cod = jdb.getId();
        jButtonImprimir.setEnabled(true);
        jButtonSair.setEnabled(true);

        jTextFieldnumeroOrca.setText(cod);
        getNome(cod);
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        DecimalFormat df = new DecimalFormat("0.##");

        String[] coluna = new String[]{"ID", "PROCEDIMENTO", "QUANTIDADE", "VALOR", "VALOR TOTAL "};
        ArrayList dados = new ArrayList();
        OrcamentoDAO dao = null;
        try {
            dao = new OrcamentoDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Orcamento> listagem = null;

        try {
            listagem = (ArrayList<Orcamento>) dao.listaAbrir(cod);
        } catch (SQLException ex) {
            Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Orcamento orcamento : listagem) {
            dados.add(new Object[]{orcamento.getNrOrcamento(), orcamento.getProcedimento(), orcamento.getQuantidade(), nf.format(orcamento.getValor()), nf.format(orcamento.getVlTotal())});
        }

        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTableOrcamento.setModel(modelo);
            jTableOrcamento.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableOrcamento.getColumnModel().getColumn(0).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(1).setPreferredWidth(400);
            jTableOrcamento.getColumnModel().getColumn(1).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(2).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(3).setResizable(false);
            jTableOrcamento.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTableOrcamento.getColumnModel().getColumn(4).setResizable(false);
            jTableOrcamento.getTableHeader().setReorderingAllowed(false);
            jTableOrcamento.setAutoResizeMode(jTableOrcamento.AUTO_RESIZE_OFF);
            jTableOrcamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed

        String cod = jTextFieldnumeroOrca.getText();
        JasperViewer jv = new JasperViewer(GeradorRelatorio.getRelatorioOrcamento(cod), false);

        jv.setTitle("RELATÓRIO DE PROCEDIMENTOS");
        jv.setVisible(true);
        jv.toFront();
        jv.setExtendedState(jv.MAXIMIZED_BOTH);    }//GEN-LAST:event_jButtonImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(FrmOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrcamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmOrcamento().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscaCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableOrcamento;
    private javax.swing.JTextField jTextFieldCod;
    private javax.swing.JTextField jTextFieldDesco;
    private javax.swing.JTextField jTextFieldNomPaciente;
    private javax.swing.JTextField jTextFieldProcedimento;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JTextField jTextFieldnumeroOrca;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JTextField jtextQuant;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {

        jTextFieldProcedimento.setText("");
        jTextFieldValor.setText("");
        jtextQuant.setText("");
        jTextFieldDesco.setText("");

    }
}
