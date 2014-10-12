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
                onInput(motionEvent);
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

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
    }

    @Override
    public void onInput(MotionEvent event) {
        Log.i("user input", "onUserTouch");
    }
}
