package kobzol.spaceships.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import kobzol.spaceships.R;
import kobzol.spaceships.model.Background;
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
        this.spaceBackground.setRenderer(new BitmapRenderer(this.spaceBackground, DisplayHelper.loadBitmap(this.context, R.drawable.space_background)));
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        this.backgroundRenderer.draw(canvas);


    }

    @Override
    public boolean onInput(MotionEvent event) {
        Log.i("user input", "onUserTouch");

        return true;
    }
}
