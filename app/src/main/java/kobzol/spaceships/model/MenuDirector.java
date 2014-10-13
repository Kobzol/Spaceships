package kobzol.spaceships.model;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import kobzol.spaceships.controller.Director;
import kobzol.spaceships.controller.SpaceDirector;
import kobzol.spaceships.ui.DisplayHelper;

/**
 * Contains buttons that control the game.
 */
public class MenuDirector extends DisplayableObject implements Director {
    private final List<MenuButton> buttons;
    private final SpaceDirector director;

    public MenuDirector(SpaceDirector director) {
        super(new Dimension(200, director.getGameCanvas().getHeight()));
        this.moveTo(director.getGameCanvas().getWidth() - this.getDimension().getWidth() / 2, director.getGameCanvas().getHeight() / 2);

        this.buttons = new ArrayList<MenuButton>();
        this.director = director;
    }

    @Override
    public void update() {

    }

    @Override
    public boolean onInput(MotionEvent event) {
        PointF clicked = new PointF(event.getRawX(), event.getRawY());

        for (MenuButton button : this.buttons)
        {
            if (DisplayHelper.isPointInsideBounds(button.getLocation(), button.getDimension(), clicked))
            {
                button.getMenuAction().onButtonClicked(button);
                return true;
            }
        }

        return DisplayHelper.isPointInsideBounds(this.getLocation(), this.getDimension(), clicked); // consumes the event if the touch happened on this menu
    }

    @Override
    public void draw(Canvas canvas, float interpolation) {

    }
}
