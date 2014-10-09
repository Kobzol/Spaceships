package kobzol.spaceships.model;

import android.graphics.Canvas;

/**
 * Object that can be drawn to a canvas.
 *
 * The draw method is called in every iteration of the game loop.
 */
public interface Drawable {
    void draw(Canvas canvas);
}
