/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst;

import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JPanel;
import jpicasst.renderables.DrawBuffer;

/**
 *
 * @author Naitsirc98
 */
public class Tool {
    
    private final JButton button;
    private final ToolOptionsPanel panel;
    private final DrawBuffer buffer;

    public Tool(JButton button, ToolOptionsPanel panel, DrawBuffer buffer) {
        this.button = button;
        this.panel = panel;
        this.buffer = buffer;
    }

    public JButton getButton() {
        return button;
    }

    public ToolOptionsPanel getPanel() {
        return panel;
    }
    
    public DrawBuffer getDrawBuffer() {
        return buffer;
    }
    
}
