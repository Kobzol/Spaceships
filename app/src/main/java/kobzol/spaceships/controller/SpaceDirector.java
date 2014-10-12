package kobzol.spaceships.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import kobzol.spaceships.R;
import kobzol.spaceships.model.Background;
import kobzol.spaceships.model.Dimension;
import kobzol.spaceships.model.Spaceship;
import kobzol.spaceships.ui.DisplayHelper;
import kobzol.spaceships.view.BitmapRenderer;
import kobzol.spaceships.view.GameCanvas;

/**
 * Controls the game.
 */
public class SpaceDirector implements Director {
    private final Context context;
    private final GameCanvas gameCanvas;

    private Background spaceBackground;
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
        this.spaceBackground = new Background(this.gameCanvas.getDimension());
        this.spaceBackground.moveTo(this.gameCanvas.getDimension().getWidth() / 2, this.gameCanvas.getDimension().getHeight() / 2);
        this.spaceBackground.setRenderer(new BitmapRenderer(this.spaceBackground, DisplayHelper.loadBitmap(this.context, R.drawable.space_background)));

        this.playerShip = new Spaceship(new Dimension(300, 300));
        this.playerShip.moveTo(this.playerShip.getDimension().getWidth() / 2, this.gameCanvas.getDimension().getHeight() / 2);
        this.playerShip.setRenderer(new BitmapRenderer(this.playerShip, DisplayHelper.loadBitmap(this.context, R.drawable.player_ship)));
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);

        this.spaceBackground.getRenderer().draw(canvas);
        this.playerShip.getRenderer().draw(canvas);
    }

    @Override
    public boolean onInput(MotionEvent event) {
        this.playerShip.moveTo(150, 360);

        Log.i("user input", "onUserTouch");

        return true;
    }
}
