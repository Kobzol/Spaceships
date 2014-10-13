package kobzol.spaceships.model;

import android.graphics.PointF;

/**
 * Object that can be displayed on canvas.
 */
public abstract class DisplayableObject implements Movable {
    private PointF location;
    private Dimension dimension;
    private Vector speed;

    public DisplayableObject(Dimension dimension) {
        this(dimension, Vector.ZERO);
    }
    public DisplayableObject(Dimension dimension, Vector speed) {
        this.location = new PointF(0, 0);
        this.dimension = dimension;
        this.speed = speed;
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
    public Vector getSpeed() {
        return this.speed;
    }
}
