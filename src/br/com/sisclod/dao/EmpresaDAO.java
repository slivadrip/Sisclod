/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Empresa;
import br.com.sisclod.model.Procedimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dih
 */
public class EmpresaDAO {
    
    
                          public String nome,empresa,fantasia,cnpj,uf,cidade,endereco,numero,bairro,telefone,telefone2,email,ie;
                          
    Connection conexao = null;

	public EmpresaDAO() throws SQLException{
			conexao = Database.getConnection();
			
	}
                public void gravar(Empresa empresa) throws SQLException{
	
                	String sql= "INSERT INTO tbempresa(noEmpresa, dsFantasia, nrCNPJ, IE, dsEndereco,"
                                + " nrEndereco, dsBairro, nrTelefone, nrTelefone2, dsEmail, idUF, idCidade) "
                                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
                        PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setString(1, empresa.getNome());
                        stmt.setString(2, empresa.getFantasia());
                        stmt.setString(3, empresa.getCnpj());
                        stmt.setString(4, empresa.getIe());
                        stmt.setString(5, empresa.getEndereco());
                        stmt.setString(6, empresa.getNumero());
                        stmt.setString(7, empresa.getBairro());
                        stmt.setString(8, empresa.getTelefone());
                        stmt.setString(9, empresa.getTelefone2());
                        stmt.setString(10, empresa.getEmail());
                        stmt.setString(11, empresa.getUf());
                        stmt.setString(12, empresa.getCidade());

		
                	stmt.execute();
                        stmt.close();
                        System.out.println("Gravado!");
                        conexao.close();
	}
                
                public void alterar(Empresa empresa) throws SQLException{
	
		   String sql ="UPDATE tbempresa SET noEmpresa=?, dsFantasia=?,nrCNPJ=?, IE=?,"
                           + "dsEndereco= ?, nrEndereco= ?,dsBairro= ?, nrTelefone= ?,"
                           + "nrTelefone2= ?, dsEmail= ?, idUF= ?, idCidade= ? WHERE  idEmpresa= ?" ;  
                   
                   PreparedStatement stmt = conexao.prepareStatement(sql);            
                   stmt.setString(1, empresa.getNome());
                   
                        stmt.setString(2, empresa.getFantasia());
                        stmt.setString(3, empresa.getCnpj());
                        stmt.setString(4, empresa.getIe());
                        stmt.setString(5, empresa.getEndereco());
                        stmt.setString(6, empresa.getNumero());
                        stmt.setString(7, empresa.getBairro());
                        stmt.setString(8, empresa.getTelefone());
                        stmt.setString(9, empresa.getTelefone2());
                        stmt.setString(10, empresa.getEmail());
                        stmt.setString(11, empresa.getUf());
                        stmt.setString(12, empresa.getCidade());
                        stmt.setInt(13, empresa.getId());
                        
                        stmt.execute();
                        stmt.close();
                    }
                
                public void excluir(Empresa empresa) throws SQLException{  
        
                        String sql = "DELETE FROM tbempresa WHERE idEmpresa = ?";  
        
		   PreparedStatement stmt = conexao.prepareStatement(sql);
              
              
                    stmt.setInt(1, empresa.getId());   
             
                    stmt.executeUpdate();  
                    stmt.close();  
       
        } 
        
    public List<Empresa> lista() throws SQLException{
			List<Empresa> Empresas = new ArrayList<Empresa>();
			String sql = "select * from tbempresa";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Empresa empresa = new Empresa();
				    empresa.setId(rs.getInt("idEmpresa"));
                                    empresa.setNome(rs.getString("noEmpresa"));
				    empresa.setFantasia(rs.getString("dsFantasia"));
  				    empresa.setCnpj(rs.getString("nrCNPJ"));

				    Empresas.add(empresa);
				}
                                stmt.execute();
                                stmt.close();
				return Empresas;
			}
                
                   }
    public List<Empresa> listaPesuisa(String pesquisa) throws SQLException{
			List<Empresa> Empresas = new ArrayList<Empresa>();
			String sql = "select * from tbempresa where noEmpresa like '%"+pesquisa +"%'";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Empresa empresa = new Empresa();
				    empresa.setId(rs.getInt("idEmpresa"));
                                    empresa.setNome(rs.getString("noEmpresa"));
				    empresa.setFantasia(rs.getString("dsFantasia"));
  				    empresa.setCnpj(rs.getString("nrCNPJ"));

				    Empresas.add(empresa);
				}
                                stmt.execute();
                                stmt.close();
				return Empresas;
			}
                
                   }
      public Empresa getEmpresa(int idEmpresa ) {
             try {
                  Empresa empresa = new Empresa();
                  PreparedStatement stmt = conexao.prepareStatement("select * from tbempresa where idEmpresa="+idEmpresa+"");
                  ResultSet rs = stmt.executeQuery();
                      while (rs.next()){
				    empresa.setId(rs.getInt("idEmpresa"));
                                    empresa.setNome(rs.getString("noEmpresa"));
				    empresa.setFantasia(rs.getString("dsFantasia"));
  				    empresa.setCnpj(rs.getString("nrCNPJ"));
                                    empresa.setIe(rs.getString("IE"));
                                    empresa.setEndereco(rs.getString("dsEndereco"));
                                    empresa.setNumero(rs.getString("nrEndereco"));
                                    empresa.setBairro(rs.getString("dsBairro"));
                                    empresa.setUf(rs.getString("idUF"));
                                    empresa.setCidade(rs.getString("idCidade"));
                                    empresa.setTelefone(rs.getString("nrTelefone"));
				    empresa.setTelefone2(rs.getString("nrTelefone2"));
                                    empresa.setEmail(rs.getString("dsEmail"));
                          

                            nome =  empresa.getNome();
                            fantasia = empresa.getFantasia();
                            cnpj =  empresa.getCnpj();
                            ie = empresa.getIe();
                            endereco = empresa.getEndereco();
                            numero = empresa.getNumero();
                            bairro = empresa.getBairro();
                            uf = empresa.getUf();
                            cidade = empresa.getCidade();
                            telefone= empresa.getTelefone();
                            telefone2= empresa.getTelefone2();
                            email = empresa.getEmail();
                      
                      }

                           rs.close();
                           stmt.close();
                           return empresa;

    } catch(SQLException e) {
        throw new RuntimeException(e);
    }
}
}
