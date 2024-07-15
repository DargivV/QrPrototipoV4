package proyectoUnidad3;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);
        SetImageLabel(JLabel,"src\\Multimedias\\UsurioIcon.png");
        SetImageLabel(jLabel2,"src\\Multimedias\\MinIcon.png");
                SetImageLabel(jLabel4,"src\\Multimedias\\FOndo2.jpg");
    }
// iconos metodo
    public Image getIconImage(){
    
    Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Multimedias/MinIcon.png"));
    
    return retValue;
    }
   
    // Labes Iconos imagenses 
    private  void SetImageLabel(JLabel labelName,String root){
    ImageIcon image = new ImageIcon(root);
    Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(),Image.SCALE_DEFAULT));
    labelName.setIcon(icon);
    this.repaint();

}

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Usuario.setBackground(new java.awt.Color(51, 51, 51));
        Usuario.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        Usuario.setForeground(new java.awt.Color(204, 204, 204));
        Usuario.setText("Ingrese el usuario de administrador");
        Usuario.setBorder(null);
        Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UsuarioMousePressed(evt);
            }
        });
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 290, 36));

        jLabel1.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contraseña");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 101, -1));

        jButton1.setBackground(new java.awt.Color(246, 246, 246));
        jButton1.setFont(new java.awt.Font("Reem Kufi", 0, 24)); // NOI18N
        jButton1.setText("Iniciar sesion ");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                y(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 340, 68));

        Password.setBackground(new java.awt.Color(51, 51, 51));
        Password.setFont(new java.awt.Font("Reem Kufi", 0, 14)); // NOI18N
        Password.setForeground(new java.awt.Color(204, 204, 204));
        Password.setText("123");
        Password.setBorder(null);
        Password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PasswordMousePressed(evt);
            }
        });
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 300, 30));

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 340, 10));

        jLabel3.setFont(new java.awt.Font("Reem Kufi", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 101, -1));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 340, 10));

        jLabel2.setText("jLabel2");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 380, 270));

        jLabel4.setText("jLabel4");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, -4, 500, 640));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLabel.setText("jLabel3");
        jPanel2.add(JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 284, 284));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void y(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_y
        // TODO add your handling code here:

    }//GEN-LAST:event_y

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String User = "admin"   ;
        String Contr =  "123" ;

        String Pass;
        Pass = new String (Password.getPassword());//.gerpassoword es solamente para el cuadro de pasword esta en los frame

        if (Usuario.getText().equals(User)&&Pass.equals(Contr)) {

            //esto cierra y abre otra ventana de nuestro frmaes

            MODULOPRINCIPAL MP= new MODULOPRINCIPAL();//creamos el objeto
            MP.setVisible(true);//visualisa la otra ventgana
            dispose();//cierra la ventana actual
        }
        else{
            JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrecta ");//mesaje de error
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed

    }//GEN-LAST:event_UsuarioActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton1MouseClicked

    private void UsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuarioMousePressed
        // TODO add your handling code here:
        if (Usuario.getText().equals("Ingrese el usuario de administrador")){
        Usuario.setText("");}

        if (String.valueOf(Password.getPassword()).isEmpty()){
         
        Password.setText("........");}
        
    }//GEN-LAST:event_UsuarioMousePressed

    private void PasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordMousePressed
        // TODO add your handling code here:
         if (String.valueOf(Password.getPassword()).isEmpty()){
        Usuario.setText("Ingrese el usuario de administrador");
         }
         if (Usuario.getText().equals("Ingrese el usuario de administrador")){
        Password.setText("");
         }
    }//GEN-LAST:event_PasswordMousePressed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
