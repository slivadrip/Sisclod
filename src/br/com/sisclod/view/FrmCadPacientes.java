/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.CidadeDAO;
import br.com.sisclod.dao.EstadoDAO;
import br.com.sisclod.dao.PacienteDAO;
import br.com.sisclod.dao.SexoDAO;
import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Cidade;
import br.com.sisclod.model.Estado;
import br.com.sisclod.model.FixedLengthDocument;
import br.com.sisclod.model.ModeloTabela;
import br.com.sisclod.model.Paciente;
import br.com.sisclod.model.Sexo;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Dih
 */
public class FrmCadPacientes extends javax.swing.JFrame {

    public int muda = 1;
    public String sexo4;

    public FrmCadPacientes() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.formatarCampoData(jFormattedTextFieldData);
        this.FormataCampoCPF(jFormattedTextFielCPF);
        this.FormataCampoTelefone(jFormattedTextFieldTelefone);
        this.FormataCampoCelular(jFormattedTextFieldCelular);
      //  this.popularTabela();
        this.popularComboBoxUF();
        this.popularSexo();
        jLabelObrigBairro.setVisible(false);
        jLabelObrigData.setVisible(false);
        jLabelObrigEmail.setVisible(false);
        jLabelObrigEndereco.setVisible(false);
        jLabelObrigNome.setVisible(false);
        jLabelObrigRg.setVisible(false);
        jTextFieldNumero.setDocument(new FixedLengthDocument(3));

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
            jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(550);
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
            jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(550);
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

    public void popularSexo() throws SQLException {

        SexoDAO dao = null;
        try {
            dao = new SexoDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Sexo> sexos = null;
        try {
            sexos = dao.lista();
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        jComboBoxSexo.removeAllItems();
        for (int i = 0; i < sexos.size(); i++) {
            jComboBoxSexo.addItem(sexos.get(i).getNome());
        }

    }

    private void popularComboBoxCidade() {

        CidadeDAO dao = null;
        Cidade cidade = new Cidade();

        String valor = (String) jComboBoxCidade.getSelectedItem();
        try {
            dao = new CidadeDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Cidade> cidades = null;
        try {
            cidades = dao.lista();
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        jComboBoxCidade.removeAllItems();
        for (int i = 0; i < cidades.size(); i++) {
            jComboBoxCidade.addItem(cidades.get(i).getNome());
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

    public void acharSexo(String sexo2) throws SQLException {

        Connection conexao = null;
        conexao = Database.getConnection();

        String sql = "select * from tbSexo";

        PreparedStatement stmt = conexao.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            jComboBoxSexo.addItem(String.valueOf(rs.getString("dsSexo")));
            jComboBoxSexo.removeItemAt(2);

            break;

        }
    }

    public static boolean isCPF(String CPF) {

        // considera-se erro CPF's formados por uma sequencia de numeros iguais 
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso; // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try { // Calculo do 1o. Digito Verificador 
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero: // por exemplo, transforma o caractere '0' no inteiro 0 // (48 eh a posicao de '0' na tabela ASCII) 
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }
        // converte no respectivo caractere numerico 
            // Calculo do 2o. Digito Verificador 
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48); // Verifica se os digitos calculados conferem com os digitos informados. 
            }
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public void limparCampos() {

        this.jTextFieldNome.setText("");
        this.jFormattedTextFielCPF.setText(null);
        this.jTextFieldRG.setText("");
        this.jTextFieldEndereco.setText("");
        this.jTextFieldNumero.setText("");
        this.jTextFieldBairro.setText("");
        this.jFormattedTextFieldTelefone.setText(null);
        this.jFormattedTextFieldCelular.setText(null);
        this.jTextFieldEmail.setText("");
        this.jFormattedTextFieldData.setText("");
        this.jComboBoxSexo.setSelectedItem(null);
        this.jComboBoxUF.setSelectedItem(null);
        this.jComboBoxCidade.setSelectedItem(null);

    }

    public void validar() {

        StringBuilder verificar = new StringBuilder();

        if ((jTextFieldNome.getText().isEmpty()) || (jTextFieldEmail.getText().isEmpty()) || (jTextFieldEndereco.getText().isEmpty()) || (jTextFieldNumero.getText().isEmpty()) || (jTextFieldRG.getText().isEmpty()) || (jTextFieldBairro.getText().isEmpty())) {

            verificar.append("<b>Confira os campos Obrigatórios!</b>");

            if (jTextFieldNome.getText().isEmpty()) {
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
                verificar.append("\n-Telefone");
            } else {
                jLabelObrigEndereco.setVisible(false);
            }

            if (jTextFieldNumero.getText().isEmpty()) {
                jLabelObrigBairro.setVisible(true);
                verificar.append("\n-Bairro");
            } else {
                jLabelObrigBairro.setVisible(false);
            }
            if (jTextFieldRG.getText().isEmpty()) {
                jLabelObrigRg.setVisible(true);
                verificar.append("\n-RG");
            } else {
                jLabelObrigRg.setVisible(false);
            }
            if (jTextFieldBairro.getText().isEmpty()) {
                jLabelObrigBairro.setVisible(true);
                verificar.append("\n-Bairro");
            } else {
                jLabelObrigBairro.setVisible(false);
            }
            if (jComboBoxCidade.getSelectedItem().equals("")) {
                verificar.append("\n-Cidade");
            } else {
            }
            if (jComboBoxUF.getSelectedItem().equals("")) {
                verificar.append("\n-UF");
            } else {
            }
            if (jComboBoxSexo.getSelectedItem().equals("")) {
                verificar.append("\n-Sexo");
            } else {
            }
        } else {
            verificar.append("<b>Campos validados!</b>");
        }

        JOptionPane.showMessageDialog(null, verificar);

    }

    public void ocultarCampos() {
        jLabelObrigBairro.setVisible(false);
        jLabelObrigData.setVisible(false);
        jLabelObrigEmail.setVisible(false);
        jLabelObrigEndereco.setVisible(false);
        jLabelObrigNome.setVisible(false);
        jLabelObrigRg.setVisible(false);
    }

    public void alterar() throws SQLException {

        if (jTablePaciente.getSelectedRow() != -1) {
            String id1 = "" + (jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0));

            int id = Integer.parseInt(id1);
            System.out.println("id..:" + id);

            String nome = jTextFieldNome.getText().toUpperCase();
            String cpf = jFormattedTextFielCPF.getText().toUpperCase();
            String rg = jTextFieldRG.getText().toUpperCase();
            String Endereco = jTextFieldEndereco.getText().toUpperCase();
            String numero = jTextFieldNumero.getText().toUpperCase();
            String bairro = jTextFieldBairro.getText().toUpperCase();
            String telefone = jFormattedTextFieldTelefone.getText().toUpperCase();
            String celular = jFormattedTextFieldCelular.getText().toUpperCase();
            String email = jTextFieldEmail.getText().toUpperCase();
            String dtNascimento = jFormattedTextFieldData.getText().toUpperCase();
            String sexo = (String) jComboBoxSexo.getSelectedItem();
            sexo = sexo.toUpperCase();
            String cidade = (String) jComboBoxCidade.getSelectedItem();
            cidade = cidade.toUpperCase();
            String uf = (String) jComboBoxUF.getSelectedItem();
            uf = uf.toUpperCase();
            System.out.println("UF..:" + uf);
            Paciente paciente = new Paciente();

            PacienteDAO dao = new PacienteDAO();

            paciente.setNome(nome);
            paciente.setCpf(cpf);
            paciente.setRg(rg);
            paciente.setEndereco(Endereco);
            paciente.setNumero(numero);
            paciente.setBairro(bairro);
            paciente.setTelefone(telefone);
            paciente.setCelular(celular);
            paciente.setEmail(email);
            paciente.setDtNascimento(dtNascimento);
            paciente.setSexo(sexo);
            paciente.setCidade(cidade);
            paciente.setUF(uf);
            paciente.setId(id);

            dao.alterar(paciente);

            JOptionPane.showMessageDialog(rootPane, "Paciente Alterado com Sucesso");

            this.popularTabela();

        }
    }

    public void FormataCampoCPF(JFormattedTextField campo) {

        try {
            MaskFormatter novo = new MaskFormatter("###.###.###-##");
            novo.setValidCharacters("0123456789");
            novo.install(campo);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi poessível formatar campo \nDetalhes:" + ex, "Aviso!", WIDTH);
        }

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

    public void FormataCampoCelular(JFormattedTextField campo) {

        try {
            MaskFormatter novo = new MaskFormatter("(##) ####-####");
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

        jLabel29 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonCancelarJ = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldRG = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jComboBoxUF = new javax.swing.JComboBox();
        jComboBoxCidade = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jFormattedTextFielCPF = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCelular = new javax.swing.JFormattedTextField();
        jComboBoxSexo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelCpdValidar = new javax.swing.JLabel();
        jLabelObrigNome = new javax.swing.JLabel();
        jLabelObrigRg = new javax.swing.JLabel();
        jLabelObrigEndereco = new javax.swing.JLabel();
        jLabelObrigBairro = new javax.swing.JLabel();
        jLabelObrigEmail = new javax.swing.JLabel();
        jLabelObrigData = new javax.swing.JLabel();

        jLabel29.setForeground(new java.awt.Color(255, 51, 51));
        jLabel29.setText("*Obrigatorio");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pacientes");

        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jTablePaciente.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePaciente);

        jButtonNovo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\add1.png")); // NOI18N
        jButtonNovo.setToolTipText("Novo");
        jButtonNovo.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
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

        jButtonExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\trash.png")); // NOI18N
        jButtonExcluir.setToolTipText("Excluir");
        jButtonExcluir.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Arrow-turn-left.png")); // NOI18N
        jButtonCancelar.setToolTipText("Voltar");
        jButtonCancelar.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Pesquisar.:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87))
        );

        jTabbedPane4.addTab("Pacientes", jPanel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nome..:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CPF..:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("RG..:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Endereço..:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Bairro..:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Estado..:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Cidade..:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Telefone..:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Celular..:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Email..:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Data de Nascismento..:");

        jButtonSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Save.png")); // NOI18N
        jButtonSalvar.setToolTipText("Salvar");
        jButtonSalvar.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonLimpar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Clockwise-arrow.png")); // NOI18N
        jButtonLimpar.setToolTipText("Limpar");
        jButtonLimpar.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonCancelarJ.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\delete1.png")); // NOI18N
        jButtonCancelarJ.setToolTipText("Voltar");
        jButtonCancelarJ.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonCancelarJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarJActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Sexo..:");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyTyped(evt);
            }
        });

        jTextFieldRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRGActionPerformed(evt);
            }
        });
        jTextFieldRG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldRGKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRGKeyTyped(evt);
            }
        });

        jTextFieldEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEnderecoActionPerformed(evt);
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

        jTextFieldNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroActionPerformed(evt);
            }
        });
        jTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroKeyTyped(evt);
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

        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });
        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyReleased(evt);
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

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Numero..:");

        jFormattedTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataKeyPressed(evt);
            }
        });

        jFormattedTextFielCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFielCPFKeyPressed(evt);
            }
        });

        jFormattedTextFieldTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldTelefoneKeyPressed(evt);
            }
        });

        jFormattedTextFieldCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldCelularKeyPressed(evt);
            }
        });

        jComboBoxSexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxSexoKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Cadastro de Paciente");

        jLabelObrigNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigNome.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigNome.setText("*Obrigatorio");

        jLabelObrigRg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigRg.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigRg.setText("*Obrigatorio");

        jLabelObrigEndereco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigEndereco.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigEndereco.setText("*Obrigatorio");

        jLabelObrigBairro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigBairro.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigBairro.setText("*Obrigatorio");

        jLabelObrigEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigEmail.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigEmail.setText("*Obrigatorio");

        jLabelObrigData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigData.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigData.setText("*Obrigatorio");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(31, 31, 31)
                        .addComponent(jTextFieldEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldBairro))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jFormattedTextFielCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabelCpdValidar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldRG))
                            .addComponent(jTextFieldEndereco)
                            .addComponent(jTextFieldNome)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelObrigRg)
                    .addComponent(jLabelObrigEndereco)
                    .addComponent(jLabelObrigBairro)
                    .addComponent(jLabelObrigEmail)
                    .addComponent(jLabelObrigData)
                    .addComponent(jLabelObrigNome))
                .addGap(33, 33, 33))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel6))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonCancelarJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigNome))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormattedTextFielCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelCpdValidar)
                        .addComponent(jLabelObrigRg))
                    .addComponent(jLabel16))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigEndereco))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabelObrigBairro))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabelObrigData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCancelarJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Cadastro Paciente", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 790, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoActionPerformed

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        muda = 1;
        jTabbedPane4.setSelectedIndex(1);

        ocultarCampos();
        limparCampos();

    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        if (muda == 1) {
            
             
        
            String nome = jTextFieldNome.getText().toUpperCase();
            String cpf = jFormattedTextFielCPF.getText().toUpperCase();
            String rg = jTextFieldRG.getText().toUpperCase();
            String Endereco = jTextFieldEndereco.getText().toUpperCase();
            String numero = jTextFieldNumero.getText().toUpperCase();
            String bairro = jTextFieldBairro.getText().toUpperCase();
            String telefone = jFormattedTextFieldTelefone.getText().toUpperCase();
            String celular = jFormattedTextFieldCelular.getText().toUpperCase();
            String email = jTextFieldEmail.getText().toUpperCase();
            String dtNascimento = jFormattedTextFieldData.getText().toUpperCase();
            String sexo = (String) jComboBoxSexo.getSelectedItem();
            sexo = sexo.toUpperCase();
            String uf = (String) jComboBoxUF.getSelectedItem();
            uf = uf.toUpperCase();
            String cidade = (String) jComboBoxCidade.getSelectedItem();
            cidade = cidade.toUpperCase();

            Paciente paciente = new Paciente();

            paciente.setNome(nome);
            paciente.setCpf(cpf);
            paciente.setRg(rg);
            paciente.setEndereco(Endereco);
            paciente.setNumero(numero);
            paciente.setBairro(bairro);
            paciente.setTelefone(telefone);
            paciente.setCelular(celular);
            paciente.setEmail(email);
            paciente.setDtNascimento(dtNascimento);
            paciente.setSexo(sexo);
            paciente.setUF(uf);
            paciente.setCidade(cidade);

            validar();

            String cpf1 = jFormattedTextFielCPF.getText().replace(".", "");
            String cpf2 = cpf1.replace("-", "");
            // cpf1 = cpf.replace(".", "-");
            if (isCPF(cpf2) == false) {
                JOptionPane.showMessageDialog(rootPane, "CPF Invalido");
                jLabelCpdValidar.setText("*");
                System.out.println("cpf..:" + cpf2);
            } else {
                jLabelCpdValidar.setText("");

                PacienteDAO dao = null;
                try {
                    dao = new PacienteDAO();
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

                }

                try {
                    dao.gravar(paciente);
                    try {
                        limparCampos();
                        popularTabela();
                        JOptionPane.showMessageDialog(rootPane, "Paciente cadastrado!! ");
                        jTabbedPane4.setSelectedIndex(0);

                    } catch (SQLException ex) {
                        Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

                }

            }
        } else {
            try {
                alterar();
                limparCampos();
                popularTabela();
                jTabbedPane4.setSelectedIndex(0);

            } catch (SQLException ex) {
                Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro ao Alterar " + ex);

            }
        }


    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked

        try {

            Object idPaciente = jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0);

            Paciente paciente = new Paciente();

            try {
                PacienteDAO dao = new PacienteDAO();
                System.out.println(idPaciente);
                dao.listaJoin((int) idPaciente);
                jTextFieldNome.setText(paciente.getNome());
                System.out.println(paciente.getNome());

                jFormattedTextFielCPF.setText(paciente.getCpf());
                jTextFieldRG.setText(paciente.getRg());
                jTextFieldEndereco.setText(paciente.getEndereco());
                jTextFieldNumero.setText(paciente.getNumero());
                jTextFieldBairro.setText(paciente.getBairro());
                jFormattedTextFieldTelefone.setText(paciente.getTelefone());
                jFormattedTextFieldCelular.setText(paciente.getCelular());
                jTextFieldEmail.setText(paciente.getEmail());
                jFormattedTextFieldData.setText(paciente.getDtNascimento());
                jComboBoxUF.setSelectedItem(paciente.getUF());
                jComboBoxCidade.setSelectedItem(paciente.getCidade());
                jComboBoxSexo.setSelectedItem(paciente.getSexo());
                System.out.println(idPaciente);

            } catch (SQLException e) {
                System.out.println("Ocorreu um erro" + e.getMessage());
            }
            jButtonExcluir.setEnabled(true);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro" + e.getMessage());

        }

    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jComboBoxUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUFActionPerformed

        String dados = String.valueOf(jComboBoxUF.getSelectedItem());

        try {
            jComboBoxCidade.removeAllItems();
            jComboBoxCidade.addItem("Escolha");
            popComboCid(dados);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_jComboBoxUFActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        limparCampos();

        jTabbedPane4.setSelectedIndex(1);
        muda = 2;
        try {
            String id1 = "" + (jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0));

            int id = Integer.parseInt(id1);
            Paciente paciente = new Paciente();

            PacienteDAO dao = new PacienteDAO();
            dao.getPaciente(id);

            String uf = dao.uf;
            String cidade = dao.cidade;
            String sexo = dao.sexo;

            String aux = uf;
            uf = cidade;
            cidade = aux;

            this.jTextFieldNome.setText(dao.nome);
            this.jFormattedTextFielCPF.setText(dao.cpf);
            this.jTextFieldRG.setText(dao.rg);
            this.jTextFieldEndereco.setText(dao.endereco);
            this.jTextFieldNumero.setText(dao.numero);
            this.jTextFieldBairro.setText(dao.bairro);
            this.jFormattedTextFieldTelefone.setText(dao.telefone);
            this.jFormattedTextFieldCelular.setText(dao.celular);
            this.jTextFieldEmail.setText(dao.email);
            this.jFormattedTextFieldData.setText(dao.data);
            this.jComboBoxSexo.setSelectedItem(sexo);
            this.jComboBoxUF.setSelectedItem(uf);
            this.jComboBoxCidade.setSelectedItem(cidade);

            acharUF(sexo);
            acharCidade(cidade);
            acharSexo(sexo);
            System.out.println("udf...:" + uf);
            System.out.println("ciade...:" + cidade);
            System.out.println("sexo...:" + sexo);

            sexo4 = sexo;
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonEditarActionPerformed


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            popularTabela2();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();

    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

        String id1 = "" + (jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(), 0));
        int id = Integer.parseInt(id1);
        Paciente paciente = new Paciente();
        paciente.setId(id);
        PacienteDAO dao = null;
        try {
            dao = new PacienteDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Excluir o Paciente", "Confirmar a Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                dao.excluir(paciente);
                popularTabela();
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (resposta == JOptionPane.NO_OPTION) {

        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonCancelarJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarJActionPerformed
        jTabbedPane4.setSelectedIndex(0);


    }//GEN-LAST:event_jButtonCancelarJActionPerformed

    private void jTextFieldRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRGActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
        //FrmPrincipal frm = new FrmPrincipal();
        // frm.show();

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroActionPerformed

    private void campoPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton1ActionPerformed(null);
        }       }//GEN-LAST:event_campoPesquisaKeyPressed

    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFielCPF.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldNomeKeyPressed

    private void jFormattedTextFielCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFielCPFKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

           String cpf1 = jFormattedTextFielCPF.getText().replace(".", "");
            String cpf2 = cpf1.replace("-", "");
            // cpf1 = cpf.replace(".", "-");
            if (isCPF(cpf2) == false) {
                JOptionPane.showMessageDialog(rootPane, "CPF Invalido");
                jLabelCpdValidar.setText("*");
                System.out.println("cpf..:" + cpf2);
            } else {
                jLabelCpdValidar.setText("");

            jTextFieldRG.requestFocus();
            }
        }    }//GEN-LAST:event_jFormattedTextFielCPFKeyPressed

    private void jTextFieldRGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRGKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldEndereco.requestFocus();
        }    }//GEN-LAST:event_jTextFieldRGKeyPressed

    private void jTextFieldEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldNumero.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldEnderecoKeyPressed

    private void jTextFieldNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldBairro.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldNumeroKeyPressed

    private void jTextFieldBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBairroKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jComboBoxCidade.requestFocus();
        }    }//GEN-LAST:event_jTextFieldBairroKeyPressed

    private void jComboBoxUFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxUFKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jComboBoxCidade.requestFocus();
        }     }//GEN-LAST:event_jComboBoxUFKeyPressed

    private void jComboBoxCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxCidadeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFieldTelefone.requestFocus();
        }     }//GEN-LAST:event_jComboBoxCidadeKeyPressed

    private void jFormattedTextFieldTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefoneKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFieldCelular.requestFocus();
        }     }//GEN-LAST:event_jFormattedTextFieldTelefoneKeyPressed

    private void jFormattedTextFieldCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCelularKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldEmail.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextFieldCelularKeyPressed

    private void jTextFieldEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyReleased
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFieldData.requestFocus();
        }     }//GEN-LAST:event_jTextFieldEmailKeyReleased

    private void jFormattedTextFieldDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jComboBoxSexo.requestFocus();
        }     }//GEN-LAST:event_jFormattedTextFieldDataKeyPressed

    private void jComboBoxSexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxSexoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jButtonSalvar.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxSexoKeyPressed

    private void jTextFieldNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if ( jTextFieldNome.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_jTextFieldNomeKeyTyped

    private void jTextFieldRGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRGKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 20;
        if ( jTextFieldRG.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_jTextFieldRGKeyTyped

    private void jTextFieldEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if ( jTextFieldEndereco.getText().length() >= limite) {
            evt.consume();
        }   
    }//GEN-LAST:event_jTextFieldEnderecoKeyTyped

    private void jTextFieldNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 3;
        if ( jTextFieldNumero.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_jTextFieldNumeroKeyTyped

    private void jTextFieldBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBairroKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 40;
        if ( jTextFieldBairro.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_jTextFieldBairroKeyTyped

    private void campoPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisaKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 40;
        if ( campoPesquisa.getText().length() >= limite) {
            evt.consume();
        }      }//GEN-LAST:event_campoPesquisaKeyTyped

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
            java.util.logging.Logger.getLogger(FrmCadPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmCadPacientes().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarJ;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxCidade;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JComboBox jComboBoxUF;
    private javax.swing.JFormattedTextField jFormattedTextFielCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldCelular;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCpdValidar;
    private javax.swing.JLabel jLabelObrigBairro;
    private javax.swing.JLabel jLabelObrigData;
    private javax.swing.JLabel jLabelObrigEmail;
    private javax.swing.JLabel jLabelObrigEndereco;
    private javax.swing.JLabel jLabelObrigNome;
    private javax.swing.JLabel jLabelObrigRg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldRG;
    // End of variables declaration//GEN-END:variables
}
