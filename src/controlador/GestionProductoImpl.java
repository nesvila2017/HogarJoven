/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.interfaces.GestionProductoInterface;
import database.Conexion;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelo.dto.ProductoDTO;
import modelo.dao.ProductoDAOImpl;
import net.sourceforge.jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Code39;

/**
 *
 * @author Fucker
 */
public class GestionProductoImpl implements GestionProductoInterface {

    private ArrayList<ProductoDTO> contenedorProducto;
    private ProductoDAOImpl pdao = new ProductoDAOImpl();
    
    
    public GestionProductoImpl() {
        contenedorProducto = new ArrayList<>();
        //contenedorProducto.add(new Producto(1, 123, "Salchichon", "Porquerias", "Burro","Uña", "Vieja", "Jorge", "La Fama de Jorge"));
    }
    
    public BufferedImage generarCodigoBarras(int ancho, int alto, String codBarra){
        
        try {
            JBarcodeBean barcode = new JBarcodeBean();
            
            // nuestro tipo de codigo de barra
           // barcode.setCodeType(new Interleaved25());
            barcode.setCodeType(new Code39());
            
            // nuestro valor a codificar y algunas configuraciones mas
            barcode.setCode(codBarra);
            barcode.setCheckDigit(true);
            
            BufferedImage bufferedImage = barcode.draw(new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB));
            
            // guardar en disco como png
            File file = new File(codBarra+".png");
            ImageIO.write(bufferedImage, "png", file);
            return bufferedImage;
        } catch (IOException ex) {
            Logger.getLogger(GestionProductoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private boolean existeProducto(ProductoDTO p) {
        for (ProductoDTO producto : contenedorProducto) {
            if (producto.equals(p)) {
                return true;
            }
        }
        return false;
    }

    public boolean registroProductos(ProductoDTO p){
        Conexion c = null;
        c=c.generarConexion();
        if(busquedaProductoID(p.getIdProducto())!=null){
            return pdao.registrarProducto(p, c);
        }
        return false;
    }
    
    @Override
    public boolean registrarProducto(ProductoDTO p) {
        if (existeProducto(p)) {
            return false;
        } else {
            contenedorProducto.add(p);
            return true;
        }
    }

    @Override
    public ProductoDTO busquedaProductoID(int id) {
        Conexion c = null;
        c=c.generarConexion();
        return pdao.buscarProductoId(id,c);
    }
    
    public Integer ultimoId(){
        Conexion c = null;
        c=c.generarConexion();
        return pdao.ultimoId(c)+1;
    }

    @Override
    public ProductoDTO busquedaPorNombre(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarProducto(ProductoDTO p) {
        Conexion c = null;
        c=c.generarConexion();
        if(busquedaProductoID(p.getIdProducto())!=null){
            return pdao.modificarProducto(p,c);
        }
        return false;
    }

    @Override
    public boolean eliminarProducto(ProductoDTO p) {
        if (existeProducto(p)) {
            return contenedorProducto.remove(p);
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<ProductoDTO> mostrarProductos() {
        Conexion c=null;
        c=c.generarConexion();
        return pdao.mostrarProductos(c);
    }

}
