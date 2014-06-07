/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.model;

import br.univali.controller.Morador;
import com.mysql.jdbc.Connection;
import java.util.ArrayList;

/**
 *
 * @author jader
 */
public class MoradorDAO {
    private ConnectionFactory fact;
    private Connection conex;
    
    public MoradorDAO () {
        this.fact = new ConnectionFactory();
        this.conex = null;
    }
    
    
    public boolean insertMorador( Morador morador) {
        this.conex = fact.startConnection();
        String query = "insert int";
        if ( this.conex != null ){
            System.out.println("Montar sql");
        }
        this.fact.finishConnection(this.conex);
        return true;
    }
    
    public boolean removeMorador ( int moradorId ) {
        return true;
    }
    
    public ArrayList<Morador> getListMorador() {
        ArrayList<Morador> listaMorador = null;
        return listaMorador;
    }  
    
}
