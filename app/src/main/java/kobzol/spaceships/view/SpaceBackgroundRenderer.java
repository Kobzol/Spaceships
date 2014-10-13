package kobzol.spaceships.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import kobzol.spaceships.R;
import kobzol.spaceships.model.Background;
import kobzol.spaceships.ui.DisplayHelper;

/**
 * Renders the continually scrolling space background.
 */
public class SpaceBackgroundRenderer implements Renderer {
    private final Background spaceBackground;
    private final Bitmap backgroundImage;

    public SpaceBackgroundRenderer(Background spaceBackground, Context context) {
        this.spaceBackground = spaceBackground;
        this.backgroundImage = DisplayHelper.loadBitmap(context, R.drawable.space_background);
    }

    public Bitmap getBitmap() {
        return this.backgroundImage;
    }

    @Override
    public void draw(Canvas canvas, float interpolation) {
        canvas.drawBitmap(
                this.backgroundImage,
                this.spaceBackground.getLocation().x + this.spaceBackground.getSpeed().x * interpolation,
                this.spaceBackground.getLocation().y + this.spaceBackground.getSpeed().y * interpolation,
                Renderer.DEFAULT_PAINT
        );
    }
}
