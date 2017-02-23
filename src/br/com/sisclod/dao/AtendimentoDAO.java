/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Atendimento;
import br.com.sisclod.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dih
 */
public class AtendimentoDAO {
    
      private Connection conexao = null;
            public int paciente;
            public String servico,data ,hora1,hora2,obs,funcionario,status;
                            
	 public AtendimentoDAO() throws SQLException{
		conexao = Database.getConnection();
		
	}
    
         public void gravar(Atendimento atendimento) throws SQLException{
	

                String sql= "insert into tbagenda2 (idPaciente, idFuncionario, servico, dsData, dsHora, status, obs)" + 
                     "values (?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1,atendimento.getIdPaciente());
		stmt.setString(2,atendimento.getIdFuncionario());
		stmt.setString(3,atendimento.getServico());
		stmt.setString(4,atendimento.getData());
                stmt.setString(5,atendimento.getHora());
                stmt.setString(6,atendimento.getStatus());
                stmt.setString(7,atendimento.getObs());
	

		stmt.execute();
		stmt.close();
}
        
        public void alterar(Atendimento atendimento) throws SQLException{
            
            String sql= "update tbagenda2 set idPaciente=?, idFuncionario=?, servico=?, dsData=?, dsHora=?,"
                    + " status=?, obs=?" + 
                     "where idAgenda=?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
                stmt.setInt(1,atendimento.getIdPaciente());
		stmt.setString(2,atendimento.getIdFuncionario());
		stmt.setString(3,atendimento.getServico());
		stmt.setString(4,atendimento.getData());
                stmt.setString(5,atendimento.getHora());
                stmt.setString(6,atendimento.getStatus());
                stmt.setString(7,atendimento.getObs());
                stmt.setInt(8, atendimento.getId());

            stmt.execute();
	    stmt.close();

        }
        
         public void excluir(Atendimento atendimento) throws SQLException{  
        
                        String sql = "DELETE FROM tbagenda2 WHERE idAgenda = ?";  
        
		   PreparedStatement stmt = conexao.prepareStatement(sql);
              
              
                    stmt.setInt(1, atendimento.getId());   
             
                    stmt.executeUpdate();  
                    stmt.close();  
       
        } 
        public Atendimento getAtendimento(int idAgenda ) {
             try {
                  Atendimento atendimento = new Atendimento();
                  PreparedStatement stmt = conexao.prepareStatement("select * from tbagenda2 where idAgenda="+idAgenda+"");
                  ResultSet rs = stmt.executeQuery();
                      while (rs.next()){
                            atendimento.setId(rs.getInt("idAgenda"));
                            atendimento.setIdPaciente(rs.getInt("idPaciente"));
                            atendimento.setIdFuncionario(rs.getString("idFuncionario"));
                            atendimento.setServico(rs.getString("servico"));
                            atendimento.setData(rs.getString("dsData"));
                            atendimento.setHora(rs.getString("dsHora"));
                            atendimento.setStatus(rs.getString("status"));
                            atendimento.setObs(rs.getString("obs"));

                            paciente =  atendimento.getIdPaciente();
                            funcionario = atendimento.getIdFuncionario();
                            servico =atendimento.getServico();
                            data =atendimento.getData();
                            hora1=atendimento.getHora();
                            status=atendimento.getStatus();
                            obs=atendimento.getObs();
                            

    }

    rs.close();
    stmt.close();
    return  atendimento;

    } catch(SQLException e) {
        throw new RuntimeException(e);
    }
}
         
     public List<Atendimento> lista() throws SQLException{
			List<Atendimento> Atendimentos = new ArrayList<Atendimento>();
			String sql = "select * from tbagenda2";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Atendimento atendimento = new Atendimento();
				    atendimento.setId(rs.getInt("idPaciente"));
                                   // atendimento.setNome(rs.getString("noPaciente"));
				   // atendimento.setCpf(rs.getString("nrCpf"));

				  
				    Atendimentos.add(atendimento);
				}
                                stmt.execute();
                                stmt.close();
				return Atendimentos;
			}
                
                   }
         
         
         
          public List<Atendimento> getLista1() throws SQLException{
		List<Atendimento> atendimentos = new ArrayList<>();
                 Date data = new Date();
                 SimpleDateFormat dformatador = new SimpleDateFormat("dd-MM-yyyy");
                 String sData = dformatador.format(data);
                 System.out.println("dddd"+sData);
		String sql = "SELECT tbagenda2.idAgenda, tbpaciente.noPaciente, tbagenda2.dsData, tbagenda2.dsHora, tbagenda2.status \n" +
                    "FROM `tbagenda2`\n" +
                        "INNER JOIN `tbpaciente` on tbagenda2.idPaciente = tbpaciente.idPaciente WHERE tbagenda2.dsData ='"+sData+"' ORDER BY idAgenda;";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
                            
			while (rs.next()){
			    Atendimento atendimento = new Atendimento();
			    atendimento.setId(rs.getInt("tbagenda2.idAgenda"));
			    atendimento.setNomePaciente(rs.getString("tbpaciente.noPaciente"));
                            atendimento.setData(rs.getString("tbagenda2.dsData"));                         
                            atendimento.setHora(rs.getString("tbagenda2.dsHora"));                         
                            atendimento.setStatus(rs.getString("tbagenda2.status"));
			   
			    atendimentos.add(atendimento);
			}
			return atendimentos;
		}
          }
          
           public List<Atendimento> getListaJoin() throws SQLException{
		List<Atendimento> atendimentos = new ArrayList<>();
		String sql = "SELECT pac.noPaciente, ag2.servico, ag2.dsData, ag2.dsHora\n" +
"FROM tbagenda2 AS ag2\n" +
"INNER JOIN tbpaciente pac ON ag2.idPaciente = pac.idPaciente";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
                            
			while (rs.next()){
			    Atendimento atendimento = new Atendimento();
			    atendimento.setNomePaciente(rs.getString("pac.noPaciente"));
                            atendimento.setData(rs.getString("ag2.dsData"));   
                            atendimento.setHora(rs.getString("ag2.dsHora"));   
                            atendimento.setServico(rs.getString("ag2.servico"));     

                       //     atendimento.setIdPaciente(rs.getInt("ag2.idPaciente"));
			   
			    atendimentos.add(atendimento);
			}
			return atendimentos;
		}
          }
           
              public List<Atendimento> getListaJoinData(String data) throws SQLException{
		List<Atendimento> atendimentos = new ArrayList<>();
		String sql = "SELECT pac.noPaciente, ag2.servico, ag2.dsData, ag2.dsHora\n" +
                                "FROM tbagenda2 AS ag2\n" +
                               "INNER JOIN tbpaciente AS pac ON ag2.idPaciente = pac.idPaciente\n" +
                               "WHERE dsData = '"+data+"'order by ag2.dsData \n" +
                                    "";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
                            
			while (rs.next()){
			    Atendimento atendimento = new Atendimento();
			    atendimento.setNomePaciente(rs.getString("pac.noPaciente"));
                            atendimento.setData(rs.getString("ag2.dsData"));   
                            atendimento.setHora(rs.getString("ag2.dsHora"));   
                            atendimento.setServico(rs.getString("ag2.servico"));     

                       //     atendimento.setIdPaciente(rs.getInt("ag2.idPaciente"));
			   
			    atendimentos.add(atendimento);
			}
			return atendimentos;
		}
          }
              
              
               public List<Atendimento> getListaJoinPaciente(String paciente) throws SQLException{
		List<Atendimento> atendimentos = new ArrayList<>();
		String sql = "SELECT pac.noPaciente, ag2.servico, ag2.dsData, ag2.dsHora\n" +
                                "FROM tbagenda2 AS ag2\n" +
                               "INNER JOIN tbpaciente AS pac ON ag2.idPaciente = pac.idPaciente\n" +
                               "WHERE pac.noPaciente like '%"+paciente +"%' order by ag2.dsData";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
                            
			while (rs.next()){
			    Atendimento atendimento = new Atendimento();
			    atendimento.setNomePaciente(rs.getString("pac.noPaciente"));
                            atendimento.setData(rs.getString("ag2.dsData"));   
                            atendimento.setHora(rs.getString("ag2.dsHora"));   
                            atendimento.setServico(rs.getString("ag2.servico"));     

                       //     atendimento.setIdPaciente(rs.getInt("ag2.idPaciente"));
			   
			    atendimentos.add(atendimento);
			}
			return atendimentos;
		}
          }
               //Join para jDialog
               public List<Atendimento> getListaDialogTerminar(String nome) throws SQLException{
		List<Atendimento> atendimentos = new ArrayList<>();
                
		String sql = "SELECT tbagenda2.idAgenda, tbpaciente.noPaciente, tbagenda2.dsData, tbagenda2.dsHora, tbagenda2.status \n" +
                    "FROM `tbagenda2`\n" +
                        "INNER JOIN `tbpaciente` on tbagenda2.idPaciente = tbpaciente.idPaciente WHERE tbagenda2.status = 'AGENDADA' AND tbpaciente.noPaciente like '%"+nome+"%' ORDER BY idAgenda;";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
                            
			while (rs.next()){
			    Atendimento atendimento = new Atendimento();
			    atendimento.setId(rs.getInt("tbagenda2.idAgenda"));
			    atendimento.setNomePaciente(rs.getString("tbpaciente.noPaciente"));
                            atendimento.setData(rs.getString("tbagenda2.dsData"));                         
                            atendimento.setHora(rs.getString("tbagenda2.dsHora"));                         
                            atendimento.setStatus(rs.getString("tbagenda2.status"));
			   
			    atendimentos.add(atendimento);
			}
			return atendimentos;
		}
          }
               
               public List<Atendimento> getListaDialogTerminarData(String data) throws SQLException{
		List<Atendimento> atendimentos = new ArrayList<>();
                
		String sql = "SELECT tbagenda2.idAgenda, tbpaciente.noPaciente, tbagenda2.dsData, tbagenda2.dsHora, tbagenda2.status \n" +
                    "FROM `tbagenda2`\n" +
                        "INNER JOIN `tbpaciente` on tbagenda2.idPaciente = tbpaciente.idPaciente WHERE tbagenda2.status = 'AGENDADA' AND tbagenda2.dsData ='"+data+"' ORDER BY idAgenda;";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
                            
			while (rs.next()){
			    Atendimento atendimento = new Atendimento();
			    atendimento.setId(rs.getInt("tbagenda2.idAgenda"));
			    atendimento.setNomePaciente(rs.getString("tbpaciente.noPaciente"));
                            atendimento.setData(rs.getString("tbagenda2.dsData"));                         
                            atendimento.setHora(rs.getString("tbagenda2.dsHora"));                         
                            atendimento.setStatus(rs.getString("tbagenda2.status"));
			   
			    atendimentos.add(atendimento);
			}
			return atendimentos;
		}
          }
               
               public void alterarStatus(int id) throws SQLException{
            
             String sql= "UPDATE tbagenda2 SET  status =  'CONCLUIDO' WHERE  tbagenda2.idAgenda ="+id+"" ;

            Atendimento atendimento=  new Atendimento();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            

            stmt.execute();
	    stmt.close();

        }

}
