package kobzol.spaceships.controller;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

import kobzol.spaceships.R;
import kobzol.spaceships.event.MenuAction;
import kobzol.spaceships.event.SideMenuAction;
import kobzol.spaceships.model.Dimension;
import kobzol.spaceships.model.DisplayableObject;
import kobzol.spaceships.model.MenuButton;
import kobzol.spaceships.ui.DisplayHelper;
import kobzol.spaceships.view.RenderingCollection;

/**
 * Contains buttons that control the game.
 */
public class MenuDirector extends DisplayableObject implements Director {
    private final List<MenuButton> buttons;
    private final SpaceDirector director;

    private final Bitmap menuImage;
    private final Bitmap fireButtonImage;

    public MenuDirector(SpaceDirector director, final SideMenuAction menuAction) {
        super(new Dimension(200, director.getGameCanvas().getDimension().getHeight()));

        this.moveTo(director.getGameCanvas().getDimension().getWidth() - this.getDimension().getWidth() / 2, director.getGameCanvas().getDimension().getHeight() / 2);

        this.buttons = new ArrayList<MenuButton>();
        this.director = director;

        this.menuImage = DisplayHelper.loadBitmap(director.getContext(), R.drawable.menu);
        this.fireButtonImage = DisplayHelper.loadBitmap(director.getContext(), R.drawable.button);

        this.setupButtons(menuAction);
    }

    private void setupButtons(final SideMenuAction menuAction) {
        MenuButton fireButton = new MenuButton(new Dimension(100, 100), new MenuAction() {
            @Override
            public void onButtonClicked(MenuButton button) {
                menuAction.onFireButtonClicked();
            }
        });
        fireButton.moveTo(this.getLocation().x, this.getLocation().y - 100);

        this.buttons.add(fireButton);
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
        RenderingCollection.renderCenteredBitmap(this, this.menuImage, canvas, interpolation);
        RenderingCollection.renderCenteredBitmap(this.buttons.get(0), this.fireButtonImage, canvas, interpolation);
    }
}
