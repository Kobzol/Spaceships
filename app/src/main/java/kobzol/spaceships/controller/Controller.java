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
     * @return true if the input was consumed, false otherwise
     */
    boolean onInput(MotionEvent event);
}
