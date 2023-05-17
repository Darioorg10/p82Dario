/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package application;

import controllers.FacturaJpaController;
import entities.Factura;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dario
 */
public class VentanaConsultar extends javax.swing.JFrame {

    /**
     * Creates new form VentanaActualizar
     */
    public VentanaConsultar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        botonRegresar = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        PanelPrincipal.setBackground(new java.awt.Color(48, 56, 65));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonRegresar.setBackground(new java.awt.Color(255, 75, 0));
        botonRegresar.setFont(new java.awt.Font("Liberation Sans", 1, 33)); // NOI18N
        botonRegresar.setForeground(new java.awt.Color(238, 238, 238));
        botonRegresar.setText("Regresar");
        botonRegresar.setBorder(null);
        botonRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRegresarMouseClicked(evt);
            }
        });
        PanelPrincipal.add(botonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, 200, 50));

        titulo.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 173, 181));
        titulo.setText("CONSULTA FACTURAS");
        titulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelPrincipal.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 420, 60));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setShowGrid(true);
        jScrollPane1.setViewportView(tabla);

        PanelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 930, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRegresarMouseClicked
        // TODO add your handling code here:
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
        ventanaInicio.setLocationRelativeTo(null);
        ventanaInicio.setResizable(false);
        this.dispose();
    }//GEN-LAST:event_botonRegresarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        // Vamos a crear un manejador de entidades, al que le tenemos que añadir el nombre que tenemos en el persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("p82dario");

        // Creamos un controlador con el manejador de entidades
        controllers.FacturaJpaController controlador = new FacturaJpaController(emf);

        // Creamos una lista con todas las facturas
        List<Factura> listaFacturas = controlador.findFacturaEntities();

        // Creamos un array de String que contenga los títulos que queremos insertar en la tabla
        String[] columnas = {"Codigo", "Fecha", "Descripcion", "Importe"};

        // Creamos un modelo para la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            // Ponemos un método sobreescrito para que la tabla no se pueda editar
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        modeloTabla.setColumnIdentifiers(columnas);

        // Recorremos la lista añadiendo los datos
        for (Factura f : listaFacturas) {
            // Tenemos que meter los datos de cada factura en un array de tipo object
            SimpleDateFormat formateo = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = formateo.format(f.getFechaEmision());
            Object[] filaFactura = {f.getCodFactura(), fechaFormateada, f.getDescripcion(), f.getTotalImporteFactura()};
            modeloTabla.addRow(filaFactura); // Añadimos cada dato a cada fila
        }

        // Hacemos que la tabla tome como modelo el que hemos creado
        tabla.setModel(modeloTabla);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(VentanaConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaConsultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConsultar().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
