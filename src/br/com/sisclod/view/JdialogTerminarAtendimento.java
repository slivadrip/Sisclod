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
public class JdialogTerminarAtendimento extends javax.swing.JDialog {

    /**
     * Creates new form JdialogTerminarAtendimento
     */
    public JdialogTerminarAtendimento(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
       // popularTabela();
        
    }

    private void popularTabela() throws SQLException {
        
       
            String[] coluna = new String[]{"ID", "NOME", "DATA","HORA","STATUS"};
            ArrayList dados = new ArrayList();
            AtendimentoDAO dao = new AtendimentoDAO();
            ArrayList<Atendimento> listagem;
       
            String nome = jTextFieldNomePaciente.getText().toUpperCase();
                listagem = (ArrayList<Atendimento>) dao.getListaDialogTerminar(nome);
                        for (Atendimento atendimento : listagem) {
                            dados.add(new Object[]{atendimento.getId(), atendimento.getNomePaciente(), atendimento.getData(),atendimento.getHora(),atendimento.getStatus()});
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
    
    private void popularTabelaData(String data) throws SQLException {
        
       
            String[] coluna = new String[]{"ID", "NOME", "DATA","HORA","STATUS"};
            ArrayList dados = new ArrayList();
            AtendimentoDAO dao = new AtendimentoDAO();
            ArrayList<Atendimento> listagem;
       
                listagem = (ArrayList<Atendimento>) dao.getListaDialogTerminarData(data);
                        for (Atendimento atendimento : listagem) {
                            dados.add(new Object[]{atendimento.getId(), atendimento.getNomePaciente(), atendimento.getData(),atendimento.getHora(),atendimento.getStatus()});
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNomePaciente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAtendimento = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jDateChooserDataPesquisa = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Finalizar Atendimento");

        jLabel2.setText("Paciente..:");

        jTextFieldNomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomePacienteActionPerformed(evt);
            }
        });
        jTextFieldNomePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomePacienteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomePacienteKeyTyped(evt);
            }
        });

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

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("CONCLUIDA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jDateChooserDataPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserDataPesquisaKeyPressed(evt);
            }
        });

        jLabel3.setText("Data..:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooserDataPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(191, 191, 191))
            .addGroup(layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserDataPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton1)))
                .addGap(49, 49, 49)
                .addComponent(jButton2)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
            
      int resposta = JOptionPane.showConfirmDialog(null, "FINALIZAR ESSE ATEDIMENTO?", "Confirmar a Exclusão", JOptionPane.YES_NO_OPTION);

      if (resposta == JOptionPane.YES_OPTION) {
            try {            Atendimento atendimento =  new Atendimento();

                 AtendimentoDAO dao = new AtendimentoDAO();
                 atendimento.setStatus("CONCLUIDA");
                 atendimento.setId((int)jTableAtendimento.getValueAt(jTableAtendimento.getSelectedRow(), 0));
                 dao.alterarStatus((int) jTableAtendimento.getValueAt(jTableAtendimento.getSelectedRow(), 0));
                popularTabela();
      } catch (SQLException ex) {
          Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
      }
      } else if (resposta == JOptionPane.NO_OPTION) {

      }
    
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomePacienteActionPerformed


    }//GEN-LAST:event_jTextFieldNomePacienteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

         SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
                   System.out.println(jDateChooserDataPesquisa.getDate());
 
        String data = simpleDate.format(jDateChooserDataPesquisa.getDate());

        try {
            popularTabelaData(data);
        } catch (SQLException ex) {
            Logger.getLogger(FrmVisulizarAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            popularTabela();
        } catch (SQLException ex) {
            Logger.getLogger(JdialogTerminarAtendimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldNomePacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomePacienteKeyPressed
if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                jButton1ActionPerformed(null);
        }    }//GEN-LAST:event_jTextFieldNomePacienteKeyPressed

    private void jDateChooserDataPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserDataPesquisaKeyPressed
if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                jButton3ActionPerformed(null);
        }     }//GEN-LAST:event_jDateChooserDataPesquisaKeyPressed

    private void jTextFieldNomePacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomePacienteKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if ( jTextFieldNomePaciente.getText().length() >= limite) {
            evt.consume();
        }   
    }//GEN-LAST:event_jTextFieldNomePacienteKeyTyped

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JdialogTerminarAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdialogTerminarAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdialogTerminarAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdialogTerminarAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdialogTerminarAtendimento dialog = null;
                try {
                    dialog = new JdialogTerminarAtendimento(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(JdialogTerminarAtendimento.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooserDataPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAtendimento;
    private javax.swing.JTextField jTextFieldNomePaciente;
    // End of variables declaration//GEN-END:variables
}
