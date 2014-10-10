package kobzol.spaceships.model;

import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Object that can be drawn to a canvas.
 *
 * The draw method is called in every iteration of the game loop.
 */
public interface Drawable {
    /**
     * Draws itself onto a canvas.
     * @param canvas canvas
     */
    void draw(Canvas canvas);

    /**
     * Returns it's position.
     * @return Position of the object.
     */
    Point getPosition();
}
