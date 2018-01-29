/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.dao.ProductoDAO;
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
    public boolean registrarProducto(ProductoDAO p) {
        PreparedStatement ps;
        if (c.puntoRestauracion()) {
                try {
                ps = c.crearConexion().prepareStatement("INSERT INTO `inventariohogar`.`producto` ( `idCategoria`, `descripcion`) VALUES ( ?, ?);");
                ps.setInt(1, p.getIdCategoria());
                ps.setString(2,p.getDescrip());
                
                ps.execute();
                return c.realizarTransaccion();
            } catch (SQLException sQLException) {
                    System.out.println("Exception Registrar producto" + sQLException);
            }
           
        }
        return false;
    }

    /*
    UPDATE `inventariohogar`.`producto` SET `codBarras`='909089890', `descripcion`='YOGURT ALPINA 80ML', `marca`='ALPINA' WHERE `idProducto`='2';
UPDATE `inventariohogar`.`producto` SET `descripcion`='CARNE DE CERDO 500 GR' WHERE `idProducto`='1';
UPDATE `inventariohogar`.`producto` SET `codBarras`='909089890', `descripcion`='REGENERIS', `marca`='ALPINA', `modelo`='ALPINA', `serie`='ALPINA', `fabricante`='ALPINA', `fechaFabric`='2012-12-29', `loteFabric`='909LA' WHERE `idProducto`='3';

    */
    @Override
    public boolean modificarProducto(ProductoDAO p) {
        PreparedStatement ps;
        if (c.puntoRestauracion()) {
            //ps=c.crearConexion().prepareStatement("");
        }
        return false;
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
    public ProductoDAO buscarProductoId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductoDAO buscarProductoCodBarra(int codBarra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDAO> buscarProductoDescripcion(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDAO> buscarProductosEstado(boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDAO> buscarProductosMarca(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDAO> buscarProductosModelo(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDAO> buscarProductosCategoria(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDAO> buscarProductosProveedor(String busqueda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDAO> mostrarProductos() {
        ArrayList<ProductoDAO> productos = new ArrayList<>();
         PreparedStatement ps;
         ResultSet rs;
        if (c.puntoRestauracion()) {
                try {
                    System.out.println("Realizando Consulta en Tabla Producto - Metodo Mostrar Todos.");    
                ps = c.crearConexion().prepareStatement("SELECT * FROM `inventariohogar`.`producto`;");
                ps.execute();
                
                rs= ps.getResultSet();
                    while (rs.next()) {
                        ProductoDAO p = new ProductoDAO();
                        p.setIdProducto(rs.getInt(1));
                        p.setIdCategoria(rs.getInt(2));
                        p.setCodBarras(rs.getInt(3));
                        p.setDescrip(rs.getString(4));
                        p.setMarca(rs.getString(5));
                        p.setModelo(rs.getString(6));
                        p.setSerie(rs.getString(7));
                        p.setFabrica(rs.getString(8));
                        p.setFechaFab(rs.getDate(9));
                        p.setLote(rs.getString(10));
                        p.setFechaReg(rs.getTimestamp(11));
                        
                        productos.add(p);
                        System.out.println("Objeto en arreglo: " + productos.get(0).getDescrip());
                    }
                    System.out.println("Resultado de Objeto: Esta vacio ---> " + productos.isEmpty());
                return productos;
                
            } catch (SQLException sQLException) {
                    System.out.println("Exception Mostrar todos los  productos" + sQLException);
            }
           
        }
        return productos;
    }
    
}
