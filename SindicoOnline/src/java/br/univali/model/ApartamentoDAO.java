/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.model;

import br.univali.controller.Apartamento;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jader
 */
public class ApartamentoDAO {
    private ConnectionFactory fact;
    private Connection conex;
    
    public ApartamentoDAO () {
        this.fact = new ConnectionFactory();
        this.conex = null;        
    }
    
    
    public boolean insertApartamento( Apartamento ap ) {
        this.conex = this.fact.startConnection(); 
        String query = "insert into apartamento (bloco, numero, andar)" +
                " values (?, ?, ?)";
        try {
            PreparedStatement st = this.conex.prepareStatement( query );
            st.setString(1, ap.getBlock());
            st.setInt(2, ap.getNumber());
            st.setInt(3, ap.getFloor());
            
            st.execute();      
        } catch (SQLException ex) {
            System.out.println("Falha ao executar " + ex);
        }
        if ( this.conex != null) {
            System.out.println("Inserindo Apartamento");
        }
        
        this.fact.finishConnection(this.conex);        
        return true;      
    }
    
    
    public int getIdApartamento( Apartamento ap ) {
        int id = 0;
        String query = 
                "select idApartamento from apartamento where numero = ? and andar = ? and bloco = ? ";
        this.conex = this.fact.startConnection(); 
        try {
            PreparedStatement st = this.conex.prepareStatement( query );
            st.setInt(1, ap.getNumber());
            st.setInt(2, ap.getFloor());
            st.setString(3, ap.getBlock());
            ResultSet rs = st.executeQuery();
            while( rs.next()){
                id = rs.getInt("idApartamento");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApartamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
        this.fact.finishConnection(this.conex);   
        System.out.println("Id retorno " + id);
        return id;
        
    }
    
}
