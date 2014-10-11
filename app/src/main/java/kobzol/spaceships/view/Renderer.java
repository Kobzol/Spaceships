package kobzol.spaceships.view;

import android.graphics.Canvas;

/**
 * Renders a model.
 */
public interface Renderer {
    /**
     * Draw the model onto a canvas.
     * @param canvas canvas
     */
    void draw(Canvas canvas);
}
