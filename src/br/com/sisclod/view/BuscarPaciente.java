/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.PacienteDAO;
import br.com.sisclod.model.ModeloTabela;
import br.com.sisclod.model.Paciente;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Dih
 */
public class BuscarPaciente extends javax.swing.JDialog {
   public static  FrmAtendimento enviaTexto;
public static String nome;
public static String cpf,id2;
public static int id;
    /**
     * Creates new form BuscarPaciente
     */
    public BuscarPaciente(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
                initComponents();
                popularTabela();
                setLocationRelativeTo(null);
                setResizable(false);
    }
    
        /**
     * @param aEnviaTexto the enviaTexto to set
     */
    public static void setEnviaTexto(FrmAtendimento aEnviaTexto) {
        enviaTexto = aEnviaTexto;
    }

    /**
     * @return the nome
     */
    public static String getNome() {
        return nome;
    }

    /**
     * @return the id2
     */
    public static String getId2() {
        return id2;
    }

    /**
     * @param aId2 the id2 to set
     */
    public static void setId2(String aId2) {
        id2 = aId2;
    }

    /**
     * @return the id
     */
    public static int getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(int aId) {
        id = aId;
    }
public void popularTabela() throws SQLException {
        String[] coluna = new String[]{"ID", "NOME", "CPF"};
        ArrayList dados = new ArrayList();
        PacienteDAO dao = new PacienteDAO();
        ArrayList<Paciente> listagem;
       
        
            listagem = (ArrayList<Paciente>) dao.lista();
            for (Paciente paciente : listagem) {
                dados.add(new Object[]{paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getRg()});
            }
        
           
       
        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTablePaciente.setModel(modelo);
            jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTablePaciente.getColumnModel().getColumn(0).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(480);
            jTablePaciente.getColumnModel().getColumn(1).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(134);
            jTablePaciente.getColumnModel().getColumn(2).setResizable(false);
           

            jTablePaciente.getTableHeader().setReorderingAllowed(false);
            jTablePaciente.setAutoResizeMode(jTablePaciente.AUTO_RESIZE_OFF);
            jTablePaciente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }
        
    }

public void popularTabela2() throws SQLException {
        String[] coluna = new String[]{"ID", "NOME", "CPF"};
        ArrayList dados = new ArrayList();
        PacienteDAO dao = new PacienteDAO();
        ArrayList<Paciente> listagem;
       
        String pesquisa = campoPesquisa.getText();
            listagem = (ArrayList<Paciente>) dao.lista2(pesquisa);
            for (Paciente paciente : listagem) {
                dados.add(new Object[]{paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getRg()});
            }
        
           
       
        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTablePaciente.setModel(modelo);
            jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTablePaciente.getColumnModel().getColumn(0).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(500);
            jTablePaciente.getColumnModel().getColumn(1).setResizable(false);
            jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTablePaciente.getColumnModel().getColumn(2).setResizable(false);
           

            jTablePaciente.getTableHeader().setReorderingAllowed(false);
            jTablePaciente.setAutoResizeMode(jTablePaciente.AUTO_RESIZE_OFF);
            jTablePaciente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        jTablePaciente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePaciente);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pesquisa.:");

        campoPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoPesquisaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPesquisaKeyTyped(evt);
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
        jLabel2.setText("Pacientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked

        id2 = jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString();
        nome = jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 1).toString();
        
        dispose();
        /*
        if(enviaTexto == null){
            int id = ((int) jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0));
           // nome = "" + jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 1);
            //cpf = ""+ jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 2);
            //id2 = ""+ id;
            
            
            try {
                enviaTexto = new FrmAtendimento();
                enviaTexto.recebendo(nome);
                enviaTexto.recebendo2(id2);
                enviaTexto.jTextFieldNomPaciente.setText(nome);

                //enviaTexto.setVisible(true);

                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(FrmBuscarPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            //enviaTexto.setVisible(true);
            //enviaTexto.setState(FrmAtendimento.NORMAL);
            dispose();
        }
*/
    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            popularTabela2();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        id2 = jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0).toString();
        nome = jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 1).toString();
        
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void campoPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisaKeyPressed

if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                jButton1ActionPerformed(null);
        }  
    }//GEN-LAST:event_campoPesquisaKeyPressed

    private void campoPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisaKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if ( campoPesquisa.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_campoPesquisaKeyTyped

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
            java.util.logging.Logger.getLogger(BuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscarPaciente dialog = null;
                try {
                    dialog = new BuscarPaciente(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(BuscarPaciente.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePaciente;
    // End of variables declaration//GEN-END:variables
}
