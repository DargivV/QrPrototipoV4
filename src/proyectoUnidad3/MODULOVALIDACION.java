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
public class MODULOVALIDACION extends javax.swing.JFrame {
    
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
                String apeM = datos[4];
                String AdentroFiera = datos[5];
                String est = datos[6];
                int Nhi = Integer.parseInt(datos[7]);
                String Ecuela = datos[8];
                ini = InsertaFinal(ini, cod, nom, apeP, apeM, AdentroFiera, est, Nhi, Ecuela);
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
        String AdentrooFuera;
        String estadoAF;
        String ECuela; 
        int DNI;
        
        Nodo sig;
        Nodo ant;
        Nodo prev;
        
        public Nodo(String cod, String nom, String apeP, String Turno, String ANDentroFuera, String est, int Nhi, String ESCUELA) {
          codigo=cod;
          nombre=nom;
          apellidoPaterno=apeP;
          TurnoMT=Turno;
          AdentrooFuera=ANDentroFuera;
          estadoAF=est;
          DNI=Nhi;
          ECuela=ESCUELA;  
          sig=ant=null;
          prev=null;
        }
       
    }
     
     DefaultTableModel miModelo;
     String[] cabecera={"N°","Codigo","Nombres","Apellidos", "Horario ","Fecha | Hora","ESTADO DE INGRESO", "DNI", "EScuela"};
     String [][] data={};
     
     public Nodo ini, fin;
     public Nodo pFound;
     int num=0;
     
   
       public MODULOVALIDACION() {
        initComponents();
        this.setLocationRelativeTo(this);
        ini=fin=pFound=null;
        
        miModelo=new DefaultTableModel(data, cabecera);
        tblRegistros.setModel(miModelo);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        cbxEstadoAF = new javax.swing.JComboBox<>();
        btnCaargar = new javax.swing.JButton();
        txtDNI = new javax.swing.JTextField();
        txtESCuela = new javax.swing.JTextField();
        txtTurno = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        btnCaargar1 = new javax.swing.JButton();
        btnGrabar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        SALIDA = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnRestaurar1 = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 240, 32));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 150, 40));
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 150, 40));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 540, 160));

        cbxEstadoAF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADENTRO", "AFUERA" }));
        cbxEstadoAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoAFActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEstadoAF, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 180, 50));

        btnCaargar.setBackground(new java.awt.Color(204, 204, 255));
        btnCaargar.setText("Abrir");
        btnCaargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaargarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCaargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 170, 60));
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 150, 30));

        txtESCuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtESCuelaActionPerformed(evt);
            }
        });
        jPanel1.add(txtESCuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 150, 30));

        txtTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Mañana", "Tarde", "Noche" }));
        jPanel1.add(txtTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 150, 40));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 520, 20));

        btnCaargar1.setBackground(new java.awt.Color(204, 204, 255));
        btnCaargar1.setText("Abrir de ...");
        btnCaargar1.setActionCommand("");
        btnCaargar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaargar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCaargar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 290, 100, 60));

        btnGrabar1.setBackground(new java.awt.Color(204, 255, 204));
        btnGrabar1.setText("Guardar en ... ");
        btnGrabar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnGrabar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 130, 60));

        jButton1.setBackground(new java.awt.Color(250, 250, 250));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 320, 40));

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 100, 60));

        jButton3.setBackground(new java.awt.Color(250, 250, 250));
        jButton3.setText("Actualisar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 510, 40));

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
        jPanel2.add(SALIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 4, 50, 50));

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("<");
        jButton4.setActionCommand("<\n");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 40));

        jLabel6.setFont(new java.awt.Font("Reem Kufi", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("VALIDACION DE LOS DATOS ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 210, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 960, 50));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 13, 970, 30));

        jButton6.setBackground(new java.awt.Color(250, 250, 250));
        jButton6.setText("Qr_Read");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 150, 40));

        jLabel2.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("CODIGO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, -1));

        jLabel7.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("NOMBRE");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("APELLIDOS");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel8.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("TURNO  ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 80, -1));

        jLabel13.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("ESTADO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 100, 50));

        jLabel14.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("DNI");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 110, -1));

        jLabel15.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("ESCUELA");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 110, -1));

        btnRestaurar1.setBackground(new java.awt.Color(51, 51, 51));
        btnRestaurar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedias/1basuraCwe.png"))); // NOI18N
        btnRestaurar1.setBorder(null);
        btnRestaurar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestaurar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 600));

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        MODULOPRINCIPAL MP= new MODULOPRINCIPAL();//creamos el objeto
        MP.setVisible(true);//mantiene siempre activo la funcion
        dispose();//cierra la ventana actual
    }//GEN-LAST:event_jButton4ActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         pFound.codigo=txtCodigo.getText();
        pFound.nombre=txtNombre.getText().toUpperCase();
        pFound.apellidoPaterno=txtApellidoPaterno.getText().toUpperCase();
        pFound.TurnoMT=txtTurno.getSelectedItem().toString(); 
        pFound.estadoAF=cbxEstadoAF.getSelectedItem().toString();
        pFound.DNI=Integer.parseInt(txtDNI.getText());
        pFound.ECuela=txtESCuela.getText();
        LimpiarEntradas(); 
        VerDatos(1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SALIDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIDAActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_SALIDAActionPerformed

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

    private void btnRestaurar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurar1ActionPerformed
        LimpiarEntradas();

    }//GEN-LAST:event_btnRestaurar1ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MODULOVALIDACION().setVisible(true);
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
                         AdentroFiera=aux.AdentrooFuera;
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
                    AdentroFiera=aux.AdentrooFuera;
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
    private javax.swing.JButton btnCaargar;
    private javax.swing.JButton btnCaargar1;
    private javax.swing.JButton btnGrabar1;
    private javax.swing.JButton btnRestaurar1;
    private javax.swing.JComboBox<String> cbxEstadoAF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtESCuela;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JComboBox<String> txtTurno;
    // End of variables declaration//GEN-END:variables
}
