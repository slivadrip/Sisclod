/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author adriano
 */
public class Database {
    public static Connection getConnection() throws SQLException{
			String url = "jdbc:mysql://127.0.0.1/sisclod?user=root&password=";
			
		   	Connection conexao = DriverManager.getConnection(url);					
			System.out.println("Conectado.");
			return conexao;
			
			
	

    }
     public static Connection getConnection2(   	
		String url,
                String usuario,
                String senha) throws SQLException{
			
		return DriverManager.getConnection(url, usuario, senha);
	

    }
    public static Connection getSisclodConnection2() throws SQLException{
        return getConnection2("jdbc:mysql://127.0.0.1/sisclod",
                "root",
                    "");
    }

    public Statement stm;
    public ResultSet rs;
    public Connection conn;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String caminho = "jdbc:mysql://localhost:3306/sisclod";
    private final String usuario = "root";
    private final String senha = "";

   
    
    public void conecta(){
        try {
                    System.setProperty("jdbc.drivers", driver);
        
            conn = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Erro de conexão! \n Erro"+ex.getMessage());
        }
    }

 public void executaSQL(String sql){
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Erro no ExecutaSQL! \n Erro"+ex.getMessage());
        }
    }
 }
