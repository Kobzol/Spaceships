package kobzol.spaceships.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import kobzol.spaceships.model.Movable;

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
        canvas.drawBitmap(this.bmp, this.object.getLocation().x, this.object.getLocation().y, Renderer.DEFAULT_PAINT);
    }
}
