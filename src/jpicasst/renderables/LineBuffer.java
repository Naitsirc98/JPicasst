/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst.renderables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import jpicasst.Canvas;

/**
 *
 * @author Naitsirc98
 */
public class LineBuffer implements DrawBuffer {

    private boolean active = false;
    private Point origin = new Point();
    private Point target = new Point();
    private Color color;
    private Stroke stroke;
    private int strokeThickness;

    @Override
    public void begin(Object... args) {
        
        origin.setLocation((int) args[0], (int) args[1]);
        target.setLocation(origin);

        color = (Color) args[2];
        strokeThickness = (int) args[3];
        stroke = new BasicStroke(strokeThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        active = true;
    }

    @Override
    public void update(Object... values) {
        target.setLocation((int) values[0], (int) values[1]); 
    }

    @Override
    public void draw(Graphics2D g) {

        g.setColor(color);
        g.setStroke(stroke);

        g.drawLine(origin.x, origin.y, target.x, target.y);

    }
    
    private Point max(Point p1, Point p2) {
        return p1.distance(0, 0) >= p2.distance(0, 0) ? p1 : p2;
    }
    
    private Point min(Point p1, Point p2) {
         return p1.distance(0, 0) < p2.distance(0, 0) ? p1 : p2;
    }

    @Override
    public Renderable end() {
        assert(active);
        
        final int x0 = Integer.min(origin.x, target.x) - strokeThickness;
        final int y0 = Integer.min(origin.y, target.y) - strokeThickness;
        final int x1 = Integer.max(origin.x, target.x);
        final int y1 = Integer.max(origin.y, target.y);
        
        final int width = Integer.max(Math.abs(x1 - x0), 1);
        final int height = Integer.max(Math.abs(y1 - y0), 1) ;
        
        origin.translate(-x0, -y0);
        target.translate(-x0, -y0);

        BufferedImage texture = DrawBuffer.createTexture2D(width + strokeThickness * 2, height + strokeThickness * 2);

        Graphics2D g = texture.createGraphics();
        Canvas.getInstance().setGraphicsConfig(g);
        g.setStroke(stroke);
        g.setColor(color);

        g.drawLine(origin.x, origin.y, target.x, target.y);

        g.dispose();
        
        active = false;

        return new Renderable(texture, new Rectangle(x0, y0, width, height));
    }

    @Override
    public void discard() {
        active = false;
    }

    @Override
    public boolean isActive() {
        return active;
    }

}
