package kobzol.spaceships.model;

import android.graphics.PointF;

/**
 * Interface for objects that can change their location.
 */
public interface Movable {
    /**
     * Returns the object's location.
     * @return location
     */
    PointF getLocation();

    /**
     * Changes the object's location.
     * @param x horizontal change in pixels
     * @param y vertical change in pixels
     */
    void move(float x, float y);
}
