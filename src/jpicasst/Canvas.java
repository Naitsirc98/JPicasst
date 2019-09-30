package jpicasst;

import jpicasst.renderables.DrawBuffer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import static java.awt.RenderingHints.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.swing.JPanel;
import jpicasst.renderables.Renderable;

public class Canvas extends JPanel {

    private static Canvas instance;

    public static Canvas getInstance() {
        assert (instance != null);
        return instance;
    }

    private final Map<RenderingHints.Key, Object> graphicsConfig;
    private List<Renderable> renderQueue;
    private DrawBuffer buffer;

    public Canvas() {
        graphicsConfig = new HashMap<>();
        setupGraphicsConfig();
        renderQueue = new ArrayList<>();
        instance = this;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g = (Graphics2D) graphics;
        setGraphicsConfig(g);

        for(Renderable r : renderQueue) {
            graphics.drawImage(r.getTexture(), (int)r.getBoundingBox().getX(), (int)r.getBoundingBox().getY(), null);
        }
        
        if(buffer != null && buffer.isActive()) {
            buffer.draw(g);
        }

        graphics.dispose();
    }

    public void setGraphicsConfig(Graphics2D g) {
        g.setRenderingHints(graphicsConfig);
    }

    public List<Renderable> getRenderQueue() {
        return renderQueue;
    }
    
    public void setRenderQueue(List<Renderable> renderQueue) {
        this.renderQueue = renderQueue;
    }
    
    public void setDrawBuffer(DrawBuffer buffer) {
        this.buffer = buffer;
    }

    private void setupGraphicsConfig() {

        graphicsConfig.put(KEY_RENDERING, VALUE_RENDER_QUALITY);
        graphicsConfig.put(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        graphicsConfig.put(KEY_COLOR_RENDERING, VALUE_COLOR_RENDER_QUALITY);
        graphicsConfig.put(KEY_INTERPOLATION, VALUE_INTERPOLATION_BILINEAR);
        graphicsConfig.put(KEY_STROKE_CONTROL, VALUE_STROKE_NORMALIZE);

    }

}
