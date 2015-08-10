/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softor.impl;

import com.softor.conexion.Conexion;
import com.softor.dao.PersonaDAO;
import com.softor.entities.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author ci_vbaez
 */
public class PersonaImpl implements PersonaDAO {

    private final Conexion conexion = new Conexion();
    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Persona persona = null;
    private List<Persona> personas = null;

    @PostConstruct
    public void init() {
        try {
            con = conexion.getConexion();
        } catch (Exception ex) {

        }
    }

    @Override
    public Persona add(Persona entity) {
        try {
            pstmt = con.prepareStatement("INSERT INTO persona VALUES (?)");
            pstmt.setString(1, entity.getNombre());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqlEx) {

                }
            }
        }
        return null;
    }

    @Override
    public Persona edit(Persona entity) {
        try {
            pstmt = con.prepareStatement("UPDATE persona SET nombre = ? WHERE id_persona = ?");
            pstmt.setString(1, entity.getNombre());
            pstmt.setInt(2, entity.getId());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqlEx) {

                }
            }
        }
        return null;
    }

    @Override
    public void delete(Integer key) {
        try {
            pstmt = con.prepareStatement("DELETE FROM persona WHERE id_persona = ?");
            pstmt.setInt(1, key);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqlEx) {

                }
            }
        }
    }

    @Override
    public Persona getById(Integer key) {
        persona = new Persona();
        try {
            pstmt = con.prepareStatement("SELECT id, descripcion FROM persona WHERE id = ?");
            pstmt.setInt(1, key);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    persona.setId(rs.getInt("id"));
                    persona.setNombre(rs.getString("descripcion"));
                }
            }
        } catch (SQLException ex) {

        }
        return persona;
    }

    @Override
    public List<Persona> getAll() {
        personas = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT id, descripcion FROM persona");
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    persona = new Persona();
                    persona.setId(rs.getInt("id"));
                    persona.setNombre(rs.getString("descripcion"));
                    personas.add(persona);
                }
            }
        } catch (SQLException ex) {

        }
        return personas;
    }

}
