/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.GestionCategoriaImpl;
import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.interfaces.CategoriaDAO;
import modelo.dto.CategoriaDTO;


/**
 *
 * @author Fucker
 */
public class CategoriaDAOImpl implements CategoriaDAO{

     private Conexion conectar;
    private static final Logger LOGGER = Logger.getLogger(CategoriaDAOImpl.class.getName());
     

    public CategoriaDAOImpl() {
        
    }
     @Override
     public String nameCategoria(int id){
        ArrayList<CategoriaDTO> cat = mostrarCategorias();
        for (CategoriaDTO c : cat) {
            if (c.getIdCategoria()==id) {
                return c.getDescripCat();
            }
        }
        return null;
    }
    
    @Override
    public Boolean registrarCategoria(CategoriaDTO d) {
       Conexion c = null;
        conectar=c.generarConexion();
        PreparedStatement ps;
       Savepoint sapo = conectar.puntoRestauracion();
            try {
                ps = conectar.crearConexion().prepareStatement("");
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(GestionCategoriaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conectar.confirmarTransaccion(sapo);

       
    }

    @Override
    public Boolean modificarCategoria(CategoriaDTO d) {
       Conexion c = null;
        conectar=c.generarConexion();
        PreparedStatement ps;
       Savepoint sapo = conectar.puntoRestauracion();       
            try {
                ps = conectar.crearConexion().prepareStatement("");
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(GestionCategoriaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conectar.confirmarTransaccion(sapo);
    }

    @Override
    public Boolean eliminarCategoria(CategoriaDTO d) {
        Conexion c = null;
        conectar=c.generarConexion();
        PreparedStatement ps;
              Savepoint sapo = conectar.puntoRestauracion();       
       
            try {
                ps = conectar.crearConexion().prepareStatement("");
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(GestionCategoriaImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return conectar.confirmarTransaccion(sapo);

       
    }

    @Override
    public CategoriaDTO buscarCategaria(int idCategoria) {
        Conexion c = null;
        conectar=c.generarConexion();
        PreparedStatement ps;
        ResultSet rs;
        CategoriaDTO d = new CategoriaDTO();
        try {
            ps = conectar.crearConexion().prepareStatement("select * from `inventariohogar`.`categoria` where `idcategoria`=?");
            ps.setInt(1, idCategoria);
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                d.setIdCategoria(rs.getInt(1));
                d.setDescripCat(rs.getString(2));
                
            }
            return d;
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategoriaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public CategoriaDTO buscarCategoriaNombre(String cat) {
         Conexion c = null;
        conectar=c.generarConexion();
        PreparedStatement ps;
        ResultSet rs;
        CategoriaDTO d = new CategoriaDTO();
        try {
            ps = conectar.crearConexion().prepareStatement("select * from `inventariohogar`.`categoria` where `descripCat`=?");
            ps.setString(1, cat);
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                d.setIdCategoria(rs.getInt(1));
                d.setDescripCat(rs.getString(2));
                
            }
            return d;
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategoriaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    @Override
    public ArrayList<CategoriaDTO> mostrarCategorias() {
        Conexion c = null;
        conectar=c.generarConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        ArrayList<CategoriaDTO> categorias = new ArrayList<>();
        try {
            LOGGER.info("----PREPARANDO CONSULTA --- MOSTRAR CATEGORIAS ---");
            ps = conectar.crearConexion().prepareStatement("select * from `inventariohogar`.`categoria`");
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                CategoriaDTO d = new CategoriaDTO();
                d.setIdCategoria(rs.getInt(1));
                d.setDescripCat(rs.getString(2));
                categorias.add(d);
            }
            ps.close();
            
            LOGGER.info("---- FIN CONSULTA --- MOSTRAR CATEGORIAS ---");
            conectar.cerrarConexion();
            conectar=null;
            return categorias;
        } catch (SQLException ex) {
            Logger.getLogger(GestionCategoriaImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    

    
}
