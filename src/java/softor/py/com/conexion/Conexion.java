/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softor.py.com.conexion;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author ci_vbaez
 */
public class Conexion {
    private Context ctx = null;
    Connection con = null;
    
    public Connection getConexion(){
        try{
            ctx = new InitialContext();
            Context initCtx = (Context) ctx.lookup("java:/comp/env");
            DataSource ds = (DataSource) initCtx.lookup("jdbc/MyLocalDB");
            con = ds.getConnection();
        } catch (Exception ex){
            System.out.println("Prueba ");
        }
        return con;
    }
}
