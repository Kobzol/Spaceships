package kobzol.spaceships.ui;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

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
}
