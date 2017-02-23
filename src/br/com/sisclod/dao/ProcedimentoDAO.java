/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
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
public class ProcedimentoDAO {
    
    
                          public String nome,obs,valor1;
                          public double valor;
    Connection conexao = null;

	public ProcedimentoDAO() throws SQLException{
			conexao = Database.getConnection();
			
	}
                public void gravar(Procedimento procedimento) throws SQLException{
	
                	String sql= "insert into tbprocedimentos(noProcedimento,vlProcedimento,obsProcedimento) values(?,?,?)";
		
                        PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setString(1, procedimento.getNome());
                        stmt.setDouble(2, procedimento.getValor());
                        stmt.setString(3, procedimento.getObs());

		
                	stmt.execute();
                        stmt.close();
                        System.out.println("Gravado!");
                        conexao.close();
	}
                
                public void alterar(Procedimento procedimento) throws SQLException{
	
		   String sql = "update tbprocedimentos set noProcedimento= ?, vlProcedimento= ?,obsProcedimento= ?   where idProcedimento= ?";
		   PreparedStatement stmt = conexao.prepareStatement(sql);
		    stmt.setString(1, procedimento.getNome());
                    stmt.setDouble(2, procedimento.getValor());
                    stmt.setString(3, procedimento.getObs());
                    stmt.setInt(4, procedimento.getId());

		    stmt.execute();
		    stmt.close();
	}
                
                public void excluir(Procedimento procedimento) throws SQLException{  
        
                        String sql = "DELETE FROM tbprocedimentos WHERE idProcedimento = ?";  
        
		   PreparedStatement stmt = conexao.prepareStatement(sql);
              
              
                    stmt.setInt(1, procedimento.getId());   
             
                    stmt.executeUpdate();  
                    stmt.close();  
       
        } 
        
    public List<Procedimento> lista() throws SQLException{
			List<Procedimento> Procedimentos = new ArrayList<Procedimento>();
			String sql = "select * from tbprocedimentos";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Procedimento procedimento = new Procedimento();
				    procedimento.setId(rs.getInt("idProcedimento"));
                                    procedimento.setNome(rs.getString("noProcedimento"));
				    procedimento.setValor(rs.getDouble("vlProcedimento"));

				  
				    Procedimentos.add(procedimento);
				}
                                stmt.execute();
                                stmt.close();
				return Procedimentos;
			}
                
                   }
    
     public List<Procedimento> lista2(String pesquisa) throws SQLException{
			List<Procedimento> Procedimentos = new ArrayList<Procedimento>();
                      String sql = "select * from tbprocedimentos where noProcedimento like '%"+pesquisa +"%'";

			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Procedimento procedimento = new Procedimento();
				    procedimento.setId(rs.getInt("idProcedimento"));
                                    procedimento.setNome(rs.getString("noProcedimento"));
				    procedimento.setValor(rs.getDouble("vlProcedimento"));

				  
				    Procedimentos.add(procedimento);
				}
                                stmt.execute();
                                stmt.close();
				return Procedimentos;
			}
                
                   }
    
      public Procedimento getProcedimento(int idProcedimento ) {
             try {
                  Procedimento procedimento = new Procedimento();
                  PreparedStatement stmt = conexao.prepareStatement("select * from tbprocedimentos where idProcedimento="+idProcedimento+"");
                  ResultSet rs = stmt.executeQuery();
                      while (rs.next()){
                            procedimento.setId(rs.getInt("idProcedimento"));
                            procedimento.setNome(rs.getString("noProcedimento"));
                            procedimento.setValor(rs.getDouble("vlProcedimento"));
                            procedimento.setObs(rs.getString("obsProcedimento"));
                          

                            nome =  procedimento.getNome();
                            valor1 = ""+ procedimento.getValor();
                            obs =  procedimento.getObs();


    }

                           rs.close();
                           stmt.close();
                           return procedimento;

    } catch(SQLException e) {
        throw new RuntimeException(e);
    }
}
}
