/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.UIManager;

/**
 *
 * @author Naitsirc98
 */
public class ColorComboBoxRenderer extends DefaultListCellRenderer {

    private final Map<String, ImageIcon> iconMap = new HashMap<>();

    public ColorComboBoxRenderer() {
        iconMap.put("Black", new ImageIcon(getClass().getResource("black.png")));
        iconMap.put("White", new ImageIcon(getClass().getResource("white.png")));
        iconMap.put("Red", new ImageIcon(getClass().getResource("red.png")));
        iconMap.put("Green", new ImageIcon(getClass().getResource("green.png")));
        iconMap.put("Blue", new ImageIcon(getClass().getResource("blue.png")));
        iconMap.put("Yellow", new ImageIcon(getClass().getResource("yellow.png")));
        iconMap.put("Orange", new ImageIcon(getClass().getResource("orange.png")));
        iconMap.put("Pink", new ImageIcon(getClass().getResource("pink.png")));
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
