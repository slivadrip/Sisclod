/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.eclipse.persistence.config.TargetDatabase;

/**
 *
 * @author Dih
 */
public class GeradorRelatoriosDAO {

   // MessagesFactory msg;
    Connection conexao = null;
    ResultSet resultado = null;
    PreparedStatement stmt = null;
    Statement st = null;

    public GeradorRelatoriosDAO() {
        //msg = new MessagesFactory();
    }

    /**
     *
     * Não é interessante fechar a conexao no mesmo metodo que chama o
     * resultset, por isso, o tratamento sera difente, onde para chamar cada
     * relatorio pelo menos 2 metodos desta classe sera usado. 1 - gerar
     * rsultset (abre conexao automaticamente) 2 - fechar conexao
     *
     * @return
     */
//metodos da classe DAO
    public ResultSet getRtSPacientesPorId() {
        /*todas as QUERYS devem estar em ninusculo*/
        String sqlScript = "select * from tbpaciente order by idpaciente"; /*AKI VC COLOCA SEU SQL SEMPRE EM MINUSCULO*/
        try {
            conexao = Database.getConnection();
            stmt = conexao.prepareStatement(sqlScript);
            stmt.executeQuery();
            resultado = stmt.getResultSet();
        } catch (SQLException ex) {
            System.out.println("Classe DAO encontrou um problema!!!\nDetalhes : " + ex + "Aviso!!");
        }

        return resultado; /*ESSE METODO RETORNA UM RESULSET ESPECIFICAMENTE, É COM ELE COM A JASPERPRINT SERA PREENCHIDA, OU SEJA, ESTES MEDOTOS SERVEM APENAS PARA ACESSAR O BANCO E ENCONTRAR O RESULTADO*/
    }

    public ResultSet getRtStPacientePorNome() {
        String sqlScript = "select * from tbpaciente order by noPaciente";
        try {
            conexao = Database.getConnection();
            stmt = conexao.prepareStatement(sqlScript);
            stmt.executeQuery();
            resultado = stmt.getResultSet();
           
        } catch (SQLException ex) {
           
        }

        return resultado;
    }
    
    //metodos da classe DAO
    public ResultSet getRtSFuncionarioPorId() {
        /*todas as QUERYS devem estar em ninusculo*/
        String sqlScript = "select * from tbfuncionario"; /*AKI VC COLOCA SEU SQL SEMPRE EM MINUSCULO*/
        try {
            conexao = Database.getConnection();
            stmt = conexao.prepareStatement(sqlScript);
            stmt.executeQuery();
            resultado = stmt.getResultSet();
        } catch (SQLException ex) {
            System.out.println("Classe DAO encontrou um problema!!!\nDetalhes : " + ex + "Aviso!!");
        }

        return resultado; /*ESSE METODO RETORNA UM RESULSET ESPECIFICAMENTE, É COM ELE COM A JASPERPRINT SERA PREENCHIDA, OU SEJA, ESTES MEDOTOS SERVEM APENAS PARA ACESSAR O BANCO E ENCONTRAR O RESULTADO*/
    }

      public ResultSet getRtSProcedimentosPorId() {
        /*todas as QUERYS devem estar em ninusculo*/
        String sqlScript = "select * from tbprocedimentos"; /*AKI VC COLOCA SEU SQL SEMPRE EM MINUSCULO*/
        try {
            conexao = Database.getConnection();
            stmt = conexao.prepareStatement(sqlScript);
            stmt.executeQuery();
            resultado = stmt.getResultSet();
        } catch (SQLException ex) {
            System.out.println("Classe DAO encontrou um problema!!!\nDetalhes : " + ex + "Aviso!!");
        }
        return resultado; /*ESSE METODO RETORNA UM RESULSET ESPECIFICAMENTE, É COM ELE COM A JASPERPRINT SERA PREENCHIDA, OU SEJA, ESTES MEDOTOS SERVEM APENAS PARA ACESSAR O BANCO E ENCONTRAR O RESULTADO*/
    }
       public ResultSet getRtSAgendaPorId(String data1, String data2) {
        /*todas as QUERYS devem estar em ninusculo*/
        String sqlScript = "SELECT tbagenda2.idAgenda, tbpaciente.noPaciente, tbagenda2.dsData, tbagenda2.dsHora, tbpaciente.nrCelular\n" +
"FROM tbagenda2\n" +
"INNER JOIN tbpaciente ON tbagenda2.idPaciente = tbpaciente.idPaciente\n" +
"WHERE tbagenda2.dsData\n" +
"BETWEEN  '"+data1+"'\n" +
"AND  '"+data2+"'\n" +
"ORDER BY tbagenda2.dsData"; /*AKI VC COLOCA SEU SQL SEMPRE EM MINUSCULO*/
        try {
            conexao = Database.getConnection();
            stmt = conexao.prepareStatement(sqlScript);
            stmt.executeQuery();
            resultado = stmt.getResultSet();
        } catch (SQLException ex) {
            System.out.println("Classe DAO encontrou um problema!!!\nDetalhes : " + ex + "Aviso!!");
        }

        return resultado; /*ESSE METODO RETORNA UM RESULSET ESPECIFICAMENTE, É COM ELE COM A JASPERPRINT SERA PREENCHIDA, OU SEJA, ESTES MEDOTOS SERVEM APENAS PARA ACESSAR O BANCO E ENCONTRAR O RESULTADO*/
    }
 
       
       
       public ResultSet getRtSAOrcamento(String cod) {
        /*todas as QUERYS devem estar em ninusculo*/
        String sqlScript =" SELECT tborcamento.nrOrcamento, tbpaciente.noPaciente, tbpaciente.dsEndereco,tbpaciente.nrCpf, tbpaciente.dsBairro, tbpaciente.nrTelefone, tborcamento.dsValor, tborcamento.quantidade, tborcamento.idProcedimentos,tborcamento.vlTotal FROM tborcamento INNER JOIN tbpaciente on tborcamento.idPaciente = tbpaciente.idPaciente where tborcamento.nrOrcamento = '"+cod+"'"; /*AKI VC COLOCA SEU SQL SEMPRE EM MINUSCULO*/
        try {
            conexao = Database.getConnection();
            stmt = conexao.prepareStatement(sqlScript);
            stmt.executeQuery();
            resultado = stmt.getResultSet();
        } catch (SQLException ex) {
            System.out.println("Classe DAO encontrou um problema!!!\nDetalhes : " + ex + "Aviso!!");
        }

        return resultado; /*ESSE METODO RETORNA UM RESULSET ESPECIFICAMENTE, É COM ELE COM A JASPERPRINT SERA PREENCHIDA, OU SEJA, ESTES MEDOTOS SERVEM APENAS PARA ACESSAR O BANCO E ENCONTRAR O RESULTADO*/
    }
    public void setCloseConnection() {

        try {
            resultado.close();
            stmt.close();
            conexao.close();
            resultado = null;
            stmt = null;
            conexao = null;
        } catch (SQLException ex) {
            System.out.println("ERRO AO FECHAR CONECCAO: " + ex);
        }

    }

}
