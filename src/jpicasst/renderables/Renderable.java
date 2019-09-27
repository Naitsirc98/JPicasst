/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst.renderables;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Renderable {
    
    private final BufferedImage texture;
    private final Rectangle boundingBox;
    
    public Renderable(BufferedImage texture, Rectangle bb) {
        this.texture = texture;
        this.boundingBox = bb;
    }
    
    public BufferedImage getTexture() {
        return texture;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }
    
}
