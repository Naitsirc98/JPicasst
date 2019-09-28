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
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import jpicasst.Canvas;

/**
 *
 * @author Naitsirc98
 */
public class ShapeBuffer implements DrawBuffer {

    private enum DrawMode {
        OUTLINE, FILL
    }

    private boolean active = false;
    private Point origin = new Point();
    private Point target = new Point();
    private Color color;
    private Stroke stroke;
    private int strokeThickness;
    private UpdatableShape shape;
    private DrawMode mode;

    @Override
    public void begin(Object... args) {

        origin.setLocation((int) args[0], (int) args[1]);
        target.setLocation(origin);

        color = (Color) args[2];
        strokeThickness = (int) args[3];
        stroke = new BasicStroke(strokeThickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        switch (args[4].toString()) {

            case "Rectangle":
                shape = new UpdatableRectangle();
                break;
            case "Ellipse":
                shape = new UpdatableEllipse();
                break;
            case "Triangle":
                shape = new UpdatableTriangle();
                break;
            case "Pentagon":
                shape = new UpdatablePentagon();
                break;

        }

        mode = args[5].equals("Outline") ? DrawMode.OUTLINE : DrawMode.FILL;

        active = true;
    }

    @Override
    public void update(Object... values) {
        target.setLocation((int) values[0], (int) values[1]);
        shape.update((int) values[0], (int) values[1]);
    }

    @Override
    public void draw(Graphics2D g) {

        g.setColor(color);
        g.setStroke(stroke);

        if (mode == DrawMode.OUTLINE) {
            g.draw(shape.getShape());
        } else {
            g.fill(shape.getShape());
        }

    }

    private Point max(Point p1, Point p2) {
        return p1.distance(0, 0) >= p2.distance(0, 0) ? p1 : p2;
    }

    private Point min(Point p1, Point p2) {
        return p1.distance(0, 0) < p2.distance(0, 0) ? p1 : p2;
    }

    @Override
    public Renderable end() {
        assert (active);

        Rectangle2D rect = shape.getBoundingBox();

        final int x0 = (int) rect.getMinX() - strokeThickness;
        final int y0 = (int) rect.getMinY() - strokeThickness;

        final int width = Integer.max((int) rect.getWidth(), 1);
        final int height = Integer.max((int) rect.getHeight(), 1);

        shape.translate(-x0, -y0);

        BufferedImage texture = DrawBuffer.createTexture2D(width + strokeThickness * 2, height + strokeThickness * 2);

        Graphics2D g = texture.createGraphics();
        Canvas.getInstance().setGraphicsConfig(g);
        g.setStroke(stroke);
        g.setColor(color);

        if (mode == DrawMode.OUTLINE) {
            g.draw(shape.getShape());
        } else {
            g.fill(shape.getShape());
        }

        g.dispose();

        active = false;

        shape = null;

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

    private interface UpdatableShape {

        void update(int x, int y);

        void translate(int x, int y);

        Shape getShape();

        Rectangle2D getBoundingBox();

    }

    private class UpdatableRectangle implements UpdatableShape {

        private Rectangle rectangle = new Rectangle();

        @Override
        public void update(int x, int y) {

            final int x0 = Integer.min(origin.x, x);
            final int y0 = Integer.min(origin.y, y);
            final int x1 = Math.abs(origin.x - x);
            final int y1 = Math.abs(origin.y - y);

            rectangle.setLocation(x0, y0);
            rectangle.setSize(x1, y1);
        }

        @Override
        public Shape getShape() {
            return rectangle;
        }

        @Override
        public void translate(int x, int y) {
            rectangle.translate(x, y);
        }

        @Override
        public Rectangle2D getBoundingBox() {
            return rectangle.getBounds2D();
        }

    }

    private class UpdatableEllipse implements UpdatableShape {

        private Ellipse2D.Float ellipse = new Ellipse2D.Float();

        @Override
        public void update(int x, int y) {

            final int x0 = Integer.min(origin.x, x);
            final int y0 = Integer.min(origin.y, y);
            final int x1 = Math.abs(origin.x - x);
            final int y1 = Math.abs(origin.y - y);

            ellipse.x = x0;
            ellipse.y = y0;
            ellipse.width = x1;
            ellipse.height = y1;

        }

        @Override
        public void translate(int x, int y) {
            ellipse.x += x;
            ellipse.y += y;
        }

        @Override
        public Shape getShape() {
            return ellipse;
        }

        @Override
        public Rectangle2D getBoundingBox() {
            return ellipse.getBounds2D();
        }

    }

    private class UpdatableTriangle implements UpdatableShape {

        private Polygon triangle;

        public UpdatableTriangle() {
            triangle = new Polygon(
                    new int[]{origin.x, origin.x, origin.x},
                    new int[]{origin.y, origin.y, origin.y},
                    3);
        }

        @Override
        public void update(int x, int y) {

            if (x < origin.x) {

                triangle.xpoints[0] = x;
                triangle.xpoints[2] = Math.abs(2 * origin.x - x);

            } else {

                triangle.xpoints[0] = Math.abs(2 * origin.x - x);
                triangle.xpoints[2] = x;

            }

            triangle.ypoints[0] = y;
            triangle.ypoints[2] = y;

        }

        @Override
        public void translate(int x, int y) {
            triangle.translate(x, y);
        }

        @Override
        public Shape getShape() {
            return triangle;
        }

        @Override
        public Rectangle2D getBoundingBox() {
            return triangle.getBounds2D();
        }

    }

    private class UpdatablePentagon implements UpdatableShape {
        
        /*
           2
         /  \
        1---3
        |   |
        0___4
        
        */

        private Polygon pentagon;

        public UpdatablePentagon() {

            pentagon = new Polygon(
                    new int[]{origin.x, origin.x, origin.x, origin.x, origin.x},
                    new int[]{origin.y, origin.y, origin.y, origin.y, origin.y},
                    5);

        }

        @Override
        public void update(int x, int y) {

            if (x < origin.x) {

                pentagon.xpoints[0] = pentagon.xpoints[1] = x;
                pentagon.xpoints[3] = pentagon.xpoints[4] = Math.abs(2 * origin.x - x);

            } else {

                pentagon.xpoints[0] = pentagon.xpoints[1] = Math.abs(2 * origin.x - x);
                pentagon.xpoints[3] = pentagon.xpoints[4] = x;

            }

            pentagon.ypoints[0] = pentagon.ypoints[4] = y;
           
            if(y < origin.y) {
                pentagon.ypoints[1] = pentagon.ypoints[3] = origin.y - Math.abs(origin.y - y) / 2;
            } else {
                pentagon.ypoints[1] = pentagon.ypoints[3] = origin.y + Math.abs(origin.y - y) / 2;
            }

        }

        @Override
        public void translate(int x, int y) {
            pentagon.translate(x, y);
        }

        @Override
        public Shape getShape() {
            return pentagon;
        }

        @Override
        public Rectangle2D getBoundingBox() {
            return pentagon.getBounds2D();
        }

    }

}
