/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.controller;

import br.univali.model.AcessoCondominioDAO;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jader
 */
public class AcessoCondominio {

    private String nome;
    private String dataEntrada;
    private String dataSaida;
    private int idAcesso;
    
    public AcessoCondominio() {
        
    } 
    
    public JSONObject getObjectAcesso(AcessoCondominio acesso) {
        JSONObject obj = new JSONObject();
        obj.put("idAcesso", acesso.getIdAcesso());
        obj.put("dataEntrada", acesso.getDataEntrada());
        obj.put("dataSaida",acesso.getDataSaida());
        System.out.println("Nome json " + acesso.getNome());
        obj.put("nome", acesso.getNome());
        return obj;        
    }
    
    public String buildAnswerInJson( ArrayList<AcessoCondominio> list){
        JSONArray jArray = new JSONArray();
        for ( int i =0; i < list.size(); i++) {
            JSONObject obj = getObjectAcesso(list.get(i));
            jArray.put(obj);
        }
        return jArray.toString();
    }
    
    public String getListaEntrada() {
        AcessoCondominioDAO acessoDao = new AcessoCondominioDAO();
        ArrayList<AcessoCondominio> list;
        list = acessoDao.getListaEntrada();
        return buildAnswerInJson(list);        
    }
    
    public String getLisSaida() {
        AcessoCondominioDAO acessoDao = new AcessoCondominioDAO();
        ArrayList<AcessoCondominio> list;
        list = acessoDao.getListaSaida();
        return buildAnswerInJson(list);
    }
    
    public void registraSaida( String content) {
        AcessoCondominioDAO acessoDao = new AcessoCondominioDAO();
        JSONObject obj = new JSONObject(content);          
        acessoDao.registraSaida(obj.getInt("id"), obj.getString("dataSaida"));        
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the dataEntrada
     */
    public String getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the dataSaida
     */
    public String getDataSaida() {
        return dataSaida;
    }

    /**
     * @param dataSaida the dataSaida to set
     */
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    /**
     * @return the idAcesso
     */
    public int getIdAcesso() {
        return idAcesso;
    }

    /**
     * @param idAcesso the idAcesso to set
     */
    public void setIdAcesso(int idAcesso) {
        this.idAcesso = idAcesso;
    }

}
