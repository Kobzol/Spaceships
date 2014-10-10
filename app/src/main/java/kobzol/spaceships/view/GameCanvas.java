package kobzol.spaceships.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Canvas on which the whole game is drawn.
 *
 * Receives and delegates user input.
 */
public class GameCanvas extends SurfaceView implements SurfaceHolder.Callback {
    public GameCanvas(Context context) {
        super(context);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    public Canvas startDrawing() {
        return this.getHolder().lockCanvas(null);
    }

    public void stopDrawing(Canvas canvas) {

    }
}
