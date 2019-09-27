/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JButton;

/**
 *
 * @author Naitsirc98
 */
public final class Utils {

    private Utils() {
    }

    private static final Color BLUE = new Color(0x0094FF);

    private static Map<String, Font> FONT_MAP;

    public static Map<String, Font> getFonts() {
        if (FONT_MAP == null) {
            FONT_MAP = new TreeMap<>();
            loadSystemFonts();
        }
        return FONT_MAP;
    }

    private static void loadSystemFonts() {
        FONT_MAP.put("Arial", new Font("Arial", Font.PLAIN, 14));
        FONT_MAP.put("Bodoni MT", new Font("Bodoni MT", Font.PLAIN, 14));
        FONT_MAP.put("Calibri", new Font("Calibri", Font.PLAIN, 14));
        FONT_MAP.put("Comic Sans MS", new Font("Comic Sans MS", Font.PLAIN, 14));
        FONT_MAP.put("Consolas", new Font("Consolas", Font.PLAIN, 14));
        FONT_MAP.put("Impact", new Font("Impact", Font.PLAIN, 14));
        FONT_MAP.put("Monospaced.plain", new Font("Monospaced.plain", Font.PLAIN, 14));
        FONT_MAP.put("Times New Roman", new Font("Times New Roman", Font.PLAIN, 14));
    }

    public static void setButtonsOpaque(JButton... buttons) {
        for (JButton b : buttons) {
            b.setContentAreaFilled(false);
            b.setOpaque(true);
        }
    }

    public static Color getColor(String colorName) {
        switch (colorName) {

            case "Black":
                return Color.BLACK;
            case "White":
                return Color.WHITE;
            case "Red":
                return Color.RED;
            case "Green":
                return Color.GREEN;
            case "Blue":
                return BLUE;
            case "Yellow":
                return Color.YELLOW;
            case "Orange":
                return Color.ORANGE;
            case "Pink":
                return Color.MAGENTA;
            default:
                return Color.BLACK;

        }
    }

}
