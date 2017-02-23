/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Cidade;
import br.com.sisclod.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriano
 */
public class PacienteDAO{
    private Connection conexao = null;

    public String nome,cpf,rg,endereco,numero,bairro,telefone,celular,email,data,cidade="",uf="",sexo="";
	 public PacienteDAO() throws SQLException{
		conexao = Database.getConnection();
		
	}
	
	public void gravar(Paciente paciente) throws SQLException{
	

                String sql= "insert into tbpaciente (noPaciente , nrCpf, nrRg, dsEndereco, nrEndereco, dsBairro, nrTelefone, nrCelular, dsEmail, dtNascimento, dsSexo, idCidade, idUF)" + 
                     "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1,paciente.getNome());
		stmt.setString(2,paciente.getCpf());
		stmt.setString(3,paciente.getRg());
		stmt.setString(4,paciente.getEndereco());
                stmt.setString(5,paciente.getNumero());
                stmt.setString(6,paciente.getBairro());
                stmt.setString(7,paciente.getTelefone());
		stmt.setString(8,paciente.getCelular());
		stmt.setString(9,paciente.getEmail());
	        stmt.setString(10,paciente.getDtNascimento());
		stmt.setString(11,paciente.getSexo());
                stmt.setString(12,paciente.getCidade());
                stmt.setString(13,paciente.getUF());


		stmt.execute();
		stmt.close();
}
        
        public void alterar(Paciente paciente) throws SQLException{
            
            String sql= "update tbpaciente set noPaciente=?, nrCpf=?, nrRg=?, dsEndereco=?, nrEndereco=?,"
                    + " dsBairro=?, nrTelefone=?, nrCelular=?, dsEmail=?, dtNascimento=?, dsSexo=?, idCidade=?, idUF=?" + 
                     "where idPaciente=?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getRg());
            stmt.setString(4, paciente.getEndereco());
            stmt.setString(5, paciente.getNumero());
            stmt.setString(6, paciente.getBairro());
            stmt.setString(7, paciente.getTelefone());
            stmt.setString(8, paciente.getCelular());
            stmt.setString(9, paciente.getEmail());
            stmt.setString(10, paciente.getDtNascimento());
            stmt.setString(11, paciente.getSexo());
            stmt.setString(12, paciente.getCidade());
            stmt.setString(13, paciente.getUF());
            stmt.setInt(14, paciente.getId());

            stmt.execute();
	    stmt.close();

        }
        
         public void excluir(Paciente paciente) throws SQLException{  
        
                        String sql = "DELETE FROM tbpaciente WHERE idPaciente = ?";  
        
		   PreparedStatement stmt = conexao.prepareStatement(sql);
              
              
                    stmt.setInt(1, paciente.getId());   
             
                    stmt.executeUpdate();  
                    stmt.close();  
       
        } 
        public Paciente getPaciente(int idPaciente ) {
             try {
                  Paciente paciente = new Paciente();
                  PreparedStatement stmt = conexao.prepareStatement("select * from tbpaciente where idPaciente="+idPaciente+"");
                  ResultSet rs = stmt.executeQuery();
                      while (rs.next()){
                            paciente.setId(rs.getInt("idPaciente"));
                            paciente.setNome(rs.getString("noPaciente"));
                            paciente.setCpf(rs.getString("nrCpf"));
                            paciente.setRg(rs.getString("nrRg"));
                            paciente.setEndereco(rs.getString("dsEndereco"));
                            paciente.setNumero(rs.getString("nrEndereco"));
                            paciente.setBairro(rs.getString("dsBairro"));
                            paciente.setTelefone(rs.getString("nrTelefone"));
                            paciente.setCelular(rs.getString("nrCelular"));
                            paciente.setEmail(rs.getString("dsEmail"));
                            paciente.setDtNascimento(rs.getString("dtNascimento"));
                            paciente.setSexo(rs.getString("dsSexo"));
                            paciente.setUF(rs.getString("idCidade"));
                            paciente.setCidade(rs.getString("idUF"));

                            nome =  paciente.getNome();
                            cpf = paciente.getCpf();
                            rg =paciente.getRg();
                            endereco=paciente.getEndereco();
                            numero=paciente.getNumero();
                            bairro=paciente.getBairro();
                            telefone=paciente.getTelefone();
                            celular=paciente.getCelular();
                            email=paciente.getEmail();
                            data=paciente.getDtNascimento();
                            sexo= paciente.getSexo();
                            cidade=paciente.getCidade();
                            uf= paciente.getUF();

            System.out.println("Paciente..:"+paciente.getNome());
    }

    rs.close();
    stmt.close();
    return paciente;

    } catch(SQLException e) {
        throw new RuntimeException(e);
    }
}
        public List<Paciente> listaPesquisa(String noPaciente) throws SQLException{
			String sql = "select * from tbpaciente where nome like ?";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setString(1,noPaciente );
		        stmt.execute();
			ResultSet rs = stmt.executeQuery();
			List<Paciente> Pacientes = new ArrayList<Paciente>();

                            while (rs.next()){
				    Paciente paciente = new Paciente();
				    paciente.setId(rs.getInt("idPaciente"));
                                    paciente.setNome(rs.getString("noPaciente"));
				    paciente.setCpf(rs.getString("nrCpf"));

				  
				    Pacientes.add(paciente);
				}
                                stmt.execute();
                                stmt.close();
				return Pacientes;
			
                
                   }
        
        
        public List<Paciente> listaBusca(String noPaciente) throws SQLException{
			String sql = "select * from tbpaciente where noPaciente = '" + noPaciente +"'";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setString(1,noPaciente );
		        stmt.execute();
			ResultSet rs = stmt.executeQuery();
			List<Paciente> Pacientes = new ArrayList<Paciente>();

                            while (rs.next()){
				    Paciente paciente = new Paciente();
				    paciente.setId(rs.getInt("idPaciente"));
                                    paciente.setNome(rs.getString("noPaciente"));
				    paciente.setCpf(rs.getString("nrCpf"));

				  
				    Pacientes.add(paciente);
				}
                                stmt.execute();
                                stmt.close();
				return Pacientes;
			
                
                   }
         public List<Paciente> getLista1() throws SQLException{
		List<Paciente> pacientes = new ArrayList<>();
		String sql = "SELECT tbpaciente.idPaciente,tbCidade.noCidade,tbCidade.noCidade\n" +
                    "FROM `tbPaciente`\n" +
                        "INNER JOIN `tbCidade` on tbpaciente.sgUF = tbpaciente.sgUF ORDER BY idCidade;";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
                            
			while (rs.next()){
			    Paciente paciente = new Paciente();
			    paciente.setId(rs.getInt("tbpaciente.idPaciente"));
			    paciente.setNome(rs.getString("tbpaciente.noPaciente"));
                            //cidade.setEstado(rs.getInt("tbCidade.idUF"));
                            paciente.setCidade(rs.getString("tbCidade.noCidade"));                         
                  
			   
			    pacientes.add(paciente);
			}
			return pacientes;
		}
          }
          
        
           public List<Paciente> listaJoin(int idPaciente ) throws SQLException{
			List<Paciente> Pacientes = new ArrayList<Paciente>();
                        Paciente paciente = new Paciente();
                                         
                     String sql = "select * from tbpaciente where idPaciente = '"+idPaciente+ "' ";
			System.out.println("DAO"+idPaciente);
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
                                    paciente.setId(rs.getInt("idPaciente"));
                                    paciente.setNome(rs.getString("noPaciente"));
                                    paciente.setCpf(rs.getString("nrCpf"));
                                    paciente.setRg(rs.getString("nrRg"));
                                    paciente.setEndereco(rs.getString("dsEndereco"));
                                    paciente.setNumero(rs.getString("nrEndereco"));
                                    paciente.setBairro(rs.getString("dsBairro"));
                                    paciente.setTelefone(rs.getString("nrTelefone"));
                                    paciente.setTelefone(rs.getString("nrCelular"));
                       		    paciente.setEmail(rs.getString("dsEmail"));
                                    paciente.setDtNascimento(rs.getString("dtNascimento"));
                                    paciente.setSexo(rs.getString("dsSexo"));
                                    paciente.setUF(rs.getString("idCidade"));
                                    paciente.setCidade(rs.getString("idUF"));
                                    
                                    String nome =  paciente.getNome();

                                    System.out.println("Paciente..:"+paciente.getNome());

				    Pacientes.add(paciente);
				}
                                stmt.execute();
                                stmt.close();
				return Pacientes;
			}
		}
         public List<Paciente> lista() throws SQLException{
			List<Paciente> Pacientes = new ArrayList<Paciente>();
			String sql = "select * from tbpaciente";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Paciente paciente = new Paciente();
				    paciente.setId(rs.getInt("idPaciente"));
                                    paciente.setNome(rs.getString("noPaciente"));
				    paciente.setCpf(rs.getString("nrCpf"));

				  
				    Pacientes.add(paciente);
				}
                                stmt.execute();
                                stmt.close();
				return Pacientes;
			}
                
                   }
         
         public List<Paciente> lista2(String pesquisa) throws SQLException{
			List<Paciente> Pacientes = new ArrayList<Paciente>();
			String sql = "select * from tbpaciente where noPaciente like '%"+pesquisa +"%'";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Paciente paciente = new Paciente();
				    paciente.setId(rs.getInt("idPaciente"));
                                    paciente.setNome(rs.getString("noPaciente"));
				    paciente.setCpf(rs.getString("nrCpf"));

				  
				    Pacientes.add(paciente);
				}
                                stmt.execute();
                                stmt.close();
				return Pacientes;
			}
                
                   }

      }

    

    

