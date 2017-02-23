/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.dao;

import br.com.sisclod.factory.Database;
import java.sql.SQLException;
import br.com.sisclod.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dih
 */
public class FuncionarioDAO {
    
      private Connection conexao = null;

    public String nome,cpf,rg,endereco,numero,bairro,telefone,celular,email,data,cidade,uf,sexo,usuario,login,senha;
	 public FuncionarioDAO() throws SQLException{
		conexao = Database.getConnection();
		
	}
    public void gravar(Funcionario funcionario) throws SQLException{
	

                String sql= "insert into tbfuncionario (noFuncionario , nrCpf, nrRg, dsEndereco, nrEndereco, dsBairro, "
                        + "nrTelefone, nrCelular, dsEmail, dtNascimento, idCidade, idUF, sexo, dsusuario, dsLogin, dsSenha)" + 
                     "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1,funcionario.getNome());
		stmt.setString(2,funcionario.getCpf());
		stmt.setString(3,funcionario.getRg());
		stmt.setString(4,funcionario.getEndereco());
                stmt.setString(5,funcionario.getNumero());
                stmt.setString(6,funcionario.getBairro());
                stmt.setString(7,funcionario.getTelefone());
		stmt.setString(8,funcionario.getCelular());
		stmt.setString(9,funcionario.getEmail());
	        stmt.setString(10,funcionario.getDtNascimento());
                stmt.setString(11,funcionario.getCidade());
                stmt.setString(12,funcionario.getUF());
		stmt.setString(13,funcionario.getSexo());
		stmt.setString(14,funcionario.getUsuario());
		stmt.setString(15,funcionario.getLogin());
		stmt.setString(16,funcionario.getSenha());


		stmt.execute();
		stmt.close();
}
        
    public void alterar(Funcionario funcionario) throws SQLException{
            
            String sql= "update tbfuncionario set noFuncionario=?, nrCpf=?, nrRg=?, dsEndereco=?, nrEndereco=?, dsBairro=?, "
                    + "nrTelefone=?, nrCelular=?, dsEmail=?, dtNascimento=?, idCidade=?, idUF=?, sexo=?, dsusuario=?, dsLogin=?, dsSenha=? " + 
                     "where idFuncionario=?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
                stmt.setString(1,funcionario.getNome());
		stmt.setString(2,funcionario.getCpf());
		stmt.setString(3,funcionario.getRg());
		stmt.setString(4,funcionario.getEndereco());
                stmt.setString(5,funcionario.getNumero());
                stmt.setString(6,funcionario.getBairro());
                stmt.setString(7,funcionario.getTelefone());
		stmt.setString(8,funcionario.getCelular());
		stmt.setString(9,funcionario.getEmail());
	        stmt.setString(10,funcionario.getDtNascimento());
                stmt.setString(11,funcionario.getCidade());
                stmt.setString(12,funcionario.getUF());
		stmt.setString(13,funcionario.getSexo());
		stmt.setString(14,funcionario.getUsuario());
                stmt.setString(15,funcionario.getLogin());
		stmt.setString(16,funcionario.getSenha());
                stmt.setInt(17,funcionario.getId());
              
                stmt.execute();
                stmt.close();

        }
     
    public void excluir(Funcionario funcionario) throws SQLException{  
        
                        String sql = "DELETE FROM tbfuncionario WHERE idFuncionario = ?";  
        
		   PreparedStatement stmt = conexao.prepareStatement(sql);
              
              
                    stmt.setInt(1, funcionario.getId());   
             
                    stmt.executeUpdate();  
                    stmt.close();  
       
        } 
  
    public Funcionario getFuncionario(int idFuncionario ) {
             try {
                  Funcionario funcionario = new Funcionario();
                  PreparedStatement stmt = conexao.prepareStatement("select * from tbfuncionario where idFuncionario= "+idFuncionario+" ");
                  ResultSet rs = stmt.executeQuery();
                      while (rs.next()){
                            funcionario.setId(rs.getInt("idFuncionario"));
                            funcionario.setNome(rs.getString("noFuncionario"));
                            funcionario.setCpf(rs.getString("nrCpf"));
                            funcionario.setRg(rs.getString("nrRg"));
                            funcionario.setEndereco(rs.getString("dsEndereco"));
                            funcionario.setNumero(rs.getString("nrEndereco"));
                            funcionario.setBairro(rs.getString("dsBairro"));
                            funcionario.setTelefone(rs.getString("nrTelefone"));
                            funcionario.setCelular(rs.getString("nrCelular"));
                            funcionario.setEmail(rs.getString("dsEmail"));
                            funcionario.setDtNascimento(rs.getString("dtNascimento"));
                            funcionario.setSexo(rs.getString("sexo"));
                            funcionario.setUF(rs.getString("idCidade"));
                            funcionario.setCidade(rs.getString("idUF"));
                            funcionario.setUsuario(rs.getString("dsusuario"));
                            funcionario.setLogin(rs.getString("dsLogin"));
                            funcionario.setSenha(rs.getString("dsSenha"));
                            
                            nome =  funcionario.getNome();
                            cpf = funcionario.getCpf();
                            rg =funcionario.getRg();
                            endereco=funcionario.getEndereco();
                            numero=funcionario.getNumero();
                            bairro=funcionario.getBairro();
                            telefone=funcionario.getTelefone();
                            celular=funcionario.getCelular();
                            email=funcionario.getEmail();
                            data=funcionario.getDtNascimento();
                            cidade=funcionario.getCidade();
                            uf= funcionario.getUF();
                            sexo= funcionario.getSexo();
                            usuario = funcionario.getUsuario();
                            login = funcionario.getLogin();
                            senha = funcionario.getSenha();

            System.out.println("Paciente..:"+funcionario.getNome());
    }

    rs.close();
    stmt.close();
    return funcionario;

    } catch(SQLException e) {
        throw new RuntimeException(e);
    }
}
        
    public List<Funcionario> lista() throws SQLException{
			List<Funcionario> Funcionarios = new ArrayList<Funcionario>();
			String sql = "select * from tbfuncionario";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				     Funcionario funcionario = new Funcionario();
				    funcionario.setId(rs.getInt("idFuncionario"));
                                    funcionario.setNome(rs.getString("noFuncionario"));
				    funcionario.setCpf(rs.getString("nrCpf"));
                                    funcionario.setUsuario(rs.getString("dsusuario"));
				  
				    Funcionarios.add(funcionario);
				}
                                stmt.execute();
                                stmt.close();
				return Funcionarios;
			}
                
                   }
    public List<Funcionario> listaOdontologista() throws SQLException{
			List<Funcionario> Funcionarios = new ArrayList<Funcionario>();
			String sql = "select * from tbfuncionario where dsusuario = 'ODONTOLOGISTA'";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				     Funcionario funcionario = new Funcionario();
				    funcionario.setId(rs.getInt("idFuncionario"));
                                    funcionario.setNome(rs.getString("noFuncionario"));
				    funcionario.setCpf(rs.getString("nrCpf"));
                                    funcionario.setUsuario(rs.getString("dsusuario"));
				  
				    Funcionarios.add(funcionario);
				}
                                stmt.execute();
                                stmt.close();
				return Funcionarios;
			}
                
                   }
    
     public List<Funcionario> lista2(String pesquisa) throws SQLException{
			List<Funcionario> Funcionarios = new ArrayList<Funcionario>();
			String sql = "select * from tbfuncionario where noFuncionario like '%"+pesquisa +"%'";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Funcionario funcionario = new Funcionario();
				    funcionario.setId(rs.getInt("idFuncionario"));
                                    funcionario.setNome(rs.getString("noFuncionario"));
				    funcionario.setCpf(rs.getString("nrCpf"));
                                    funcionario.setUsuario(rs.getString("dsusuario"));

				  
				    Funcionarios.add(funcionario);
				}
                                stmt.execute();
                                stmt.close();
				return Funcionarios;
			}
                
                   }
     public List<Funcionario> listaLogin() throws SQLException{
			List<Funcionario> Usuarios = new ArrayList<Funcionario>();
			String sql = "select * from tbFuncionario";
			
			try(PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				ResultSet rs = stmt.getResultSet();
				while (rs.next()){
				    Funcionario usuario = new Funcionario();
				    usuario.setId(rs.getInt("idFuncionario"));
                                    usuario.setLogin(rs.getString("dsLogin"));
				    usuario.setSenha(rs.getString("dsSenha"));
                              
				  
				    Usuarios.add(usuario);
				}
				return Usuarios;
			}
		}
  
    public void achaUF(String sgUF) throws SQLException{
         Funcionario funcionario = new Funcionario();
                  PreparedStatement stmt = conexao.prepareStatement("select * from tbUF where sgUF="+sgUF+"");
                  ResultSet rs = stmt.executeQuery();
        
        
    }


     public boolean listaLoginPermissao(String user) throws SQLException{
         Funcionario funcionario = new Funcionario();
         boolean validar = false;
                  PreparedStatement stmt = conexao.prepareStatement("select * from tbFuncionario where dsusuario = "+user+"");
                  ResultSet rs = stmt.executeQuery();
                   if(rs.next()){
                    validar = true;
                    return validar;
                   }else{
                       return false;
                   }
        
    }
     
     
     public ResultSet listaLoginPermissaoFiltra(String user) throws SQLException{
         Funcionario funcionario = new Funcionario();
                  PreparedStatement stmt = conexao.prepareStatement("SELECT dsusuario FROM tbfuncionario WHERE dsLogin = "+user+"");
                  ResultSet rs = stmt.executeQuery();
                  return rs;
                   }
        
    
}
