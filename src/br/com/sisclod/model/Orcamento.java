/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisclod.model;

/**
 *
 * @author Dih
 */
public class Orcamento {
    private int id;
    private int idPaciente;
    private String Procedimento;
    private double valor;
    private int quantidade;
    private double vlTotal;
    private int nrOrcamento;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the Procedimento
     */
    public String getProcedimento() {
        return Procedimento;
    }

    /**
     * @param Procedimento the Procedimento to set
     */
    public void setProcedimento(String Procedimento) {
        this.Procedimento = Procedimento;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    /**
     * @return the nrOrcamento
     */
    public int getNrOrcamento() {
        return nrOrcamento;
    }

    /**
     * @param nrOrcamento the nrOrcamento to set
     */
    public void setNrOrcamento(int nrOrcamento) {
        this.nrOrcamento = nrOrcamento;
    }

    /**
     * @return the vlTotal
     */
    public double getVlTotal() {
        return vlTotal;
    }

    /**
     * @param vlTotal the vlTotal to set
     */
    public void setVlTotal(double vlTotal) {
        this.vlTotal = vlTotal;
    }
    
}
