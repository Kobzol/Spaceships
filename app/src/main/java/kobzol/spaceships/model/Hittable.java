package kobzol.spaceships.model;

import android.graphics.Rect;

/**
 * Object that can be hit by some other object.
 */
public interface Hittable {
    Rect getBoundingBox();
}
