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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author adriano
 */
public class UsuarioDAO {
    	Connection conexao = null;

		public UsuarioDAO() throws SQLException{
			conexao = Database.getConnection();
			
		}
    
    public List<Usuario> lista() throws SQLException{
			List<Usuario> Usuarios = new ArrayList<Usuario>();
			String sql = "select * from tbUsuarios";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Usuario usuario = new Usuario();
				    usuario.setId(rs.getInt("idUsuarios"));
                                    usuario.setLogin(rs.getString("login"));
				    usuario.setSenha(rs.getString("senha"));
                              
				  
				    Usuarios.add(usuario);
				}
				return Usuarios;
			}
		}
        public List<Usuario> pesquisar(String nome, String senha) throws SQLException{
        List<Usuario> Usuarios = new ArrayList<Usuario>();
			String sql = "select nome, senha from usuario where nome =? and senha =?";
                        ResultSet rs = null;
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				
				
				    Usuario usuario = new Usuario();
				    
                                    usuario.setLogin(rs.getString("nome"));
				    usuario.setSenha(rs.getString("senha"));
				  
                                  rs = stmt.executeQuery();
				    
                                  
                                  if(rs.next()){
                                      
                                      
                                      
                                      JOptionPane.showMessageDialog(null, "Seja Bem Vindo Ao Sistema","Obrigago",JOptionPane.INFORMATION_MESSAGE);
                                      
                                  }else{
                                         JOptionPane.showMessageDialog(null, "Voce nao Tem Acesso ao Sistmea Sistema","Tente de Novo",JOptionPane.INFORMATION_MESSAGE);

                                      
                                  }
                                  
                        }catch (SQLException e){
                            try {
                                if(conexao != null){
                                    conexao.rollback();
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                         return Usuarios;
               
    }
        public boolean validaLogin(Usuario nome)  {       
     String sql = "SELECT * FROM usuario WHERE nome=? AND senha=?" ;  
              
        try{    
        Statement stmt = this.conexao.createStatement();       
            
        ResultSet rs = stmt.executeQuery(sql);   
           Usuario usuario = new Usuario();
				    
           usuario.setLogin(rs.getString("nome"));
	   usuario.setSenha(rs.getString("senha"));
          
        return rs.next();  
        }catch(SQLException erroSql) {       
            erroSql.printStackTrace(System.err);    
        }       
     return false;  
        }  
        
public boolean validar(String nome, String senha) {
		boolean result = false;
		Connection conexao = null;
		try {
			conexao = Database.getConnection();
			PreparedStatement comando = conexao.prepareStatement("SELECT * FROM tabela WHERE nome = ? AND senha = ?");

			comando.setString(1, nome);
			comando.setString(2, senha);
			if (comando != null)
                                return true;
	
                          }

		catch (SQLException e) {   
			e.getMessage();
			
		}   
		System.out.println(result);   
		return result;  
        }

            
}
        
        
	


