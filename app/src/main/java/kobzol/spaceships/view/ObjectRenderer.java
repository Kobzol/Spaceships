package kobzol.spaceships.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import kobzol.spaceships.model.DisplayableObject;

/**
 * Displays the object so that the object's location will be the center of his bitmap.
 */
public class ObjectRenderer {
    public static void renderCentered(Canvas canvas, DisplayableObject object) {
        canvas.drawBitmap(object.getImage(), object.getLocation().x - object.getImage().getWidth() / 2, object.getLocation().y - object.getImage().getHeight() / 2, new Paint());
    }
}
