/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.ProcedimentoDAO;
import br.com.sisclod.model.ModeloTabela;
import br.com.sisclod.model.Procedimento;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


/**
 *
 * @author Dih
 */
public class BuscarProcedimento extends javax.swing.JDialog {
    private static String id;
    private static String nome;
    private static String valor;

    /**
     * @return the id
     */
    public static String getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public static String getNome() {
        return nome;
    }

    /**
     * @return the valor
     */
    public static String getValor() {
        return valor;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(String aId) {
        id = aId;
    }

    /**
     * @param aNome the nome to set
     */
    public static void setNome(String aNome) {
        nome = aNome;
    }

    /**
     * @param aValor the valor to set
     */
    public static void setValor(String aValor) {
        valor = aValor;
    }

    /**
     * Creates new form BuscarProcedimento
     */
    public BuscarProcedimento(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        popularTabela();
         setLocationRelativeTo(null);
        setResizable(false);
    }

    private void popularTabela() throws SQLException {
        
        
            String[] coluna = new String[]{"ID", "NOME", "VALOR"};
            ArrayList dados = new ArrayList();
            ProcedimentoDAO dao = new ProcedimentoDAO();
            ArrayList<Procedimento> listagem;
       
         NumberFormat nf = NumberFormat.getCurrencyInstance();
         DecimalFormat df = new DecimalFormat("0.##");




                listagem = (ArrayList<Procedimento>) dao.lista();
                        for (Procedimento procedimento : listagem) {
                            dados.add(new Object[]{procedimento.getId(), procedimento.getNome(),nf.format(procedimento.getValor())});
                    }
        
           
       
                 ModeloTabela modelo = new ModeloTabela(dados, coluna);

                try {
                    jTableProcedimento.setModel(modelo);
                    jTableProcedimento.getColumnModel().getColumn(0).setPreferredWidth(50);
                    jTableProcedimento.getColumnModel().getColumn(0).setResizable(false);
                    jTableProcedimento.getColumnModel().getColumn(1).setPreferredWidth(500);
                    jTableProcedimento.getColumnModel().getColumn(1).setResizable(false);
                    jTableProcedimento.getColumnModel().getColumn(2).setPreferredWidth(100);
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
                    jTableProcedimento.getColumnModel().getColumn(1).setPreferredWidth(500);
                    jTableProcedimento.getColumnModel().getColumn(1).setResizable(false);
                    jTableProcedimento.getColumnModel().getColumn(2).setPreferredWidth(100);
                    jTableProcedimento.getColumnModel().getColumn(2).setResizable(false);
           

                    jTableProcedimento.getTableHeader().setReorderingAllowed(false);
                    jTableProcedimento.setAutoResizeMode(jTableProcedimento.AUTO_RESIZE_OFF);
                    jTableProcedimento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProcedimento = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 400));

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
        jTableProcedimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProcedimentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProcedimento);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pesquisa.:");

        jTextFieldPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarActionPerformed(evt);
            }
        });
        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sisclod/util/fotos/lupa_318-80384_1.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Accept.png")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Procedimentos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(291, 291, 291)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(231, 231, 231)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            popularTabela2();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setId(jTableProcedimento.getValueAt(jTableProcedimento.getSelectedRow(), 0).toString());
             setNome(jTableProcedimento.getValueAt(jTableProcedimento.getSelectedRow(), 1).toString());
            setValor(jTableProcedimento.getValueAt(jTableProcedimento.getSelectedRow(), 2).toString());
            dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableProcedimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProcedimentoMouseClicked

             setId(jTableProcedimento.getValueAt(jTableProcedimento.getSelectedRow(), 0).toString());
             setNome(jTableProcedimento.getValueAt(jTableProcedimento.getSelectedRow(), 1).toString());
            setValor(jTableProcedimento.getValueAt(jTableProcedimento.getSelectedRow(), 2).toString());
            
                        dispose();

    }//GEN-LAST:event_jTableProcedimentoMouseClicked

    private void jTextFieldPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPesquisarActionPerformed

    private void jTextFieldPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyPressed
if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                jButton1ActionPerformed(null);
        }     }//GEN-LAST:event_jTextFieldPesquisarKeyPressed

    private void jTextFieldPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarProcedimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarProcedimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarProcedimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarProcedimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarProcedimento dialog = null;
                try {
                    dialog = new BuscarProcedimento(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(BuscarProcedimento.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProcedimento;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
