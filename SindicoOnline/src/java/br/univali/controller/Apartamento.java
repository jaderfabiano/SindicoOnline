/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.controller;

import br.univali.model.ApartamentoDAO;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jader
 */
public class Apartamento {
    private int floor;
    private int idApartment;
    private int number;
    private String block;
    
    public Apartamento(){
        
    }
    
    public JSONObject getApartamentoToJSon( Apartamento ap ) {
        JSONObject obj = new JSONObject();
        obj.put("idApartamento", ap.getIdApartment());
        obj.put("bloco", ap.getBlock());
        obj.put("andar", ap.getFloor());
        obj.put("numero", ap.getNumber());
        return obj;
    }
    
    public JSONObject mountListApartamentos( ArrayList<Apartamento> list){
        JSONArray jArray = new JSONArray();
        JSONObject objAp = new JSONObject();
        
        for ( int i = 0; i < list.size(); i++){
            JSONObject obj = getApartamentoToJSon(list.get(i));
            jArray.put(obj);
        }
        objAp.put("apartamentos", jArray);
        return objAp;
    } 
    
    public String getListaApartamento(){
        ApartamentoDAO apDao = new ApartamentoDAO();       
                
        ArrayList<Apartamento> listApartamento = null;
        
        listApartamento = apDao.getListaApartamento();
        JSONObject obj = mountListApartamentos(listApartamento);
      
        return obj.toString();
        
    }
    
    public Apartamento(int floorAp, int numberAp, String apBlock) {
        this.block = apBlock;
        this.floor = floorAp;
        this.number = numberAp;
        
        System.out.println("Apartamento " + this.number);
    }
    
    
   
    
    public Apartamento getApartamentoById( int idApartamento){
        Apartamento ap = new Apartamento();
        ApartamentoDAO apDao =  new ApartamentoDAO();
        
        ap = apDao.getApartamentoById(idApartamento);
        
        return ap;
        
    }

    /**
     * @return the floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * @return the idApartment
     */
    public int getIdApartment() {
        return idApartment;
    }

    /**
     * @param idApartment the idApartment to set
     */
    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return the block
     */
    public String getBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(String block) {
        this.block = block;
    }

    
}
