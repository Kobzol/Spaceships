package kobzol.spaceships.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import kobzol.spaceships.controller.Controller;
import kobzol.spaceships.view.BitmapRenderer;
import kobzol.spaceships.view.Renderer;

/**
 * Contains buttons that control the game.
 */
public class Menu extends DisplayableObject implements Controller, Renderer {
    private final List<MenuButton> buttons;
    private final List<Renderer> renderers;

    public Menu(Dimension dimension, float speed) {
        super(dimension, speed);

        this.buttons = new ArrayList<MenuButton>();
        this.renderers = new ArrayList<Renderer>();
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


        return false;
    }

    @Override
    public void draw(Canvas canvas) {
        for (Renderer renderer : this.renderers)
        {
            renderer.draw(canvas);
        }
    }
}
