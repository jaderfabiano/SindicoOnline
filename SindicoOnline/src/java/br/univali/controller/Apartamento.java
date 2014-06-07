/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.controller;

import br.univali.model.ApartamentoDAO;

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
    
    public Apartamento(int floorAp, int numberAp, String apBlock) {
        this.block = apBlock;
        this.floor = floorAp;
        this.number = numberAp;
        
        System.out.println("Apartamento " + this.number);
    }
    
    
    public Apartamento getApartamentoByMorador( int idMorador){
        Apartamento ap = null;
        ApartamentoDAO apDao = new ApartamentoDAO();
        
        ap = apDao.getApartamentoByIdMorador(idMorador);
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
