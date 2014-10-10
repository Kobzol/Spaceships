package kobzol.spaceships.model;

import android.view.MotionEvent;

/**
 * Object that can be touched and reacts to user input.
 */
public interface Touchable {
    void onTouch(MotionEvent event);
}
