package kobzol.spaceships.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import kobzol.spaceships.R;
import kobzol.spaceships.event.MenuAction;
import kobzol.spaceships.model.Background;
import kobzol.spaceships.model.Dimension;
import kobzol.spaceships.model.Menu;
import kobzol.spaceships.model.MenuButton;
import kobzol.spaceships.model.Spaceship;
import kobzol.spaceships.ui.DisplayHelper;
import kobzol.spaceships.view.BitmapRenderer;
import kobzol.spaceships.view.GameCanvas;
import kobzol.spaceships.view.NonScaledBitmapRenderer;

/**
 * Controls the game.
 */
public class SpaceDirector implements Director {
    private final Context context;
    private final GameCanvas gameCanvas;

    private Background spaceBackground;
    private SpaceBackgroundController spaceBackgroundController;

    private Menu sideMenu;

    private Spaceship playerShip;
    private PlayerController playerController;

    public SpaceDirector(Context context, GameCanvas gameCanvas) {
        this.context = context;
        this.gameCanvas = gameCanvas;
        this.gameCanvas.addInputListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                onInput(motionEvent);
                return true;
            }
        });

        this.initializeWorld();
    }

    public GameCanvas getGameCanvas() {
        return this.gameCanvas;
    }
    public Context getContext() {
        return this.context;
    }

    private void initializeWorld() {
        this.spaceBackground = new Background(this.gameCanvas.getDimension(), 2.0f);
        this.spaceBackground.setRenderer(new NonScaledBitmapRenderer(this.spaceBackground, DisplayHelper.loadBitmap(this.context, R.drawable.space_background)));
        this.spaceBackgroundController = new SpaceBackgroundController(this.spaceBackground, this);

        this.sideMenu = new Menu(new Dimension(200, this.gameCanvas.getDimension().getHeight()), 0.0f, DisplayHelper.loadBitmap(this.context, R.drawable.menu));
        this.sideMenu.moveTo(this.gameCanvas.getDimension().getWidth() - this.sideMenu.getDimension().getHeight(), this.gameCanvas.getDimension().getHeight() / 2);
        this.sideMenu.addButton(new MenuButton(new Dimension(50, 50), 0.0f, new MenuAction() {
            @Override
            public void onButtonClicked(MenuButton button) {
                Toast.makeText(context, "button clicked!", Toast.LENGTH_SHORT).show();
            }
        }), DisplayHelper.loadBitmap(this.context, R.drawable.button));

        this.playerShip = new Spaceship(new Dimension(300, 300), 10.0f);
        this.playerShip.moveTo(this.playerShip.getDimension().getWidth() / 2, this.gameCanvas.getDimension().getHeight() / 2);
        this.playerShip.setRenderer(new BitmapRenderer(this.playerShip, DisplayHelper.loadBitmap(this.context, R.drawable.player_ship)));
        this.playerController = new PlayerController(this.playerShip, this);
    }

    @Override
    public void update() {
        this.spaceBackgroundController.update();
        this.playerController.update();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);

        this.spaceBackground.getRenderer().draw(canvas);
        this.playerShip.getRenderer().draw(canvas);
    }

    @Override
    public boolean onInput(MotionEvent event) {
        this.playerController.onInput(event);

        return true;
    }
}
