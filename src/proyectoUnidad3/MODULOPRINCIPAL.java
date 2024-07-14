package proyectoUnidad3;

import javax.swing.JOptionPane;

public class MODULOPRINCIPAL extends javax.swing.JFrame {

   
    public MODULOPRINCIPAL() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtREGISTRO = new javax.swing.JButton();
        jbtREPORTE = new javax.swing.JButton();
        jbtVALIDACION1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtREGISTRO.setText("REGSITRO");
        jbtREGISTRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtREGISTROActionPerformed(evt);
            }
        });

        jbtREPORTE.setText("REPORTES");
        jbtREPORTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtREPORTEActionPerformed(evt);
            }
        });

        jbtVALIDACION1.setText("VALIDADCION");
        jbtVALIDACION1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVALIDACION1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbtREPORTE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtVALIDACION1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(jbtREGISTRO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jbtREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtVALIDACION1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtREPORTE, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MODULOPRINCIPAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtREGISTRO;
    private javax.swing.JButton jbtREPORTE;
    private javax.swing.JButton jbtVALIDACION1;
    // End of variables declaration//GEN-END:variables
}
