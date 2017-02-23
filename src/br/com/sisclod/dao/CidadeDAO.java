/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Cidade;
import br.com.sisclod.model.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kurama
 */
public class CidadeDAO {
    
    
    Connection conexao = null;

	public CidadeDAO() throws SQLException{
			conexao = Database.getConnection();
			
	}
                public void gravar(Cidade cidade) throws SQLException{
	
                	String sql= "insert into tbCidade(noCidade,sgUF) values(?,?)";
		
                        PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setString(1, cidade.getNome());
                        stmt.setString(2, cidade.getEstado());
                        
		
                	stmt.execute();
                        stmt.close();
                        System.out.println("Gravado!");
                        conexao.close();
	}
                
                public void alterar(Cidade cidade) throws SQLException{
	
		   String sql = "update tbCidade set noCidade= ?, sgUF= ?   where idCidade= ?";
		   PreparedStatement stmt = conexao.prepareStatement(sql);
		   stmt.setString(1, cidade.getNome());
		   stmt.setString(2, cidade.getEstado());
		   stmt.setInt(3, cidade.getId());
		   stmt.execute();
		   stmt.close();
	}
                
                public void excluir(Cidade cidade) throws SQLException{  
        
                        String sql = "DELETE FROM tbCidade WHERE idCidade = ?";  
        
		   PreparedStatement stmt = conexao.prepareStatement(sql);
              
              
                    stmt.setInt(1, cidade.getId());   
             
                    stmt.executeUpdate();  
                    stmt.close();  
       
        } 
        
                public void selecionar(Cidade cidade) throws SQLException{
	
                	String sql= "select * from tbCidade where idCidade=?";
		
                        PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setString(1, cidade.getNome());
                        stmt.setString(2, cidade.getEstado());
                        
		
                	stmt.execute();
                        stmt.close();
                        System.out.println("ok!");
                        conexao.close();
	}

                 public List<Cidade> lista() throws SQLException{
			List<Cidade> Cidades = new ArrayList<Cidade>();
			String sql = "select * from tbCidade";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Cidade cidade = new Cidade();
				    cidade.setId(rs.getInt("idCidade"));
                                    cidade.setNome(rs.getString("noCidade"));
				    cidade.setEstado(rs.getString("sgUF"));

				  
				    Cidades.add(cidade);
				}
				return Cidades;
			}
                
                   }
                 public List<Cidade> AcharCidadelista2(String noCidade) throws SQLException{
			List<Cidade> Cidades = new ArrayList<Cidade>();
			String sql = "select * from tbCidade where noCidade like '%"+noCidade+"%' ";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Cidade cidade = new Cidade();
				   cidade.setId(rs.getInt("idCidade"));
                                    cidade.setNome(rs.getString("noCidade"));
				    cidade.setEstado(rs.getString("sgUF"));

				  
				    Cidades.add(cidade);
				}
				return Cidades;
			}
         
           }
                         public List<Cidade> AcharCidadelista(String noCidade) throws SQLException{
			List<Cidade> Cidades = new ArrayList<Cidade>();
			String sql = "select * from tbCidade where noCidade="+noCidade+"";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Cidade cidade = new Cidade();
				    cidade.setId(rs.getInt("idUF"));
                                    cidade.setNome(rs.getString("noUF"));
				  
				    Cidades.add(cidade);
				}
				return Cidades;
			}
         
           }
                  public List<Cidade> listaJoin(String valor ) throws SQLException{
			List<Cidade> Cidades = new ArrayList<Cidade>();
                        Cidade cidade = new Cidade();

			String sql = "select * from tbCidade where sgUF = ?";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    cidade.setId(rs.getInt("idCidade"));
                                    cidade.setNome(rs.getString("noCidade"));
				    cidade.setEstado(rs.getString("sgUF"));
				  
				    Cidades.add(cidade);
				}
				return Cidades;
			}
		}
                 
                 public List<Cidade> pesquisar() throws SQLException{
		List<Cidade> cidades = new ArrayList<>();
                 Cidade cidade = new Cidade();
		String sql = "SELECT tbCidade.idCidade,tbCidade.noCidade,tbUF.sgUF\n" +
                    "FROM `tbCidade`\n" +
                        "INNER JOIN `tbUF` on tbCidade.sgUF = tbUF.sgUF WHERE noCidade LIKE %"+cidade.getNome() +" ORDER BY idCidade;";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
                            
			while (rs.next()){
			   
			    cidade.setId(rs.getInt("tbCidade.idCidade"));
			    cidade.setNome(rs.getString("tbCidade.noCidade"));
                            //cidade.setEstado(rs.getInt("tbCidade.idUF"));
                            cidade.setEstadoTabela(rs.getString("tbUF.sgUF"));                         
                  
			   
			    cidades.add(cidade);
			}
			return cidades;
		}
              }
               public List<Cidade> getLista1() throws SQLException{
		List<Cidade> cidades = new ArrayList<>();
		String sql = "SELECT tbCidade.idCidade,tbCidade.noCidade,tbUF.sgUF\n" +
                    "FROM `tbCidade`\n" +
                        "INNER JOIN `tbUF` on tbCidade.sgUF = tbUF.sgUF ORDER BY idCidade;";
		
		try(PreparedStatement stmt = conexao.prepareStatement(sql)){
			stmt.execute();
			ResultSet rs = stmt.getResultSet();
                            
			while (rs.next()){
			    Cidade cidade = new Cidade();
			    cidade.setId(rs.getInt("tbCidade.idCidade"));
			    cidade.setNome(rs.getString("tbCidade.noCidade"));
                            //cidade.setEstado(rs.getInt("tbCidade.idUF"));
                            cidade.setEstadoTabela(rs.getString("tbUF.sgUF"));                         
                  
			   
			    cidades.add(cidade);
			}
			return cidades;
		}
                
                
	
            
}

    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cidade> AcharCidadelista(Cidade cidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
