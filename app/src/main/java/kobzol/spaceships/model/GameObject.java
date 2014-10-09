package kobzol.spaceships.model;

/**
 * Game object that updates it's logic once a tick.
 */
public interface GameObject extends Drawable {
    /**
     * Update it's internal logic.
     * Called in every iteration of the game loop.
     */
    void update();
}
