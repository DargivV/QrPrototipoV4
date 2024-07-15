package proyectoUnidad3;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
public class ModuloREPORTS extends javax.swing.JFrame {
    
//guardarlo en el txt
private void guardarDatosEnArchivo(File archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < tblRegistros.getRowCount(); i++) {
                for (int j = 0; j < tblRegistros.getColumnCount(); j++) {
                    writer.write(tblRegistros.getValueAt(i, j).toString());
                    if (j < tblRegistros.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
            writer.close();
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + ex.getMessage());
        }
    }
//cargar los datso
    private void cargarDatosDesdeArchivo(File archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            DefaultTableModel model = (DefaultTableModel) tblRegistros.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                model.addRow(datos);
                String cod = datos[1];
                String nom = datos[2];
                String apeP = datos[3];
                String Turno = datos[4];
                String Hora = datos[5];
                String est = datos[6];
                int Nhi = Integer.parseInt(datos[7]);
                String Ecuela = datos[8];
                ini = InsertaFinal(ini, cod, nom, apeP, Turno, Hora, est, Nhi, Ecuela);
            }
            JOptionPane.showMessageDialog(this, "Datos cargados correctamente desde: " + archivo.getAbsolutePath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo: " + ex.getMessage());
        }
    }
  //-----------------------
    private void guaerdaEn(File archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < tblRegistros.getRowCount(); i++) {
                for (int j = 0; j < tblRegistros.getColumnCount(); j++) {
                    writer.write(tblRegistros.getValueAt(i, j).toString());
                    if (j < tblRegistros.getColumnCount() - 1) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
            writer.close();
            JOptionPane.showMessageDialog(this, "Datos guardados correctamente en: " + archivo.getAbsolutePath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + ex.getMessage());
        }
    }
    
    
   //----------------- 
    
       private void cargarDatosCOn(File archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            DefaultTableModel model = (DefaultTableModel) tblRegistros.getModel();
            model.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                model.addRow(datos);
            }
            JOptionPane.showMessageDialog(this, "Datos cargados correctamente desde: " + archivo.getAbsolutePath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo: " + ex.getMessage());
        }
    }
 
    
    //-------------- lsita enlasada
    public class Nodo{
        String codigo;
        String nombre;
        String apellidoPaterno;
        String TurnoMT;
        String Horas;
        String estadoAF;
        String ECuela; 
        int DNI;
        
        Nodo sig;
        Nodo ant;
        Nodo prev;
        
        public Nodo(String cod, String nom, String apeP, String Turno, String hora, String est, int Nhi, String ESCUELA) {
          codigo=cod;
          nombre=nom;
          apellidoPaterno=apeP;
          TurnoMT=Turno;
          Horas=hora;
          estadoAF=est;
          DNI=Nhi;
          ECuela=ESCUELA;  
          sig=ant=null;
          prev=null;
        }
       
    }
     
     DefaultTableModel miModelo;
     String[] cabecera={"N°","Codigo","Nombres","Apellidos", "Turno ","Fecha | Hora","Intento de entradas", "DNI", "EScuela"};
     String [][] data={};
     
     public Nodo ini, fin;
     public Nodo pFound;
     int num=0;
     
   
       public ModuloREPORTS() {
        initComponents();
        this.setLocationRelativeTo(this);
        ini=fin=pFound=null;
        
        miModelo=new DefaultTableModel(data, cabecera);
        tblRegistros.setModel(miModelo);
        
        //reportes llamada
         int tamanoLista = obtenerTamanoLista(ini); 
         txtCantida.setText("Tamaño de la lista: " + tamanoLista); 
         contarTurnos(ini);
            
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        btnCaargar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCaargar1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        SALIDA = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGrabar1 = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        txtCantida = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtTurno = new javax.swing.JComboBox<>();
        cbxEstadoAF = new javax.swing.JComboBox<>();
        txtDNI = new javax.swing.JTextField();
        txtESCuela = new javax.swing.JTextField();
        Trunroo = new javax.swing.JButton();
        txtPorTurnM = new javax.swing.JTextField();
        txtPorTurnT = new javax.swing.JTextField();
        txtPorTurnN = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(71, 65, 163));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane1.setViewportView(tblRegistros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 750, 280));

        btnCaargar.setBackground(new java.awt.Color(204, 204, 255));
        btnCaargar.setText("Abrir");
        btnCaargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaargarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCaargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 210, 60));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 390, 20));

        btnCaargar1.setBackground(new java.awt.Color(204, 204, 255));
        btnCaargar1.setText("Abrir de ...");
        btnCaargar1.setActionCommand("");
        btnCaargar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaargar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCaargar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 260, 180, 60));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SALIDA.setBackground(new java.awt.Color(153, 153, 153));
        SALIDA.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        SALIDA.setText("x");
        SALIDA.setBorder(null);
        SALIDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIDAActionPerformed(evt);
            }
        });
        jPanel2.add(SALIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 10, 60, 40));

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("<");
        jButton5.setActionCommand("<\n");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Modulo de Reportes");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 320, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1180, 50));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 13, 1190, 30));

        btnGrabar1.setBackground(new java.awt.Color(204, 255, 204));
        btnGrabar1.setText("Guardar en ... ");
        btnGrabar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnGrabar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 150, 130, 60));

        btnRestaurar.setBackground(new java.awt.Color(51, 51, 51));
        btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedias/1basuraCwe.png"))); // NOI18N
        btnRestaurar.setBorder(null);
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 40, 30));

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 150, 100, 60));

        jButton6.setBackground(new java.awt.Color(248, 248, 248));
        jButton6.setText("Qr_Read");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 100, 30));

        txtCantida.setBackground(new java.awt.Color(51, 51, 51));
        txtCantida.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        txtCantida.setForeground(new java.awt.Color(255, 255, 255));
        txtCantida.setBorder(null);
        jPanel1.add(txtCantida, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 620, 320, 40));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedias/refresh.png"))); // NOI18N
        jButton3.setText(" ");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 570, 70, 30));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 250, 32));

        jButton1.setBackground(new java.awt.Color(248, 248, 248));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 80, 30));

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("CODIGO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        jLabel14.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("TURNO  ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("DNI");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, -1));

        jLabel15.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("APELLIDOS");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel7.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("NOMBRE");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Asistencias totales");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 570, 170, 30));

        jLabel13.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("ESCUELA");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 110, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 140, 30));
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 140, 30));

        txtTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Mañana", "Tarde", "Noche" }));
        jPanel1.add(txtTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 140, 30));

        cbxEstadoAF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADENTRO", "AFUERA" }));
        cbxEstadoAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoAFActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEstadoAF, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 140, 30));
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 140, 30));

        txtESCuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtESCuelaActionPerformed(evt);
            }
        });
        jPanel1.add(txtESCuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 140, 30));

        Trunroo.setBackground(new java.awt.Color(51, 51, 51));
        Trunroo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedias/refresh.png"))); // NOI18N
        Trunroo.setText(" ");
        Trunroo.setBorder(null);
        Trunroo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrunrooActionPerformed(evt);
            }
        });
        jPanel1.add(Trunroo, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 350, 80, 30));

        txtPorTurnM.setBackground(new java.awt.Color(51, 51, 51));
        txtPorTurnM.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        txtPorTurnM.setForeground(new java.awt.Color(255, 255, 255));
        txtPorTurnM.setBorder(null);
        jPanel1.add(txtPorTurnM, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 320, 40));

        txtPorTurnT.setBackground(new java.awt.Color(51, 51, 51));
        txtPorTurnT.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        txtPorTurnT.setForeground(new java.awt.Color(255, 255, 255));
        txtPorTurnT.setBorder(null);
        jPanel1.add(txtPorTurnT, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 320, 40));

        txtPorTurnN.setBackground(new java.awt.Color(51, 51, 51));
        txtPorTurnN.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        txtPorTurnN.setForeground(new java.awt.Color(255, 255, 255));
        txtPorTurnN.setBorder(null);
        jPanel1.add(txtPorTurnN, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 510, 320, 40));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 20, 190));

        jLabel9.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("PERMISO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 110, 30));

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, 340, 20));

        jLabel10.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Asistencias totales");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 350, 170, 30));

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 380, 340, 20));

        jSeparator5.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 600, 340, 20));

        jSeparator6.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 660, 340, 20));

        jSeparator7.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 550, 340, 20));

        jSeparator8.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 500, 340, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    //--------------------------------------------
   public Set<String> obtenerCodigosExistentes(String rutaArchivo) {
    Set<String> codigos = new HashSet<>();
    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(","); // Dividir la línea por comas
            if (partes.length > 1) {
                codigos.add(partes[1].trim()); // Agregar la segunda posición como código
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return codigos;
}
    
    public String Permiso(String ESTADO){ 
    
    if (ESTADO=="ADENTRO") {
      return "denegados ";
    } else if (ESTADO=="AFUERA"){
      return "permitidos"; 
    }
          return null;
  
}
    


    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        LimpiarEntradas();
     
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
    }//GEN-LAST:event_formWindowOpened
  
    private void btnCaargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaargarActionPerformed
        
   
        
         // Especificar la ruta del archivo  C:\\Users\\golde\\Documents\\NetBeansProjects\\SESION6\\SESION6\\
    String rutaArchivo = "datos_alumnos.txt";
    File archivo = new File(rutaArchivo);

    if (archivo.exists() && archivo.isFile()) {
        cargarDatosDesdeArchivo(archivo);
    } else {
        System.out.println("El archivo no existe o no es un archivo válido.");
    } 

    }//GEN-LAST:event_btnCaargarActionPerformed

    private void cbxEstadoAFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoAFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoAFActionPerformed

    private void txtESCuelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtESCuelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtESCuelaActionPerformed

    private void btnCaargar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaargar1ActionPerformed
        // TODO add your handling code here:
        
     JFileChooser fileChooser = new JFileChooser();
    if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();
        cargarDatosCOn(archivo);
    }

       
     
        
    }//GEN-LAST:event_btnCaargar1ActionPerformed

    private void btnGrabar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabar1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
    if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();
        guaerdaEn(archivo);
    }
          
       /*
        guaerdaEn
        */

        
    }//GEN-LAST:event_btnGrabar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         String cod = txtCodigo.getText();
    if (cod.equalsIgnoreCase("")) {
        JOptionPane.showMessageDialog(this, "Ingrese un código por favor");
    } else {
        pFound = Buscar(ini, cod);

        if (pFound != null) {
            txtNombre.setText(pFound.nombre);
            txtApellidoPaterno.setText(pFound.apellidoPaterno); 
            txtTurno.setSelectedItem(pFound.TurnoMT);
            txtESCuela.setText(String.valueOf(pFound.ECuela));
            txtDNI.setText(String.valueOf(pFound.DNI));
            cbxEstadoAF.setSelectedItem(pFound.estadoAF);
         
        } else {
            JOptionPane.showMessageDialog(this, "El código: " + cod + ", no está en la lista");
        }
    }
    
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
           String rutaArchivo = "datos_alumnos.txt";
    File archivo = new File(rutaArchivo);

    if (archivo.exists() && archivo.isFile()) {
        guardarDatosEnArchivo(archivo);
    } else {
        System.out.println("El archivo no existe o no es un archivo válido.");
    }
         
    }//GEN-LAST:event_jButton2ActionPerformed
//-----------------
  public int obtenerTamanoLista(Nodo ini) {
    int tamano = 0;
    Nodo current = ini;

    while (current != null) {
        tamano++;
        current = current.sig;
    }

    return tamano;
}
   
    //--------------------
    
    
      Nodo BuscaRR(Nodo inicio, String Turno) {
        
        Nodo pos=inicio;
        
        while(pos!=null && !Turno.equalsIgnoreCase(pos.TurnoMT))
            pos=pos.sig;
       return pos;
        
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         int tamanoLista = obtenerTamanoLista(ini); 
        
            txtCantida.setText("Tamaño de la lista: " + tamanoLista); 
            
            
      //}
        
    }//GEN-LAST:event_jButton3ActionPerformed
 // Método para contar turnos tarde
 
public void contarTurnos(Nodo inicio) {
    int countTarde = 0;
    int countManana = 0;
    int countNoche = 0;
    Nodo current = inicio;

    for (int i = 0; i < obtenerTamanoLista(inicio); i++) {
        if (current != null) {
            switch (current.TurnoMT.toLowerCase()) {
                case "tarde":
                    countTarde++;
                    break;
                case "mañana":
                case "manana":  // Consideramos ambas formas "mañana" y "manana" por posibles variaciones
                    countManana++;
                    break;
                case "noche":
                    countNoche++;
                    break;
            }
            current = current.sig;
        }
    }

    /*JOptionPane.showMessageDialog(this, "Cantidad de turnos 'tarde': " + countTarde +
                                            "\nCantidad de turnos 'mañana': " + countManana +
                                            "\nCantidad de turnos 'noche': " + countNoche);
    */
    txtPorTurnM.setText("\n Cantidad de turnos 'mañana': " + countManana );
    txtPorTurnT.setText("Cantidad de turnos 'tarde': " + countTarde);
    txtPorTurnN.setText("\n Cantidad de turnos 'noche': " + countNoche);
    
}
    private void TrunrooActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrunrooActionPerformed
        // TODO add your handling code here:
         contarTurnos(ini);
    
        //--------------------------
        
    }//GEN-LAST:event_TrunrooActionPerformed

    private void SALIDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIDAActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_SALIDAActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        MODULOPRINCIPAL MP= new MODULOPRINCIPAL();//creamos el objeto
        MP.setVisible(true);//mantiene siempre activo la funcion
        dispose();//cierra la ventana actual
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Qr pa leer

        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            System.out.println("Ruta del archivo seleccionado: " + archivo.getAbsolutePath()); // Verificar la ruta
            String rutA=(archivo.getAbsolutePath());

            //-------------------

            try (InputStream barcodeInputStream = new FileInputStream(rutA)) {
                BufferedImage barcBufferredImage = ImageIO.read(barcodeInputStream);
                LuminanceSource source = new BufferedImageLuminanceSource(barcBufferredImage);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                Reader reader = new MultiFormatReader();
                Result result = reader.decode(bitmap);

                txtCodigo.setText(result.getText());

            }
            catch(Exception e){}
        }
    }//GEN-LAST:event_jButton6ActionPerformed

   
    
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloREPORTS().setVisible(true);
            }
        });
    }
    
      Nodo Buscar(Nodo inicio, String cod) {
        
        Nodo pos=inicio;
        
        while(pos!=null && !cod.equalsIgnoreCase(pos.codigo))
            pos=pos.sig;
       return pos;
        
    }
      
      Nodo InsertaFinal(Nodo inicio, String cod, String nom, String apeP, String apeM, String AdentroFiera ,String est, int Nhi, String Ecuela) {
          Nodo nuevo=new Nodo(cod, nom, apeP, apeM, AdentroFiera, est, Nhi, Ecuela);
          
          nuevo.sig=inicio;
          if(inicio==null)
          {
              fin=nuevo;
              fin.sig=null;
          }
          
          if(inicio!=null)
              inicio.ant=nuevo;
          
          inicio=nuevo;
                  return inicio;
      }
              
    
    void LimpiarEntradas(){
        txtCodigo.setText("");
        txtNombre.setText("");
        
        txtApellidoPaterno.setText("");
        txtTurno.setSelectedIndex(0);
        cbxEstadoAF.setSelectedIndex(0);
        txtDNI.setText("");
        txtESCuela.setText("");
        txtCodigo.requestFocus();
    }
    
    void vaciar_tabla(){
        
        int filas=tblRegistros.getRowCount();
        for(int i=0;i<filas;i++)
            miModelo.removeRow(0);
    }
    void VerDatos(int ind){
        String cod, nom, apeP, apeM, est,AdentroFiera,Ecuela;
        int Nhi; 
        float s;
        
        switch(ind){
            case 1: 
            {
                vaciar_tabla();
                Nodo aux=ini;
                num=0;
                while(aux!=null)
                        {
                         cod=aux.codigo;
                         nom=aux.nombre;
                         apeP=aux.apellidoPaterno;
                         apeM=aux.TurnoMT;
                         AdentroFiera=aux.Horas;
                         est=aux.estadoAF;
                         Nhi=aux.DNI;
                         Ecuela=aux.ECuela; 
                         
                        
                         num++;
                         Object[] fila={num, cod, nom, apeP, apeM, AdentroFiera, est, Nhi, Ecuela };
                         miModelo.addRow(fila);
                         aux=aux.sig;
                        }
            }break;
            
            case 2:
                {
                vaciar_tabla();
                Nodo aux=fin;
                num=0;
                while(aux!=null)
                {
                    cod=aux.codigo;
                    nom=aux.nombre;
                    apeP=aux.apellidoPaterno;
                    apeM=aux.TurnoMT;
                    AdentroFiera=aux.Horas;
                    est=aux.estadoAF;
                    Nhi=aux.DNI;
                    Ecuela=aux.ECuela;
                   
                         
                   
                    num++;
                    Object[] fila={num, cod, nom, apeP, apeM,AdentroFiera, est, Nhi, Ecuela };
                    miModelo.addRow(fila);
                    aux=aux.ant;
                    
                }
                
            } break;
                
            
        }
        
        
    }
 
    
    void Eliminar(){
        Nodo actual;
        boolean encontrado=false;
        actual=ini;
        while((actual!=null) && (!encontrado)){
            encontrado=actual.codigo.equalsIgnoreCase(txtCodigo.getText().trim());
            if(!encontrado)
                actual=actual.sig;
        }
           if(actual!=null)
           {
               if(actual==ini){
                   ini= actual.sig;
                   if(actual.sig!=null)
                    actual.sig.ant=null;
            
               } else if(actual.sig!=null){
                   actual.ant.sig=actual.sig;
                   actual.sig.ant=actual.ant;
               }
               else {
                   actual.ant.sig=null;
                   fin=actual.ant;
               }
               actual=null;
           }
           
           
    }
    
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SALIDA;
    private javax.swing.JButton Trunroo;
    private javax.swing.JButton btnCaargar;
    private javax.swing.JButton btnCaargar1;
    private javax.swing.JButton btnGrabar1;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JComboBox<String> cbxEstadoAF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCantida;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtESCuela;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPorTurnM;
    private javax.swing.JTextField txtPorTurnN;
    private javax.swing.JTextField txtPorTurnT;
    private javax.swing.JComboBox<String> txtTurno;
    // End of variables declaration//GEN-END:variables
}
