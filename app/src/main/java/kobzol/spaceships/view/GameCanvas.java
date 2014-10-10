package kobzol.spaceships.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

import kobzol.spaceships.model.Dimension;
import kobzol.spaceships.ui.DisplayHelper;

/**
 * Canvas on which the whole game is drawn.
 *
 * Receives and delegates user input.
 */
public class GameCanvas extends SurfaceView implements SurfaceHolder.Callback {
    private final List<OnTouchListener> inputListeners;
    private final Dimension dimension;

    public GameCanvas(Context context) {
        super(context);

        this.inputListeners = new ArrayList<OnTouchListener>();

        DisplayMetrics dm = DisplayHelper.getDisplayMetrics(context);
        this.dimension = new Dimension(dm.widthPixels, dm.heightPixels);
    }

    public Dimension getDimension() {
        return this.dimension;
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

    public void addInputListener(OnTouchListener listener) {
        this.inputListeners.add(listener);
    }

    /**
     * Returns a canvas on which can be drawn.
     * @return canvas for drawing
     */
    public Canvas startDrawing() {
        return this.getHolder().lockCanvas(null);
    }

    /**
     * Locks the canvas and display the changes on the screen.
     * @param canvas canvas with new pixels
     */
    public void stopDrawing(Canvas canvas) {
        this.getHolder().unlockCanvasAndPost(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        for (OnTouchListener listener : this.inputListeners)
        {
            listener.onTouch(this, event);
        }

        return true;
    }
}
