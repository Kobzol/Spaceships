package kobzol.spaceships.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import kobzol.spaceships.event.SideMenuAction;
import kobzol.spaceships.view.GameCanvas;

/**
 * Controls the game.
 */
public class SpaceDirector implements Director {
    private final Context context;
    private final GameCanvas gameCanvas;

    private SpaceBackgroundDirector spaceBackgroundDirector;
    private PlayerDirector playerDirector;
    private MenuDirector menuDirector;

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
        this.spaceBackgroundDirector = new SpaceBackgroundDirector(this);
        this.playerDirector = new PlayerDirector(this);
        this.menuDirector = new MenuDirector(this, new SideMenuAction() {
            @Override
            public void onFireButtonClicked() {
                playerDirector.fireWeapon();
            }
        });
    }

    @Override
    public void update() {
        this.spaceBackgroundDirector.update();
        this.menuDirector.update();
        this.playerDirector.update();
    }

    @Override
    public void draw(Canvas canvas, float interpolation) {
        canvas.drawColor(Color.BLACK);

        this.spaceBackgroundDirector.draw(canvas, interpolation);
        this.menuDirector.draw(canvas, interpolation);
        this.playerDirector.draw(canvas, interpolation);
    }

    @Override
    public boolean onInput(MotionEvent event) {
        if (!this.menuDirector.onInput(event))
        {
            this.playerDirector.onInput(event);
        }

        return true;
    }
}
