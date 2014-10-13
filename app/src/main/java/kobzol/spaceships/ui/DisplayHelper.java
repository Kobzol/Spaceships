package kobzol.spaceships.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import kobzol.spaceships.model.Dimension;
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

    /**
     * Calculates the distance between the two points.
     * @param point1 first point
     * @param point2 second point
     * @return distance of the points
     */
    public static double calculateDistance(PointF point1, PointF point2) {
        PointF vector = new PointF(point1.x - point2.x, point1.y - point2.y);
        return Math.sqrt(vector.x * vector.x + vector.y * vector.y);
    }

    /**
     * Calculates whether the given object is inside bounds of the given dimension.
     * @param bound dimension
     * @param object movable object
     * @return true if the object is inside the bound, otherwise false
     */
    public static boolean isInsideBounds(Dimension bound, Movable object) {
        return DisplayHelper.isInsideBounds(bound, object.getLocation(), object.getDimension());
    }

    /**
     * Calculates whether the given object is inside bounds of the given dimension.
     * @param bound dimension
     * @param location object location
     * @param dimension object dimension
     * @return true if the object is inside the bound, otherwise false
     */
    public static boolean isInsideBounds(Dimension bound, PointF location, Dimension dimension) {
        return  !(location.x - dimension.getWidth() / 2 < 0 ||
                  location.x + dimension.getWidth() / 2 >= bound.getWidth() ||
                  location.y - dimension.getHeight() / 2 < 0 ||
                  location.y + dimension.getHeight() / 2 >= bound.getHeight());
    }

    /**
     * Calculates whether the given point is inside the given rectangle.
     * @param rectangleLocation location of the rectangle
     * @param rectangleDimension dimension of the rectangle
     * @param point point
     * @return true if the point is inside the rectangle, otherwise false
     */
    public static boolean isPointInsideBounds(PointF rectangleLocation, Dimension rectangleDimension, PointF point) {
        return  point.x <= rectangleLocation.x + rectangleDimension.getWidth() / 2  &&
                point.x >= rectangleLocation.x - rectangleDimension.getWidth() / 2 &&
                point.y >= rectangleLocation.y - rectangleDimension.getHeight() / 2 &&
                point.y <= rectangleLocation.y + rectangleDimension.getHeight() / 2;
    }

    /**
     * Returns source vector moved towards destination vector by speed.
     * @param source source vector
     * @param destination destination vector
     * @param speed speed in pixels/tick
     * @return moved vector
     */
    public static PointF getVectorDelta(PointF source, PointF destination, float speed) {
        PointF vector = new PointF(destination.x - source.x, destination.y - source.y);
        double length = Math.sqrt(vector.x * vector.x + vector.y * vector.y);

        if (length == 0)
        {
            return destination;
        }
        else
        {
            vector.set((float)(vector.x / length), (float)(vector.y / length));

            return new PointF(source.x + vector.x * speed, source.y + vector.y * speed);
        }
    }
}
