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
public class Morador extends Pessoa {
    private int garagem;
    private int idMorador;

    /**
     * @return the garagem
     */
    public int getGaragem() {
        return garagem;
    }

    /**
     * @param garagem the garagem to set
     */
    public void setGaragem(int garagem) {
        this.garagem = garagem;
    }

    /**
     * @return the idMorador
     */
    public int getIdMorador() {
        return idMorador;
    }

    /**
     * @param idMorador the idMorador to set
     */
    public void setIdMorador(int idMorador) {
        this.idMorador = idMorador;
    }    
    
}
