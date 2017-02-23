/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.EmpresaDAO;
import br.com.sisclod.dao.EstadoDAO;
import br.com.sisclod.dao.PacienteDAO;
import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Empresa;
import br.com.sisclod.model.Estado;
import br.com.sisclod.model.ModeloTabela;
import br.com.sisclod.model.FixedLengthDocument;
import java.awt.Component;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Dih
 */
public class FrmCadEmpresa extends javax.swing.JFrame {

    int muda = 1;

    /**
     * Creates new form FrmCadEmpresa
     */
    public FrmCadEmpresa() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        jLabelCpdValidar.setVisible(false);
       // popularTabela();
        popularComboBoxUF();
        FormataCampoTelefone(jFormattedTextFieldTelefone);
        FormataCampoTelefone(jFormattedTextFieldTelefone2);
        FormataCampoCnpj(jFormattedTextFieldcnpj);

        jTextFieldnumero.setDocument(new FixedLengthDocument(3));
        jLabelObrigNome.setVisible(false);
        jLabelObrigEmail.setVisible(false);
        jLabelObrigEndereco.setVisible(false);
        jLabelObrigBairro.setVisible(false);
        jLabelObrigFantasia.setVisible(false);
        jLabelObrigIE.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmpresa = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonCancelarJ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldnome = new javax.swing.JTextField();
        jTextFieldFantasia = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldnumero = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone2 = new javax.swing.JFormattedTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextFieldcnpj = new javax.swing.JFormattedTextField();
        jTextFieldIE = new javax.swing.JTextField();
        jComboBoxUF = new javax.swing.JComboBox();
        jComboBoxCidade = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabelCpdValidar = new javax.swing.JLabel();
        jLabelObrigNome = new javax.swing.JLabel();
        jLabelObrigFantasia = new javax.swing.JLabel();
        jLabelObrigIE = new javax.swing.JLabel();
        jLabelObrigEndereco = new javax.swing.JLabel();
        jLabelObrigBairro = new javax.swing.JLabel();
        jLabelObrigEmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableEmpresa);

        jButtonEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\edit.png")); // NOI18N
        jButtonEditar.setToolTipText("");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\add1.png")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\trash.png")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Arrow-turn-left.png")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextFieldPesquisa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Pesquisa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton4)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonEditar)
                        .addGap(40, 40, 40)
                        .addComponent(jButton6)
                        .addGap(40, 40, 40)
                        .addComponent(jButton7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButtonEditar)
                            .addComponent(jButton6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empresa", jPanel1);

        jButtonSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Save.png")); // NOI18N
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonLimpar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Clockwise-arrow.png")); // NOI18N
        jButtonLimpar.setToolTipText("");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonCancelarJ.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\delete1.png")); // NOI18N
        jButtonCancelarJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarJActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Razão Social:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Fantasia:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Endereço:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Numero:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Bairro:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Estado:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cidade:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Telefone:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Telefone(2):");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("E-mail:");

        jTextFieldnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldnomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldnomeKeyTyped(evt);
            }
        });

        jTextFieldFantasia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFantasiaActionPerformed(evt);
            }
        });
        jTextFieldFantasia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldFantasiaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFantasiaKeyTyped(evt);
            }
        });

        jTextFieldEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldEnderecoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEnderecoKeyTyped(evt);
            }
        });

        jTextFieldnumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldnumeroActionPerformed(evt);
            }
        });
        jTextFieldnumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldnumeroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldnumeroKeyTyped(evt);
            }
        });

        jTextFieldBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBairroActionPerformed(evt);
            }
        });
        jTextFieldBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBairroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBairroKeyTyped(evt);
            }
        });

        jFormattedTextFieldTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldTelefoneKeyPressed(evt);
            }
        });

        jFormattedTextFieldTelefone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldTelefone2KeyPressed(evt);
            }
        });

        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("CNPJ:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Inscrição:");

        jFormattedTextFieldcnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldcnpjKeyPressed(evt);
            }
        });

        jTextFieldIE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIEKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldIEKeyTyped(evt);
            }
        });

        jComboBoxUF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxUF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUFActionPerformed(evt);
            }
        });
        jComboBoxUF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxUFKeyPressed(evt);
            }
        });

        jComboBoxCidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxCidadeKeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel13.setText("Cadastro de Empresa");

        jLabelCpdValidar.setForeground(new java.awt.Color(255, 0, 0));
        jLabelCpdValidar.setText("*");

        jLabelObrigNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigNome.setForeground(new java.awt.Color(255, 0, 0));
        jLabelObrigNome.setText("* Obrigatório");

        jLabelObrigFantasia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigFantasia.setForeground(new java.awt.Color(255, 0, 0));
        jLabelObrigFantasia.setText("* Obrigatório");

        jLabelObrigIE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigIE.setForeground(new java.awt.Color(255, 0, 0));
        jLabelObrigIE.setText("* Obrigatório");

        jLabelObrigEndereco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigEndereco.setForeground(new java.awt.Color(255, 0, 0));
        jLabelObrigEndereco.setText("* Obrigatório");

        jLabelObrigBairro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigBairro.setForeground(new java.awt.Color(255, 0, 0));
        jLabelObrigBairro.setText("* Obrigatório");

        jLabelObrigEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigEmail.setForeground(new java.awt.Color(255, 0, 0));
        jLabelObrigEmail.setText("* Obrigatório");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldnome))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addComponent(jLabel3))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEndereco)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldcnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCpdValidar)
                                .addGap(8, 8, 8)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldIE))
                            .addComponent(jTextFieldFantasia)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(28, 28, 28)
                        .addComponent(jTextFieldEmail)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelObrigNome)
                    .addComponent(jLabelObrigFantasia)
                    .addComponent(jLabelObrigIE)
                    .addComponent(jLabelObrigEndereco)
                    .addComponent(jLabelObrigBairro)
                    .addComponent(jLabelObrigEmail))
                .addGap(55, 55, 55))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jButtonSalvar)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonLimpar)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonCancelarJ)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigNome))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigFantasia))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jFormattedTextFieldcnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabelCpdValidar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldIE, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelObrigIE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigEndereco))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigBairro))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jFormattedTextFieldTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigEmail))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSalvar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonCancelarJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLimpar)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro Empresa", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void popularTabela() throws SQLException {
        String[] coluna = new String[]{"ID", "NOME", "FANTASIA", "CNPJ"};
        ArrayList dados = new ArrayList();
        EmpresaDAO dao = new EmpresaDAO();
        ArrayList<Empresa> listagem;

        listagem = (ArrayList<Empresa>) dao.lista();
        for (Empresa empresa : listagem) {
            dados.add(new Object[]{empresa.getId(), empresa.getNome(), empresa.getFantasia(), empresa.getCnpj()});
        }

        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTableEmpresa.setModel(modelo);
            jTableEmpresa.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableEmpresa.getColumnModel().getColumn(0).setResizable(false);
            jTableEmpresa.getColumnModel().getColumn(1).setPreferredWidth(500);
            jTableEmpresa.getColumnModel().getColumn(1).setResizable(false);
            jTableEmpresa.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableEmpresa.getColumnModel().getColumn(2).setResizable(false);
            jTableEmpresa.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableEmpresa.getColumnModel().getColumn(2).setResizable(false);
            jTableEmpresa.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTableEmpresa.getColumnModel().getColumn(3).setResizable(false);
            jTableEmpresa.getTableHeader().setReorderingAllowed(false);
            jTableEmpresa.setAutoResizeMode(jTableEmpresa.AUTO_RESIZE_OFF);
            jTableEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }

    }

    public void popularTabela2() throws SQLException {
        String[] coluna = new String[]{"ID", "NOME", "FANTASIA", "CNPJ"};
        ArrayList dados = new ArrayList();
        EmpresaDAO dao = new EmpresaDAO();
        ArrayList<Empresa> listagem;

        String pesquisa = jTextFieldPesquisa.getText().toUpperCase();
        listagem = (ArrayList<Empresa>) dao.listaPesuisa(pesquisa);
        for (Empresa empresa : listagem) {
            dados.add(new Object[]{empresa.getId(), empresa.getNome(), empresa.getFantasia(), empresa.getCnpj()});
        }

        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTableEmpresa.setModel(modelo);
            jTableEmpresa.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableEmpresa.getColumnModel().getColumn(0).setResizable(false);
            jTableEmpresa.getColumnModel().getColumn(1).setPreferredWidth(500);
            jTableEmpresa.getColumnModel().getColumn(1).setResizable(false);
            jTableEmpresa.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableEmpresa.getColumnModel().getColumn(2).setResizable(false);
            jTableEmpresa.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableEmpresa.getColumnModel().getColumn(2).setResizable(false);
            jTableEmpresa.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTableEmpresa.getColumnModel().getColumn(3).setResizable(false);
            jTableEmpresa.getTableHeader().setReorderingAllowed(false);
            jTableEmpresa.setAutoResizeMode(jTableEmpresa.AUTO_RESIZE_OFF);
            jTableEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }

    }

    public void popularComboBoxUF() {

        EstadoDAO dao = null;
        try {
            dao = new EstadoDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Estado> estados = null;
        try {
            estados = dao.lista();
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        jComboBoxUF.removeAllItems();
        for (int i = 0; i < estados.size(); i++) {
            jComboBoxUF.addItem(estados.get(i).getSigla());
            //jComboBoxUF.addItem(String.valueOf(estados.get(i).getId()+""));
            String valor = (String) jComboBoxUF.getSelectedItem();
        }

    }

    public void popComboCid(String sgUF) throws SQLException {
        Connection conexao = null;
        conexao = Database.getConnection();

        String sql = "select * from tbCidade where sgUF = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, sgUF);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            jComboBoxCidade.addItem(String.valueOf(rs.getString("noCidade")));
        }

    }

    public void acharUF(String uf2) throws SQLException {

        Connection conexao = null;
        conexao = Database.getConnection();

        String sql = "select * from tbuf where sgUF = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, uf2);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            jComboBoxUF.addItem(String.valueOf(rs.getString("sgUF")));
        }

    }

    public void acharCidade(String cidade2) throws SQLException {

        Connection conexao = null;
        conexao = Database.getConnection();

        String sql = "select * from tbCidade where noCidade = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, cidade2);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            jComboBoxCidade.addItem(String.valueOf(rs.getString("noCidade")));

        }
    }

    static public boolean isCNPJ(String str_cnpj) {
        int soma = 0, aux, dig;
        String cnpj_calc = str_cnpj.substring(0, 12);

        if (str_cnpj.length() != 14) {
            return false;
        }

        char[] chr_cnpj = str_cnpj.toCharArray();

        /* Primeira parte */
        for (int i = 0; i < 4; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);

        cnpj_calc += (dig == 10 || dig == 11)
                ? "0" : Integer.toString(dig);

        /* Segunda parte */
        soma = 0;
        for (int i = 0; i < 5; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpj_calc += (dig == 10 || dig == 11)
                ? "0" : Integer.toString(dig);

        return str_cnpj.equals(cnpj_calc);
    }

    public void limparCampos() {

        this.jTextFieldnome.setText("");
        this.jTextFieldFantasia.setText(null);
        this.jTextFieldIE.setText("");
        this.jTextFieldEndereco.setText("");
        this.jTextFieldnumero.setText("");
        this.jTextFieldBairro.setText("");
        this.jFormattedTextFieldTelefone.setText(null);
        this.jFormattedTextFieldTelefone2.setText(null);
        this.jTextFieldEmail.setText("");
        this.jFormattedTextFieldcnpj.setText("");
        this.jComboBoxUF.setSelectedItem(null);
        this.jComboBoxCidade.setSelectedItem(null);

    }

    public void FormataCampoTelefone(JFormattedTextField campo) {

        try {
            MaskFormatter novo = new MaskFormatter("(##) ####-####");
            novo.setValidCharacters("0123456789");
            novo.install(campo);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi poessível formatar campo \nDetalhes:" + ex, "Aviso!", WIDTH);
        }

    }

    public void FormataCampoCnpj(JFormattedTextField campo) {

        try {
            MaskFormatter novo = new MaskFormatter("##.###.###/####-##");
            novo.setValidCharacters("0123456789");
            novo.install(campo);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi poessível formatar campo \nDetalhes:" + ex, "Aviso!", WIDTH);
        }

    }

    public void alterar() throws SQLException {

        if (jTableEmpresa.getSelectedRow() != -1) {
            String id1 = "" + (jTableEmpresa.getValueAt(jTableEmpresa.getSelectedRow(), 0));

            int id = Integer.parseInt(id1);
            System.out.println("id..:" + id);

            String nome = jTextFieldnome.getText().toUpperCase();
            String fantasia = jTextFieldFantasia.getText().toUpperCase();
            String cnpj = jFormattedTextFieldcnpj.getText().toUpperCase();
            String IE = jTextFieldIE.getText().toUpperCase();
            String Endereco = jTextFieldEndereco.getText().toUpperCase();
            String numero = jTextFieldnumero.getText().toUpperCase();
            String bairro = jTextFieldBairro.getText().toUpperCase();
            String telefone = jFormattedTextFieldTelefone.getText().toUpperCase();
            String telefone2 = jFormattedTextFieldTelefone2.getText().toUpperCase();
            String email = jTextFieldEmail.getText().toUpperCase();
            String uf = (String) jComboBoxUF.getSelectedItem();
            uf = uf.toUpperCase();
            String cidade = (String) jComboBoxCidade.getSelectedItem();
            cidade = cidade.toUpperCase();

            System.out.println("UF..:" + uf);
            Empresa empresa = new Empresa();

            EmpresaDAO dao = new EmpresaDAO();

            empresa.setNome(nome);
            empresa.setFantasia(fantasia);
            empresa.setCnpj(cnpj);
            empresa.setIe(IE);
            empresa.setEndereco(Endereco);
            empresa.setNumero(numero);
            empresa.setBairro(bairro);
            empresa.setTelefone(telefone);
            empresa.setTelefone2(telefone2);
            empresa.setEmail(email);
            empresa.setCidade(cidade);
            empresa.setUf(uf);
            empresa.setId(id);

            dao.alterar(empresa);

            JOptionPane.showMessageDialog(rootPane, "Paciente Alterado com Sucesso");

            this.popularTabela();

        }
    }

    public void validar() {

        StringBuilder verificar = new StringBuilder();

        if ((jTextFieldnome.getText().isEmpty()) || (jTextFieldEmail.getText().isEmpty()) || (jTextFieldEndereco.getText().isEmpty()) || (jTextFieldFantasia.getText().isEmpty()) || (jTextFieldIE.getText().isEmpty()) || (jTextFieldBairro.getText().isEmpty())) {

            verificar.append("<b>Confira os campos Obrigatórios!</b>");

            if (jTextFieldnome.getText().isEmpty()) {
                verificar.append("\n-Nome");
                jLabelObrigNome.setVisible(true);
            } else {
                jLabelObrigNome.setVisible(false);
            }
            if (jTextFieldEmail.getText().isEmpty()) {
                jLabelObrigEmail.setVisible(true);
                verificar.append("\n-Email");
            } else {
                jLabelObrigEmail.setVisible(false);
            }

            if (jTextFieldEndereco.getText().isEmpty()) {
                jLabelObrigEndereco.setVisible(true);
                verificar.append("\n-Endereco");
            } else {
                jLabelObrigEndereco.setVisible(false);
            }

            if (jTextFieldFantasia.getText().isEmpty()) {
                jLabelObrigFantasia.setVisible(true);
                verificar.append("\n-Fantasia");
            } else {
                jLabelObrigFantasia.setVisible(false);
            }
            if (jTextFieldIE.getText().isEmpty()) {
                jLabelObrigIE.setVisible(true);
                verificar.append("\n-IE");
            } else {
                jLabelObrigIE.setVisible(false);
            }
            if (jTextFieldBairro.getText().isEmpty()) {
                jLabelObrigBairro.setVisible(true);
                verificar.append("\n-Bairro");
            } else {
                jLabelObrigBairro.setVisible(false);
            }
        } else {
            verificar.append("<b>Empresa Cadastrada!</b>");
        }

        JOptionPane.showMessageDialog(null, verificar);

    }
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        limparCampos();

        jTabbedPane1.setSelectedIndex(1);
        muda = 2;
        try {
            String id1 = "" + (jTableEmpresa.getValueAt(jTableEmpresa.getSelectedRow(), 0));

            int id = Integer.parseInt(id1);
            Empresa empresa = new Empresa();

            EmpresaDAO dao = new EmpresaDAO();
            dao.getEmpresa(id);

            String uf = dao.uf;
            String cidade = dao.cidade;

            this.jTextFieldnome.setText(dao.nome);
            this.jTextFieldFantasia.setText(dao.fantasia);
            this.jFormattedTextFieldcnpj.setText(dao.cnpj);
            this.jTextFieldIE.setText(dao.ie);
            this.jTextFieldEndereco.setText(dao.endereco);
            this.jTextFieldnumero.setText(dao.numero);
            this.jTextFieldBairro.setText(dao.bairro);
            this.jFormattedTextFieldTelefone.setText(dao.telefone);
            this.jFormattedTextFieldTelefone2.setText(dao.telefone2);
            this.jTextFieldEmail.setText(dao.email);
            this.jComboBoxUF.setSelectedItem(uf);
            this.jComboBoxCidade.setSelectedItem(cidade);

            acharUF(uf);
            acharCidade(cidade);

            System.out.println("udf...:" + uf);
            System.out.println("ciade...:" + cidade);

        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(1);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        String id1 = "" + (jTableEmpresa.getValueAt(jTableEmpresa.getSelectedRow(), 0));
        int id = Integer.parseInt(id1);
        Empresa empresa = new Empresa();
        empresa.setId(id);
        EmpresaDAO dao = null;

        try {
            dao = new EmpresaDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }

      //  JOptionPane.showConfirmDialog(null, "Deseja Excluir o Registro", "Confirmar a Exclusão", JOptionPane.YES_NO_OPTION);
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Excluir o Registro", "Confirmar a Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                dao.excluir(empresa);
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                popularTabela();
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadEmpresa.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (resposta == JOptionPane.NO_OPTION) {

        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        if (muda == 1) {
            String nome = jTextFieldnome.getText().toUpperCase();
            String fantasia = jTextFieldFantasia.getText().toUpperCase();
            String cnpj = jFormattedTextFieldcnpj.getText().toUpperCase();
            String IE = jTextFieldIE.getText().toUpperCase();
            String Endereco = jTextFieldEndereco.getText().toUpperCase();
            String numero = jTextFieldnumero.getText().toUpperCase();
            String bairro = jTextFieldBairro.getText().toUpperCase();
            String telefone = jFormattedTextFieldTelefone.getText().toUpperCase();
            String telefone2 = jFormattedTextFieldTelefone2.getText().toUpperCase();
            String email = jTextFieldEmail.getText().toUpperCase();
            String uf = (String) jComboBoxUF.getSelectedItem();
            uf = uf.toUpperCase();
            String cidade = (String) jComboBoxCidade.getSelectedItem();
            cidade = cidade.toUpperCase();

            Empresa empresa = new Empresa();

            empresa.setNome(nome);
            empresa.setFantasia(fantasia);
            empresa.setCnpj(cnpj);
            empresa.setIe(IE);
            empresa.setEndereco(Endereco);
            empresa.setNumero(numero);
            empresa.setBairro(bairro);
            empresa.setTelefone(telefone);
            empresa.setTelefone2(telefone2);
            empresa.setEmail(email);
            empresa.setUf(uf);
            empresa.setCidade(cidade);
            validar();
            EmpresaDAO dao = null;
            String cnpj1 = jFormattedTextFieldcnpj.getText().replace(".", "");
            String cnpj2 = cnpj1.replace("-", "");
            cnpj2 = cnpj2.replace("/", "");
            // cpf1 = cpf.replace(".", "-");
            if (isCNPJ(cnpj2) == false) {
                JOptionPane.showMessageDialog(rootPane, "CNPJ Invalido");
                jLabelCpdValidar.setText("*");
                System.out.println("cpf..:" + cnpj2);
            } else {
                jLabelCpdValidar.setText("");

                try {
                    dao = new EmpresaDAO();
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

                }

                try {
                    dao.gravar(empresa);
                    try {
                        limparCampos();
                        popularTabela();
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);
                }

            }

        } else {
            try {
                alterar();
                limparCampos();
                popularTabela();
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();

    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonCancelarJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarJActionPerformed

        jTabbedPane1.setSelectedIndex(0);
        limparCampos();
    }//GEN-LAST:event_jButtonCancelarJActionPerformed

    private void jTextFieldnumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldnumeroActionPerformed

    }//GEN-LAST:event_jTextFieldnumeroActionPerformed

    private void jTextFieldBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBairroActionPerformed

    }//GEN-LAST:event_jTextFieldBairroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            popularTabela2();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUFActionPerformed
        String dados = String.valueOf(jComboBoxUF.getSelectedItem());

        try {
            jComboBoxCidade.removeAllItems();
            jComboBoxCidade.addItem("Escolha");
            popComboCid(dados);
        } catch (SQLException ex) {
        }

    }//GEN-LAST:event_jComboBoxUFActionPerformed

    private void jTextFieldPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldPesquisaKeyPressed

    private void jTextFieldnomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldnomeKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldFantasia.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldnomeKeyPressed

    private void jTextFieldFantasiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFantasiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFantasiaActionPerformed

    private void jTextFieldFantasiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFantasiaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFieldcnpj.requestFocus();
        }    }//GEN-LAST:event_jTextFieldFantasiaKeyPressed

    private void jFormattedTextFieldcnpjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldcnpjKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
 String cnpj1 = jFormattedTextFieldcnpj.getText().replace(".", "");
            String cnpj2 = cnpj1.replace("-", "");
            cnpj2 = cnpj2.replace("/", "");
            // cpf1 = cpf.replace(".", "-");
            if (isCNPJ(cnpj2) == false) {
                JOptionPane.showMessageDialog(rootPane, "CNPJ Invalido");
                jLabelCpdValidar.setText("*");
                System.out.println("cpf..:" + cnpj2);
            } else {
                jLabelCpdValidar.setText("");

            jTextFieldIE.requestFocus();
            }
        }    }//GEN-LAST:event_jFormattedTextFieldcnpjKeyPressed

    private void jTextFieldIEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIEKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldEndereco.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldIEKeyPressed

    private void jTextFieldEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldnumero.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldEnderecoKeyPressed

    private void jTextFieldnumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldnumeroKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldBairro.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldnumeroKeyPressed

    private void jTextFieldBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBairroKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jComboBoxUF.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldBairroKeyPressed

    private void jComboBoxUFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxUFKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jComboBoxCidade.requestFocus();
        }    }//GEN-LAST:event_jComboBoxUFKeyPressed

    private void jComboBoxCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxCidadeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFieldTelefone.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxCidadeKeyPressed

    private void jFormattedTextFieldTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefoneKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFieldTelefone2.requestFocus();
        }    }//GEN-LAST:event_jFormattedTextFieldTelefoneKeyPressed

    private void jFormattedTextFieldTelefone2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefone2KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldEmail.requestFocus();
        }    }//GEN-LAST:event_jFormattedTextFieldTelefone2KeyPressed

    private void jTextFieldEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

            jButtonSalvar.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldEmailKeyPressed

    private void jTextFieldnomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldnomeKeyTyped
        String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if (jTextFieldnome.getText().length() >= limite) {
            evt.consume();
        }     }//GEN-LAST:event_jTextFieldnomeKeyTyped

    private void jTextFieldFantasiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFantasiaKeyTyped
        String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if (jTextFieldFantasia.getText().length() >= limite) {
            evt.consume();
        }     }//GEN-LAST:event_jTextFieldFantasiaKeyTyped

    private void jTextFieldIEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIEKeyTyped
        String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 20;
        if (jTextFieldIE.getText().length() >= limite) {
            evt.consume();
        }     }//GEN-LAST:event_jTextFieldIEKeyTyped

    private void jTextFieldEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoKeyTyped
        String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if (jTextFieldEndereco.getText().length() >= limite) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldEnderecoKeyTyped

    private void jTextFieldnumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldnumeroKeyTyped
        String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 3;
        if (jTextFieldnumero.getText().length() >= limite) {
            evt.consume();
        }     }//GEN-LAST:event_jTextFieldnumeroKeyTyped

    private void jTextFieldBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBairroKeyTyped
        String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if (jTextFieldBairro.getText().length() >= limite) {
            evt.consume();
        }     }//GEN-LAST:event_jTextFieldBairroKeyTyped

    private void jTextFieldEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyTyped

        int limite = 50;
        if (jTextFieldEmail.getText().length() >= limite) {
            evt.consume();
        }     }//GEN-LAST:event_jTextFieldEmailKeyTyped

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
            java.util.logging.Logger.getLogger(FrmCadEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadEmpresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmCadEmpresa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonCancelarJ;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxCidade;
    private javax.swing.JComboBox jComboBoxUF;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone2;
    private javax.swing.JFormattedTextField jFormattedTextFieldcnpj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCpdValidar;
    private javax.swing.JLabel jLabelObrigBairro;
    private javax.swing.JLabel jLabelObrigEmail;
    private javax.swing.JLabel jLabelObrigEndereco;
    private javax.swing.JLabel jLabelObrigFantasia;
    private javax.swing.JLabel jLabelObrigIE;
    private javax.swing.JLabel jLabelObrigNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableEmpresa;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldFantasia;
    private javax.swing.JTextField jTextFieldIE;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldnome;
    private javax.swing.JTextField jTextFieldnumero;
    // End of variables declaration//GEN-END:variables
}
