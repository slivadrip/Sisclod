package br.com.sisclod.relatorios.util;

import br.com.sisclod.dao.GeradorRelatoriosDAO;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class GeradorRelatorio {

    public static JasperPrint getRelatorioPacientes(){
/*RETORNA UM JASPERPRINT, QUE SERA USADO PARA CONSTRUIR A JANELA DO RELATORIO*/
        JasperPrint jp = null;//INICIALIZA ELA
        try {
            GeradorRelatoriosDAO gr = new GeradorRelatoriosDAO(); 
            JRResultSetDataSource resultSet = new JRResultSetDataSource(gr.getRtSPacientesPorId()); /*PEGA O RESULT SET DA CLASSE DAO EQUIVALENTE*/
/*JRResultSetDataSource � A CLASSE QUE RECEBE O RESULT SET*/
            jp = JasperFillManager.fillReport("relatorios/Pacientes.jasper", new HashMap(), resultSet);/*AKI,A CLASSE ABRE O MODELO CRIADO PREVIAMENTE
TEM QUE FICAR ATENDO, POIS A PASTA ONDE VC SALVA O MODELO DO RELATORIO, USANDO PROGRAMA DO IPORT DEVE FICAR AKI, ALEM DISSO, VC DEVE COSTRUIT O MODELO DO RELATORIO
ANTES USANDO O PROGRAM IREPORT E SALVALO NESSE DIRETORIO,  E COM EXATAMENTE O MESMO SQL(SO QUE MINUSCULO) VC  CHAMAR O O RESULT SET
ESSE � MEU DIRETORIO COMPLETO "C:\Users\Nadinael\Documents\NetBeansProjects\SISGEBI\ireport-relatorios"
ONDE 'SISBEGI � A PASTA DO PROJETO, PERCEB Q VC N PRECISA ESPECIFICAR TUDO QUEANDO CHAMA O ARQUIVO [fillReport("ireport-relatorios/RelatorioTodosEstados.jasper", new HashMap(), resultSet)]'
 */
            gr.setCloseConnection();
        } catch (JRException ex) {
            System.out.println("FALHA: " + ex);
        }
        return jp;
/*RETORNA O JASPER PRINT QUE VAI MOSTRAR O RELATORIO/
    }
    
    public static JasperPrint getRelatorioAutores(){
        JasperPrint jp = null;
        try {
            GeradorRelatorioDAO gr = new GeradorRelatorioDAO();
            JRResultSetDataSource resultSet = new JRResultSetDataSource(gr.getRtStLivroPorId());
            jp = JasperFillManager.fillReport("ireport-relatorios/Relatorio.jasper", new HashMap(), resultSet);
            gr.setCloseConnection();
        } catch (JRException ex) {
            System.out.println("FALHA: " + ex);
        }
        return jp;
    }
    
*/
    
    }
    
    public static JasperPrint getRelatorioFuncionarios(){
        JasperPrint jp = null;//INICIALIZA ELA
        try {
            GeradorRelatoriosDAO gr = new GeradorRelatoriosDAO(); 
            JRResultSetDataSource resultSet = new JRResultSetDataSource(gr.getRtSFuncionarioPorId()); /*PEGA O RESULT SET DA CLASSE DAO EQUIVALENTE*/
            jp = JasperFillManager.fillReport("relatorios/funcionarios.jasper", new HashMap(), resultSet);
            gr.setCloseConnection();
        } catch (JRException ex) {
            System.out.println("FALHA: " + ex);
        }
        return jp;

    
    }
    
     public static JasperPrint getRelatorioProcedimentos(){
        JasperPrint jp = null;//INICIALIZA ELA
        try {
            GeradorRelatoriosDAO gr = new GeradorRelatoriosDAO(); 
            JRResultSetDataSource resultSet = new JRResultSetDataSource(gr.getRtSProcedimentosPorId()); /*PEGA O RESULT SET DA CLASSE DAO EQUIVALENTE*/
            jp = JasperFillManager.fillReport("relatorios/procedimentos.jasper", new HashMap(), resultSet);
            gr.setCloseConnection();
        } catch (JRException ex) {
            System.out.println("FALHA: " + ex);
        }
        return jp;

    
    }
     
     public static JasperPrint getRelatorioAgenda(String data1, String data2){
        JasperPrint jp = null;//INICIALIZA ELA
        try {
            GeradorRelatoriosDAO gr = new GeradorRelatoriosDAO(); 
            JRResultSetDataSource resultSet = new JRResultSetDataSource(gr.getRtSAgendaPorId(data1,data2)); /*PEGA O RESULT SET DA CLASSE DAO EQUIVALENTE*/
            jp = JasperFillManager.fillReport("relatorios/agenda.jasper", new HashMap(), resultSet);
            gr.setCloseConnection();
        } catch (JRException ex) {
            System.out.println("FALHA: " + ex);
        }
        return jp;

    
    }
     
         public static JasperPrint getRelatorioOrcamento (String cod){
        JasperPrint jp = null;//INICIALIZA ELA
        try {
            GeradorRelatoriosDAO gr = new GeradorRelatoriosDAO(); 
            JRResultSetDataSource resultSet = new JRResultSetDataSource(gr.getRtSAOrcamento(cod)); /*PEGA O RESULT SET DA CLASSE DAO EQUIVALENTE*/
            jp = JasperFillManager.fillReport("relatorios/orcamentos.jasper", new HashMap(), resultSet);
            gr.setCloseConnection();
        } catch (JRException ex) {
            System.out.println("FALHA: " + ex);
        }
        return jp;

    
    }
}