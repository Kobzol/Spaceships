package kobzol.spaceships.model;

import android.graphics.Bitmap;
import android.graphics.PointF;

/**
 * Object that can be displayed on canvas.
 */
public abstract class DisplayableObject implements Movable {
    private Bitmap image;
    private PointF location;

    public DisplayableObject(Bitmap image) {
        this.image = image;
        this.location = new PointF(0, 0);
    }

    public Bitmap getImage() {
        return this.image;
    }

    @Override
    public PointF getLocation() {
        return this.location;
    }

    @Override
    public void moveBy(float x, float y) {
        this.moveTo(this.location.x + x, this.location.y + y);
    }

    @Override
    public void moveTo(float x, float y) {
        this.location.set(x, y);
    }
}
