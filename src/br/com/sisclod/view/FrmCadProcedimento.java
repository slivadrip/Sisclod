/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.CidadeDAO;
import br.com.sisclod.dao.PacienteDAO;
import br.com.sisclod.dao.ProcedimentoDAO;
import br.com.sisclod.model.Cidade;
import br.com.sisclod.model.ModeloTabela;
import br.com.sisclod.model.Paciente;
import br.com.sisclod.model.Procedimento;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author rootux
 */
public class FrmCadProcedimento extends javax.swing.JFrame {

    public int muda = 1;

    /**
     * Creates new form FrmCadProcedimento
     */
    public FrmCadProcedimento() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
     //   popularTabela();
        jLabelObrigNome.setVisible(false);
        jLabelObrigValor.setVisible(false);

    }

    private void popularTabela() throws SQLException {

        String[] coluna = new String[]{"ID", "NOME", "VALOR"};
        ArrayList dados = new ArrayList();
        ProcedimentoDAO dao = new ProcedimentoDAO();
        ArrayList<Procedimento> listagem;
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        listagem = (ArrayList<Procedimento>) dao.lista();
        for (Procedimento procedimento : listagem) {
            dados.add(new Object[]{procedimento.getId(), procedimento.getNome(), nf.format(procedimento.getValor())});
        }

        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTableProcedimento.setModel(modelo);
            jTableProcedimento.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableProcedimento.getColumnModel().getColumn(0).setResizable(false);
            jTableProcedimento.getColumnModel().getColumn(1).setPreferredWidth(610);
            jTableProcedimento.getColumnModel().getColumn(1).setResizable(false);
            jTableProcedimento.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTableProcedimento.getColumnModel().getColumn(2).setResizable(false);

            jTableProcedimento.getTableHeader().setReorderingAllowed(false);
            jTableProcedimento.setAutoResizeMode(jTableProcedimento.AUTO_RESIZE_OFF);
            jTableProcedimento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }

    }

    private void popularTabela2() throws SQLException {

        String[] coluna = new String[]{"ID", "NOME", "VALOR"};
        ArrayList dados = new ArrayList();
        ProcedimentoDAO dao = new ProcedimentoDAO();
        ArrayList<Procedimento> listagem;

        String pesquisa = jTextFieldPesquisar.getText();

        listagem = (ArrayList<Procedimento>) dao.lista2(pesquisa);
        for (Procedimento procedimento : listagem) {
            dados.add(new Object[]{procedimento.getId(), procedimento.getNome(), procedimento.getValor()});
        }

        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTableProcedimento.setModel(modelo);
            jTableProcedimento.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTableProcedimento.getColumnModel().getColumn(0).setResizable(false);
            jTableProcedimento.getColumnModel().getColumn(1).setPreferredWidth(610);
            jTableProcedimento.getColumnModel().getColumn(1).setResizable(false);
            jTableProcedimento.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTableProcedimento.getColumnModel().getColumn(2).setResizable(false);

            jTableProcedimento.getTableHeader().setReorderingAllowed(false);
            jTableProcedimento.setAutoResizeMode(jTableProcedimento.AUTO_RESIZE_OFF);
            jTableProcedimento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }

    }

    public void alterar() throws SQLException {

        if (jTableProcedimento.getSelectedRow() != -1) {
            String id1 = "" + (jTableProcedimento.getValueAt(jTableProcedimento.getSelectedRow(), 0));

            int id = Integer.parseInt(id1);
            System.out.println("id..:" + id);

            String nome = jTextFieldNomeProce.getText().toUpperCase();
            String valor = jTextFieldValorProced.getText().toUpperCase();
            String obs = jTextAreaObservacao.getText().toUpperCase();
            double valor1 = Double.parseDouble(valor);
            Procedimento procedimento = new Procedimento();

            ProcedimentoDAO dao = new ProcedimentoDAO();

            procedimento.setNome(nome);
            procedimento.setValor(valor1);
            procedimento.setObs(obs);
            procedimento.setId(id);

            dao.alterar(procedimento);

            JOptionPane.showMessageDialog(rootPane, "Procedimento Alterado com Sucesso");

            this.popularTabela();

        }
    }

    public void FormataCampoValor(JFormattedTextField campo) {

        try {
            MaskFormatter novo = new MaskFormatter("###.##");
            novo.setValidCharacters("0123456789");
            novo.install(campo);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi poessível formatar campo \nDetalhes:" + ex, "Aviso!", WIDTH);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProcedimento = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jTextFieldValorProced = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservacao = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonLimpar = new javax.swing.JButton();
        jTextFieldNomeProce = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabelObrigNome = new javax.swing.JLabel();
        jLabelObrigValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Procedimentos");

        jPanel1.setToolTipText("");

        jTableProcedimento.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTableProcedimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableProcedimento);

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\add1.png")); // NOI18N
        jButton4.setToolTipText("Novo");
        jButton4.setAutoscrolls(true);
        jButton4.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\edit.png")); // NOI18N
        jButtonEditar.setToolTipText("Editar");
        jButtonEditar.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\trash.png")); // NOI18N
        jButton6.setToolTipText("Excluir");
        jButton6.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Arrow-turn-left.png")); // NOI18N
        jButton7.setToolTipText("Voltar");
        jButton7.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Pesquisa:");

        jTextFieldPesquisar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyTyped(evt);
            }
        });

        jButtonPesquisa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonPesquisa.setText("OK");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });
        jButtonPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonPesquisaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43)
                        .addComponent(jButtonPesquisa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButtonPesquisa))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );

        jTabbedPane1.addTab("Procedimentos", jPanel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Valor..:");

        jButtonSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Save.png")); // NOI18N
        jButtonSalvar.setToolTipText("Salvar");
        jButtonSalvar.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTextFieldValorProced.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldValorProcedKeyPressed(evt);
            }
        });

        jTextAreaObservacao.setColumns(20);
        jTextAreaObservacao.setRows(5);
        jTextAreaObservacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaObservacaoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaObservacaoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaObservacao);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nome..:");

        jButtonCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\delete1.png")); // NOI18N
        jButtonCancelar.setToolTipText("Voltar");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Observação..:");

        jButtonLimpar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Clockwise-arrow.png")); // NOI18N
        jButtonLimpar.setToolTipText("Limpar");
        jButtonLimpar.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jTextFieldNomeProce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeProceActionPerformed(evt);
            }
        });
        jTextFieldNomeProce.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeProceKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeProceKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setText("Cadastro de Procedimentos");

        jLabelObrigNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigNome.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigNome.setText("*Obrigatorio");

        jLabelObrigValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigValor.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigValor.setText("*Obrigatorio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldValorProced)
                                    .addComponent(jTextFieldNomeProce)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelObrigNome)
                            .addComponent(jLabelObrigValor))
                        .addGap(313, 313, 313))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeProce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigNome))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldValorProced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigValor))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );

        jTabbedPane1.addTab("Cadastro de procedimento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(1);

        muda = 1;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (muda == 1) {
            String nome = jTextFieldNomeProce.getText().toUpperCase();
            String valor1 = jTextFieldValorProced.getText().toUpperCase();
            String obs = jTextAreaObservacao.getText().toUpperCase();

            validar();
            double valor = Double.parseDouble(valor1);
            DecimalFormat df = new DecimalFormat("0.##");
            df.format(valor);
            String a = df.format(valor);
            valor = Double.parseDouble(a);
            Procedimento procedimento = new Procedimento();
            procedimento.setNome(nome);
            procedimento.setValor(valor);
            procedimento.setObs(obs);

            ProcedimentoDAO dao = null;

            try {
                dao = new ProcedimentoDAO();
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

            }

            try {
                dao.gravar(procedimento);

                try {
                    this.popularTabela();
                    JOptionPane.showMessageDialog(rootPane, "Procedimento cadastrado!! ");
                    jTabbedPane1.setSelectedIndex(0);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

            }

        } else {
            try {
                alterar();
                limparCampos();

            } catch (SQLException ex) {
                Logger.getLogger(FrmCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                popularTabela();
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTabbedPane1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        muda = 2;
        try {
            String id1 = "" + (jTableProcedimento.getValueAt(jTableProcedimento.getSelectedRow(), 0));

            int id = Integer.parseInt(id1);
            Procedimento procedimento = new Procedimento();

            ProcedimentoDAO dao = new ProcedimentoDAO();
            dao.getProcedimento(id);

            this.jTextFieldNomeProce.setText(dao.nome);
            this.jTextFieldValorProced.setText(dao.valor1);
            this.jTextAreaObservacao.setText(dao.obs);

            System.out.println(dao.obs);
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String id1 = "" + (jTableProcedimento.getValueAt(jTableProcedimento.getSelectedRow(), 0));
        int id = Integer.parseInt(id1);
        Procedimento procedimento = new Procedimento();
        procedimento.setId(id);
        ProcedimentoDAO dao = null;
        try {
            dao = new ProcedimentoDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Excluir o Procedimento", "Confirmar a Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                dao.excluir(procedimento);
                popularTabela();
                JOptionPane.showMessageDialog(rootPane, "Procedimento Excluido ");

            } catch (SQLException ex) {
                Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (resposta == JOptionPane.NO_OPTION) {

      }    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        try {
            popularTabela2();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jTextFieldPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonPesquisaActionPerformed(null);
        }    }//GEN-LAST:event_jTextFieldPesquisarKeyPressed

    private void jButtonPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonPesquisaKeyPressed


    }//GEN-LAST:event_jButtonPesquisaKeyPressed

    private void jTextFieldNomeProceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeProceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeProceActionPerformed

    private void jTextFieldNomeProceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeProceKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldValorProced.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldNomeProceKeyPressed

    private void jTextFieldValorProcedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorProcedKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextAreaObservacao.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldValorProcedKeyPressed

    private void jTextAreaObservacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaObservacaoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jButtonSalvar.requestFocus();
        }
    }//GEN-LAST:event_jTextAreaObservacaoKeyPressed

    private void jTextFieldNomeProceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeProceKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if ( jTextFieldNomeProce.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_jTextFieldNomeProceKeyTyped

    private void jTextAreaObservacaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaObservacaoKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 60;
        if ( jTextAreaObservacao.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_jTextAreaObservacaoKeyTyped

    private void jTextFieldPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 40;
        if ( jTextFieldPesquisar.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_jTextFieldPesquisarKeyTyped

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
            java.util.logging.Logger.getLogger(FrmCadProcedimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadProcedimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadProcedimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadProcedimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmCadProcedimento().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadProcedimento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelObrigNome;
    private javax.swing.JLabel jLabelObrigValor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableProcedimento;
    private javax.swing.JTextArea jTextAreaObservacao;
    private javax.swing.JTextField jTextFieldNomeProce;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldValorProced;
    // End of variables declaration//GEN-END:variables

    private void limparCampos() {

        jTextFieldNomeProce.setText("");
        jTextFieldValorProced.setText("");
        jTextAreaObservacao.setText("");

    }

    public void validar() {

        StringBuilder verificar = new StringBuilder();

        if ((jTextFieldNomeProce.getText().isEmpty()) || (jTextFieldValorProced.getText().isEmpty())) {

            verificar.append("<b>Confira os campos Obrigatórios!</b>");

            if (jTextFieldNomeProce.getText().isEmpty()) {
                verificar.append("\n-Nome");
                jLabelObrigNome.setVisible(true);
            } else {
                jLabelObrigNome.setVisible(false);
            }
            if (jTextFieldValorProced.getText().isEmpty()) {
                jLabelObrigValor.setVisible(true);
                verificar.append("\n-valor");
            } else {
                jLabelObrigValor.setVisible(false);
            }

        } else {
            verificar.append("<b>Campos validados!</b>");
        }

        JOptionPane.showMessageDialog(null, verificar);

    }
}
