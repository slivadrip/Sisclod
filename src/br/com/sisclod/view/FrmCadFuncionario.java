/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.CidadeDAO;
import br.com.sisclod.dao.EstadoDAO;
import br.com.sisclod.dao.FuncionarioDAO;
import br.com.sisclod.dao.SexoDAO;
import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Cidade;
import br.com.sisclod.model.Estado;
import br.com.sisclod.model.FixedLengthDocument;
import br.com.sisclod.model.Funcionario;
import br.com.sisclod.model.ModeloTabela;
import br.com.sisclod.model.Sexo;
import static br.com.sisclod.view.FrmCadPacientes.isCPF;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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
 * @auhor rootux
 */
public class FrmCadFuncionario extends javax.swing.JFrame {

    public int muda = 1;

    /**
     * Creates new form FrmCadFuncionario
     */
    public FrmCadFuncionario() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.formatarCampoData(jFormattedTextFieldData);
        this.FormataCampoCPF(jFormattedTextFielCPF);
        this.FormataCampoTelefone(jFormattedTextFieldTelefone);
        this.FormataCampoCelular(jFormattedTextFieldCelular);
       // this.popularTabela();
        this.popularComboBoxUF();
        this.popularSexo();
        jTextFieldNumero.setDocument(new FixedLengthDocument(3));

        jLabelObrigData.setVisible(false);
        jLabelObrigEndereco.setVisible(false);
        jLabelObrigNome.setVisible(false);
        jLabelObrigRg.setVisible(false);
        jLabelLogin.setVisible(false);
        jlabelObrigNum.setVisible(false);
    }

    public void popularTabela() throws SQLException {
        String[] coluna = new String[]{"ID", "NOME", "CPF", "USUARIO"};
        ArrayList dados = new ArrayList();
        FuncionarioDAO dao = new FuncionarioDAO();
        ArrayList<Funcionario> listagem;

        listagem = (ArrayList<Funcionario>) dao.lista();
        for (Funcionario funcionario : listagem) {
            dados.add(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getUsuario()});
        }

        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTableFuncionario.setModel(modelo);
            jTableFuncionario.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableFuncionario.getColumnModel().getColumn(0).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(450);
            jTableFuncionario.getColumnModel().getColumn(1).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableFuncionario.getColumnModel().getColumn(2).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTableFuncionario.getColumnModel().getColumn(3).setResizable(false);

            jTableFuncionario.getTableHeader().setReorderingAllowed(false);
            jTableFuncionario.setAutoResizeMode(jTableFuncionario.AUTO_RESIZE_OFF);
            jTableFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados\ndetalhes: " + ex, "Aviso!", 1);
        }

    }

    public void popularTabela2() throws SQLException {
        String[] coluna = new String[]{"ID", "NOME", "CPF", "USUARIO"};
        ArrayList dados = new ArrayList();
        FuncionarioDAO dao = new FuncionarioDAO();
        ArrayList<Funcionario> listagem;

        String pesquisar = jTextFieldPesquisar.getText();

        listagem = (ArrayList<Funcionario>) dao.lista2(pesquisar);
        for (Funcionario funcionario : listagem) {
            dados.add(new Object[]{funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getUsuario()});
        }

        ModeloTabela modelo = new ModeloTabela(dados, coluna);

        try {
            jTableFuncionario.setModel(modelo);
            jTableFuncionario.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableFuncionario.getColumnModel().getColumn(0).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(450);
            jTableFuncionario.getColumnModel().getColumn(1).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTableFuncionario.getColumnModel().getColumn(2).setResizable(false);
            jTableFuncionario.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTableFuncionario.getColumnModel().getColumn(3).setResizable(false);

            jTableFuncionario.getTableHeader().setReorderingAllowed(false);
            jTableFuncionario.setAutoResizeMode(jTableFuncionario.AUTO_RESIZE_OFF);
            jTableFuncionario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        this.jTextFieldLogin.setText("");
        this.jPasswordFieldFuncionario.setText(null);
        this.jComboBoxUser.setSelectedItem(null);

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

    public void alterar() throws SQLException {

        if (jTableFuncionario.getSelectedRow() != -1) {
            String id1 = "" + (jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 0));

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
            String uf = (String) jComboBoxUF.getSelectedItem();
            uf = uf.toUpperCase();
            String cidade = (String) jComboBoxCidade.getSelectedItem();
            cidade = cidade.toUpperCase();
            String usuario = (String) jComboBoxUser.getSelectedItem();
            String login = jTextFieldLogin.getText().toUpperCase();
            String senha = jPasswordFieldFuncionario.getText().toUpperCase();

            System.out.println("UF..:" + uf);
            Funcionario funcionario = new Funcionario();

            FuncionarioDAO dao = new FuncionarioDAO();

            funcionario.setNome(nome);
            funcionario.setCpf(cpf);
            funcionario.setRg(rg);
            funcionario.setEndereco(Endereco);
            funcionario.setNumero(numero);
            funcionario.setBairro(bairro);
            funcionario.setTelefone(telefone);
            funcionario.setCelular(celular);
            funcionario.setEmail(email);
            funcionario.setDtNascimento(dtNascimento);
            funcionario.setUF(uf);
            funcionario.setCidade(cidade);
            funcionario.setSexo(sexo);
            funcionario.setUsuario(usuario);
            funcionario.setLogin(login);
            funcionario.setSenha(senha);
            funcionario.setId(id);

            dao.alterar(funcionario);

            JOptionPane.showMessageDialog(rootPane, "Funcionario Alterado com Sucesso");

            this.popularTabela();

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

    public void validar() {
        StringBuilder verificar = new StringBuilder();

        if ((jTextFieldNome.getText().isEmpty()) || (jTextFieldEndereco.getText().isEmpty()) || (jTextFieldRG.getText().isEmpty()) || (jTextFieldLogin.getText().isEmpty()) || (jTextFieldBairro.getText().isEmpty())) {

            verificar.append("<b>Confira os campos Obrigatórios!</b>");

            if (jTextFieldNome.getText().isEmpty()) {
                verificar.append("\n-Nome");
                jLabelObrigNome.setVisible(true);
            } else {
                jLabelObrigNome.setVisible(false);
            }

            if (jTextFieldEndereco.getText().isEmpty()) {
                jLabelObrigEndereco.setVisible(true);
                verificar.append("\n-Endereço");
            } else {
                jLabelObrigEndereco.setVisible(false);
            }

            if (jTextFieldRG.getText().isEmpty()) {
                jLabelObrigRg.setVisible(true);
                verificar.append("\n-RG");
            } else {
                jLabelObrigRg.setVisible(false);
            }
            if (jTextFieldLogin.getText().isEmpty()) {
                jLabelLogin.setVisible(true);
                verificar.append("\n-Login");
            } else {
                jLabelLogin.setVisible(false);
            }
            if (jTextFieldBairro.getText().isEmpty()) {
                jlabelObrigNum.setVisible(true);
                verificar.append("\n-Bairro");
            } else {
                jlabelObrigNum.setVisible(false);
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
            if (jFormattedTextFieldCelular.getText().isEmpty()) {
                verificar.append("\n-Celular");
            } else {
            }
        } else {
            verificar.append("<b>Campos validados!</b>");
        }

        JOptionPane.showMessageDialog(null, verificar);

    }

    public void ocultarCampos() {
        jLabelObrigData.setVisible(false);
        jLabelObrigEndereco.setVisible(false);
        jLabelObrigNome.setVisible(false);
        jLabelObrigRg.setVisible(false);
        jLabelLogin.setVisible(false);
        jlabelObrigNum.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
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
        jLabel11 = new javax.swing.JLabel();
        jTextFieldRG = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jComboBoxUF = new javax.swing.JComboBox();
        jComboBoxCidade = new javax.swing.JComboBox();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxUser = new javax.swing.JComboBox();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelarJ = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jFormattedTextFielCPF = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCelular = new javax.swing.JFormattedTextField();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldLogin = new javax.swing.JTextField();
        jPasswordFieldFuncionario = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCPF2 = new javax.swing.JLabel();
        jLabelObrigNome = new javax.swing.JLabel();
        jLabelObrigRg = new javax.swing.JLabel();
        jLabelObrigEndereco = new javax.swing.JLabel();
        jlabelObrigNum = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        jLabelObrigData = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelCpdValidar = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPasswordFieldFuncionario1 = new javax.swing.JPasswordField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        jLabel19.setText("jLabel19");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionarios");

        jPanel2.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel2.setRequestFocusEnabled(false);

        jTableFuncionario.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableFuncionario);

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

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Pesquisa:");

        jTextFieldPesquisar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
        );

        jTabbedPane1.addTab("Funcionário", jPanel2);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nome....:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CPF..:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("RG..:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Endereço..:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Numero..:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Bairro..:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Estado..:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Cidade..:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Email..:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Telefone..:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Celular..:");

        jTextFieldRG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldRGKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRGKeyTyped(evt);
            }
        });

        jTextFieldEndereco.setMinimumSize(new java.awt.Dimension(6, 19));
        jTextFieldEndereco.setPreferredSize(new java.awt.Dimension(20, 20));
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
        jComboBoxCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCidadeActionPerformed(evt);
            }
        });
        jComboBoxCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxCidadeKeyPressed(evt);
            }
        });

        jTextFieldEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldEmailFocusLost(evt);
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Data de Nascismento..:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Sexo..:");

        jComboBoxSexo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        jComboBoxSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxSexoKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Tipo Funcionario");

        jComboBoxUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBoxUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADMINISTRADOR", "ODONTOLOGISTA", "SECRETARIA" }));
        jComboBoxUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxUserKeyPressed(evt);
            }
        });

        jButtonSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\Save.png")); // NOI18N
        jButtonSalvar.setToolTipText("Salvar");
        jButtonSalvar.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelarJ.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dih\\Desktop\\icones\\fantatisk\\png\\project\\delete1.png")); // NOI18N
        jButtonCancelarJ.setToolTipText("Cancelar");
        jButtonCancelarJ.setPreferredSize(new java.awt.Dimension(60, 60));
        jButtonCancelarJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarJActionPerformed(evt);
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

        jFormattedTextFielCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextFielCPFFocusLost(evt);
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

        jFormattedTextFieldData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel15.setText("Cadastro de Funcionário");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Login:");

        jTextFieldLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldLoginKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLoginKeyTyped(evt);
            }
        });

        jPasswordFieldFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldFuncionarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldFuncionarioKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Senha..:");

        jLabelEmail.setForeground(new java.awt.Color(255, 0, 51));

        jLabelCPF2.setForeground(new java.awt.Color(255, 0, 51));

        jLabelObrigNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigNome.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigNome.setText("*Obrigatorio");

        jLabelObrigRg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigRg.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigRg.setText("*Obrigatorio");

        jLabelObrigEndereco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigEndereco.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigEndereco.setText("*Obrigatorio");

        jlabelObrigNum.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlabelObrigNum.setForeground(new java.awt.Color(255, 51, 51));
        jlabelObrigNum.setText("*Obrigatorio");

        jLabelLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelLogin.setForeground(new java.awt.Color(255, 51, 51));
        jLabelLogin.setText("*Obrigatorio");

        jLabelObrigData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelObrigData.setForeground(new java.awt.Color(255, 51, 51));
        jLabelObrigData.setText("*Obrigatorio");

        jTextFieldNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomeKeyTyped(evt);
            }
        });

        jLabelCpdValidar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelCpdValidar.setForeground(new java.awt.Color(255, 51, 51));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Repita");

        jPasswordFieldFuncionario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldFuncionario1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordFieldFuncionario1KeyTyped(evt);
            }
        });

        jLabel21.setText("*");

        jLabel22.setText("*");

        jLabel23.setText("*");

        jLabel24.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(223, 223, 223)
                        .addComponent(jLabelCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelObrigRg)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jFormattedTextFielCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelCpdValidar)
                                        .addGap(80, 80, 80))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldCelular))
                                    .addComponent(jTextFieldEmail)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(147, 147, 147)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldBairro))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel17))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jButtonCancelarJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jPasswordFieldFuncionario1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPasswordFieldFuncionario))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)))
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(182, 182, 182)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelObrigData)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabelObrigEndereco))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlabelObrigNum))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelLogin))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelObrigNome, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel15)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelObrigNome)
                    .addComponent(jLabel21))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextFieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelObrigRg)
                                        .addComponent(jFormattedTextFielCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel22)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabelCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCpdValidar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelObrigEndereco)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelObrigNum))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelObrigData))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jPasswordFieldFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jPasswordFieldFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelarJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Cadastro Funcionário", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed

        jTabbedPane1.setSelectedIndex(1);
        limparCampos();
        ocultarCampos();
        muda = 1;
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed

        limparCampos();

        jTabbedPane1.setSelectedIndex(1);
        muda = 2;
        try {
            String id1 = "" + (jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 0));

            int id = Integer.parseInt(id1);
            Funcionario funcionario = new Funcionario();

            FuncionarioDAO dao = new FuncionarioDAO();
            dao.getFuncionario(id);

            String uf = dao.uf;
            String cidade = dao.cidade;
            String sexo = dao.sexo;
            String usuario = dao.usuario;

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
            this.jComboBoxUF.setSelectedItem(cidade);
            this.jComboBoxCidade.setSelectedItem(uf);
            this.jComboBoxUser.setSelectedItem(usuario);
            this.jTextFieldLogin.setText(dao.login);
            this.jPasswordFieldFuncionario.setText(dao.senha);

            System.out.println("UF...:" + uf);

        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonEditarActionPerformed

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
            String uf = (String) jComboBoxUF.getSelectedItem();
            uf = uf.toUpperCase();
            String cidade = (String) jComboBoxCidade.getSelectedItem();
            cidade = cidade.toUpperCase();
            String usuario = (String) jComboBoxUser.getSelectedItem();

            String login = jTextFieldLogin.getText().toUpperCase();
            String senha = jPasswordFieldFuncionario.getText().toUpperCase();

            validar();
            String cpf1 = jFormattedTextFielCPF.getText().replace(".", "");
            String cpf2 = cpf1.replace("-", "");
            // cpf1 = cpf.replace(".", "-");
            if (isCPF(cpf2) == false) {
                JOptionPane.showMessageDialog(rootPane, "CPF Invalido");
                jLabelCPF2.setText("*");
                System.out.println("cpf..:" + cpf2);
            } else {
                jLabelCPF2.setText("");

                Funcionario funcionario = new Funcionario();

                funcionario.setNome(nome);
                funcionario.setCpf(cpf);
                funcionario.setRg(rg);
                funcionario.setEndereco(Endereco);
                funcionario.setNumero(numero);
                funcionario.setBairro(bairro);
                funcionario.setTelefone(telefone);
                funcionario.setCelular(celular);
                funcionario.setEmail(email);
                funcionario.setDtNascimento(dtNascimento);
                funcionario.setSexo(sexo);
                funcionario.setUF(uf);
                funcionario.setCidade(cidade);
                funcionario.setUsuario(usuario);
                funcionario.setLogin(login);
                funcionario.setSenha(senha);

                FuncionarioDAO dao = null;
                try {
                    dao = new FuncionarioDAO();
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);
                }

                try {
                    dao.gravar(funcionario);
                    jLabelCPF2.setText("");

                    try {
                        limparCampos();
                        popularTabela();
                        JOptionPane.showMessageDialog(rootPane, "Funcionario Cadastrado!!");

                    } catch (SQLException ex) {
                        Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar" + ex);

                }
            }

        } else {
            try {
                alterar();
                try {
                    limparCampos();
                    popularTabela();
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar " + ex);

            }
        }


    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        String id1 = "" + (jTableFuncionario.getValueAt(jTableFuncionario.getSelectedRow(), 0));
        int id = Integer.parseInt(id1);
        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        FuncionarioDAO dao = null;
        try {
            dao = new FuncionarioDAO();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Excluir o Funcionario", "Confirmar a Exclusão", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try {
                dao.excluir(funcionario);
                popularTabela();
                JOptionPane.showMessageDialog(rootPane, "Funcionário Excluido ");

            } catch (SQLException ex) {
                Logger.getLogger(FrmCadPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (resposta == JOptionPane.NO_OPTION) {


      }    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jComboBoxUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUFActionPerformed
        String dados = String.valueOf(jComboBoxUF.getSelectedItem());

        try {
            jComboBoxCidade.removeAllItems();
            jComboBoxCidade.addItem("Escolha");
            popComboCid(dados);
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_jComboBoxUFActionPerformed

    private void jComboBoxCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCidadeActionPerformed

    private void jTextFieldEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            popularTabela2();
        } catch (SQLException ex) {
            Logger.getLogger(FrmCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonCancelarJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarJActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButtonCancelarJActionPerformed

    private void jTextFieldEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusLost

        /*if ((jTextFieldEmail.getText().contains("@")) && (jTextFieldEmail.getText().contains(".")) && 
         (!jTextFieldEmail.getText().contains(" "))) { 
         String usuario = new String(jTextFieldEmail.getText().substring(0,
         jTextFieldEmail.getText().lastIndexOf('@'))); 
    
         String dominio = new String(jTextFieldEmail.getText().substring(jTextFieldEmail.getText().lastIndexOf ('@') + 1,
         jTextFieldEmail.getText().length())); if ((usuario.length() >=1) && (!usuario.contains("@")) &&
         (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".") >= 1) && 
         (dominio.lastIndexOf(".") < dominio.length() - 1)) { jLabelEmail.setText(""); 
         } else {
         jLabelEmail.setText("E-mail Inválido");
         jTextFieldEmail.requestFocus();
         } 
         } 
         else {
         jLabelEmail.setText("E-mail Inválido"); 
         jTextFieldEmail.requestFocus(); 
         }

         */
    }//GEN-LAST:event_jTextFieldEmailFocusLost

    private void jFormattedTextFielCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFielCPFFocusLost

    }//GEN-LAST:event_jFormattedTextFielCPFFocusLost

    private void jTextFieldPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_jTextFieldPesquisarKeyPressed

    private void jTextFieldNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFielCPF.requestFocus();
        }    }//GEN-LAST:event_jTextFieldNomeKeyPressed

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
        }
    }//GEN-LAST:event_jFormattedTextFielCPFKeyPressed

    private void jTextFieldRGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRGKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldEndereco.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldRGKeyPressed

    private void jTextFieldEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldNumero.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldEnderecoKeyPressed

    private void jTextFieldNumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldBairro.requestFocus();
        }    }//GEN-LAST:event_jTextFieldNumeroKeyPressed

    private void jTextFieldBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBairroKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

            jComboBoxUF.requestFocus();
        }
    }//GEN-LAST:event_jTextFieldBairroKeyPressed

    private void jComboBoxUFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxUFKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jComboBoxCidade.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxUFKeyPressed

    private void jComboBoxCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxCidadeKeyPressed

        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFieldTelefone.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxCidadeKeyPressed

    private void jFormattedTextFieldTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldTelefoneKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFieldCelular.requestFocus();
        }
    }//GEN-LAST:event_jFormattedTextFieldTelefoneKeyPressed

    private void jFormattedTextFieldCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCelularKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldEmail.requestFocus();
        }    }//GEN-LAST:event_jFormattedTextFieldCelularKeyPressed

    private void jTextFieldEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jFormattedTextFieldData.requestFocus();
        }    }//GEN-LAST:event_jTextFieldEmailKeyPressed

    private void jFormattedTextFieldDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jComboBoxSexo.requestFocus();
        }    }//GEN-LAST:event_jFormattedTextFieldDataKeyPressed

    private void jComboBoxSexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxSexoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jTextFieldLogin.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxSexoKeyPressed

    private void jTextFieldLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoginKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jPasswordFieldFuncionario.requestFocus();
        }    }//GEN-LAST:event_jTextFieldLoginKeyPressed

    private void jPasswordFieldFuncionarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldFuncionarioKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jComboBoxUser.requestFocus();
        }    }//GEN-LAST:event_jPasswordFieldFuncionarioKeyPressed

    private void jComboBoxUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxUserKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {

            jButtonSalvar.requestFocus();
        }
    }//GEN-LAST:event_jComboBoxUserKeyPressed

    private void jTextFieldNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeKeyTyped
        String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 50;
        if (jTextFieldNome.getText().length() >= limite) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldNomeKeyTyped

    private void jTextFieldRGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRGKeyTyped
   String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 45;
        if (jTextFieldRG.getText().length() >= limite) {
            evt.consume();
        }    }//GEN-LAST:event_jTextFieldRGKeyTyped

    private void jTextFieldNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 3;
        if ( jTextFieldNumero.getText().length() >= limite) {
            evt.consume();
        }     }//GEN-LAST:event_jTextFieldNumeroKeyTyped

    private void jTextFieldBairroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBairroKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 40;
        if ( jTextFieldBairro.getText().length() >= limite) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldBairroKeyTyped

    private void jTextFieldEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyTyped

        int limite = 50;
        if ( jTextFieldEmail.getText().length() >= limite) {
            evt.consume();
        }    }//GEN-LAST:event_jTextFieldEmailKeyTyped

    private void jTextFieldLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLoginKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 20;
        if ( jTextFieldLogin.getText().length() >= limite) {
            evt.consume();
        }    }//GEN-LAST:event_jTextFieldLoginKeyTyped

    private void jPasswordFieldFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldFuncionarioKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 20;
        if ( jTextFieldNumero.getText().length() >= limite) {
            evt.consume();
        }    }//GEN-LAST:event_jPasswordFieldFuncionarioKeyTyped

    private void jTextFieldEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 20;
        if ( jTextFieldEndereco.getText().length() >= limite) {
            evt.consume();
        }      }//GEN-LAST:event_jTextFieldEnderecoKeyTyped

    private void jTextFieldPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyTyped
String min = "qwertyuiopasdfghjklçzxcvbnm";

        if (min.contains(evt.getKeyChar() + "")) {
            evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
        int limite = 40;
        if ( jTextFieldPesquisar.getText().length() >= limite) {
            evt.consume();
        }       }//GEN-LAST:event_jTextFieldPesquisarKeyTyped

    private void jPasswordFieldFuncionario1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldFuncionario1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldFuncionario1KeyPressed

    private void jPasswordFieldFuncionario1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldFuncionario1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldFuncionario1KeyTyped

    public static String imprimeCPF(String CPF) {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));

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
            java.util.logging.Logger.getLogger(FrmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmCadFuncionario().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JComboBox jComboBoxUser;
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
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCPF2;
    private javax.swing.JLabel jLabelCpdValidar;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelObrigData;
    private javax.swing.JLabel jLabelObrigEndereco;
    private javax.swing.JLabel jLabelObrigNome;
    private javax.swing.JLabel jLabelObrigRg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldFuncionario;
    private javax.swing.JPasswordField jPasswordFieldFuncionario1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableFuncionario;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldRG;
    private javax.swing.JLabel jlabelObrigNum;
    // End of variables declaration//GEN-END:variables
}
