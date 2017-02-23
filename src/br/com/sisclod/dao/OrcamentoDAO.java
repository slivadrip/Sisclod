/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
import br.com.sisclod.model.Orcamento;
import br.com.sisclod.model.Paciente;
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
public class OrcamentoDAO {
        private Connection conexao = null;
        public String procedimento;
        public int id,paciente,quantidade,nrOrcamento;
        public double vlTotal,valor;
     public OrcamentoDAO() throws SQLException{
		conexao = Database.getConnection();
		
	}
     
      public void gravar(Orcamento orcamento) throws SQLException{
	
                	String sql= "insert into tborcamento(idPaciente, idProcedimentos, dsValor, quantidade, vlTotal, nrOrcamento) values(?,?,?,?,?,?)";
		
                        PreparedStatement stmt = conexao.prepareStatement(sql);
                        stmt.setInt(1, orcamento.getIdPaciente());
                        stmt.setString(2, orcamento.getProcedimento());
                        stmt.setDouble(3, orcamento.getValor());
                        stmt.setInt(4, orcamento.getQuantidade());
                        stmt.setDouble(5, orcamento.getVlTotal());
                        stmt.setInt(6, orcamento.getNrOrcamento());
		
                	stmt.execute();
                        stmt.close();
                        System.out.println("Gravado!");
                        conexao.close();
	}
                
                public void alterar(Orcamento orcamento) throws SQLException{
	
		   String sql = "update tborcamento set idPaciente= ?, idProcedimentos= ?,dsValor= ?, quantidade =? ,vlTotal=? , nrOrcamento =?    where idProcedimento= ?";
		   PreparedStatement stmt = conexao.prepareStatement(sql);
                        
                        stmt.setInt(1, orcamento.getIdPaciente());
                        stmt.setString(2, orcamento.getProcedimento());
                        stmt.setDouble(3, orcamento.getValor());
                        stmt.setInt(4, orcamento.getQuantidade());
                        stmt.setDouble(5, orcamento.getVlTotal());
                        stmt.setInt(6, orcamento.getNrOrcamento());

                        stmt.execute();
                        stmt.close();
	}
                
                public void excluir(Orcamento orcamento) throws SQLException{  
        
                        String sql = "DELETE FROM tborcamento WHERE idOrcamento = ?";  
        
		   PreparedStatement stmt = conexao.prepareStatement(sql);
              
              
                    stmt.setInt(1, orcamento.getId());   
             
                    stmt.executeUpdate();  
                    stmt.close();  
       
        } 
        
    public List<Orcamento> lista(String cod) throws SQLException{
			List<Orcamento> Orcamentos = new ArrayList<Orcamento>();
			String sql = "select * from tborcamento where nrOrcamento ="+cod+"";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Orcamento orcamento = new Orcamento();
				    orcamento.setId(rs.getInt("idOrcamento"));
                                    orcamento.setIdPaciente(rs.getInt("idPaciente"));
				    orcamento.setProcedimento(rs.getString("idProcedimentos"));
                                    orcamento.setValor(rs.getDouble("dsValor"));
				    orcamento.setQuantidade(rs.getInt("quantidade"));
                                    orcamento.setVlTotal(rs.getDouble("vlTotal"));
                                   orcamento.setNrOrcamento(rs.getInt("nrOrcamento"));
				    Orcamentos.add(orcamento);
				}
                                stmt.execute();
                                stmt.close();
				return Orcamentos;
			}
                
                   }
    
    public List<Orcamento> listaAbrir(String cod) throws SQLException{
			List<Orcamento> Orcamentos = new ArrayList<Orcamento>();
			String sql = "select * from tborcamento where nrOrcamento ="+cod+"";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Orcamento orcamento = new Orcamento();
				    orcamento.setId(rs.getInt("idOrcamento"));
                                    orcamento.setIdPaciente(rs.getInt("idPaciente"));
				    orcamento.setProcedimento(rs.getString("idProcedimentos"));
                                    orcamento.setValor(rs.getDouble("dsValor"));
				    orcamento.setQuantidade(rs.getInt("quantidade"));
                                    orcamento.setVlTotal(rs.getDouble("vlTotal"));
                                   orcamento.setNrOrcamento(rs.getInt("nrOrcamento"));
				    Orcamentos.add(orcamento);
				}
                                stmt.execute();
                                stmt.close();
				return Orcamentos;
			}
                
                   }
    
     public List<Orcamento> lista2(String pesquisa) throws SQLException{
			List<Orcamento> Orcamentos = new ArrayList<Orcamento>();
                      String sql = "select * from tborcamento where idOrcamento = 1";

			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				   Orcamento orcamento = new Orcamento();
				    orcamento.setId(rs.getInt("idOrcamento"));
                                    orcamento.setIdPaciente(rs.getInt("idPaciente"));
				    orcamento.setProcedimento(rs.getString("idProcedimentos"));
                                    orcamento.setValor(rs.getDouble("valor"));
				    orcamento.setQuantidade(rs.getInt("valor"));
                                    orcamento.setVlTotal(rs.getDouble("vlTotal"));

				    Orcamentos.add(orcamento);
				}
                                stmt.execute();
                                stmt.close();
				return Orcamentos;
			}
                
                   }
    
      public Orcamento getOrcamento(int idOrcamento) {
             try {
                  Orcamento orcamento = new Orcamento();
                  PreparedStatement stmt = conexao.prepareStatement("select * from tborcamento where idOrcamento="+idOrcamento+"");
                  ResultSet rs = stmt.executeQuery();
                      while (rs.next()){
                            orcamento.setId(rs.getInt("idOrcamento"));
                            orcamento.setIdPaciente(rs.getInt("idPaciente"));
                            orcamento.setProcedimento(rs.getString("idProcedimentos"));
                            orcamento.setValor(rs.getDouble("dsValor"));
                            orcamento.setQuantidade(rs.getInt("quantidade"));
                            orcamento.setVlTotal(rs.getDouble("vlTotal"));
                            orcamento.setNrOrcamento(rs.getInt("nrOrcamento"));
                            paciente =  orcamento.getIdPaciente();
                            procedimento = ""+ orcamento.getProcedimento();
                            valor =  orcamento.getValor();
                            quantidade = orcamento.getQuantidade();
                            vlTotal = orcamento.getVlTotal();
                            nrOrcamento = orcamento.getNrOrcamento();
    }

                           rs.close();
                           stmt.close();
                           return orcamento;

    } catch(SQLException e) {
        throw new RuntimeException(e);
    }
}


    
    public List<Orcamento> getNumeroOrcamento() throws SQLException{
			List<Orcamento> Orcamentos = new ArrayList<Orcamento>();
			String sql = "SELECT  nrOrcamento \n" +
                                        "FROM  tborcamento\n" +
                                        "ORDER BY  nrOrcamento DESC \n" +
                                        "LIMIT 1";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Orcamento orcamento = new Orcamento();
				    orcamento.setId(rs.getInt("nrOrcamento"));
                                 
			    Orcamentos.add(orcamento);
				}
                                stmt.execute();
                                stmt.close();
				return Orcamentos;
			}
                
                   }
    
    public void getNumeroVenda() throws SQLException{
        
         
                  String sql = ("SELECT  nrOrcamento \n" +
                                        "FROM  tborcamento\n" +
                                        "ORDER BY  nrOrcamento DESC \n" +
                                        "LIMIT 1");
                    PreparedStatement stmt = conexao.prepareStatement(sql);
              

             
                    stmt.executeUpdate();  
                    stmt.close();  
        
   

}
    
    
}
