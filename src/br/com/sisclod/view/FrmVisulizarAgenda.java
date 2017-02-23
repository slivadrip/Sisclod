/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.AtendimentoDAO;
import br.com.sisclod.model.Atendimento;
import br.com.sisclod.model.ModeloTabela;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Dih
 */
public class FrmVisulizarAgenda extends javax.swing.JFrame {

    /**
     * Creates new form FrmVisulizarAgenda
     */
    public FrmVisulizarAgenda() throws SQLException {
        initComponents();
        
        setLocationRelativeTo(null);
        setResizable(false);
        
    }

    
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
    
     private void popularTabelaPaciente() throws SQLException {
        
       
            String[] coluna = new String[]{"NOME","SERVIÇO", "DATA","HORA"};
            ArrayList dados = new ArrayList();
            AtendimentoDAO dao = new AtendimentoDAO();
            ArrayList<Atendimento> listagem;
       
                          String paciente = jTextFieldPacientePesquisa.getText();

        
                listagem = (ArrayList<Atendimento>) dao.getListaJoinPaciente(paciente);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserDataPesquisa = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAtendimento = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPacientePesquisa = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Data.:");

        jDateChooserDataPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserDataPesquisaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserDataPesquisaKeyTyped(evt);
            }
        });

        jTableAtendimento.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTableAtendimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableAtendimento);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\magnifying-glass-32.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Paciente.:");

        jTextFieldPacientePesquisa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldPacientePesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPacientePesquisaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPacientePesquisaKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\magnifying-glass-32.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserDataPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPacientePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jDateChooserDataPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTextFieldPacientePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Consultar Agenda");

        jButtonVoltar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Arrow-turn-left.png")); // NOI18N
        jButtonVoltar.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4))
                            .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
                   System.out.println(jDateChooserDataPesquisa.getDate());
 
        String data = simpleDate.format(jDateChooserDataPesquisa.getDate());

        try {
            popularTabela(data);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVisulizarAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            popularTabelaPaciente();
        } catch (SQLException ex) {
            Logger.getLogger(FrmVisulizarAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jTextFieldPacientePesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPacientePesquisaKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 40;
        if ( jTextFieldPacientePesquisa.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_jTextFieldPacientePesquisaKeyTyped

    private void jTextFieldPacientePesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPacientePesquisaKeyPressed
if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                jButton2ActionPerformed(null);
        }    }//GEN-LAST:event_jTextFieldPacientePesquisaKeyPressed

    private void jDateChooserDataPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserDataPesquisaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserDataPesquisaKeyTyped

    private void jDateChooserDataPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserDataPesquisaKeyPressed
if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                jButton1ActionPerformed(null);
        }       }//GEN-LAST:event_jDateChooserDataPesquisaKeyPressed

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
            java.util.logging.Logger.getLogger(FrmVisulizarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVisulizarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVisulizarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVisulizarAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmVisulizarAgenda().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmVisulizarAgenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonVoltar;
    private com.toedter.calendar.JDateChooser jDateChooserDataPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAtendimento;
    private javax.swing.JTextField jTextFieldPacientePesquisa;
    // End of variables declaration//GEN-END:variables
}
