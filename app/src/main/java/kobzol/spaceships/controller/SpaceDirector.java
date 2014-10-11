package kobzol.spaceships.controller;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import kobzol.spaceships.view.GameCanvas;

/**
 * Controls the game.
 */
public class SpaceDirector implements Director {
    private final GameCanvas gameCanvas;

    public SpaceDirector(GameCanvas gameCanvas) {
        this.gameCanvas = gameCanvas;
        this.gameCanvas.addInputListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                onUserTouch(motionEvent);
                return true;
            }
        });
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {

    }

    private void onUserTouch(MotionEvent event) {

    }
}
