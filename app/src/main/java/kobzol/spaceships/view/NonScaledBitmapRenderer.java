package kobzol.spaceships.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import kobzol.spaceships.model.Movable;

/**
 * Renderer which displays given bitmap at the position (top left) of the model. Does not scale the bitmap.
 */
public class NonScaledBitmapRenderer extends BitmapRenderer {
    public NonScaledBitmapRenderer(Movable object, Bitmap bmp) {
        super(object, bmp);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(
                this.getBitmap(),
                this.getObject().getLocation().x,
                this.getObject().getLocation().y,
                Renderer.DEFAULT_PAINT);
    }
}
