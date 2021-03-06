package kobzol.spaceships.view;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Renders a model.
 */
public interface Renderer {
    public static final Paint DEFAULT_PAINT = new Paint();

    /**
     * Draw the model onto a canvas.
     * @param canvas canvas
     * @param interpolation interpolation value
     */
    void draw(Canvas canvas, float interpolation);
}
