package kobzol.spaceships.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import kobzol.spaceships.controller.Controller;
import kobzol.spaceships.ui.DisplayHelper;
import kobzol.spaceships.view.BitmapRenderer;
import kobzol.spaceships.view.Renderer;

/**
 * Contains buttons that control the game.
 */
public class Menu extends DisplayableObject implements Controller, Renderer {
    private final List<MenuButton> buttons;
    private final List<Renderer> renderers;

    private final BitmapRenderer renderer;

    public Menu(Dimension dimension, float speed, Bitmap background) {
        super(dimension, speed);

        this.buttons = new ArrayList<MenuButton>();
        this.renderers = new ArrayList<Renderer>();
        this.renderer = new BitmapRenderer(this, background);
    }

    /**
     * Adds a menu button to this menu.
     * @param button menu button
     */
    public void addButton(MenuButton button, Bitmap bitmap) {
        this.buttons.add(button);
        button.moveTo(this.getLocation().x + button.getLocation().x, this.getLocation().y + button.getLocation().y);

        this.renderers.add(new BitmapRenderer(button, bitmap));
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
    public void draw(Canvas canvas) {
        this.renderer.draw(canvas);

        for (Renderer renderer : this.renderers)
        {
            renderer.draw(canvas);
        }
    }
}
