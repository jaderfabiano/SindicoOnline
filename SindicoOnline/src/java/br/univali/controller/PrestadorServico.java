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
public class PrestadorServico extends Pessoa {
    private String cnpj;
    private int idPrestadorServico;
    private String nomeEmpresa;   

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the idPrestadorServico
     */
    public int getIdPrestadorServico() {
        return idPrestadorServico;
    }

    /**
     * @param idPrestadorServico the idPrestadorServico to set
     */
    public void setIdPrestadorServico(int idPrestadorServico) {
        this.idPrestadorServico = idPrestadorServico;
    }

    /**
     * @return the nomeEmpresa
     */
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    /**
     * @param nomeEmpresa the nomeEmpresa to set
     */
    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    
}
