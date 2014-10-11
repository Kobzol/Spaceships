package kobzol.spaceships.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

import kobzol.spaceships.model.DisplayableObject;

/**
 * Static class containing various methods of object rendering.
 */
public class ObjectRenderer {
    private static PointF location = new PointF();
    private final static Paint DEFAULT_PAINT = new Paint();

    /**
     * Renders the object so that it's bitmap will be centered around it's location.
     * @param canvas canvas
     * @param object rendered object
     */
    public static void renderCentered(Canvas canvas, DisplayableObject object) {
        ObjectRenderer.render(canvas, object.getImage(), object.getLocation().x - object.getImage().getWidth() / 2, object.getLocation().y - object.getImage().getHeight() / 2, ObjectRenderer.DEFAULT_PAINT);
    }

    /**
     * Renders the object so that it's bitmap will be located at it's location.
     * @param canvas canvas
     * @param object rendered object
     */
    public static void renderTopLeft(Canvas canvas, DisplayableObject object) {
        ObjectRenderer.render(canvas, object.getImage(), object.getLocation().x, object.getLocation().y, ObjectRenderer.DEFAULT_PAINT);
    }

    /**
     * Renders the given image to a canvas.
     * @param canvas canvas
     * @param bitmap image
     * @param x horizontal position
     * @param y vertical position
     * @param paint paint
     */
    private static void render(Canvas canvas, Bitmap bitmap, float x, float y, Paint paint) {
        canvas.drawBitmap(bitmap, x, y, paint);
    }
}
