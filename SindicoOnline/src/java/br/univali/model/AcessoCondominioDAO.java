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
        String query = "select * from portaria where not isnull(dataSaida)";
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
                    System.out.println("Nome tabela " + rs.getString("nome"));
                    acesso.setNome(rs.getString("nome"));
                    listAcesso.add(acesso);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AcessoCondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }                
        return listAcesso;        
        
    }
    public ArrayList<AcessoCondominio> getListaEntrada(){
        ArrayList<AcessoCondominio> listAcesso = new ArrayList<AcessoCondominio>();
        String query = "select * from portaria where isnull(dataSaida)";
        //AcessoCondominio acesso = new AcessoCondominio();
        this.conex = this.fact.startConnection();
        if (this.conex != null){
            try {
                PreparedStatement st = this.conex.prepareStatement(query);
                ResultSet rs = st.executeQuery();
                while(rs.next()){
                    AcessoCondominio acesso = new AcessoCondominio();
                    System.out.println("Pegando lista de entrada");
                    acesso.setDataEntrada(rs.getString("dataEntrada"));
                    acesso.setIdAcesso(rs.getInt("idacessoCondominio"));
                    acesso.setDataSaida("");
                    acesso.setNome(rs.getString("nome"));
                    System.out.println("Nome " + acesso.getNome());
                    listAcesso.add(acesso);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AcessoCondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }                
        return listAcesso;        
    }
    
    
    public boolean registraSaida( int idAcesso, String dataSaida ) {
        String query = "update portaria set dataSaida = ? where idacessoCondomino = ?";
        this.conex = this.fact.startConnection();
        
        if ( this.conex != null){
            PreparedStatement st;
            try {
                st = this.conex.prepareStatement(query);
                st.execute();
            } catch (SQLException ex) {
                Logger.getLogger(AcessoCondominioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        //this.fact.finishConnection(this.conex);
        return true;
        
    }
    
}
