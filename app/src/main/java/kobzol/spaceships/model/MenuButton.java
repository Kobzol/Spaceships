package kobzol.spaceships.model;

import kobzol.spaceships.event.MenuAction;

/**
 * Menu button that performs some action.
 */
public class MenuButton extends DisplayableObject {
    private final MenuAction action;

    public MenuButton(Dimension dimension, MenuAction action) {
        super(dimension);

        this.action = action;
    }

    public MenuAction getMenuAction() {
        return this.action;
    }
}
