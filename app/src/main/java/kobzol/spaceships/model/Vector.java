package kobzol.spaceships.model;

import android.graphics.PointF;

/**
 * Represents vector.
 */
public class Vector extends PointF implements Copyable<Vector> {
    public static final Vector ZERO = new Vector(0, 0);

    public Vector(float x, float y) {
        super(x, y);
    }


    @Override
    public Vector copy() {
        return new Vector(this.x, this.y);
    }
}
