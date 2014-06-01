/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jader fabiano
 */
public class ConnectionFactory {
    
    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url        = "jdbc:mysql://127.0.0.1:3306";
    private static final String user       = "root";
    private static final String passwd     = "1234";    
    
    
    
    public Connection startConnection () {
        Connection connect = null;
        try {
            Class.forName(driverName);
            connect = (Connection) DriverManager.getConnection(url, user, passwd);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro conexao");
        }
        return connect;                        
    }   
    
}
