/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.model;

import br.univali.controller.Morador;
import com.mysql.jdbc.Connection;
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
public class MoradorDAO {
    private ConnectionFactory fact;
    private Connection conex;
    
    public MoradorDAO () {
        this.fact = new ConnectionFactory();
        this.conex = null;
    }
    
    
    public boolean insertMorador( Morador morador) {
        this.conex = fact.startConnection();
        String query = "insert into morador (nome, cpf, rg, dataNascimento, foneResidencial, "
                +"celular, veiculo, garagem, idApartamento ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        System.out.println("Morador a inserir "+  morador.getNome());
        if ( this.conex != null ){
            System.out.println("Montar sql");
            try {
                PreparedStatement st = this.conex.prepareStatement( query );
                st.setString(1, morador.getNome());
                st.setString(2, morador.getCpf());
                st.setInt(3, morador.getRg());
                st.setString(4, morador.getDataNascimento());
                st.setString(5, morador.getFoneResidencial());
                st.setString(6, morador.getCelular());
                st.setString(7, morador.getVeiculo());
                st.setInt(8, morador.getGaragem());
                st.setInt(9, morador.getIdApartamento());
                st.execute();
                
            } catch (SQLException ex) {
                Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.fact.finishConnection(this.conex);
        return true;
    }
    
    public boolean removeMorador ( int moradorId ) {
        return true;
    }
    
    
    public int getIdMoradorByCpf( String cpf ){
        int id = 0;
        String query = "select idMorador from morador where cpf = ?";
        this.conex = this.fact.startConnection();
        
        if ( this.conex != null){
            try {
                PreparedStatement st = this.conex.prepareStatement(query);
                st.setString(1, cpf);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("idMorador");                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.fact.finishConnection(this.conex);
        
        
        return id;
    }
    
    
    public Morador getMoradorById( int idMorador ) {
        Morador morador = null;
        String query = "select * from morador where idMorador = ?";
        
        try {
            PreparedStatement st = this.conex.prepareStatement( query );
            st.setInt(1, idMorador);
            
            ResultSet rs = st.executeQuery();
            int count = 1;
            while (rs.next()){
                
                System.out.println("vez " + count + " item " + rs.getString("Nome"));
                count++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return morador;
    }
    
    public ArrayList<Morador> getListMorador() {
        ArrayList<Morador> listaMorador = null;
        return listaMorador;
    }  
    
}
