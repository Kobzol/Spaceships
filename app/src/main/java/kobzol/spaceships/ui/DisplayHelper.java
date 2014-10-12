package kobzol.spaceships.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import kobzol.spaceships.model.Movable;

/**
 * Static class with display methods.
 */
public class DisplayHelper {
    /**
     * Gets the display metrics for the given device.
     * @param context context
     * @return display metrics
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);

        return metrics;
    }

    /**
     * Loads bitmap from application resources.
     * @param context context
     * @param id bitmap (resource) id
     * @return loaded bitmap
     */
    public static Bitmap loadBitmap(Context context, int id) {
        return BitmapFactory.decodeResource(context.getResources(), id);
    }

    /**
     * Gets the rectangle occupied by the object.
     * @param object movable object
     * @return rectangle occupied by the object
     */
    public static RectF getRectangle(Movable object) {
        return new RectF(
                object.getLocation().x - object.getDimension().getWidth() / 2,
                object.getLocation().y - object.getDimension().getHeight() / 2,
                object.getLocation().x + object.getDimension().getWidth() / 2,
                object.getLocation().y + object.getDimension().getHeight() / 2
        );
    }
}
