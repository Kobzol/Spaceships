package kobzol.spaceships.event;

/**
 * Side menu action.
 */

public interface SideMenuAction {
    /**
     * Event which fires when the fire button is clicked.
     */
    void onFireButtonClicked();

    /**
     * Event which fires when the pause button is clicked.
     */
    void onPauseButtonClicked();

}
