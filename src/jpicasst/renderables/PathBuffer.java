/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpicasst.renderables;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import jpicasst.Canvas;

/**
 *
 * @author Naitsirc98
 */
public class PathBuffer implements DrawBuffer {

    private boolean active = false;
    private Color color;
    private Stroke stroke;
    private int strokeThickness;
    private List<Integer> vertices;
    private int x0, y0;
    private int x1, y1;

    public PathBuffer() {
        this.vertices = new ArrayList<>();
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void begin(Object... args) {

        x0 = Integer.MAX_VALUE;
        y0 = Integer.MAX_VALUE;
        x1 = Integer.MIN_VALUE;
        y1 = Integer.MIN_VALUE;

        vertices.clear();
        
        update(args[0], args[1]);

        color = (Color) args[2];
        strokeThickness = (Integer)args[3];
        stroke = new BasicStroke(strokeThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        active = true;
    }

    @Override
    public void update(Object... values) {
        assert (active);

        final int x = (int) values[0];
        final int y = (int) values[1];

        vertices.add(x);
        vertices.add(y);

        x0 = Integer.min(x0, x);
        y0 = Integer.min(y0, y);

        x1 = Integer.max(x1, x);
        y1 = Integer.max(y1, y);

    }

    @Override
    public void draw(Graphics2D g) {
        assert (active);

        if (vertices.size() <= 2) {
            return;
        }
        
        g.setColor(color);
        g.setStroke(stroke);

        int lastX = vertices.get(0);
        int lastY = vertices.get(1);

        for (int i = 2; i < vertices.size(); i += 2) {

            final int x = vertices.get(i);
            final int y = vertices.get(i + 1);

            g.drawLine(lastX, lastY, x, y);

            lastX = x;
            lastY = y;
        }

    }

    @Override
    public Renderable end() {
        assert (active);

        active = false;

        final int width = Integer.max(Math.abs(x1 - x0), 1);
        final int height = Integer.max(Math.abs(y1 - y0), 1);

        BufferedImage texture = DrawBuffer.createTexture2D(width+ strokeThickness * 2, height+ strokeThickness * 2);
        
        Graphics2D g = texture.createGraphics();

        Canvas.getInstance().setGraphicsConfig(g);
        g.setStroke(stroke);
        g.setColor(color);
        
        x0 -= strokeThickness;
        y0 -= strokeThickness;

        int lastX = vertices.get(0) - x0;
        int lastY = vertices.get(1) - y0;

        for (int i = 2; i < vertices.size(); i += 2) {

            final int x = vertices.get(i) - x0;
            final int y = vertices.get(i + 1) - y0;

            g.drawLine(lastX, lastY, x, y);

            lastX = x;
            lastY = y;
        }

        g.dispose();

        return new Renderable(texture, new Rectangle(x0, y0, width, height));
    }

    @Override
    public void discard() {
        active = false;
    }

}
