/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionCategoriaImpl;
import controlador.GestionProductoImpl;
import java.awt.Font;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import modelo.dto.CategoriaDTO;
import modelo.dto.ProductoDTO;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Fucker
 */
public class ProductoView extends javax.swing.JFrame {

    /**
     * Creates new form ProductoView
     *
     *
     */
    private GestionCategoriaImpl gc;
    private GestionProductoImpl gp;
    private static ProductoView iniciarProductoView;
    private static Logger LOGGER = Logger.getLogger(ProductoView.class.getName());

    private ProductoView() {
        gp = new GestionProductoImpl();
        gc = new GestionCategoriaImpl();

        setUndecorated(true);
        initComponents();

        setLocationRelativeTo(null);
        estadoIncial();
    }

    private void estadoIncial() {

        Date d = new Date();
        txtFechaReg.setDate(d);
        LOGGER.log(Level.INFO, "--------Ajuste Fecha Inicial:... >>>> \n {0}", d);
        txtDescrip.requestFocus();
        txtCodBarras.setEnabled(true);
        comboEstado.setSelectedIndex(1);
        try {
            llenarTabla();
            mostrarCategorias();
            txtIdProducto.setText(gp.ultimoId().toString());
        } catch (NullPointerException e) {
            LOGGER.log(Level.SEVERE, "Error en Carga de Informacion: --->", e);
            esconderInterfaz(e);
        }
        
        
    }

    private void esconderInterfaz(Exception e) {

        panelGeneral.setLayout(new AbsoluteLayout());
        panelGeneral.setBackground(java.awt.Color.darkGray);
        panelFormulario.setVisible(false);
        panelBotones.setVisible(false);
        tablaRegistros.setVisible(false);
        tituloLabel.setLocation(new Point(tituloLabel.getLocation().x, tituloLabel.getLocation().y + 250));
        tituloLabel.setText("La Base de Datos no se encuentra. :´( ");
        tituloLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 60));
        tituloLabel.setIcon(null);
        rotuloLabel.setSize(600, 300);
        rotuloLabel.setText("Error en Carga de Información: " + e.toString());

    }

    public void validacionCaracteres(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (Character.isDigit(c)) {
            getToolkit().beep();
            ke.consume();
        }
    }

    public void validacionNumeros(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            ke.consume();
        }
    }

    public static ProductoView inicializarProducto() {
        if (iniciarProductoView == null) {
            iniciarProductoView = new ProductoView();
            return iniciarProductoView;
        } else {
            return iniciarProductoView;
        }
    }

    private void mostrarCategorias() {
        LOGGER.info("------ Inicio de Muestreo de Categorias. ------");

        ArrayList<CategoriaDTO> categorias = gc.mostrarCategorias();
        for (CategoriaDTO categoria : categorias) {
            comboCategoria.addItem(categoria.getDescripCat());
        }
        LOGGER.info("------ Fin de Muestreo de Categorias. ------");
    }

    private boolean verificarExtension(File file) {
        LOGGER.log(Level.INFO, "Verificando Extensi\u00f3n Imagen: Nombre: {0} {1}", new Object[]{file.getName(), file.getAbsoluteFile()});
        final String[] okFileExtensions = new String[]{"jpg", "jpeg", "png"};
        for (String extension : okFileExtensions) {
            if (file.getName().toLowerCase().endsWith(extension)) {
                LOGGER.info("Extensión Aceptada.");
                return true;
            }
        }
        LOGGER.severe("Extensión No Aceptada.");
        return false;
    }

    private boolean tamanoArchivoPermitido(File file) {
        LOGGER.log(Level.INFO, "Verificando Tama\u00f1o Imagen: Nombre: {0} Tama\u00f1o: {1}", new Object[]{file.getName(), file.length()});
        if (file.length() > 2097152) {
            LOGGER.log(Level.INFO, "Tama\u00f1o Imagen Aceptado: Nombre: {0} Tama\u00f1o: {1}", new Object[]{file.getName(), file.length()});
            return false;
        }
        LOGGER.log(Level.INFO, "Tama\u00f1o Imagen No Aceptado: Nombre: {0} Tama\u00f1o: {1}", new Object[]{file.getName(), file.length()});
        return true;
    }

    private File imagenProducto() {
        LOGGER.info("Realizando Carga de Imagen...");
        JFileChooser filechoose = new JFileChooser();
        filechoose.showOpenDialog(this);
        File imagen = filechoose.getSelectedFile();
        BufferedImage imagenAjustada;
        if (tamanoArchivoPermitido(imagen)) {
            if (imagen != null && verificarExtension(imagen)) {
                System.out.println("Absolute path: " + imagen.toURI().normalize());
                try {
                    LOGGER.info("Colocando imagen...");
                    imagenAjustada = ImageIO.read(imagen);
                    imgSite.setIcon(new javax.swing.ImageIcon(imagenAjustada.getScaledInstance(imgSite.getWidth(), imgSite.getHeight(), Image.SCALE_DEFAULT)));
                } catch (IOException iOException) {
                    LOGGER.log(Level.SEVERE, "Error: {0}", iOException);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Imagen no soportada o no encontrada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El tamaño de la imagén excede los 2 MBs. Reduzca el tamaño de la imagen.");
        }
        return imagen;
    }

    private FileInputStream imagenBlob() {
        return null;
    }

    private void limpiar() {
        txtFechaReg.setDate(new Date());
        txtCodBarras.setText("");
        txtDescrip.setText("");
        txtDescrip.requestFocus();
        comboCategoria.setSelectedIndex(0);
        comboEstado.setSelectedIndex(1);
        spinMinStock.setValue(0);
        spinMaxStock.setValue(0);
        txtIdProducto.setText(gp.ultimoId().toString());
        labelCodBarra.setIcon(null);

    }

    private void llenarTabla() {

        ArrayList<ProductoDTO> productosRegistrados = gp.mostrarProductos();
        ArrayList<CategoriaDTO> cat = gc.mostrarCategorias();
        final String nombreColumnas[] = {"ID Producto", "Codigo Barras", "Fecha Registro", "Descripción", "Categoria", "Estado", "Unidad Medida", "Min. Stock", "Max. Stock"};
        LOGGER.info("\n---------Inicio de Llenado de Tabla--------\n");
        DefaultTableModel dtf = new DefaultTableModel(nombreColumnas, productosRegistrados.size());
        int j = 0;
        for (ProductoDTO p : productosRegistrados) {
            String categoria = "";
            for (CategoriaDTO c : cat ) {
                if (c.getIdCategoria().equals(p.getIdCategoria())) {
                    categoria = c.getDescripCat();
                }
            }
                
            
            dtf.setValueAt(p.getIdProducto(), j, 0);
            dtf.setValueAt(p.getCodBarras(), j, 1);
            dtf.setValueAt(p.getFechaReg(), j, 2);
            dtf.setValueAt(p.getDescrip(), j, 3);
            dtf.setValueAt(categoria, j, 4);
            dtf.setValueAt(p.getEstado(), j, 5);
            dtf.setValueAt(p.getUnidadMedida(), j, 6);
            dtf.setValueAt(p.getStockMin(), j, 7);
            dtf.setValueAt(p.getStockMax(), j, 8);
            j++;
        }

        LOGGER.info("\n---------Fin de Llenado de Tabla--------\n");
        tablaProductos.setModel(dtf);
        final int anchos[] = {10, 50, 100, 400, 70, 20, 10, 10, 10};

        for (int i = 0; i < tablaProductos.getColumnCount(); i++) {
            tablaProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    private boolean validarCampos() {
        if (txtIdProducto.getText().equals("") || txtFechaReg.getDate().equals("") || txtDescrip.getText().equals("") || comboCategoria.getSelectedIndex() == 0 || txtUnidad.getText().equals("") || spinMaxStock.equals(0) || spinMinStock.equals(0) || comboEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Los campos marcados con un '*' son obligatorios. \n Ingrese o seleccione la información correspondiente en cada uno.", "Error - Campos Vacios.", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    private void generarCodigoBarras() {
        final int ALTURA = 70;
        if (!validarCampos()) {
            JOptionPane.showMessageDialog(null, "Debe introducir la respectiva información en los campos ID, Descripcion, Categoría, Unidad de Medida y Fecha de Registro para generar el código de barras del ITEM.");
        } else {

            String codBarraGen = "";
            try {
                String descrip = txtDescrip.getText(0, 3).trim();
                String id = "0" + txtIdProducto.getText(0, 2).trim();
                String cat = comboCategoria.getSelectedItem().toString().substring(0, 3).trim();
                String unidMedida = txtUnidad.getText(0, 2).trim();
                codBarraGen = descrip + id + cat + unidMedida;
                txtCodBarras.setText(codBarraGen);
            } catch (BadLocationException ex) {
                Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            BufferedImage codBarra = gp.generarCodigoBarras(labelCodBarra.getWidth(), ALTURA, codBarraGen);

            labelCodBarra.setIcon(new javax.swing.ImageIcon(codBarra.getScaledInstance(imgSite.getWidth(), ALTURA, Image.SCALE_REPLICATE)));
        }
    }

    private String mayusculasCadena(String minus) {
        String mayus = minus.toUpperCase();
        return mayus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMinimized = new javax.swing.JLabel();
        btnRestore = new javax.swing.JLabel();
        btnMaximize = new javax.swing.JLabel();
        panelGeneral = new javax.swing.JPanel();
        tituloLabel = new javax.swing.JLabel();
        rotuloLabel = new javax.swing.JLabel();
        panelBotonesVentana = new javax.swing.JPanel();
        btnMaximize1 = new javax.swing.JLabel();
        btnRestore1 = new javax.swing.JLabel();
        btnMinimized1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        tablaRegistros = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        panelBotones = new javax.swing.JPanel();
        btnModificarProducto = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnInventario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnModificarProducto1 = new javax.swing.JButton();
        panelFormulario = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        txtFechaReg = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarID = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDescrip = new javax.swing.JTextField();
        txtCodBarras = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        spinMinStock = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        spinMaxStock = new javax.swing.JSpinner();
        txtUnidad = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        imgSite = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        labelCodBarra = new javax.swing.JLabel();
        btnModificarProducto3 = new javax.swing.JButton();
        btnModificarProducto4 = new javax.swing.JButton();
        btnModificarProducto5 = new javax.swing.JButton();
        btnCodBarras = new javax.swing.JButton();

        btnMinimized.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Minimize_Window_38px_1.png"))); // NOI18N
        btnMinimized.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizedMouseClicked(evt);
            }
        });

        btnRestore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Maximize_Window_38px.png"))); // NOI18N
        btnRestore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRestoreMouseClicked(evt);
            }
        });

        btnMaximize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Maximize_Window_48px_1.png"))); // NOI18N
        btnMaximize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaximizeMouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setFocusCycleRoot(false);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1217, 428));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        panelGeneral.setBackground(new java.awt.Color(4, 0, 16));

        tituloLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 36)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(204, 204, 204));
        tituloLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Open_Box_96px.png"))); // NOI18N
        tituloLabel.setText("Administración de Catalogo de Productos");

        rotuloLabel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        rotuloLabel.setForeground(new java.awt.Color(153, 153, 153));
        rotuloLabel.setText("Administración del ingreso de productos e insumos que utiliza el personal y las usuarias del Hogar de la Joven");

        panelBotonesVentana.setOpaque(false);

        btnMaximize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Maximize_Window_48px_1.png"))); // NOI18N
        btnMaximize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMaximize1MouseClicked(evt);
            }
        });

        btnRestore1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Maximize_Window_38px.png"))); // NOI18N
        btnRestore1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRestore1MouseClicked(evt);
            }
        });

        btnMinimized1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Minimize_Window_38px_1.png"))); // NOI18N
        btnMinimized1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimized1MouseClicked(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(51, 51, 51));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Cancel_48px.png"))); // NOI18N
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setFocusPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelBotonesVentanaLayout = new org.jdesktop.layout.GroupLayout(panelBotonesVentana);
        panelBotonesVentana.setLayout(panelBotonesVentanaLayout);
        panelBotonesVentanaLayout.setHorizontalGroup(
            panelBotonesVentanaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelBotonesVentanaLayout.createSequentialGroup()
                .addContainerGap()
                .add(btnMinimized1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnRestore1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnMaximize1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton10)
                .addContainerGap())
        );
        panelBotonesVentanaLayout.setVerticalGroup(
            panelBotonesVentanaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelBotonesVentanaLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelBotonesVentanaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButton10)
                    .add(panelBotonesVentanaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(btnMaximize1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnMinimized1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, btnRestore1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tablaRegistros.setAutoscrolls(true);
        tablaRegistros.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        tablaRegistros.setOpaque(false);

        tablaProductos.setAutoCreateRowSorter(true);
        tablaProductos.setBackground(new java.awt.Color(255, 255, 255));
        tablaProductos.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        tablaProductos.setForeground(new java.awt.Color(51, 51, 51));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaProductos.setToolTipText("");
        tablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaProductos.setDoubleBuffered(true);
        tablaProductos.setGridColor(new java.awt.Color(153, 153, 153));
        tablaProductos.setSelectionForeground(new java.awt.Color(40, 40, 40));
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        tablaRegistros.setViewportView(tablaProductos);

        panelBotones.setOpaque(false);

        btnModificarProducto.setBackground(new java.awt.Color(0, 102, 204));
        btnModificarProducto.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        btnModificarProducto.setForeground(new java.awt.Color(204, 204, 204));
        btnModificarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Product_48px.png"))); // NOI18N
        btnModificarProducto.setText("Modificar Producto");
        btnModificarProducto.setBorder(null);
        btnModificarProducto.setBorderPainted(false);
        btnModificarProducto.setContentAreaFilled(false);
        btnModificarProducto.setDoubleBuffered(true);
        btnModificarProducto.setFocusable(false);
        btnModificarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarProducto.setIconTextGap(0);
        btnModificarProducto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnModificarProducto.setOpaque(true);
        btnModificarProducto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0, 102, 204));
        btnAgregar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 204, 204));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_New_Product_48px.png"))); // NOI18N
        btnAgregar.setText("Registrar Producto");
        btnAgregar.setBorder(null);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setIconTextGap(0);
        btnAgregar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAgregar.setNextFocusableComponent(btnNuevo);
        btnAgregar.setOpaque(true);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        btnInventario.setBackground(new java.awt.Color(255, 220, 0));
        btnInventario.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(204, 204, 204));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Robot_48px.png"))); // NOI18N
        btnInventario.setText("Ver Inventario");
        btnInventario.setBorder(null);
        btnInventario.setBorderPainted(false);
        btnInventario.setContentAreaFilled(false);
        btnInventario.setFocusable(false);
        btnInventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInventario.setIconTextGap(0);
        btnInventario.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnInventario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnInventario, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(btnInventario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(19, 19, 19))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(195, 73));

        btnModificarProducto1.setBackground(new java.awt.Color(0, 102, 204));
        btnModificarProducto1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        btnModificarProducto1.setForeground(new java.awt.Color(204, 204, 204));
        btnModificarProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Garbage_Truck_48px.png"))); // NOI18N
        btnModificarProducto1.setText("Ejecutar Baja");
        btnModificarProducto1.setBorder(null);
        btnModificarProducto1.setBorderPainted(false);
        btnModificarProducto1.setContentAreaFilled(false);
        btnModificarProducto1.setDoubleBuffered(true);
        btnModificarProducto1.setFocusable(false);
        btnModificarProducto1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarProducto1.setIconTextGap(0);
        btnModificarProducto1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnModificarProducto1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnModificarProducto1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnModificarProducto1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout panelBotonesLayout = new org.jdesktop.layout.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnAgregar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnModificarProducto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnModificarProducto)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFormulario.setOpaque(false);

        jPanel4.setOpaque(false);

        comboCategoria.setBackground(new java.awt.Color(22, 29, 64));
        comboCategoria.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        comboCategoria.setForeground(new java.awt.Color(51, 51, 51));
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la categoria" }));
        comboCategoria.setBorder(null);
        comboCategoria.setDoubleBuffered(true);
        comboCategoria.setKeySelectionManager(null);
        comboCategoria.setName(""); // NOI18N
        comboCategoria.setNextFocusableComponent(txtUnidad);
        comboCategoria.setOpaque(false);
        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Fecha Registro:*");

        txtIdProducto.setBackground(new java.awt.Color(22, 29, 64));
        txtIdProducto.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        txtIdProducto.setForeground(new java.awt.Color(204, 204, 204));
        txtIdProducto.setBorder(null);
        txtIdProducto.setCaretColor(new java.awt.Color(153, 255, 0));
        txtIdProducto.setDoubleBuffered(true);
        txtIdProducto.setFocusCycleRoot(true);
        txtIdProducto.setMinimumSize(new java.awt.Dimension(22, 22));
        txtIdProducto.setNextFocusableComponent(txtDescrip);
        txtIdProducto.setPreferredSize(new java.awt.Dimension(22, 22));
        txtIdProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdProductoMouseClicked(evt);
            }
        });
        txtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyTyped(evt);
            }
        });

        txtFechaReg.setBackground(new java.awt.Color(22, 29, 64));
        txtFechaReg.setFocusable(false);
        txtFechaReg.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        txtFechaReg.setMinimumSize(new java.awt.Dimension(50, 24));
        txtFechaReg.setOpaque(false);
        txtFechaReg.setPreferredSize(new java.awt.Dimension(132, 24));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 102));
        jLabel3.setText("Categoria: *");

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 102));
        jLabel1.setText("ID Producto:*");

        btnBuscarID.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        btnBuscarID.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Search_25px.png"))); // NOI18N
        btnBuscarID.setBorder(null);
        btnBuscarID.setBorderPainted(false);
        btnBuscarID.setContentAreaFilled(false);
        btnBuscarID.setFocusPainted(false);
        btnBuscarID.setFocusable(false);
        btnBuscarID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIDActionPerformed(evt);
            }
        });

        btnCategorias.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        btnCategorias.setForeground(new java.awt.Color(255, 255, 255));
        btnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Add_Tag_25px.png"))); // NOI18N
        btnCategorias.setBorder(null);
        btnCategorias.setBorderPainted(false);
        btnCategorias.setContentAreaFilled(false);
        btnCategorias.setFocusable(false);
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 102));
        jLabel2.setText("Descripcion: *");

        txtDescrip.setBackground(new java.awt.Color(22, 29, 64));
        txtDescrip.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        txtDescrip.setForeground(new java.awt.Color(204, 204, 204));
        txtDescrip.setBorder(null);
        txtDescrip.setCaretColor(new java.awt.Color(153, 255, 0));
        txtDescrip.setDoubleBuffered(true);
        txtDescrip.setFocusCycleRoot(true);
        txtDescrip.setMaximumSize(new java.awt.Dimension(22, 22));
        txtDescrip.setMinimumSize(new java.awt.Dimension(22, 22));
        txtDescrip.setNextFocusableComponent(comboCategoria);
        txtDescrip.setPreferredSize(new java.awt.Dimension(22, 22));
        txtDescrip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripKeyReleased(evt);
            }
        });

        txtCodBarras.setEditable(false);
        txtCodBarras.setBackground(new java.awt.Color(22, 29, 64));
        txtCodBarras.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        txtCodBarras.setForeground(new java.awt.Color(204, 204, 204));
        txtCodBarras.setBorder(null);
        txtCodBarras.setCaretColor(new java.awt.Color(153, 255, 0));
        txtCodBarras.setDisabledTextColor(new java.awt.Color(255, 204, 0));
        txtCodBarras.setDoubleBuffered(true);
        txtCodBarras.setFocusCycleRoot(true);
        txtCodBarras.setMaximumSize(new java.awt.Dimension(22, 22));
        txtCodBarras.setMinimumSize(new java.awt.Dimension(22, 22));
        txtCodBarras.setName(""); // NOI18N
        txtCodBarras.setPreferredSize(new java.awt.Dimension(80, 22));
        txtCodBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodBarrasActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 204, 204));
        jLabel20.setText("Unidad Medida:");

        jLabel18.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Stock Mínimo:");

        spinMinStock.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        spinMinStock.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinMinStock.setBorder(null);
        spinMinStock.setDoubleBuffered(true);
        spinMinStock.setNextFocusableComponent(spinMaxStock);
        spinMinStock.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Máximo:");

        spinMaxStock.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        spinMaxStock.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinMaxStock.setBorder(null);
        spinMaxStock.setDoubleBuffered(true);
        spinMaxStock.setNextFocusableComponent(btnAgregar);
        spinMaxStock.setOpaque(false);

        txtUnidad.setBackground(new java.awt.Color(22, 29, 64));
        txtUnidad.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        txtUnidad.setForeground(new java.awt.Color(204, 204, 204));
        txtUnidad.setBorder(null);
        txtUnidad.setCaretColor(new java.awt.Color(153, 255, 0));
        txtUnidad.setDoubleBuffered(true);
        txtUnidad.setFocusCycleRoot(true);
        txtUnidad.setMaximumSize(new java.awt.Dimension(22, 22));
        txtUnidad.setMinimumSize(new java.awt.Dimension(22, 22));
        txtUnidad.setName(""); // NOI18N
        txtUnidad.setNextFocusableComponent(spinMinStock);
        txtUnidad.setPreferredSize(new java.awt.Dimension(80, 22));
        txtUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUnidadKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Estado:");

        comboEstado.setBackground(new java.awt.Color(22, 29, 64));
        comboEstado.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        comboEstado.setForeground(new java.awt.Color(51, 51, 51));
        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el Estado", "Disponible", "No Disponible" }));
        comboEstado.setBorder(null);
        comboEstado.setDoubleBuffered(true);
        comboEstado.setFocusCycleRoot(true);
        comboEstado.setName(""); // NOI18N
        comboEstado.setNextFocusableComponent(txtUnidad);
        comboEstado.setOpaque(false);

        jLabel22.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Codigo Barras:");

        btnNuevo.setBackground(new java.awt.Color(0, 102, 204));
        btnNuevo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(204, 204, 204));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Product_25px.png"))); // NOI18N
        btnNuevo.setText("Nuevo Producto");
        btnNuevo.setBorder(null);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setFocusable(false);
        btnNuevo.setOpaque(true);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jLabel18)
                                .add(32, 32, 32))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4Layout.createSequentialGroup()
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel22)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel21))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(txtCodBarras, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jLabel20)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(txtUnidad, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(comboEstado, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jPanel4Layout.createSequentialGroup()
                                        .add(spinMinStock)
                                        .add(18, 18, 18)
                                        .add(jLabel19)
                                        .add(18, 18, 18)
                                        .add(spinMaxStock)))
                                .add(2, 2, 2)))
                        .add(2, 2, 2))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(txtIdProducto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(txtDescrip, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnBuscarID))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jLabel11)
                        .add(18, 18, 18)
                        .add(txtFechaReg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnNuevo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(51, 51, 51)
                        .add(comboCategoria, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCategorias)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(8, 8, 8)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(txtFechaReg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnNuevo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel1)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(txtIdProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnBuscarID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtDescrip, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel3)
                        .add(comboCategoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(btnCategorias, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtCodBarras, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtUnidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel18)
                    .add(jLabel19)
                    .add(spinMaxStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(spinMinStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(comboEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 51, 0));

        jButton1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Add_Image_48px.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setMargin(new java.awt.Insets(14, 14, 14, 14));
        jButton1.setMaximumSize(new java.awt.Dimension(110, 35));
        jButton1.setMinimumSize(new java.awt.Dimension(110, 35));
        jButton1.setPreferredSize(new java.awt.Dimension(110, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 51, 51));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Edit_Image_48px.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusPainted(false);
        jButton9.setFocusable(false);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        imgSite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgSite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Full_Image_96px.png"))); // NOI18N
        imgSite.setDoubleBuffered(true);
        imgSite.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(51, 51, 51));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Remove_Image_48px.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 34, Short.MAX_VALUE)
                .add(jButton9)
                .add(32, 32, 32)
                .add(jButton8)
                .addContainerGap())
            .add(imgSite, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(imgSite, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 177, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton8)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton9)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel9.setOpaque(false);

        labelCodBarra.setBackground(new java.awt.Color(102, 102, 102));
        labelCodBarra.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        labelCodBarra.setForeground(new java.awt.Color(255, 255, 255));
        labelCodBarra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCodBarra.setIconTextGap(0);
        labelCodBarra.setMaximumSize(new java.awt.Dimension(350, 71));
        labelCodBarra.setMinimumSize(new java.awt.Dimension(350, 71));
        labelCodBarra.setPreferredSize(new java.awt.Dimension(350, 71));

        btnModificarProducto3.setBackground(new java.awt.Color(0, 102, 204));
        btnModificarProducto3.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        btnModificarProducto3.setForeground(new java.awt.Color(204, 204, 204));
        btnModificarProducto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Post_Office_48px.png"))); // NOI18N
        btnModificarProducto3.setBorder(null);
        btnModificarProducto3.setBorderPainted(false);
        btnModificarProducto3.setContentAreaFilled(false);
        btnModificarProducto3.setDoubleBuffered(true);
        btnModificarProducto3.setFocusable(false);
        btnModificarProducto3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarProducto3.setIconTextGap(0);
        btnModificarProducto3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnModificarProducto3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificarProducto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProducto3ActionPerformed(evt);
            }
        });

        btnModificarProducto4.setBackground(new java.awt.Color(0, 102, 204));
        btnModificarProducto4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        btnModificarProducto4.setForeground(new java.awt.Color(204, 204, 204));
        btnModificarProducto4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Microsoft_Excel_48px.png"))); // NOI18N
        btnModificarProducto4.setBorder(null);
        btnModificarProducto4.setBorderPainted(false);
        btnModificarProducto4.setContentAreaFilled(false);
        btnModificarProducto4.setDoubleBuffered(true);
        btnModificarProducto4.setFocusable(false);
        btnModificarProducto4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarProducto4.setIconTextGap(0);
        btnModificarProducto4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnModificarProducto4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnModificarProducto5.setBackground(new java.awt.Color(0, 102, 204));
        btnModificarProducto5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        btnModificarProducto5.setForeground(new java.awt.Color(204, 204, 204));
        btnModificarProducto5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_PDF_48px_1.png"))); // NOI18N
        btnModificarProducto5.setBorder(null);
        btnModificarProducto5.setBorderPainted(false);
        btnModificarProducto5.setContentAreaFilled(false);
        btnModificarProducto5.setDoubleBuffered(true);
        btnModificarProducto5.setFocusable(false);
        btnModificarProducto5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarProducto5.setIconTextGap(0);
        btnModificarProducto5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnModificarProducto5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnCodBarras.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnCodBarras.setForeground(new java.awt.Color(204, 204, 204));
        btnCodBarras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Barcode_Scanner_48px.png"))); // NOI18N
        btnCodBarras.setAlignmentY(0.0F);
        btnCodBarras.setBorder(null);
        btnCodBarras.setBorderPainted(false);
        btnCodBarras.setContentAreaFilled(false);
        btnCodBarras.setFocusPainted(false);
        btnCodBarras.setFocusable(false);
        btnCodBarras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCodBarras.setIconTextGap(0);
        btnCodBarras.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCodBarras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCodBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodBarrasActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(labelCodBarra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(9, Short.MAX_VALUE))
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(btnModificarProducto5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnModificarProducto4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnModificarProducto3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCodBarras, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(labelCodBarra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnModificarProducto5)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnModificarProducto4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnModificarProducto3)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnCodBarras))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout panelFormularioLayout = new org.jdesktop.layout.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelFormularioLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .add(panelFormularioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(panelFormularioLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(0, 13, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout panelGeneralLayout = new org.jdesktop.layout.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelGeneralLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(panelBotonesVentana, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(panelGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .add(panelGeneralLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelGeneralLayout.createSequentialGroup()
                        .add(panelGeneralLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(panelGeneralLayout.createSequentialGroup()
                                .add(42, 42, 42)
                                .add(panelGeneralLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(tituloLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(panelGeneralLayout.createSequentialGroup()
                                        .add(14, 14, 14)
                                        .add(rotuloLabel)
                                        .add(0, 0, Short.MAX_VALUE)))
                                .add(59, 59, 59))
                            .add(panelGeneralLayout.createSequentialGroup()
                                .add(panelFormulario, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                        .add(panelBotones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(23, 23, 23))
                    .add(tablaRegistros))
                .addContainerGap())
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelGeneralLayout.createSequentialGroup()
                .add(panelGeneralLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(panelGeneralLayout.createSequentialGroup()
                        .add(tituloLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(rotuloLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(21, 21, 21)
                        .add(panelFormulario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(panelGeneralLayout.createSequentialGroup()
                        .add(panelBotonesVentana, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(48, 48, 48)
                        .add(panelBotones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(tablaRegistros, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelGeneral, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(panelGeneral, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizedMouseClicked
        setExtendedState(ProductoView.ICONIFIED);
    }//GEN-LAST:event_btnMinimizedMouseClicked

    private void btnRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestoreMouseClicked
        setExtendedState(ProductoView.NORMAL);
    }//GEN-LAST:event_btnRestoreMouseClicked

    private void btnMaximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizeMouseClicked
        setExtendedState(ProductoView.MAXIMIZED_BOTH);
    }//GEN-LAST:event_btnMaximizeMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnMinimized1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimized1MouseClicked
        setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimized1MouseClicked

    private void btnRestore1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestore1MouseClicked
        setExtendedState(this.NORMAL);
    }//GEN-LAST:event_btnRestore1MouseClicked

    private void btnMaximize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximize1MouseClicked
        setExtendedState(ProductoView.MAXIMIZED_BOTH);
    }//GEN-LAST:event_btnMaximize1MouseClicked

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked

        ProductoDTO p = new ProductoDTO();
        p.setIdProducto((Integer) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0));
        p.setCodBarras((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 1));
        p.setFechaReg((Timestamp) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2));
        p.setDescrip((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 3));
        String categoria = (String) (tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 4));
        p.setEstado((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5));
        p.setUnidadMedida((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 6).toString());
        p.setStockMin((Integer) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 7));
        p.setStockMax((Integer) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 8));

        txtIdProducto.setText(p.getIdProducto().toString());
        txtCodBarras.setText(p.getCodBarras());
        txtDescrip.setText(p.getDescrip());
        comboCategoria.setSelectedItem(categoria);
        txtFechaReg.setDate(p.getFechaReg());
        txtUnidad.setText(p.getUnidadMedida());
        spinMinStock.setValue(p.getStockMin());
        spinMaxStock.setValue(p.getStockMax());
        comboEstado.setSelectedItem(p.getEstado());

        generarCodigoBarras();
    }//GEN-LAST:event_tablaProductosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (validarCampos()) {
            ProductoDTO p = new ProductoDTO();

            p.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
            p.setIdCategoria(comboCategoria.getSelectedIndex());
            p.setDescrip(txtDescrip.getText());
            p.setUnidadMedida(txtUnidad.getText());
            p.setEstado(comboEstado.getSelectedItem().toString());
            p.setStockMin((Integer) spinMinStock.getValue());
            p.setStockMax((Integer) spinMaxStock.getValue());
            if (!txtCodBarras.getText().equals("")) {
                p.setCodBarras(txtCodBarras.getText());

            } else {
                if (JOptionPane.showConfirmDialog(null, "¿Desea Generar Código de Barras para este ITEM?.", "Generación de Código de Barras", JOptionPane.YES_NO_OPTION) == 1) {
                    generarCodigoBarras();
                }
            }

            gp.registroProductos(p);

            JOptionPane.showMessageDialog(null, "Se ha registrado el producto exitosamente.", "Registro Exitoso.", JOptionPane.INFORMATION_MESSAGE);

            llenarTabla();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "No se realizó el registro del producto. Intente de nuevo. Verifíque la información ingresada. ", "Error al Agregar Producto", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed

        if (validarCampos()) {
            LOGGER.info("Realizando Modificacion de Producto. -------->");
            ProductoDTO p = new ProductoDTO();

            p.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
            p.setIdCategoria(comboCategoria.getSelectedIndex());
            p.setDescrip(txtDescrip.getText());
            p.setUnidadMedida(txtUnidad.getText());
            p.setEstado(comboEstado.getSelectedItem().toString());
            p.setStockMin((Integer) spinMinStock.getValue());
            p.setStockMax((Integer) spinMaxStock.getValue());

            if (!txtCodBarras.getText().equals("")) {
                p.setCodBarras(txtCodBarras.getText());
            } else {
                if (JOptionPane.showConfirmDialog(null, "¿Desea Generar Código de Barras para este ITEM?.", "Generación de Código de Barras", JOptionPane.YES_NO_OPTION) == 1) {
                    generarCodigoBarras();

                }
            }

            System.out.println("Estado transaccion:" + gp.modificarProducto(p));

            System.out.println("Objeto modificado: " + p.toString());
            LOGGER.info("MODIFICACION TERMINADA!! ");
            JOptionPane.showMessageDialog(null, "Se ha Modificado la información del producto exitosamente.", "Registro Exitoso.", JOptionPane.INFORMATION_MESSAGE);
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No se realizó la modificación de la información del producto. Intente de nuevo. Verifíque la información ingresada. ", "Error al Agregar Producto", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed

        InventarioView iv = null;
        iv = iv.inicializarInventario();
        iv.setVisible(true);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imagenProducto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        CategoriaView cv = null;
        cv = cv.inicializarCategoriaView();
        cv.setVisible(true);
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnBuscarIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIDActionPerformed
        int id = Integer.parseInt(txtIdProducto.getText());
        ProductoDTO p = gp.busquedaProductoID(id);
        LOGGER.log(Level.INFO, "Busqueda Realizada: ---> Resultado -->{0}", p.toString());
        txtIdProducto.setText(p.getIdProducto().toString());
        txtCodBarras.setText(p.getCodBarras());
        txtDescrip.setText(p.getDescrip());
        comboCategoria.setSelectedIndex(p.getIdCategoria());
        txtFechaReg.setDate(p.getFechaReg());

    }//GEN-LAST:event_btnBuscarIDActionPerformed

    private void btnCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodBarrasActionPerformed
        generarCodigoBarras();
    }//GEN-LAST:event_btnCodBarrasActionPerformed

    private void txtIdProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyTyped
        validacionNumeros(evt);
    }//GEN-LAST:event_txtIdProductoKeyTyped

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void txtCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodBarrasActionPerformed


    }//GEN-LAST:event_txtCodBarrasActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtDescripKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripKeyReleased
        txtDescrip.setText(mayusculasCadena(txtDescrip.getText()));
    }//GEN-LAST:event_txtDescripKeyReleased

    private void txtUnidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadKeyReleased
        validacionCaracteres(evt);
        txtUnidad.setText(mayusculasCadena(txtUnidad.getText()));
    }//GEN-LAST:event_txtUnidadKeyReleased

    private void txtIdProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdProductoMouseClicked
        txtIdProducto.setText("");

    }//GEN-LAST:event_txtIdProductoMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        setLocation(MouseInfo.getPointerInfo().getLocation());
    }//GEN-LAST:event_formMouseDragged

    private void btnModificarProducto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProducto3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarProducto3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new ProductoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscarID;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnCodBarras;
    private javax.swing.JButton btnInventario;
    private javax.swing.JLabel btnMaximize;
    private javax.swing.JLabel btnMaximize1;
    private javax.swing.JLabel btnMinimized;
    private javax.swing.JLabel btnMinimized1;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JButton btnModificarProducto1;
    private javax.swing.JButton btnModificarProducto3;
    private javax.swing.JButton btnModificarProducto4;
    private javax.swing.JButton btnModificarProducto5;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel btnRestore;
    private javax.swing.JLabel btnRestore1;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JLabel imgSite;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labelCodBarra;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelBotonesVentana;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JLabel rotuloLabel;
    private javax.swing.JSpinner spinMaxStock;
    private javax.swing.JSpinner spinMinStock;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JScrollPane tablaRegistros;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JTextField txtCodBarras;
    private javax.swing.JTextField txtDescrip;
    private com.toedter.calendar.JDateChooser txtFechaReg;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtUnidad;
    // End of variables declaration//GEN-END:variables
}
