/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.vista;

import org.marcos.dto.Orden;
import org.proyectoa2.ventas.controller.ManejoColaOrdenes;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author marcos
 */
public class CobrarOrdenForm extends javax.swing.JFrame {
    private ManejoColaOrdenes manejador;
    private ButtonGroup grupo;
    private Orden orden;
    /**
     * Creates new form CobrarOrdenForm
     */
    public CobrarOrdenForm() {
        initComponents();
    }
    public CobrarOrdenForm(Orden orden) {
        initComponents();
        manejador = ManejoColaOrdenes.obtenerControlador();
        grupo = new ButtonGroup();
        grupo.add(botonEfectivo);
        grupo.add(botonSaldo);
        this.textoCliente.setText(orden.getCliente().getNombreCliente());
        this.etiquetaTotal.setText(Double.toString(orden.getTotal()));
        this.orden = orden;
        this.botonEfectivo.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSaldo = new javax.swing.JRadioButton();
        botonEfectivo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        etiquetaTotal = new javax.swing.JLabel();
        textoCliente = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        botonConfirmarPago = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        textoCantidadCancelar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        noFactura = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(553, 377));
        setPreferredSize(new java.awt.Dimension(553, 377));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonSaldo.setText("Saldo");
        getContentPane().add(botonSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        botonEfectivo.setText("Efectivo");
        getContentPane().add(botonEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        jLabel1.setText("Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setText("Total");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        etiquetaTotal.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        etiquetaTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(etiquetaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 270, 30));
        getContentPane().add(textoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 10, 310));

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setText("Forma de Pago");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        botonConfirmarPago.setText("Confirmar Pago");
        botonConfirmarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarPagoActionPerformed(evt);
            }
        });
        getContentPane().add(botonConfirmarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 130, -1));
        getContentPane().add(textoCantidadCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 270, 30));

        jLabel6.setText("Cantidad a Cancelar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel4.setText("Realizar Pago");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        jLabel2.setText("Factura");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));
        getContentPane().add(noFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 270, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConfirmarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarPagoActionPerformed
        // TODO add your handling code here
        int indice = manejador.obtenerCola().indexOf(orden);
        int tipoCobro;
        if(this.botonEfectivo.isSelected()){
            tipoCobro = 1;
        }else{
            tipoCobro = 2;
        }
        if(tipoCobro == 1 && (this.textoCantidadCancelar.getText().length() == 0 ||
                                Double.valueOf(this.textoCantidadCancelar.getText()) < orden.getTotal())
                                || this.noFactura.getText().length() == 0){
            String tmp = "No se puede realizar la transaccion.";
            if(this.textoCantidadCancelar.getText().length() == 0 ){
                tmp = tmp + "\n   * El campo cantidad a cancelar esta vacio";
            }
            if(Double.valueOf(this.textoCantidadCancelar.getText()) < orden.getTotal()){
                tmp = tmp + "\n   * La cantidad a cancelar es insuficiente";
            }
            if(this.noFactura.getText().length() == 0){
                tmp = tmp + "\n   * El campo de factura esta vacio";
            }
            JOptionPane.showMessageDialog(null, tmp, "Error, no se puede procesar!!!", JOptionPane.WARNING_MESSAGE);
        }else{
            double pago; 
            this.orden.setNoFactura(this.noFactura.getText());
            if(this.textoCantidadCancelar.getText().length() == 0 ){
                pago = 0;
            }else{
                pago = Double.valueOf(this.textoCantidadCancelar.getText());
            }
            double cambio = manejador.cobrarOrden(indice, tipoCobro, pago);
            JOptionPane.showMessageDialog(null, "El cambio del pago es: Q." + cambio, "Transaccion exitosa", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_botonConfirmarPagoActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CobrarOrdenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CobrarOrdenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CobrarOrdenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CobrarOrdenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CobrarOrdenForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonConfirmarPago;
    private javax.swing.JRadioButton botonEfectivo;
    private javax.swing.JRadioButton botonSaldo;
    private javax.swing.JLabel etiquetaTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField noFactura;
    private javax.swing.JTextField textoCantidadCancelar;
    private javax.swing.JTextField textoCliente;
    // End of variables declaration//GEN-END:variables
}
