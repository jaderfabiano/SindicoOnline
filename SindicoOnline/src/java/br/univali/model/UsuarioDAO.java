/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.model;

import br.univali.controller.Morador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jader
 */
public class UsuarioDAO {
    private ConnectionFactory fact;
    private Connection conex;
    
    public UsuarioDAO(){
        this.fact = new ConnectionFactory();
        this.conex = null;        
    }

    /**
     * @return the fact
     */
    public ConnectionFactory getFact() {
        return fact;
    }

    /**
     * @param fact the fact to set
     */
    public void setFact(ConnectionFactory fact) {
        this.fact = fact;
    }

    /**
     * @return the conex
     */
    public Connection getConex() {
        return conex;
    }

    /**
     * @param conex the conex to set
     */
    public void setConex(Connection conex) {
        this.conex = conex;
    }   
    
    public boolean insertUsuario (Morador morador) {
        this.conex = this.fact.startConnection();
           String query = "insert into usuario (idMorador, login, senha)" +
                " values (?, ?, ?)";           
           boolean insert = false;
           if ( this.conex != null) {
            try {
                PreparedStatement st = this.conex.prepareStatement(query);
                st.setInt(1, morador.getIdMorador());
                st.setString(2, morador.getUsuario());
                st.setString(3, morador.getSenha());
                st.execute();
                insert = true;
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }               
           } else {               
               System.out.println("Falha inserindo usuario ");
           }
        return insert;
        
    }
    
}
