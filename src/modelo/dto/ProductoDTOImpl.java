/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dao.Producto;
import modelo.dto.interfaces.ProductoDTO;

/**
 *
 * @author Fucker
 */
public class ProductoDTOImpl implements ProductoDTO{

    private Conexion c;
    
    
    public ProductoDTOImpl() {
        c= new Conexion();
    }

    
    
    @Override
    public boolean registrarProducto(Producto p,int idCat, int idProv) {
        PreparedStatement ps;
        if (c.puntoRestauracion()) {
                try {
                ps = c.crearConexion().prepareStatement("INSERT INTO `inventariohogar`.`producto` (`codBarras`, `descripcion`, `idCategoria`, `idProveedor`, `fechaFabric`, `loteFabric`) VALUES (?, ?, ?, ?,?, ?);");
                ps.setInt(1, p.getCodBarras());
                ps.setString(2,p.getDescrip());
                ps.setInt(3, idCat);
                ps.setInt(4, idProv);
                ps.setDate(5,p.getFechaFab());
                ps.setString(6, p.getLote());
                ps.execute();
                return c.realizarTransaccion();
            } catch (SQLException sQLException) {
                    System.out.println("Exception Registrar producto" + sQLException);
            }
           
        }
        return false;
    }

    @Override
    public boolean modificarProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estadoProducto(boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscarProductoId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto buscarProductoCodBarra(int codBarra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> buscarProductoDescripcion(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> buscarProductosEstado(boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> buscarProductosMarca(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> buscarProductosModelo(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> buscarProductosCategoria(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> buscarProductosProveedor(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Producto> mostrarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
