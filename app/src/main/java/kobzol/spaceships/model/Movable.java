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
     * Returns the dimension of the object.
     * @return dimension
     */
    Dimension getDimension();

    /**
     * Changes the object's location (relative to it's curent location).
     * @param x horizontal change in pixels
     * @param y vertical change in pixels
     */
    void moveBy(float x, float y);

    /**
     * Changes the object's location.
     * @param x horizontal location in pixels
     * @param y vertical location in pixels
     */
    void moveTo(float x, float y);

    /**
     * Returns the object's speed.
     * @return speed in pixels/tick
     */
    float getSpeed();
}
