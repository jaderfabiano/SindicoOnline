/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.controller;

import br.univali.model.ApartamentoDAO;
import br.univali.model.MoradorDAO;
import org.json.JSONObject;

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
    
  
    public void novoMorador( String contentRequest ) {
        JSONObject object = new JSONObject(contentRequest);        
        JSONObject dados = new JSONObject(object.get("morador").toString());   
        MoradorDAO moradorDao = new MoradorDAO();
        Apartamento ap = 
                new Apartamento(dados.getInt("andar"), dados.getInt("numero"), dados.get("bloco").toString());
        System.out.println("Nome " + dados.get("nome").toString());
        this.setGaragem(dados.getInt("garagem"));
        this.setNome(dados.get("nome").toString());
        this.setSexo(dados.get("sexo").toString());
        this.setSenha(dados.get("senha").toString());
        this.setRg(dados.getInt("rg"));
        this.setCelular(dados.get("celular").toString());
        this.setCpf(dados.get("cpf").toString());
        this.setDataNascimento(dados.get("dataNascimento").toString());
        this.setFoneResidencial(dados.get("foneResidencial").toString());
        this.setUsuario(dados.get("usuario").toString());
        
        System.out.println("Fim ");    
        ApartamentoDAO apDao = new ApartamentoDAO();
        apDao.insertApartamento(ap);
        apDao.getIdApartamento(ap);
        
        moradorDao.insertMorador(this);   
    }
    
    
    
}
