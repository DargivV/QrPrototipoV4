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
public class ModuloRegistro_1 extends javax.swing.JFrame {
    
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
     
   
       public ModuloRegistro_1() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        btnGrabar = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        cbxEstadoAF = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        btnCaargar = new javax.swing.JButton();
        txtDNI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtESCuela = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JComboBox<>();
        EXELSAVE = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCaargar1 = new javax.swing.JButton();
        btnGrabar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        SALIDA = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
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

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("CODIGO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        jLabel3.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("NOMBRE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("TURNO  ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("PERMISO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 110, 30));

        txtCodigo.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 130, 30));

        txtNombre.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 130, 30));

        txtApellidoPaterno.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 130, 28));

        btnGrabar.setBackground(new java.awt.Color(248, 248, 248));
        btnGrabar.setText("Grabar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 150, 60));

        btnRestaurar.setBackground(new java.awt.Color(248, 248, 248));
        btnRestaurar.setText("Vaciar Casilla");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 100, 60));

        btnEliminar.setBackground(new java.awt.Color(248, 248, 248));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 270, 50));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 930, 178));

        cbxEstadoAF.setBackground(new java.awt.Color(204, 204, 204));
        cbxEstadoAF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADENTRO", "AFUERA" }));
        cbxEstadoAF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoAFActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEstadoAF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 130, 31));

        jLabel9.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("APELLIDOS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        btnCaargar.setBackground(new java.awt.Color(204, 204, 255));
        btnCaargar.setText("Abrir");
        btnCaargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaargarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCaargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 210, 60));

        txtDNI.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 124, 30));

        jLabel10.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("DNI");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 110, -1));

        txtESCuela.setBackground(new java.awt.Color(204, 204, 204));
        txtESCuela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtESCuelaActionPerformed(evt);
            }
        });
        jPanel1.add(txtESCuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 124, 30));

        jLabel12.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("ESCUELA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 110, -1));

        txtTurno.setBackground(new java.awt.Color(204, 204, 204));
        txtTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Mañana", "Tarde", "Noche" }));
        jPanel1.add(txtTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 232, 130, 30));

        EXELSAVE.setBackground(new java.awt.Color(204, 255, 204));
        EXELSAVE.setText("Guardar como (.xls)");
        EXELSAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXELSAVEActionPerformed(evt);
            }
        });
        jPanel1.add(EXELSAVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 410, 40));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 460, 20));

        btnCaargar1.setBackground(new java.awt.Color(204, 204, 255));
        btnCaargar1.setText("Abrir de ...");
        btnCaargar1.setActionCommand("");
        btnCaargar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaargar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnCaargar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 270, 180, 60));

        btnGrabar1.setBackground(new java.awt.Color(204, 255, 204));
        btnGrabar1.setText("Guardar en ... ");
        btnGrabar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnGrabar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 130, 60));

        jButton1.setBackground(new java.awt.Color(248, 248, 248));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 240, 50));

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 100, 100, 60));

        jButton3.setBackground(new java.awt.Color(248, 248, 248));
        jButton3.setText("Qr_Read");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 80, 30));

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
        jPanel2.add(SALIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 80, 40));

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
        jLabel6.setText("ESCRITURA DE LOS DATOS ");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 320, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1180, 50));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 13, 1190, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 660));

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
    
    
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
     
String rutaArchivo = "datos_alumnos.txt";

// Obtener los códigos existentes del archivo
Set<String> codigosExistentes = obtenerCodigosExistentes(rutaArchivo);
LocalDateTime ahora = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss");
       String cod = txtCodigo.getText();
       String nom = txtNombre.getText().toUpperCase();
       String apeP = txtApellidoPaterno.getText().toUpperCase();
       String TurnoMT = txtTurno.getSelectedItem().toString();
       String est = cbxEstadoAF.getSelectedItem().toString();
       String Fecha =  ahora.format(formato);
       int Nhi = Integer.parseInt(txtDNI.getText());
       String Ecuela = txtESCuela.getText();  
       int Entradas = 0;
       
       //--------------
       File archivo = new File(rutaArchivo); 
      
       //---------------
      if (!codigosExistentes.contains(cod)) {
       
       ini= InsertaFinal(ini, cod, nom, apeP, TurnoMT, Fecha, est, Nhi, Ecuela);
       
       
       LimpiarEntradas();
       VerDatos(1);}
       else {JOptionPane.showMessageDialog(null, "el alumno ya utiliso el codigo ");
      Entradas ++;
      
      }
       //--------------
         

       
       
   
    }//GEN-LAST:event_btnGrabarActionPerformed
public String Permiso(String ESTADO){ 
    
    if (ESTADO=="ADENTRO") {
      return "denegados ";
    } else if (ESTADO=="AFUERA"){
      return "permitidos"; 
    }
          return null;
  
}
    


    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar();
        LimpiarEntradas();
        VerDatos(1);
        if(ini==null)
            JOptionPane.showMessageDialog(this, "La lista está vacía");
        Deshabilitar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        LimpiarEntradas();
        Deshabilitar();
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       Deshabilitar();
    }//GEN-LAST:event_formWindowOpened
  
    private void btnCaargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaargarActionPerformed
        
   
        
         // Especificar la ruta del archivo   
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

    private void EXELSAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EXELSAVEActionPerformed
        
        ExportarExcel obj;//exportamos la clase mediante obj 

        try {
            obj = new ExportarExcel();
            obj.exportarExcel(tblRegistros);//name de la tabla
        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
        
    }//GEN-LAST:event_EXELSAVEActionPerformed

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
         

            Habilitar();
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
    }//GEN-LAST:event_jButton3ActionPerformed

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

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloRegistro_1().setVisible(true);
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
              
    void Habilitar() {
      
        btnEliminar.setEnabled(true);
        btnGrabar.setEnabled(false);
    }
    
    void Deshabilitar() {
       
        btnEliminar.setEnabled(false);
        btnGrabar.setEnabled(true);
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
    private javax.swing.JButton EXELSAVE;
    private javax.swing.JButton SALIDA;
    private javax.swing.JButton btnCaargar;
    private javax.swing.JButton btnCaargar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnGrabar1;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JComboBox<String> cbxEstadoAF;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
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
