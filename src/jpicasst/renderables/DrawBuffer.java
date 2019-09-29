/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst.renderables;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import jpicasst.renderables.Renderable;


public interface DrawBuffer{
    
    public static BufferedImage createTexture2D(int width, int height) {
        
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = ge.getDefaultScreenDevice();
        GraphicsConfiguration config = device.getDefaultConfiguration();
        
        return config.createCompatibleImage(width, height, BufferedImage.TRANSLUCENT);
    }
    
    void begin(Object...args);
    
    void update(Object...values);
    
    void draw(Graphics2D g);
    
    Renderable end();
    
    void discard();
    
    boolean isActive();
    
}
