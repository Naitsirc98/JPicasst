/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst.renderables;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Renderable {
    
    private final BufferedImage texture;
    private final Rectangle2D boundingBox;
    
    public Renderable(BufferedImage texture, Rectangle2D bb) {
        this.texture = texture;
        this.boundingBox = bb;
    }
    
    public BufferedImage getTexture() {
        return texture;
    }

    public Rectangle2D getBoundingBox() {
        return boundingBox;
    }
    
}
