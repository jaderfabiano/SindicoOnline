/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.controller;

import br.univali.model.ApartamentoDAO;
import br.univali.model.MoradorDAO;
import br.univali.model.UsuarioDAO;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.awt.AppContext;

/**
 *
 * @author jader
 */
public class Morador extends Pessoa {
    private String garagem;
    private int idApartamento;
    private int idMorador;
    private String veiculo;

    /**
     * @return the idMorador
     */
    public int getIdMorador() {
        return idMorador;
    }

    /**
     * @param idMorador the idMorador to set
     */
    public void setIdMorador(int idMorador) {
        this.idMorador = idMorador;
    }    
    
    
    /**
     * @return the idApartamento
     */
    public int getIdApartamento() {
        return idApartamento;
    }

    /**
     * @param idApartamento the idApartamento to set
     */
    public void setIdApartamento(int idApartamento) {
        this.idApartamento = idApartamento;
    }

    /**
     * @return the veiculo
     */
    public String getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }
  
 

    /**
     * @return the garagem
     */
    public String getGaragem() {
        return garagem;
    }

    /**
     * @param garagem the garagem to set
     */
    public void setGaragem(String garagem) {
        this.garagem = garagem;
    }
    
    public void deleteMorador(int idMorador) {
        MoradorDAO moradorDao = new MoradorDAO();        
        UsuarioDAO userDao = new UsuarioDAO();
        userDao.deleteUser(idMorador);
        moradorDao.removeMorador(idMorador);        
    }
    
    public void mountObjectRequest( String contentRequest) {
        JSONObject object = new JSONObject(contentRequest);        
        JSONObject dados = new JSONObject(object.get("morador").toString());
        this.setGaragem(dados.getString("garagem"));
        this.setNome(dados.get("nome").toString());
        this.setSexo(dados.get("sexo").toString());
        this.setSenha(dados.get("senha").toString());
        this.setRg(dados.getString("rg"));
        this.setCelular(dados.get("celular").toString());
        this.setCpf(dados.get("cpf").toString());
        this.setDataNascimento(dados.get("dataNascimento").toString());
        this.setFoneResidencial(dados.get("foneResidencial").toString());
        this.setUsuario(dados.get("usuario").toString());
        this.setVeiculo(dados.get("veiculo").toString());
        this.setIdApartamento(dados.getInt("idApartamento"));
    }
    
    public void updateMorador( int idMorador, String contentRequest){
        MoradorDAO moradorDao = new MoradorDAO();
        UsuarioDAO userDao  = new UsuarioDAO();
        mountObjectRequest(contentRequest);
        moradorDao.updateMorador(idMorador, this);        
        userDao.updateUser(this, idMorador);
    }
    
    public void novoMorador( String contentRequest ) {        
        MoradorDAO moradorDao = new MoradorDAO();
     //System.out.println("Nome " + dados.get("nome").toString());
        mountObjectRequest(contentRequest);
        System.out.println("Fim ");    
        UsuarioDAO user = new UsuarioDAO();
        moradorDao.insertMorador(this);   
        this.setIdMorador(moradorDao.getIdMoradorByCpf(this.getCpf()));
        user.insertUsuario(this);       
    }
   


 public String getListMoradores() {
     String content = "";
     MoradorDAO moradorDao = new MoradorDAO();
     ArrayList<Morador> list = null;

     list = moradorDao.getListMorador();
     JSONObject obj = mountListMoradores(list);      

     return obj.toString();
 }

 public JSONObject mountMoradorJson( Morador morador) {
     JSONObject obj = new JSONObject();
     Apartamento ap= new Apartamento();
     ap = ap.getApartamentoById(morador.getIdApartamento());
     obj.put("idMorador", morador.getIdMorador());
     obj.put("nome",morador.getNome());
     obj.put("cpf", morador.getCpf());
     obj.put("celular", morador.getCelular());
     obj.put("rg", morador.getRg());
     obj.put("dataNascimento", morador.getDataNascimento());
     obj.put("foneResidencial", morador.getFoneResidencial());
     obj.put("veiculo", morador.getVeiculo());
     obj.put("garagem", morador.getGaragem());
     obj.put("sexo", morador.getSexo());
     obj.put("andar", ap.getFloor());
     obj.put("numero", ap.getNumber());
     obj.put("bloco", ap.getBlock());
     obj.put("idApartamento", morador.getIdApartamento());
     return obj;        
 }


 public JSONObject mountListMoradores( ArrayList<Morador> list){
    JSONArray jsonArray = new JSONArray();
    JSONObject obj = new JSONObject();         

     Apartamento ap= new Apartamento();
     System.out.println("Mount list to json");
     for (int i = 0; i < list.size(); i++)   {
         JSONObject objMorador = mountMoradorJson(list.get(i));         
         jsonArray.put(objMorador);            
        }
        obj.put("moradores", jsonArray);

         return obj;
    }

    public String getMorador( int id) {
        MoradorDAO moradorDao = new MoradorDAO();
        Morador morador = null;

         morador = moradorDao.getMoradorById( id );        
        JSONObject object = mountMoradorJson(morador);

        return object.toString();
    }
    
    
    
    public String getUserSenhaById(int idMorador) {
        UsuarioDAO userDao = new UsuarioDAO();
        Morador morador = userDao.getUserById(idMorador);
        JSONObject obj = new JSONObject();
        obj.put("usuario", morador.getUsuario());
        obj.put("senha", morador.getSenha());                
        return obj.toString();
    }

}
