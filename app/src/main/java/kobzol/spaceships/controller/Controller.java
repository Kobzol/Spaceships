package kobzol.spaceships.controller;

import android.view.MotionEvent;

/**
 * Controls and updates models.
 */
public interface Controller {
    /**
     * Updates a model's state.
     */
    void update();

    /**
     * Reacts to user input.
     * @param event touch event
     */
    void onInput(MotionEvent event);
}
