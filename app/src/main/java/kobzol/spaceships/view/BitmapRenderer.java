package kobzol.spaceships.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;

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

    /**
     * Returns the renderer's object.
     * @return movable object
     */
    public Movable getObject() {
        return this.object;
    }

    /**
     * Returns the renderer's bitmap.
     * @return bitmap
     */
    public Bitmap getBitmap() {
        return this.bmp;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.bmp, null, DisplayHelper.getRectangle(this.object), Renderer.DEFAULT_PAINT);
    }
}
