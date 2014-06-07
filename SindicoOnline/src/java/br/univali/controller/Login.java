/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.controller;

import br.univali.model.UsuarioDAO;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author jader
 */
public class Login {
    private String user;
    private String senha;
    
    public Login(String user, String senha){
        this.user = user;
        this.senha = senha;        
    }
    
    public Login () {
    }
    
    public boolean validateLogin(  ) {
        UsuarioDAO userDao = new UsuarioDAO();
        ArrayList<Login> list;
        boolean auth = false;
        System.out.println("Inicio validação " + this.getUser());
        list = userDao.getUsers();
        Login iterator = null;
        
        System.out.println("Tamanho lista " + list.size());
        
        for ( int i =0 ; i < list.size(); i++){            
            iterator = list.get(i);
            System.out.println("Teste " + iterator.getUser());
            if ( iterator.getUser().equals(this.getUser())){
                if ( iterator.getSenha().equals(this.getSenha())){
                    auth = true;
                    break;
                }
            } 
        }
        
        
        return auth;
        
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}