/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.model;

import br.univali.controller.Login;
import br.univali.controller.Morador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
           //this.fact.finishConnection(this.conex);
        return insert;        
    }
    
    public ArrayList<Login> getUsers(){
        ArrayList<Login> list = new ArrayList<Login>();
        this.conex = this.fact.startConnection();
        String query = "select * from usuario ";
        
        if (this.conex != null) {
            try {
                PreparedStatement st = this.conex.prepareStatement(query);
                ResultSet rs = st.executeQuery();
                while( rs.next()){
                    Login obj = new Login();
                    obj.setSenha(rs.getString("senha"));
                    obj.setUser(rs.getString("login"));
                    System.out.println("PEgou Objeto " + obj.getUser());
                    list.add(obj);
                }                         
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
        return list;
    }
    
    public boolean deleteUser( int idMorador){
        String query = "delete from usuario where idMorador = ?";
        this.conex = this.fact.startConnection();
        if (this.conex != null){
            try {
                PreparedStatement st = this.conex.prepareStatement(query);
                st.setInt(1, idMorador);
                st.execute();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return true;        
    }
    
    public Morador getUserById( int idMorador ) {
        Morador morador = new Morador();
        String query = "select * from usuario where idMorador = ?";
        this.conex = this.fact.startConnection();
        if (this.conex != null){
            try {
                PreparedStatement st = this.conex.prepareStatement(query);
                st.setInt(1, idMorador);
                ResultSet rs = st.executeQuery();
                while (rs.next()){
                    morador.setUsuario(rs.getString("login"));
                    morador.setSenha(rs.getString("senha"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }      
            
        }
        //this.fact.finishConnection(this.conex);
        return morador;      
    }
    
    public boolean updateUser(Morador morador, int idMorador){
        String query = "update usuario set login = ?, senha = ? where idMorador = ?";
        this.conex = this.fact.startConnection();
        System.out.println("Senha morador " + morador.getSenha());
        if ( this.conex != null ){
            try {
                PreparedStatement st = this.conex.prepareStatement(query);
                st.setString(1, morador.getUsuario());
                st.setString(2, morador.getSenha());
                st.setInt(3, idMorador);
                st.execute();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return true;
    }
   
    
}
