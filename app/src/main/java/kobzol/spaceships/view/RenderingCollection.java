package kobzol.spaceships.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import kobzol.spaceships.model.Movable;
import kobzol.spaceships.ui.DisplayHelper;

/**
 * Contains methods for rendering objects.
 */
public class RenderingCollection {
    /**
     * Draws the given bitmap centered at the specified location.
     * @param object movable object
     * @param bitmap bitmap
     * @param canvas canvas
     * @param interpolation interpolation value
     */
    public static void renderCenteredBitmap(Movable object, Bitmap bitmap, Canvas canvas, float interpolation) {
        canvas.drawBitmap(bitmap, null, DisplayHelper.getRectangle(object), Renderer.DEFAULT_PAINT);
    }
}
