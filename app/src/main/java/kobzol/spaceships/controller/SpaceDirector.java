package kobzol.spaceships.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import kobzol.spaceships.R;
import kobzol.spaceships.model.Background;
import kobzol.spaceships.model.Spaceship;
import kobzol.spaceships.ui.DisplayHelper;
import kobzol.spaceships.view.GameCanvas;
import kobzol.spaceships.view.ObjectRenderer;

/**
 * Controls the game.
 */
public class SpaceDirector implements Director {
    private final Context context;
    private final GameCanvas gameCanvas;

    private Background background;
    private Spaceship playerShip;

    public SpaceDirector(Context context, GameCanvas gameCanvas) {
        this.context = context;
        this.gameCanvas = gameCanvas;
        this.gameCanvas.addInputListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                onUserTouch(motionEvent);
                return true;
            }
        });

        this.initializeWorld();
    }

    private void initializeWorld() {
        this.background = new Background(DisplayHelper.loadBitmap(this.context, R.drawable.space_background));
        this.playerShip = new Spaceship(DisplayHelper.loadBitmap(this.context, R.drawable.player_ship));
    }

    @Override
    public void update() {
        this.background.moveBy(-10, 0);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);

        ObjectRenderer.renderTopLeft(canvas, this.background);
        ObjectRenderer.renderCentered(canvas, this.playerShip);
    }

    private void onUserTouch(MotionEvent event) {
        this.playerShip.moveBy(0, 10);
        Log.i("user input", "onUserTouch");
    }
}
