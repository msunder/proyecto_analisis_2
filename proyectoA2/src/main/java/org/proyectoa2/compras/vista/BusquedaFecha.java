/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.compras.vista;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Compra;
import org.proyectoa2.compras.controlador.ManejoCompra;
import org.proyectoa2.compras.controlador.ModeloCompras;

/**
 *
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class BusquedaFecha extends javax.swing.JFrame {
    private final ManejoCompra manejoCompra;
    private DetallesCompra detallesCompra;

    /**
     * Creates new form BusquedaFecha
     */
    public BusquedaFecha() {
        initComponents();
        this.setLocationRelativeTo(null);
        manejoCompra = new ManejoCompra();
        manejoCompra.listarCompras((DefaultTableModel) tablaCompras.getModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCompras = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        selectorFecha = new com.toedter.calendar.JDateChooser();
        botonBuscarFecha = new javax.swing.JButton();
        botonVerDetalle = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(760, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Busqueda de compras por fecha");
        jLabel1.setFocusable(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        tablaCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Factura", "Fecha", "Proveedor", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaCompras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 710, 280));

        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 18)); // NOI18N
        jLabel2.setText("Fecha");
        jLabel2.setFocusable(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, 30));
        getContentPane().add(selectorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 210, 30));

        botonBuscarFecha.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        botonBuscarFecha.setText("Buscar");
        botonBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarFechaActionPerformed(evt);
            }
        });
        getContentPane().add(botonBuscarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, -1, -1));

        botonVerDetalle.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        botonVerDetalle.setText("Ver Detalle");
        botonVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerDetalleActionPerformed(evt);
            }
        });
        getContentPane().add(botonVerDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, -1, -1));

        botonCancelar.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarFechaActionPerformed
        if (selectorFecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha valida", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "La fecha es correcta?", "Confirmar Busqueda", JOptionPane.YES_NO_OPTION) == 0) {
                Date fecha = selectorFecha.getDate();
                ModeloCompras modeloCompras = new ModeloCompras();
                Compra compra = new Compra();
                compra.setFecha(fecha);
                DefaultTableModel modelo = (DefaultTableModel) tablaCompras.getModel();
                modelo.setRowCount(0);
                tablaCompras.setModel(modelo);
                modelo = modeloCompras.ModeloCompras("Fecha", compra, (DefaultTableModel) tablaCompras.getModel());
                if (modelo.getRowCount() <= 0) {
                    JOptionPane.showMessageDialog(null, "No se encontro la fecha", "Error", JOptionPane.INFORMATION_MESSAGE);
                    manejoCompra.listarCompras((DefaultTableModel) tablaCompras.getModel());
                } else {
                    tablaCompras.setModel(modelo);
                }
            }
        }
    }//GEN-LAST:event_botonBuscarFechaActionPerformed

    private void botonVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerDetalleActionPerformed
        boolean b = false;
        for (int i = 0; i < tablaCompras.getRowCount(); i++) {
            if (tablaCompras.isRowSelected(i) == true) {
                b = true;
            }
        }
        if (b == true) {
            if (JOptionPane.showConfirmDialog(null, "La compra seleccionada es correcta", "Mostrar Detalle", JOptionPane.YES_NO_OPTION) == 0) {
                String factura = (String) tablaCompras.getValueAt(tablaCompras.getSelectedRow(), 0);
                detallesCompra = new DetallesCompra(factura);
                detallesCompra.setVisible(true);
                DefaultTableModel modelo = (DefaultTableModel) tablaCompras.getModel();
                modelo.setRowCount(0);
                tablaCompras.setModel(modelo);
                manejoCompra.listarCompras((DefaultTableModel) tablaCompras.getModel());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una compra de la tabla para ver el detalle", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonVerDetalleActionPerformed

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
            java.util.logging.Logger.getLogger(BusquedaFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaFecha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BusquedaFecha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarFecha;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonVerDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser selectorFecha;
    private javax.swing.JTable tablaCompras;
    // End of variables declaration//GEN-END:variables
}
