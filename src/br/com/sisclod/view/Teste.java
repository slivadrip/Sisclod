/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.view;

import br.com.sisclod.dao.PacienteDAO;
import br.com.sisclod.model.Paciente;
import java.sql.SQLException;

/**
 *
 * @author Dih
 */

public class Teste {
    
    public static void main(String[] Args) throws SQLException{
        
        Paciente p = new Paciente();
        PacienteDAO dao = new PacienteDAO();
        
        p.setNome("Adriano");
        p.setCpf("9999999");
        p.setRg("99999");
        p.setEndereco("AV AL QUADA");
        p.setBairro("Centro");
        p.setNumero("33");
        p.setTelefone("33333333");
        p.setCelular("55555");
        p.setEmail("osama@osam.com");
        p.setDtNascimento("21/12/2222");
        p.setCidade("Alvorada");
        p.setUF("BA");
        p.setSexo("Feminino");
        p.setId(10);
        
        
           
        dao.alterar(p);
    }
}
