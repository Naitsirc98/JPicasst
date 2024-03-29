/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst;

import java.awt.Color;
import javax.swing.JSlider;

/**
 *
 * @author Naitsirc98
 */
public class ShapeOptionsPanel extends DrawingOptionsPanel {

    /**
     * Creates new form ShapeOptionsPanel
     */
    public ShapeOptionsPanel() {
        initComponents();
    }

    public String getShapeName() {
        return shapeChooser.getSelectedItem().toString();
    }

    public String getDrawMode() {
        return drawModeChooser.getSelectedItem().toString();
    }

    @Override
    public JSlider getStrokeSlider() {
        return strokeSlider;
    }

    @Override
    public Color getColor() {
        return Utils.getColor(colorChooser.getSelectedItem().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorChooser = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        strokeLabel = new javax.swing.JLabel();
        strokeSlider = new javax.swing.JSlider();
        shapeChooser = new javax.swing.JComboBox<>();
        drawModeChooser = new javax.swing.JComboBox<>();

        colorChooser.setBackground(new java.awt.Color(255, 255, 255));
        colorChooser.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        colorChooser.setForeground(new java.awt.Color(0, 0, 0));
        colorChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Black", "White", "Red", "Green", "Blue", "Yellow", "Orange", "Pink" }));
        colorChooser.setRenderer(new ColorComboBoxRenderer());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        strokeLabel.setBackground(new java.awt.Color(0, 0, 0));
        strokeLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        strokeLabel.setForeground(new java.awt.Color(255, 255, 255));
        strokeLabel.setText("STROKE: 3");

        strokeSlider.setBackground(new java.awt.Color(0, 0, 0));
        strokeSlider.setForeground(new java.awt.Color(255, 255, 255));
        strokeSlider.setMaximum(10);
        strokeSlider.setMinimum(1);
        strokeSlider.setMinorTickSpacing(1);
        strokeSlider.setPaintTicks(true);
        strokeSlider.setValue(3);
        strokeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                strokeSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(strokeLabel)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(strokeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(strokeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strokeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        shapeChooser.setBackground(new java.awt.Color(255, 255, 255));
        shapeChooser.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        shapeChooser.setForeground(new java.awt.Color(0, 0, 0));
        shapeChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rectangle", "Ellipse", "Triangle", "Pentagon" }));
        shapeChooser.setRenderer(new ShapeComboBoxRenderer());

        drawModeChooser.setBackground(new java.awt.Color(255, 255, 255));
        drawModeChooser.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        drawModeChooser.setForeground(new java.awt.Color(0, 0, 0));
        drawModeChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Outline", "Fill" }));
        drawModeChooser.setRenderer(new DrawModeComboBoxRenderer());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shapeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(drawModeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(colorChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(shapeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(drawModeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void strokeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_strokeSliderStateChanged
        strokeLabel.setText("STROKE: " + strokeSlider.getValue());
    }//GEN-LAST:event_strokeSliderStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> colorChooser;
    private javax.swing.JComboBox<String> drawModeChooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> shapeChooser;
    private javax.swing.JLabel strokeLabel;
    private javax.swing.JSlider strokeSlider;
    // End of variables declaration//GEN-END:variables

}
