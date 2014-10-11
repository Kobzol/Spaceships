package kobzol.spaceships.model;

import android.graphics.Bitmap;

/**
 * Background.
 */
public class Background extends DisplayableObject {
    public Background(Bitmap bitmap) {
        super(bitmap);
    }

    @Override
    public void moveTo(float x, float y) {
        super.moveTo(x, y);

        if (this.getLocation().x % this.getImage().getWidth() == 0 && this.getLocation().x != 0)
        {
            this.moveTo(0, 0);
        }
    }
}
