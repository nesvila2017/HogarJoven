/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fucker
 */
public class Conexion {
    
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String URL = "jdbc:mysql://localhost:3306/inventariohogar";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private Connection conexion=null;
    private Savepoint sapo;
    private static Conexion conector;
    
    private static final Logger LOGGER = Logger.getLogger(Conexion.class.getName()); 
    private Conexion() {
       
    }

    public static Conexion generarConexion(){
        
        if (conector== null) {
            conector = new Conexion();
            return conector;
        }else{
            return conector;
        }
    }
    
    private Connection enlazarConexion(){
        LOGGER.log(Level.INFO, " \n======= Creando CONEXIÓN. ======= \n");
        try {
            
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL,USER,PASS);
            conexion.setAutoCommit(false);
            LOGGER.log(Level.INFO, " \n======= Conexión REALIZADA. =======\n");
            return conexion;
        } catch (NullPointerException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, "------------Error en  conexión: ------------\n" + ex);
            return conexion; 
            
        }
       
    }
    
    
    public Connection crearConexion(){
        
        if (conexion==null) {
            conexion=enlazarConexion();
            return conexion;
        }else{
            return conexion;
        }
        
    }
    
    public void cerrarConexion(){
        try {
            if (conexion!=null) {
            conexion.close();
            conexion = null;
            LOGGER.log(Level.INFO, "\n========== Conexión CERRADA.=============\n");
            }
        } catch (SQLException sQLException) {
            LOGGER.log(Level.SEVERE,"Error al Cerrar Conexion.", sQLException);
        }
    }
    
    public boolean confirmarTransaccion(Savepoint save){
        
        try {
            LOGGER.info("\n\nConfirmando...\n\n");
            conexion.commit();
            cerrarConexion();
            LOGGER.info("\n\nTransaccion Confirmada\n\n");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "----->>>>Reversando Transaccion ", ex);
            reversarTransaccion(save);
            return false;
        } 
        
        
    }
    
    public boolean reversarTransaccion(Savepoint save){
        
        try {
            LOGGER.info("\n\nReversando...\n\n");
            conexion.rollback(save);
            LOGGER.info("\n\nReversion de Transaccion Exitosa.\n\n");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                conexion.close();
                cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private Savepoint establecerPuntoRestauracion(){
        
        try {
            sapo = crearConexion().setSavepoint("Punto "+ new Date());
            LOGGER.log(Level.INFO, " \n======= PUNTO DE RESTAURACION ESTABLECIDO.  OK =======\n");
            return sapo;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "ERRON EN PUNTO DE RESTAURACION ----------------------------", ex);
            return sapo;
        }
        
    }
    
     public Savepoint puntoRestauracion(){
        
        return establecerPuntoRestauracion();
        
    }
    
   
    
    
    
}
