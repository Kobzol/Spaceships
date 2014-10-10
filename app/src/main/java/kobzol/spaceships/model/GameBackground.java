package kobzol.spaceships.model;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

/**
 * Game background with an image that scrolls horizontally.
 */
public class GameBackground extends GameObject {
    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
    }

    @Override
    public void onTouch(MotionEvent event) {

    }
}
