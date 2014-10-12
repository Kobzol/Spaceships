package kobzol.spaceships.model;

import android.graphics.PointF;

/**
 * Static class containing methods for moving movable objects.
 */
public class Mover {
    /**
     * Moves the objects towards the specific target point.
     * @param object movable object
     * @param destination destination point
     */
    public static void moveTowards(Movable object, PointF destination) {
        PointF vector = new PointF(destination.x - object.getLocation().x, destination.y - object.getLocation().y);
        double length = Math.sqrt(vector.x * vector.x + vector.y * vector.y);

        vector.set((float)(vector.x / length), (float)(vector.y / length));

        object.moveBy(vector.x * object.getSpeed(), vector.y * object.getSpeed());
    }
}
