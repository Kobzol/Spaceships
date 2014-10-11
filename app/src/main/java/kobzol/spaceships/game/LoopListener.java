package kobzol.spaceships.game;

/**
 * Contains actions that should be performed when the game loop has reached a certain loop.
 */
public interface LoopListener {
    /**
     * Called when the game should update.
     */
    void onUpdate();

    /**
     * Called when the game should draw.
     */
    void onDraw();
}
