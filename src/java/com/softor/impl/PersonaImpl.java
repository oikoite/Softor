/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softor.impl;

import com.softor.conexion.Conexion;
import com.softor.dao.PersonaDAO;
import com.softor.entities.Persona;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author ci_vbaez
 */
public class PersonaImpl implements PersonaDAO {

    private final Conexion con = new Conexion();
    private Statement stmt = null;
    private ResultSet rs = null;
        
    @Override
    public Persona add(Persona entity) {
        try{
            stmt = con.getConexion().prepareStatement("INSERT INTO persona VALUES (?,?,?,?,?)");
        } catch (Exception ex){
            
        }
        return null;
    }

    @Override
    public Persona edit(Persona entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona getById(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
