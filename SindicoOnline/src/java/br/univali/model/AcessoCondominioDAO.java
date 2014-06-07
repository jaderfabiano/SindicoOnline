/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.model;

import br.univali.controller.AcessoCondominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jader
 */
public class AcessoCondominioDAO {
    private ConnectionFactory fact;
    private Connection conex;
    
    public AcessoCondominioDAO(){
        this.fact = new ConnectionFactory();
        this.conex = null;
    }
    
    public ArrayList<AcessoCondominio> getListaSaida() {
        ArrayList<AcessoCondominio> listAcesso = new ArrayList<>();
        String query = "select * from portaria";
        AcessoCondominio acesso = new AcessoCondominio();
        this.conex = this.fact.startConnection();
        if (this.conex != null){
            try {
                PreparedStatement st = this.conex.prepareStatement(query);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    System.out.println("Pegando lista de entrada");
                    acesso.setDataEntrada(rs.getString("dataEntrada"));
                    acesso.setIdAcesso(rs.getInt("idacessoCondominio"));
                    acesso.setDataSaida(rs.getString("dataSaida"));
                    acesso.setNome("nome");
                    listAcesso.add(acesso);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AcessoCondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }                
        return listAcesso;        
        
    }
    public ArrayList<AcessoCondominio> getListaEntrada(){
        ArrayList<AcessoCondominio> listAcesso = new ArrayList<>();
        String query = "select * from portaria";
        AcessoCondominio acesso = new AcessoCondominio();
        this.conex = this.fact.startConnection();
        if (this.conex != null){
            try {
                PreparedStatement st = this.conex.prepareStatement(query);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    System.out.println("Pegando lista de entrada");
                    acesso.setDataEntrada(rs.getString("dataEntrada"));
                    acesso.setIdAcesso(rs.getInt("idacessoCondominio"));
                    acesso.setDataSaida("");
                    acesso.setNome("nome");
                    listAcesso.add(acesso);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AcessoCondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }                
        return listAcesso;        
    }
    
    
    public boolean registraSaida( int idAcesso, String dataSaida ){
        return true;
        
    }
    
}
