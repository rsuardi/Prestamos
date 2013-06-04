/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IngresosRangoFecha.java
 *
 * Created on Oct 13, 2011, 9:16:41 PM
 */
package com.wiled.ubicame.prestamos.forms;

import com.wiled.ubicame.prestamos.datalayer.Controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author egarcia
 */
public class IngresosRangoFecha extends javax.swing.JDialog {

    /** Creates new form IngresosRangoFecha */
    public IngresosRangoFecha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        desdeFechaPicker = new org.jdesktop.swingx.JXDatePicker();
        hastaFechaPicker = new org.jdesktop.swingx.JXDatePicker();
        generarReporteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresos en Rango de Fecha");
        setResizable(false);

        jLabel1.setText("Fecha Inicial:");

        jLabel2.setText("Fecha Final:");

        generarReporteBtn.setText("Generar Reporte");
        generarReporteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteBtnActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(desdeFechaPicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 159, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(hastaFechaPicker, 0, 0, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(generarReporteBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel1)
                    .add(desdeFechaPicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jLabel2)
                    .add(hastaFechaPicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(generarReporteBtn)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarReporteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteBtnActionPerformed
        // TODO add your handling code here:
        Date desde = desdeFechaPicker.getDate();
        Date hasta = hastaFechaPicker.getDate();

        if (desde == null || hasta == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha para generar el reporte.", "Error de validacion", JOptionPane.ERROR_MESSAGE);
        }
        
        Map parameters = new HashMap();
        parameters.put("fechaInicial", desde);
        parameters.put("fechaFinal", hasta);

        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/reports/EntradaRangoFechas.jasper"));
            
            JasperPrint print = JasperFillManager.fillReport(report, parameters, Controller.getInstance().getJDBCConnection());
            JasperViewer.viewReport(print, false);

            this.dispose();
            
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Jasper Report Exception", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_generarReporteBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker desdeFechaPicker;
    private javax.swing.JButton generarReporteBtn;
    private org.jdesktop.swingx.JXDatePicker hastaFechaPicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}