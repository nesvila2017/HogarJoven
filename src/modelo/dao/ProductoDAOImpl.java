/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.interfaces.ProductoDAO;
import modelo.dto.ProductoDTO;

/**
 *
 * @author Fucker
 */
public class ProductoDAOImpl implements ProductoDAO {

    private static final Logger LOGGER = Logger.getLogger(ProductoDAOImpl.class.getName());

    public ProductoDAOImpl() {

    }
    
    

    @Override
    public boolean registrarProducto(ProductoDTO p, Conexion c) {
        
        PreparedStatement ps;
        LOGGER.info("----PREPARANDO CONSULTA --- REGISTRAR PRODUCTO ---");
        Savepoint sapo = c.puntoRestauracion();
        try {
            LOGGER.info("INICIANDO CONSULTA -- REGISTRO PRODUCTO ---");
            ps = c.crearConexion().prepareStatement("INSERT INTO `inventariohogar`.`producto` (`idCategoria`, `codBarras`, `descripcion`, `marca`, `modelo`, `serie`, `fabricante`, `fechaFabric`, `loteFabric`, `estado`, `medida`,`stockMin`, `stockMax`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setInt(1, p.getIdCategoria());
            ps.setString(2, p.getCodBarras());
            ps.setString(3, p.getDescrip());
            ps.setString(4, p.getMarca());
            ps.setString(5, p.getModelo());
            ps.setString(6, p.getSerie());
            ps.setString(7, p.getFabrica());
            ps.setDate(8, p.getFechaFab());
            ps.setString(9, p.getLote());
            ps.setString(10, p.getEstado());
            ps.setString(11, p.getUnidadMedida());
            ps.setInt(12, p.getStockMin());
            ps.setInt(13, p.getStockMax());

            System.out.println(ProductoDAOImpl.class.getName() + "Ejecucion SQL: " + ps.execute());
            return c.confirmarTransaccion(sapo);
        } catch (SQLException sQLException) {
            LOGGER.log(Level.INFO, "Excepci\u00f3n al Registrar producto: ---> {0}", sQLException);
        }
        return false;
    }

    /*
    UPDATE `inventariohogar`.`producto` SET `codBarras`='909089890', `descripcion`='YOGURT ALPINA 80ML', `marca`='ALPINA' WHERE `idProducto`='2';
UPDATE `inventariohogar`.`producto` SET `descripcion`='CARNE DE CERDO 500 GR' WHERE `idProducto`='1';
UPDATE `inventariohogar`.`producto` SET `codBarras`='909089890', `descripcion`='REGENERIS', `marca`='ALPINA', `modelo`='ALPINA', `serie`='ALPINA', `fabricante`='ALPINA', `fechaFabric`='2012-12-29', `loteFabric`='909LA' WHERE `idProducto`='3';

     */
    @Override
    public boolean modificarProducto(ProductoDTO p, Conexion c) {
        
        PreparedStatement ps;
        LOGGER.info("----PREPARANDO CONSULTA --- MODIFICAR PRODUCTO ---");
        Savepoint sapo = c.puntoRestauracion();
        try {
            LOGGER.info("INICIANDO CONSULTA -- MODIFICAR PRODUCTO ---");
            ps = c.crearConexion().prepareStatement("UPDATE `inventariohogar`.`producto` SET `idCategoria`=?, `codBarras`=?, `descripcion`=?, `marca`=?, `modelo`=?, `serie`=?, `fabricante`=?, `fechaFabric`=?, `loteFabric`=?, `fechaRegistro`=`fechaRegistro`, `estado`=?,`medida`=?, `stockMin`=?, `stockMax`=? WHERE `idProducto`=?;");
            ps.setInt(1, p.getIdCategoria());
            ps.setString(2, p.getCodBarras());
            ps.setString(3, p.getDescrip());
            ps.setString(4, p.getMarca());
            ps.setString(5, p.getModelo());
            ps.setString(6, p.getSerie());
            ps.setString(7, p.getFabrica());
            ps.setDate(8, p.getFechaFab());
            ps.setString(9, p.getLote());
            ps.setString(10, p.getEstado());
            ps.setString(11, p.getUnidadMedida());
            ps.setInt(12, p.getStockMin());
            ps.setInt(13, p.getStockMax());
            ps.setInt(14, p.getIdProducto());

            ps.executeUpdate();
            
            return c.confirmarTransaccion(sapo);

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, "------ Error Modificar Registro: --->", ex);

        }
        return false;
    }

    public int ultimoId(Conexion c) {
       
        Integer id = 0;
        PreparedStatement ps;
        ResultSet rs;
        try {
            LOGGER.info("\n-------------------------------\n PREPARANDO CONSULTA   ----> MAX ID TABLA  \n -------------------------------");
            ps = c.crearConexion().prepareStatement("select max(idProducto) from `inventariohogar`.`producto`");
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            
            ps.close();
            rs.close();
            c.cerrarConexion();
            c=null;
            LOGGER.fine("-------------------------------\n FIN CONSULTA   ----> MAX ID TABLA  \n -------------------------------");
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return id;
        }
    }

    @Override
    public boolean eliminarPorID(int id, Conexion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estadoProducto(boolean estado, Conexion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductoDTO buscarProductoId(int id, Conexion c) {
       
        PreparedStatement ps;
        ResultSet rs;
        ProductoDTO p = new ProductoDTO();

        try {
            LOGGER.info("----PREPARANDO CONSULTA --- BUSCAR PRODUCTO ---");
            ps = c.crearConexion().prepareStatement("select * from `inventariohogar`.`producto` where `idProducto` = ?");
            ps.setInt(1, id);
            ps.executeQuery();
            LOGGER.info("----CONSULTA EJECUTADA--- BUSCAR PRODUCTO ---");
            rs = ps.getResultSet();
            while (rs.next()) {
                p.setIdProducto(rs.getInt(1));
                p.setIdCategoria(rs.getInt(2));
                p.setCodBarras(rs.getString(3));
                p.setDescrip(rs.getString(4));
                p.setMarca(rs.getString(5));
                p.setModelo(rs.getString(6));
                p.setSerie(rs.getString(7));
                p.setFabrica(rs.getString(8));
                p.setFechaFab(rs.getDate(9));
                p.setLote(rs.getString(10));
                p.setFechaReg(rs.getTimestamp(11));
                p.setEstado(rs.getString(12));
                p.setUnidadMedida(rs.getString(13));
                p.setStockMin(rs.getInt(14));
                p.setStockMax(rs.getInt(15));
            }
            LOGGER.info("----CONSULTA EXITOSA--- BUSCAR PRODUCTO ---");
            ps.close();
            rs.close();
            c.cerrarConexion();
            c=null;
            return p;

        } catch (SQLException sQLException) {
            LOGGER.log(Level.SEVERE, "----- Error buscar Producto por ID -----", sQLException);
        }

        return p;
    }

    @Override
    public ProductoDTO buscarProductoCodBarra(int codBarra, Conexion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDTO> buscarProductoDescripcion(String busqueda, Conexion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDTO> buscarProductosEstado(boolean estado, Conexion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDTO> buscarProductosMarca(String busqueda, Conexion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDTO> buscarProductosModelo(String busqueda, Conexion c) {

        return null;

    }

    @Override
    public ArrayList<ProductoDTO> buscarProductosCategoria(String busqueda, Conexion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDTO> buscarProductosProveedor(String busqueda, Conexion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoDTO> mostrarProductos(Conexion c) {
        
        ArrayList<ProductoDTO> productos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        try {
            LOGGER.info("\n------------------------------------------\nRealizando Consulta en Tabla Producto - Metodo Mostrar Todos.\n -----------------------------------------");
            ps = c.crearConexion().prepareStatement("SELECT * FROM `inventariohogar`.`producto`;");
            ps.execute();

            rs = ps.getResultSet();
            while (rs.next()) {
                ProductoDTO p = new ProductoDTO();
                p.setIdProducto(rs.getInt(1));
                p.setIdCategoria(rs.getInt(2));
                p.setCodBarras(rs.getString(3));
                p.setDescrip(rs.getString(4));
                p.setMarca(rs.getString(5));
                p.setModelo(rs.getString(6));
                p.setSerie(rs.getString(7));
                p.setFabrica(rs.getString(8));
                p.setFechaFab(rs.getDate(9));
                p.setLote(rs.getString(10));
                p.setFechaReg(rs.getTimestamp(11));
                p.setEstado(rs.getString(12));
                p.setUnidadMedida(rs.getString(13));
                p.setStockMin(rs.getInt(14));
                p.setStockMax(rs.getInt(15));
                productos.add(p);

            }

            LOGGER.log(Level.INFO, "------- RESULTADO DE OBJETO: Esta VAC\u00cdO ---> {0}-------", productos.isEmpty());
            ps.close();
            rs.close();
            c.cerrarConexion();
            c=null;
            return productos;

        } catch (NullPointerException | SQLException sQLException) {
            LOGGER.log(Level.SEVERE, "----EXCEPCION: Mostrar todos los  productos. -----------\n", sQLException);
        }
        return productos;
    }

}
