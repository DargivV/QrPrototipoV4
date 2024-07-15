package proyectoUnidad3;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MODULOPRINCIPAL extends javax.swing.JFrame {

    
    
    
    
 // Labes Iconos imagenses 
    private  void SetImageLabel(JLabel labelName,String root){
    ImageIcon image = new ImageIcon(root);
    Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(),Image.SCALE_DEFAULT));
    labelName.setIcon(icon);
    this.repaint();  }
    
    
    public MODULOPRINCIPAL() {
        initComponents();
                this.setLocationRelativeTo(this);
                
        SetImageLabel(registroIma1,"src\\Multimedias\\modulofondo1.png");
        
        //SetImageLabel(LabelTitulo,"src\\Multimedias\\tituloss.png");
    }
public Image getIconImage(){
    
    Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Multimedias/MinIcon.png"));
    
    return retValue;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jbtREGISTRO = new javax.swing.JButton();
        jbtVALIDACION1 = new javax.swing.JButton();
        jbtREPORTE = new javax.swing.JButton();
        registroIma = new javax.swing.JLabel();
        registroIma1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SALIDA = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 200, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 200, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 200, 20));

        jbtREGISTRO.setBackground(new java.awt.Color(51, 51, 51));
        jbtREGISTRO.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        jbtREGISTRO.setForeground(new java.awt.Color(255, 255, 255));
        jbtREGISTRO.setText("REGISTRO");
        jbtREGISTRO.setBorder(null);
        jbtREGISTRO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtREGISTROMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtREGISTROMouseExited(evt);
            }
        });
        jbtREGISTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtREGISTROActionPerformed(evt);
            }
        });
        jPanel1.add(jbtREGISTRO, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 200, 40));

        jbtVALIDACION1.setBackground(new java.awt.Color(51, 51, 51));
        jbtVALIDACION1.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        jbtVALIDACION1.setForeground(new java.awt.Color(255, 255, 255));
        jbtVALIDACION1.setText("VALIDADCION");
        jbtVALIDACION1.setBorder(null);
        jbtVALIDACION1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtVALIDACION1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtVALIDACION1MouseExited(evt);
            }
        });
        jbtVALIDACION1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVALIDACION1ActionPerformed(evt);
            }
        });
        jPanel1.add(jbtVALIDACION1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 200, 53));

        jbtREPORTE.setBackground(new java.awt.Color(51, 51, 51));
        jbtREPORTE.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        jbtREPORTE.setForeground(new java.awt.Color(255, 255, 255));
        jbtREPORTE.setText("REPORTES");
        jbtREPORTE.setBorder(null);
        jbtREPORTE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtREPORTEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtREPORTEMouseExited(evt);
            }
        });
        jbtREPORTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtREPORTEActionPerformed(evt);
            }
        });
        jPanel1.add(jbtREPORTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 200, 51));

        registroIma.setText("jLabel2");
        jPanel1.add(registroIma, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, 710, 500));

        registroIma1.setText("jLabel2");
        jPanel1.add(registroIma1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, 0, 710, 500));

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
        jPanel2.add(SALIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 10, 43, 34));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 660, 50));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, 630, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 660, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtREGISTROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtREGISTROActionPerformed
        // TODO add your handling code here:
        ModuloRegistro_1 TB= new ModuloRegistro_1 ();//creamos el objeto
        TB.setVisible(true);//mantiene siempre activo la funcion 
        
        dispose();//cierra la ventana actual
         
        
    }//GEN-LAST:event_jbtREGISTROActionPerformed

    private void jbtVALIDACION1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVALIDACION1ActionPerformed
        // TODO add your handling code here:
        
        
        MODULOVALIDACION MV= new MODULOVALIDACION();//creamos el objeto
        MV.setVisible(true);//mantiene siempre activo la funcion 
    dispose();//cierra la ventana actual
    }//GEN-LAST:event_jbtVALIDACION1ActionPerformed

    private void jbtREPORTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtREPORTEActionPerformed
        
          ModuloREPORTS MR= new ModuloREPORTS();//creamos el objeto
        MR.setVisible(true);//mantiene siempre activo la funcion 
    dispose();//cierra la ventana actual
    
    }//GEN-LAST:event_jbtREPORTEActionPerformed

    private void jbtREGISTROMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtREGISTROMouseEntered
        // raton pasa por registro 
        
        SetImageLabel(registroIma,"src\\Multimedias\\Registro.png");
    }//GEN-LAST:event_jbtREGISTROMouseEntered

    private void jbtREGISTROMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtREGISTROMouseExited
        // TODO add your handling code here:
          SetImageLabel(registroIma,null);
    }//GEN-LAST:event_jbtREGISTROMouseExited

    private void jbtVALIDACION1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtVALIDACION1MouseEntered
        // TODO add your handling code here:
         SetImageLabel(registroIma,"src\\Multimedias\\Validacion.png");
    }//GEN-LAST:event_jbtVALIDACION1MouseEntered

    private void jbtVALIDACION1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtVALIDACION1MouseExited
        // TODO add your handling code here:
          SetImageLabel(registroIma,null);
    }//GEN-LAST:event_jbtVALIDACION1MouseExited

    private void jbtREPORTEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtREPORTEMouseEntered
        // TODO add your handling code here:
        
         SetImageLabel(registroIma,"src\\Multimedias\\Reporte.png");
    }//GEN-LAST:event_jbtREPORTEMouseEntered

    private void jbtREPORTEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtREPORTEMouseExited
        // TODO add your handling code here:
          SetImageLabel(registroIma,null);
    }//GEN-LAST:event_jbtREPORTEMouseExited

    private void SALIDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIDAActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_SALIDAActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MODULOPRINCIPAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SALIDA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbtREGISTRO;
    private javax.swing.JButton jbtREPORTE;
    private javax.swing.JButton jbtVALIDACION1;
    private javax.swing.JLabel registroIma;
    private javax.swing.JLabel registroIma1;
    // End of variables declaration//GEN-END:variables
}
