package kobzol.spaceships.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

import kobzol.spaceships.model.Movable;
import kobzol.spaceships.ui.DisplayHelper;

/**
 * Renderer which displays given bitmap at the position (top left) of the model.
 */
public class BitmapRenderer implements Renderer {
    private final Movable object;
    private final Bitmap bmp;

    public BitmapRenderer(Movable object, Bitmap bmp) {
        this.object = object;
        this.bmp = bmp;
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectangle = DisplayHelper.getRectangle(this.object);
        canvas.drawBitmap(this.bmp, null, rectangle, Renderer.DEFAULT_PAINT);
    }
}
