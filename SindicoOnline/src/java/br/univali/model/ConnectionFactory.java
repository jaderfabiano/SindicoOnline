/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jader fabiano
 */
public class ConnectionFactory {
    
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url        = "jdbc:mysql://127.0.0.1:3306/sindicoonline";
    private static final String user       = "root";
      
    
    
    
    public Connection startConnection () {
        Connection connect = null;
        try {
            Class.forName(driverName);
            connect = (Connection) DriverManager.getConnection(url, user, "");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro conexao");
        }
        return connect;                        
    }   
    
    public void finishConnection( Connection conex ) {
        try {
            conex.close();
        } catch (SQLException ex) {
            System.out.println("Problema ao fechar conexao");
        }
        
    }
    
}
