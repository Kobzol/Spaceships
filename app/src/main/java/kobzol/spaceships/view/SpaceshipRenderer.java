package kobzol.spaceships.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import kobzol.spaceships.R;
import kobzol.spaceships.model.Spaceship;
import kobzol.spaceships.ui.DisplayHelper;

/**
 * Renders the spaceship.
 */
public class SpaceshipRenderer implements Renderer {
    private final Bitmap spaceShipImage;
    private final Spaceship spaceship;

    public SpaceshipRenderer(Spaceship spaceship, Context context) {
        this.spaceShipImage = DisplayHelper.loadBitmap(context, R.drawable.player_ship);
        this.spaceship = spaceship;
    }

    @Override
    public void draw(Canvas canvas, float interpolation) {
        canvas.drawBitmap(this.spaceShipImage, null, DisplayHelper.getRectangle(this.spaceship), Renderer.DEFAULT_PAINT);
    }
}
