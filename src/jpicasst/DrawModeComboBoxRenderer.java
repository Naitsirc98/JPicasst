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
public class DrawModeComboBoxRenderer extends DefaultListCellRenderer {

    private final Map<String, ImageIcon> iconMap = new HashMap<>();

    public DrawModeComboBoxRenderer() {
        iconMap.put("Outline", new ImageIcon(getClass().getResource("rectangle.png")));
        iconMap.put("Fill", new ImageIcon(getClass().getResource("fill.png")));
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
