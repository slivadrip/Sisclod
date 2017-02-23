/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.sisclod.model.Sexo;
/**
 *
 * @author Dih
 */
public class SexoDAO {
    
        private Connection conexao = null;

     public SexoDAO() throws SQLException{
		conexao = Database.getConnection();
		
	}
     
      public List<Sexo> lista() throws SQLException{
			List<Sexo> Sexos = new ArrayList<Sexo>();
			String sql = "select * from tbSexo";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Sexo sexo = new Sexo();
				    sexo.setId(rs.getInt("idSexo"));
                                    sexo.setNome(rs.getString("dsSexo"));
				  
				    Sexos.add(sexo);
				}
                          return Sexos;
			}
                
    
      }   
}
