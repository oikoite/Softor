/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softor.py.com.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ci_vbaez
 */
public class TestConexion {

    public static void main(String args[]) {
        Conexion con = new Conexion();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.getConexion().createStatement();
            rs = stmt.executeQuery("select id, descripcion from prueba");
            while (rs.next()) {
                System.out.print("id: " + rs.getInt("id") + "\t");
                System.out.print("descripcion: " + rs.getInt("descripcion") + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
