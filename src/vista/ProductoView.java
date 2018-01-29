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
import modelo.dao.ProductoDAO;

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
    private static ProductoView iniciarProductoView;

    private ProductoView() {
        gp = new GestionProducto();
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        setUndecorated(true);
        initComponents();
        llenarTabla();
        llenadoComboBox();
        setLocationRelativeTo(null);
        estadoIncial();
    }
    
    public static ProductoView inicializarProducto(){
        if (iniciarProductoView==null) {
            iniciarProductoView = new ProductoView();
            return iniciarProductoView;
        }else{
            return iniciarProductoView;
        }
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

    }

    private void llenarTabla() {
        ArrayList<ProductoDAO> productosRegistrados = gp.mostrarProductos();
        String nombreColumnas[] = {"ID Producto", "Codigo Barras", "Descripción", "Categoria","Marca", "Modelo", "Serie", "Proveedor", "Fabricante"};
        DefaultTableModel dtf = new DefaultTableModel(nombreColumnas, productosRegistrados.size());
        for (int i = 0; i < productosRegistrados.size(); i++) {
            dtf.setValueAt(productosRegistrados.get(i).getIdProducto(), i, 0);
            System.out.println("Id Producto"+ productosRegistrados.get(i).getIdProducto());
            
            dtf.setValueAt(productosRegistrados.get(i).getCodBarras(), i, 1);
            dtf.setValueAt(productosRegistrados.get(i).getDescrip(), i, 2);
            System.out.println("Descripcion"+ productosRegistrados.get(i).getDescrip());
            dtf.setValueAt(productosRegistrados.get(i).getIdCategoria(), i, 3);
            dtf.setValueAt(productosRegistrados.get(i).getMarca(), i, 4);
            dtf.setValueAt(productosRegistrados.get(i).getModelo(), i, 5);
            dtf.setValueAt(productosRegistrados.get(i).getSerie(), i, 6);
            dtf.setValueAt(productosRegistrados.get(i).getLote(), i, 7);
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

        btnMinimized = new javax.swing.JLabel();
        btnRestore = new javax.swing.JLabel();
        btnMaximize = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDescrip = new javax.swing.JTextField();
        txtFecha1 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        imgSite = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txtMarca = new javax.swing.JTextField();
        checkModelo = new javax.swing.JCheckBox();
        checkCodigo = new javax.swing.JCheckBox();
        txtSerie = new javax.swing.JTextField();
        txtLote = new javax.swing.JTextField();
        checkSerie = new javax.swing.JCheckBox();
        checkFabrica = new javax.swing.JCheckBox();
        txtCodBarras = new javax.swing.JTextField();
        checkMarca = new javax.swing.JCheckBox();
        txtFabrica = new javax.swing.JTextField();
        checkLote = new javax.swing.JCheckBox();
        txtModelo = new javax.swing.JTextField();
        checkMedida = new javax.swing.JCheckBox();
        txtUnidadMedida = new javax.swing.JTextField();
        txtMedida = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        checkfabrica = new javax.swing.JCheckBox();
        txtfabrica = new com.toedter.calendar.JDateChooser();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnMaximize1 = new javax.swing.JLabel();
        btnRestore1 = new javax.swing.JLabel();
        btnMinimized1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

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

        jPanel6.setBackground(new java.awt.Color(4, 0, 16));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setMinimumSize(new java.awt.Dimension(446, 483));
        jPanel2.setOpaque(false);

        jPanel3.setOpaque(false);

        jPanel4.setOpaque(false);

        comboCategoria.setBackground(new java.awt.Color(22, 29, 64));
        comboCategoria.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la categoria" }));
        comboCategoria.setBorder(null);
        comboCategoria.setFocusable(false);
        comboCategoria.setOpaque(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Fecha Registro:*");

        txtIdProducto.setBackground(new java.awt.Color(22, 29, 64));
        txtIdProducto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtIdProducto.setBorder(null);
        txtIdProducto.setMinimumSize(new java.awt.Dimension(22, 22));
        txtIdProducto.setPreferredSize(new java.awt.Dimension(22, 22));

        txtFecha.setBackground(new java.awt.Color(22, 29, 64));
        txtFecha.setFocusable(false);
        txtFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFecha.setMinimumSize(new java.awt.Dimension(50, 24));
        txtFecha.setOpaque(false);
        txtFecha.setPreferredSize(new java.awt.Dimension(132, 24));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 102));
        jLabel3.setText("Categoria: *");

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 102));
        jLabel1.setText("ID Producto:*");

        jButton2.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Search_25px.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);

        jButton5.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Add_Tag_25px.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 102));
        jLabel2.setText("Descripcion: *");

        txtDescrip.setBackground(new java.awt.Color(22, 29, 64));
        txtDescrip.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtDescrip.setBorder(null);
        txtDescrip.setMaximumSize(new java.awt.Dimension(22, 22));
        txtDescrip.setMinimumSize(new java.awt.Dimension(22, 22));
        txtDescrip.setPreferredSize(new java.awt.Dimension(22, 22));

        txtFecha1.setBackground(new java.awt.Color(22, 29, 64));
        txtFecha1.setFocusable(false);
        txtFecha1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFecha1.setMinimumSize(new java.awt.Dimension(50, 24));
        txtFecha1.setOpaque(false);
        txtFecha1.setPreferredSize(new java.awt.Dimension(132, 24));

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Fecha Factura:*");

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jLabel11)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtDescrip, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(txtIdProducto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(txtFecha, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(18, 18, 18)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel13)
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                                .add(comboCategoria, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jButton5))
                            .add(txtFecha1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .add(13, 13, 13))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(3, 3, 3)
                        .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtFecha1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanel4Layout.createSequentialGroup()
                                .add(jLabel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(txtFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(comboCategoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel3))
                    .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtIdProducto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1))
                        .add(jButton5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtDescrip, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .add(12, 12, 12))
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
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel7Layout.createSequentialGroup()
                        .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jButton9)
                        .add(18, 18, 18)
                        .add(jButton8))
                    .add(imgSite, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(imgSite, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton9)
                    .add(jButton8))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setOpaque(false);

        txtMarca.setBackground(new java.awt.Color(22, 29, 64));
        txtMarca.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(153, 204, 0));
        txtMarca.setBorder(null);
        txtMarca.setMaximumSize(new java.awt.Dimension(22, 22));
        txtMarca.setMinimumSize(new java.awt.Dimension(22, 22));
        txtMarca.setPreferredSize(new java.awt.Dimension(80, 22));

        checkModelo.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkModelo.setForeground(new java.awt.Color(204, 204, 204));
        checkModelo.setText("Modelo:");
        checkModelo.setFocusable(false);
        checkModelo.setMaximumSize(new java.awt.Dimension(22, 22));
        checkModelo.setMinimumSize(new java.awt.Dimension(22, 22));
        checkModelo.setOpaque(false);
        checkModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkModeloActionPerformed(evt);
            }
        });

        checkCodigo.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkCodigo.setForeground(new java.awt.Color(204, 204, 204));
        checkCodigo.setText("Cod. Barras:");
        checkCodigo.setFocusable(false);
        checkCodigo.setMaximumSize(new java.awt.Dimension(22, 22));
        checkCodigo.setMinimumSize(new java.awt.Dimension(22, 22));
        checkCodigo.setOpaque(false);
        checkCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCodigoActionPerformed(evt);
            }
        });

        txtSerie.setBackground(new java.awt.Color(22, 29, 64));
        txtSerie.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSerie.setForeground(new java.awt.Color(153, 204, 0));
        txtSerie.setBorder(null);
        txtSerie.setMaximumSize(new java.awt.Dimension(22, 22));
        txtSerie.setMinimumSize(new java.awt.Dimension(22, 22));
        txtSerie.setPreferredSize(new java.awt.Dimension(80, 22));

        txtLote.setBackground(new java.awt.Color(22, 29, 64));
        txtLote.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtLote.setForeground(new java.awt.Color(153, 204, 0));
        txtLote.setBorder(null);
        txtLote.setMaximumSize(new java.awt.Dimension(22, 22));
        txtLote.setMinimumSize(new java.awt.Dimension(22, 22));
        txtLote.setPreferredSize(new java.awt.Dimension(80, 22));

        checkSerie.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkSerie.setForeground(new java.awt.Color(204, 204, 204));
        checkSerie.setText("Serie:");
        checkSerie.setFocusable(false);
        checkSerie.setMaximumSize(new java.awt.Dimension(22, 22));
        checkSerie.setMinimumSize(new java.awt.Dimension(22, 22));
        checkSerie.setOpaque(false);
        checkSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSerieActionPerformed(evt);
            }
        });

        checkFabrica.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkFabrica.setForeground(new java.awt.Color(204, 204, 204));
        checkFabrica.setText("Fabricante:");
        checkFabrica.setFocusable(false);
        checkFabrica.setMaximumSize(new java.awt.Dimension(22, 22));
        checkFabrica.setMinimumSize(new java.awt.Dimension(22, 22));
        checkFabrica.setOpaque(false);
        checkFabrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkFabricaActionPerformed(evt);
            }
        });

        txtCodBarras.setBackground(new java.awt.Color(22, 29, 64));
        txtCodBarras.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCodBarras.setForeground(new java.awt.Color(153, 204, 0));
        txtCodBarras.setBorder(null);
        txtCodBarras.setMaximumSize(new java.awt.Dimension(22, 22));
        txtCodBarras.setMinimumSize(new java.awt.Dimension(22, 22));
        txtCodBarras.setName(""); // NOI18N
        txtCodBarras.setPreferredSize(new java.awt.Dimension(80, 22));

        checkMarca.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkMarca.setForeground(new java.awt.Color(204, 204, 204));
        checkMarca.setText("Marca:");
        checkMarca.setFocusable(false);
        checkMarca.setMaximumSize(new java.awt.Dimension(22, 22));
        checkMarca.setMinimumSize(new java.awt.Dimension(22, 22));
        checkMarca.setOpaque(false);
        checkMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMarcaActionPerformed(evt);
            }
        });

        txtFabrica.setBackground(new java.awt.Color(22, 29, 64));
        txtFabrica.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFabrica.setForeground(new java.awt.Color(153, 204, 0));
        txtFabrica.setBorder(null);
        txtFabrica.setMaximumSize(new java.awt.Dimension(22, 22));
        txtFabrica.setMinimumSize(new java.awt.Dimension(22, 22));
        txtFabrica.setPreferredSize(new java.awt.Dimension(80, 22));

        checkLote.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkLote.setForeground(new java.awt.Color(204, 204, 204));
        checkLote.setText("Lote:");
        checkLote.setMaximumSize(new java.awt.Dimension(22, 22));
        checkLote.setMinimumSize(new java.awt.Dimension(22, 22));
        checkLote.setOpaque(false);
        checkLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLoteActionPerformed(evt);
            }
        });

        txtModelo.setBackground(new java.awt.Color(22, 29, 64));
        txtModelo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(153, 204, 0));
        txtModelo.setBorder(null);
        txtModelo.setMaximumSize(new java.awt.Dimension(22, 22));
        txtModelo.setMinimumSize(new java.awt.Dimension(22, 22));
        txtModelo.setPreferredSize(new java.awt.Dimension(80, 22));

        checkMedida.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkMedida.setForeground(new java.awt.Color(204, 204, 204));
        checkMedida.setText("Medida");
        checkMedida.setMaximumSize(new java.awt.Dimension(22, 22));
        checkMedida.setMinimumSize(new java.awt.Dimension(22, 22));
        checkMedida.setOpaque(false);
        checkMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMedidaActionPerformed(evt);
            }
        });

        txtUnidadMedida.setBackground(new java.awt.Color(22, 29, 64));
        txtUnidadMedida.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtUnidadMedida.setForeground(new java.awt.Color(153, 204, 0));
        txtUnidadMedida.setBorder(null);
        txtUnidadMedida.setMaximumSize(new java.awt.Dimension(22, 22));
        txtUnidadMedida.setMinimumSize(new java.awt.Dimension(22, 22));
        txtUnidadMedida.setName(""); // NOI18N
        txtUnidadMedida.setPreferredSize(new java.awt.Dimension(80, 22));

        txtMedida.setBackground(new java.awt.Color(22, 29, 64));
        txtMedida.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtMedida.setForeground(new java.awt.Color(153, 204, 0));
        txtMedida.setBorder(null);
        txtMedida.setMaximumSize(new java.awt.Dimension(22, 22));
        txtMedida.setMinimumSize(new java.awt.Dimension(22, 22));
        txtMedida.setName(""); // NOI18N
        txtMedida.setPreferredSize(new java.awt.Dimension(80, 22));

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Unidad Med.:");

        checkfabrica.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        checkfabrica.setForeground(new java.awt.Color(204, 204, 204));
        checkfabrica.setText("Fecha Fabric.:");
        checkfabrica.setMaximumSize(new java.awt.Dimension(22, 22));
        checkfabrica.setMinimumSize(new java.awt.Dimension(22, 22));
        checkfabrica.setOpaque(false);
        checkfabrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkfabricaActionPerformed(evt);
            }
        });

        txtfabrica.setBackground(new java.awt.Color(22, 29, 64));
        txtfabrica.setForeground(new java.awt.Color(153, 255, 0));
        txtfabrica.setPreferredSize(new java.awt.Dimension(132, 24));

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(checkFabrica, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(checkCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(checkMarca, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtFabrica, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtCodBarras, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtMarca, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(checkLote, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 76, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(checkModelo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(checkSerie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(txtModelo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(txtSerie, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(txtLote, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(checkfabrica, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(checkMedida, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel12))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtMedida, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtfabrica, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .add(txtUnidadMedida, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(checkfabrica, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(checkMedida, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(checkCodigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(txtCodBarras, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(txtSerie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(checkSerie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(txtfabrica, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtMarca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(checkMarca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtModelo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(checkModelo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtMedida, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtFabrica, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(checkFabrica, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(checkLote, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtLote, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtUnidadMedida, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 3, Short.MAX_VALUE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jButton7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jButton7.setForeground(new java.awt.Color(204, 204, 204));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Robot_48px.png"))); // NOI18N
        jButton7.setText("Ver Inventario");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton7.setIconTextGap(10);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(204, 204, 204));
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
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 204, 204));
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

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jButton4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnAgregar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jButton7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 178, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jButton7)
                .add(18, 18, 18)
                .add(jButton4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnAgregar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.setMinimumSize(new java.awt.Dimension(581, 468));
        jPanel1.setOpaque(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setOpaque(false);

        tablaProductos.setBackground(new java.awt.Color(4, 0, 16));
        tablaProductos.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        tablaProductos.setForeground(new java.awt.Color(204, 204, 204));
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
        tablaProductos.setSelectionForeground(new java.awt.Color(40, 40, 40));
        tablaProductos.setShowHorizontalLines(false);
        tablaProductos.setShowVerticalLines(false);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setOpaque(false);

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

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
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
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButton10)
                    .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(btnMaximize1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(btnMinimized1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, btnRestore1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_Open_Box_96px.png"))); // NOI18N
        jLabel6.setText("Administración de Catalogo de Productos");

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .add(jPanel6Layout.createSequentialGroup()
                .add(43, 43, 43)
                .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(112, 112, 112)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6Layout.createSequentialGroup()
                        .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(86, 86, 86))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6Layout.createSequentialGroup()
                        .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)))
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 221, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 298, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean validarCampos() {
        if (txtIdProducto.getText().equals("") || txtFecha.getDate().equals("") || txtDescrip.getText().equals("") || comboCategoria.getSelectedIndex() == 0) {
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
            ProductoDAO p = new ProductoDAO();
            String camposNoRegistrados =" Campos no Registrados: \n";
            p.setIdProducto(Integer.parseInt(txtIdProducto.getText()));
            p.setIdCategoria(comboCategoria.getSelectedIndex());
            
            
            p.setDescrip(txtDescrip.getText());
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
            if (conteoFaltantes>=0) {
                tipoMensaje=1;
            }else{
                tipoMensaje=0;
            }
            JOptionPane.showMessageDialog(null, "Se ha registrado el producto exitosamente. \n"+ camposNoRegistrados,"Producto Registrado.",tipoMensaje);
            System.out.println("Objeto en registro" +p.toString());
            llenarTabla();
        } else {
            JOptionPane.showMessageDialog(null, "No se realizó el registro del producto. Intente de nuevo. Verifíque la información ingresada. ", "Error al Agregar Producto", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       imagenProducto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        dispose();
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        ProductoDAO p = new ProductoDAO();
        p.setIdProducto((Integer) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0));
        p.setCodBarras((Integer) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 1));
        p.setDescrip((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2));
//        p.setCategoria((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 3));
        p.setMarca((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 4));
        p.setModelo((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5));
        p.setSerie((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 6));
//        p.setProveed((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 7));
        p.setFabrica((String) tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 8));

        txtIdProducto.setText(p.getIdProducto().toString());
        txtCodBarras.setText(p.getCodBarras().toString());
        //textDescrip.setText(p.getDescrip());

    }//GEN-LAST:event_tablaProductosMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    //InventarioView iv = new InventarioView();
    //iv.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnMinimizedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizedMouseClicked
        setExtendedState(this.ICONIFIED);

    }//GEN-LAST:event_btnMinimizedMouseClicked

    private void btnRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestoreMouseClicked
        setExtendedState(this.NORMAL);
    }//GEN-LAST:event_btnRestoreMouseClicked

    private void btnMaximizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizeMouseClicked

        setExtendedState(this.MAXIMIZED_BOTH);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnMaximizeMouseClicked

    private void btnRestore1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestore1MouseClicked
        setExtendedState(this.NORMAL);
    }//GEN-LAST:event_btnRestore1MouseClicked

    private void btnMinimized1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimized1MouseClicked
        setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimized1MouseClicked

    private void btnMaximize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximize1MouseClicked

        setExtendedState(this.MAXIMIZED_BOTH);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnMaximize1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void checkModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkModeloActionPerformed
        if (checkModelo.isSelected()) {
            txtModelo.setEnabled(true);
            txtModelo.setEditable(true);
            txtModelo.requestFocus();
        } else {
            txtModelo.setEnabled(false);
            txtModelo.setEditable(false);
            txtModelo.setText("");
        }
    }//GEN-LAST:event_checkModeloActionPerformed

    private void checkCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCodigoActionPerformed

        if (checkCodigo.isSelected()) {
            txtCodBarras.setEnabled(true);
            txtCodBarras.setEditable(true);
            txtCodBarras.requestFocus();
        } else {
            txtCodBarras.setEnabled(false);
            txtCodBarras.setEditable(false);
            txtCodBarras.setText("");
        }
    }//GEN-LAST:event_checkCodigoActionPerformed

    private void checkSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSerieActionPerformed
        if (this.checkSerie.isSelected()) {
            txtSerie.setEnabled(true);
            txtSerie.setEditable(true);
            txtSerie.requestFocus();
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
            txtFabrica.requestFocus();
        } else {
            txtFabrica.setEnabled(false);
            txtFabrica.setEditable(false);
            txtFabrica.setText("");
        }
    }//GEN-LAST:event_checkFabricaActionPerformed

    private void checkMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMarcaActionPerformed
        if (this.checkMarca.isSelected()) {
            txtMarca.setEnabled(true);
            txtMarca.setEditable(true);
            txtMarca.requestFocus();
        } else {
            txtMarca.setEnabled(false);
            txtMarca.setEditable(false);
            txtMarca.setText("");
        }
    }//GEN-LAST:event_checkMarcaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CategoriaView cv= null;
        cv=cv.inicializarCategoriaView();
        cv.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void checkLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLoteActionPerformed

        if (this.checkLote.isSelected()) {
            txtLote.setEnabled(true);
            txtLote.setEditable(true);
            txtLote.requestFocus();
        } else {
            txtLote.setEnabled(false);
            txtLote.setEditable(false);
            txtLote.setText("");
        }
    }//GEN-LAST:event_checkLoteActionPerformed

    private void checkfabricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkfabricaActionPerformed
        if (this.checkfabrica.isSelected()) {
            txtfabrica.setEnabled(true);
            
            txtfabrica.requestFocus();
        } else {
            txtfabrica.setEnabled(false);
            
            
        }
    }//GEN-LAST:event_checkfabricaActionPerformed

    private void checkMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMedidaActionPerformed
        
        if (this.checkMedida.isSelected()) {
            txtMedida.setEnabled(true);
            txtMedida.setEditable(true);
            txtMedida.requestFocus();
        } else {
            txtMedida.setEnabled(false);
            txtMedida.setEditable(false);
            txtMedida.setText("");
        }
    }//GEN-LAST:event_checkMedidaActionPerformed

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
    private javax.swing.JLabel btnMaximize;
    private javax.swing.JLabel btnMaximize1;
    private javax.swing.JLabel btnMinimized;
    private javax.swing.JLabel btnMinimized1;
    private javax.swing.JLabel btnRestore;
    private javax.swing.JLabel btnRestore1;
    private javax.swing.JCheckBox checkCodigo;
    private javax.swing.JCheckBox checkFabrica;
    private javax.swing.JCheckBox checkLote;
    private javax.swing.JCheckBox checkMarca;
    private javax.swing.JCheckBox checkMedida;
    private javax.swing.JCheckBox checkModelo;
    private javax.swing.JCheckBox checkSerie;
    private javax.swing.JCheckBox checkfabrica;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JLabel imgSite;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCodBarras;
    private javax.swing.JTextField txtDescrip;
    private javax.swing.JTextField txtFabrica;
    private com.toedter.calendar.JDateChooser txtFecha;
    private com.toedter.calendar.JDateChooser txtFecha1;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMedida;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtUnidadMedida;
    private com.toedter.calendar.JDateChooser txtfabrica;
    // End of variables declaration//GEN-END:variables
}
