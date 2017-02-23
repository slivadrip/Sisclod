/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Estado;
import br.com.sisclod.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author kurama
 */
public class EstadoDAO {
    
    	Connection conexao = null;

		public EstadoDAO() throws SQLException{
			conexao = Database.getConnection();
			
		}
                public void gravar(Estado estado) throws SQLException{
	
		String sql= "insert into tbUF(noUF,sgUF) values(?,?)";
		
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, estado.getNome());
		stmt.setString(2, estado.getSigla());
		
		
		stmt.execute();
		stmt.close();
		System.out.println("Gravado!");
		conexao.close();
	}
	
	 public void excluir(Estado estado) throws SQLException  
	    {  
	         
	        String sql = "DELETE FROM tbUF WHERE idUF ="+ estado.getId();  
	        PreparedStatement stmt = conexao.prepareStatement(sql);  
                
	        //stmt.setInt(1,estado.getId());  
	          
	        stmt.execute();  
	        stmt.close(); 
	        
	    

	    }
         
         public void alterar(Estado estado) throws SQLException{
             
		   String sql = "update TBuf set noUF=?,sgUF=? where id=?";
		   PreparedStatement stmt = conexao.prepareStatement(sql);
		   stmt.setString(1, estado.getNome());
		   stmt.setString(2, estado.getSigla());
		    stmt.execute();
		   stmt.close();
             
         }
         
           public List<Estado> lista() throws SQLException{
			List<Estado> Estados = new ArrayList<Estado>();
			String sql = "select * from tbUF";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Estado estado = new Estado();
				    estado.setId(rs.getInt("idUF"));
                                    estado.setNome(rs.getString("noUF"));
				    estado.setSigla(rs.getString("sgUF"));
				  
				    Estados.add(estado);
				}
				return Estados;
			}
		}
           public List<Estado> AcharUFlista(String sgUF) throws SQLException{
			List<Estado> Estados = new ArrayList<Estado>();
			String sql = "select * from tbUF where sgUF="+sgUF+"";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Estado estado = new Estado();
				    estado.setId(rs.getInt("idUF"));
                                    estado.setNome(rs.getString("noUF"));
				    estado.setSigla(rs.getString("sgUF"));
				  
				    Estados.add(estado);
				}
				return Estados;
			}
         
           }
        
    
}
