package kobzol.spaceships.event;

import kobzol.spaceships.model.MenuButton;

/**
 * Action that should be performed after a menu action has happened.
 */
public interface MenuAction {
    /**
     * Event which fires when a button is clicked.
     * @param button menu button that was clicked
     */
    void onButtonClicked(MenuButton button);

}
