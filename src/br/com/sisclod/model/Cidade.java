/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.model;

/**
 *
 * @author adriano
 */
public class Cidade {
    
    private int id;
    private String nome;
    private String estado;
    private String estadoTabela;
    private String sgUF;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }       

    public String getEstadoTabela() {
        return estadoTabela;
    }

    public void setEstadoTabela(String estadoTabela) {
        this.estadoTabela = estadoTabela;
    }
    
}
