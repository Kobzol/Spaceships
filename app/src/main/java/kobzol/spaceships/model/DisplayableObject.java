package kobzol.spaceships.model;

import android.graphics.PointF;

import kobzol.spaceships.view.Renderer;

/**
 * Object that can be displayed on canvas.
 */
public abstract class DisplayableObject implements Movable {
    private PointF location;
    private Dimension dimension;
    private float speed;

    private Renderer renderer;

    public DisplayableObject(Dimension dimension, float speed) {
        this.location = new PointF(0, 0);
        this.dimension = dimension;
        this.speed = speed;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    @Override
    public PointF getLocation() {
        return this.location;
    }

    @Override
    public void moveBy(float x, float y) {
        this.moveTo(this.location.x + x, this.location.y + y);
    }

    @Override
    public void moveTo(float x, float y) {
        this.location.set(x, y);
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }
}
