/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.controller;

/**
 *
 * @author jader
 */
public class Funcionario extends Pessoa {
    private String cargo;
    private int idFuncionario;
    private int numeroIdentificacao;

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the numeroIdentificacao
     */
    public int getNumeroIdentificacao() {
        return numeroIdentificacao;
    }

    /**
     * @param numeroIdentificacao the numeroIdentificacao to set
     */
    public void setNumeroIdentificacao(int numeroIdentificacao) {
        this.numeroIdentificacao = numeroIdentificacao;
    }
    
}
