/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GestionProducto;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.Producto;

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
    private GestionProducto gp;

    public ProductoView() {
        gp = new GestionProducto();
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        setUndecorated(false);
        initComponents();
        llenarTabla();
        llenadoComboBox();
        setLocationRelativeTo(null);
        estadoIncial();
        

    }

    
    

    private boolean acceptExtension(File file) {
        final String[] okFileExtensions = new String[] { "jpg", "jpeg", "png" };
        for (String extension : okFileExtensions) {
            if (file.getName().toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean tamanoArchivoPermitido(File file){
        if (file.length()>2097152) {
            return false;
        }
        return true;
    }

    private void imagenProducto(){
        JFileChooser filechoose = new JFileChooser();
        filechoose.showOpenDialog(this);
        File imagen = filechoose.getSelectedFile();
        if(tamanoArchivoPermitido(imagen)){
        if (imagen != null && acceptExtension(imagen)) {
            System.out.println("Absolute path: "+imagen.toURI().normalize());
            BufferedImage imagenAjustada;
           
            try {
                imagenAjustada = ImageIO.read(imagen);
                imgSite.setIcon(new javax.swing.ImageIcon(imagenAjustada.getScaledInstance(imgSite.getWidth(), imgSite.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException iOException) {
                System.out.println("Error: "+ iOException);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Imagen no soportada o no encontrada.");
        }
        }else{
            JOptionPane.showMessageDialog(null, "El tamaño de la imagén excede los 2 MBs. Reduzca el tamaño de la imagen.");
        }
    }
    
    private void limpiar(){
        txtFecha.setDate(new Date());
        txtCodBarras.setText("");
        txtFabrica.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtSerie.setText("");
        txtIdProducto.setText("");
        comboCategoria.setSelectedIndex(0);
        comboProveedor.setSelectedIndex(1);
    }
    
    private void estadoIncial() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = new Date();
        System.out.println("Hora Hoy: " + sdf.format(d.getTime()));
        txtIdProducto.requestFocus();
        txtFecha.setDate(d);
        txtCodBarras.setEnabled(false);
        txtFabrica.setEnabled(false);
        txtMarca.setEnabled(false);
        txtModelo.setEnabled(false);
        txtSerie.setEnabled(false);
    }

    private void llenadoComboBox() {
        comboCategoria.addItem("COMIDA");
        comboProveedor.addItem("WILTER EDUARDO");
    }

    private void llenarTabla() {
        ArrayList<Producto> productosRegistrados = gp.mostrarProductos();
        String nombreColumnas[] = {"ID Producto", "Codigo Barras", "Descripción", "Categoria","Marca", "Modelo", "Serie", "Proveedor", "Fabricante"};
        DefaultTableModel dtf = new DefaultTableModel(nombreColumnas, productosRegistrados.size());
        for (int i = 0; i < productosRegistrados.size(); i++) {
            dtf.setValueAt(productosRegistrados.get(i).getIdProducto(), i, 0);
            dtf.setValueAt(productosRegistrados.get(i).getCodBarras(), i, 1);
            dtf.setValueAt(productosRegistrados.get(i).getDescrip(), i, 2);
            dtf.setValueAt(productosRegistrados.get(i).getCategoria(), i, 3);
            dtf.setValueAt(productosRegistrados.get(i).getMarca(), i, 4);
            dtf.setValueAt(productosRegistrados.get(i).getModelo(), i, 5);
            dtf.setValueAt(productosRegistrados.get(i).getSerie(), i, 6);
            dtf.setValueAt(productosRegistrados.get(i).getProveed(), i, 7);
            dtf.setValueAt(productosRegistrados.get(i).getFabrica(), i, 8);
        }

        tablaProductos.setModel(dtf);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        comboCategoria = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();
        txtFabrica = new javax.swing.JTextField();
        comboProveedor = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        checkMarca = new javax.swing.JCheckBox();
        checkModelo = new javax.swing.JCheckBox();
        checkSerie = new javax.swing.JCheckBox();
        checkProvider = new javax.swing.JCheckBox();
        checkFabrica = new javax.swing.JCheckBox();
        txtCodBarras = new javax.swing.JTextField();
        checkCodigo = new javax.swing.JCheckBox();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textDescrip = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        imgSite = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setMinimumSize(new java.awt.Dimension(1217, 428));
        setResizable(false);
        setSize(new java.awt.Dimension(1217, 428));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(446, 483));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 102));
        jLabel1.setText("ID Producto:*");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 102));
        jLabel2.setText("Descripcion: *");

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 102));
        jLabel3.setText("Categoria: *");

        txtIdProducto.setBackground(java.awt.Color.white);
        txtIdProducto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtIdProducto.setBorder(null);
        txtIdProducto.setMinimumSize(new java.awt.Dimension(22, 24));
        txtIdProducto.setPreferredSize(new java.awt.Dimension(22, 24));

        comboCategoria.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la categoria" }));
        comboCategoria.setBorder(null);
        comboCategoria.setFocusable(false);
        comboCategoria.setOpaque(false);

        jButton2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Search_25px.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);

        btnAgregar.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_New_Product_48px.png"))); // NOI18N
        btnAgregar.setText("Agregar Producto");
        btnAgregar.setBorder(null);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setFocusPainted(false);
        btnAgregar.setFocusable(false);
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnAgregar.setIconTextGap(10);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Product_48px.png"))); // NOI18N
        jButton4.setText("Modificar");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setDoubleBuffered(true);
        jButton4.setFocusable(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton4.setIconTextGap(10);

        txtMarca.setBackground(java.awt.Color.white);
        txtMarca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(51, 51, 51));
        txtMarca.setBorder(null);
        txtMarca.setMinimumSize(new java.awt.Dimension(22, 24));
        txtMarca.setPreferredSize(new java.awt.Dimension(22, 24));

        txtModelo.setBackground(java.awt.Color.white);
        txtModelo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(51, 51, 51));
        txtModelo.setBorder(null);
        txtModelo.setMinimumSize(new java.awt.Dimension(22, 24));
        txtModelo.setPreferredSize(new java.awt.Dimension(22, 24));

        txtSerie.setBackground(java.awt.Color.white);
        txtSerie.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSerie.setForeground(new java.awt.Color(51, 51, 51));
        txtSerie.setBorder(null);
        txtSerie.setMinimumSize(new java.awt.Dimension(22, 24));
        txtSerie.setPreferredSize(new java.awt.Dimension(22, 24));

        txtFabrica.setBackground(java.awt.Color.white);
        txtFabrica.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFabrica.setForeground(new java.awt.Color(51, 51, 51));
        txtFabrica.setBorder(null);
        txtFabrica.setMinimumSize(new java.awt.Dimension(22, 24));
        txtFabrica.setPreferredSize(new java.awt.Dimension(22, 24));

        comboProveedor.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        comboProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el proveedor" }));
        comboProveedor.setFocusable(false);
        comboProveedor.setOpaque(false);

        jButton6.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Supplier_25px_1.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Fecha Registro:*");

        jButton7.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Robot_48px.png"))); // NOI18N
        jButton7.setText("Ver Inventario");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton7.setIconTextGap(10);

        checkMarca.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkMarca.setForeground(new java.awt.Color(255, 255, 255));
        checkMarca.setText("Marca:");
        checkMarca.setFocusable(false);
        checkMarca.setOpaque(false);
        checkMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMarcaActionPerformed(evt);
            }
        });

        checkModelo.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkModelo.setForeground(new java.awt.Color(255, 255, 255));
        checkModelo.setText("Modelo:");
        checkModelo.setFocusable(false);
        checkModelo.setOpaque(false);
        checkModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkModeloActionPerformed(evt);
            }
        });

        checkSerie.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkSerie.setForeground(new java.awt.Color(255, 255, 255));
        checkSerie.setText("Serie:");
        checkSerie.setFocusable(false);
        checkSerie.setOpaque(false);
        checkSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSerieActionPerformed(evt);
            }
        });

        checkProvider.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkProvider.setForeground(new java.awt.Color(255, 0, 102));
        checkProvider.setText("Proveedor:*");
        checkProvider.setFocusable(false);
        checkProvider.setOpaque(false);
        checkProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkProviderActionPerformed(evt);
            }
        });

        checkFabrica.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkFabrica.setForeground(new java.awt.Color(255, 255, 255));
        checkFabrica.setText("Fabricante:");
        checkFabrica.setFocusable(false);
        checkFabrica.setOpaque(false);
        checkFabrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFabricaActionPerformed(evt);
            }
        });

        txtCodBarras.setBackground(java.awt.Color.white);
        txtCodBarras.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodBarras.setForeground(new java.awt.Color(51, 51, 51));
        txtCodBarras.setBorder(null);
        txtCodBarras.setMinimumSize(new java.awt.Dimension(22, 24));
        txtCodBarras.setName(""); // NOI18N
        txtCodBarras.setPreferredSize(new java.awt.Dimension(22, 24));

        checkCodigo.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkCodigo.setForeground(new java.awt.Color(255, 255, 255));
        checkCodigo.setText("Cod. Barras:");
        checkCodigo.setFocusable(false);
        checkCodigo.setOpaque(false);
        checkCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCodigoActionPerformed(evt);
            }
        });

        txtFecha.setBackground(java.awt.Color.white);
        txtFecha.setFocusable(false);
        txtFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFecha.setOpaque(false);
        txtFecha.setPreferredSize(new java.awt.Dimension(132, 22));

        jButton5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Add_Tag_25px.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Scan_Stock_96px.png"))); // NOI18N

        textDescrip.setBackground(new java.awt.Color(255, 255, 255));
        textDescrip.setColumns(20);
        textDescrip.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textDescrip.setLineWrap(true);
        textDescrip.setRows(5);
        textDescrip.setWrapStyleWord(true);
        textDescrip.setBorder(null);
        textDescrip.setDoubleBuffered(true);
        jScrollPane2.setViewportView(textDescrip);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 24));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Open_Box_48px.png"))); // NOI18N
        jLabel6.setText("Registro de Productos");

        imgSite.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgSite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Image_File_48px.png"))); // NOI18N
        imgSite.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));
        imgSite.setDoubleBuffered(true);
        imgSite.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

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

        jButton8.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(51, 51, 51));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Remove_Image_48px.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(btnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 131, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 155, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15))
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(38, 38, 38)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel11))
                        .add(0, 0, Short.MAX_VALUE)))
                .add(376, 376, 376))
            .add(jPanel2Layout.createSequentialGroup()
                .add(38, 38, 38)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jLabel3)
                    .add(checkProvider))
                .add(13, 13, 13)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 189, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(comboCategoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton5))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(comboProveedor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 153, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton6))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                                .add(txtIdProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 158, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton2)))
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                                .add(40, 40, 40)
                                .add(jButton9)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton8)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(12, 12, 12)
                                .add(imgSite, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel2Layout.createSequentialGroup()
                                        .add(checkFabrica, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(txtFabrica, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 179, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jPanel2Layout.createSequentialGroup()
                                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(checkMarca)
                                            .add(checkModelo)
                                            .add(checkSerie)
                                            .add(checkCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(11, 11, 11)
                                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(txtCodBarras, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 179, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                                .add(org.jdesktop.layout.GroupLayout.LEADING, txtModelo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 179, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(txtSerie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 179, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(txtMarca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 179, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel6)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jButton8)
                            .add(jButton9))
                        .add(18, 18, Short.MAX_VALUE)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(txtFecha, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(12, 12, 12)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtIdProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1))
                        .add(14, 14, 14)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(txtMarca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(checkMarca))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(txtModelo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(checkModelo))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(txtSerie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(checkSerie))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(txtFabrica, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(checkFabrica))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel2Layout.createSequentialGroup()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel2)
                                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel3)
                                        .add(comboCategoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jButton5))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jButton6)
                                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(comboProveedor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(checkProvider)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(btnAgregar)
                                    .add(jButton4)
                                    .add(jButton7)))))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(imgSite, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jButton2)
                            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(checkCodigo)
                                .add(txtCodBarras, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 0, Short.MAX_VALUE)))
                .add(62, 62, 62))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 430));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(581, 468));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setOpaque(false);

        tablaProductos.setAutoCreateRowSorter(true);
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
        tablaProductos.setFillsViewportHeight(true);
        tablaProductos.setGridColor(new java.awt.Color(255, 255, 255));
        tablaProductos.setOpaque(false);
        tablaProductos.setShowHorizontalLines(false);
        tablaProductos.setShowVerticalLines(false);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

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

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButton10)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 499, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(30, 30, 30)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 309, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton10)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, -8, 560, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCodigoActionPerformed

        if (checkCodigo.isSelected()) {
            txtCodBarras.setEnabled(true);
            txtCodBarras.setEditable(true);
        } else {
            txtCodBarras.setEnabled(false);
            txtCodBarras.setEditable(false);
            txtCodBarras.setText("");
        }

    }//GEN-LAST:event_checkCodigoActionPerformed

    private void checkModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkModeloActionPerformed
        if (checkModelo.isSelected()) {
            txtModelo.setEnabled(true);
            txtModelo.setEditable(true);
        } else {
            txtModelo.setEnabled(false);
            txtModelo.setEditable(false);
            txtModelo.setText("");
        }
    }//GEN-LAST:event_checkModeloActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void checkSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSerieActionPerformed
        if (this.checkSerie.isSelected()) {
            txtSerie.setEnabled(true);
            txtSerie.setEditable(true);
        } else {
            txtSerie.setEnabled(false);
            txtSerie.setEditable(false);
            txtSerie.setText("");
        }
    }//GEN-LAST:event_checkSerieActionPerformed

    private void checkFabricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkFabricaActionPerformed
        if (this.checkFabrica.isSelected()) {
            txtFabrica.setEnabled(true);
            txtFabrica.setEditable(true);
        } else {
            txtFabrica.setEnabled(false);
            txtFabrica.setEditable(false);
            txtFabrica.setText("");
        }
    }//GEN-LAST:event_checkFabricaActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        Producto p = new Producto();
        p.setIdProducto((Integer) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0));
        p.setCodBarras((Integer) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 1));
        p.setDescrip((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2));
        p.setCategoria((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 3));
        p.setMarca((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 4));
        p.setModelo((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5));
        p.setSerie((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 6));
        p.setProveed((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 7));
        p.setFabrica((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 8));

        txtIdProducto.setText(p.getIdProducto().toString());
        txtCodBarras.setText(p.getCodBarras().toString());
        textDescrip.setText(p.getDescrip());


    }//GEN-LAST:event_tablaProductosMouseClicked

    private boolean validarCampos() {
        if (txtIdProducto.getText().equals("") || txtFecha.getDate().equals("") || textDescrip.getText().equals("") || comboCategoria.getSelectedIndex() == 0 || comboProveedor.getSelectedIndex() == 0 ) {
            JOptionPane.showMessageDialog(null, "La información del producto esta vacía. \n El llenado de los campos marcados con un '*' son obligatorios. \n Ingrese la información correspondiente en cada uno.", "Error - Campos Vacios.", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int conteoFaltantes = 0;
        int tipoMensaje;
        if (validarCampos()) {
            Producto p = new Producto();
            String camposNoRegistrados =" Campos no Registrados: \n";
            p.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
            p.setCategoria(String.valueOf(comboCategoria.getSelectedIndex()));
            p.setProveed(String.valueOf(comboProveedor.getSelectedIndex()));
            
            p.setDescrip(textDescrip.getText());
            if (!txtMarca.getText().equals("")) {
                p.setMarca(txtMarca.getText());
                
            }else{
                camposNoRegistrados+=" Marca \n";
            }
            if (!txtCodBarras.getText().equals("")) {
                p.setCodBarras(Integer.parseInt(txtCodBarras.getText()));
                
            }else{
                camposNoRegistrados+=" Código de Barras \n";
            }
            if(!txtModelo.getText().equals("")){
                p.setModelo(txtModelo.getText());
                
            }else{
                camposNoRegistrados+=" Modelo \n";
            }
            if(!txtSerie.getText().equals("")){
                p.setSerie(txtSerie.getText());
                
            }else{
                camposNoRegistrados+=" Serie \n";
            }
            if(!txtFabrica.getText().equals("")){
                p.setFabrica(txtFabrica.getText());
                
            }else{
                camposNoRegistrados+=" Fabrica \n";
            }
            
            
            gp.registroProductos(p);
            if (conteoFaltantes<=0) {
                tipoMensaje=0;
            }else{
                tipoMensaje=1;
            }
            JOptionPane.showMessageDialog(null, "Se ha registrado el producto exitosamente. \n"+ camposNoRegistrados,"Producto Registrado.",tipoMensaje);
            System.out.println("Objeto en registro" +p.toString());
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No se realizó el registro del producto. Intente de nuevo. Verifíque la información ingresada. ", "Error al Agregar Producto", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void checkMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMarcaActionPerformed
        if (this.checkMarca.isSelected()) {
            txtMarca.setEnabled(true);
            txtMarca.setEditable(true);
        } else {
            txtMarca.setEnabled(false);
            txtMarca.setEditable(false);
            txtMarca.setText("");
        }
    }//GEN-LAST:event_checkMarcaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       imagenProducto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkProviderActionPerformed
        if (this.checkProvider.isSelected()) {
            comboProveedor.setEnabled(true);
            comboProveedor.setEditable(true);
        } else {
            comboProveedor.setEnabled(false);
            comboProveedor.setEditable(false);
            comboProveedor.setSelectedIndex(0);
        }
    }//GEN-LAST:event_checkProviderActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JCheckBox checkCodigo;
    private javax.swing.JCheckBox checkFabrica;
    private javax.swing.JCheckBox checkMarca;
    private javax.swing.JCheckBox checkModelo;
    private javax.swing.JCheckBox checkProvider;
    private javax.swing.JCheckBox checkSerie;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboProveedor;
    private javax.swing.JLabel imgSite;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextArea textDescrip;
    private javax.swing.JTextField txtCodBarras;
    private javax.swing.JTextField txtFabrica;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
