/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 *
 * @author Naitsirc98
 */
public class ShapeComboBoxRenderer extends DefaultListCellRenderer {

    private final Map<String, ImageIcon> iconMap = new HashMap<>();

    public ShapeComboBoxRenderer() {
        iconMap.put("Rectangle", new ImageIcon(getClass().getResource("rectangle.png")));
        iconMap.put("Ellipse", new ImageIcon(getClass().getResource("ellipse.png")));
        iconMap.put("Triangle", new ImageIcon(getClass().getResource("triangle.png")));
        iconMap.put("Pentagon", new ImageIcon(getClass().getResource("pentagon.png")));
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        String color = (String) value;
        this.setText(color);
        this.setIcon(iconMap.get(color));
        return this;
    }

}
