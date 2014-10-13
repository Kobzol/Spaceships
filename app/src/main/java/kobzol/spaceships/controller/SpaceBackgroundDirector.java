package kobzol.spaceships.controller;

import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import kobzol.spaceships.model.Background;
import kobzol.spaceships.model.Vector;
import kobzol.spaceships.ui.DisplayHelper;
import kobzol.spaceships.view.SpaceBackgroundRenderer;

/**
 * Moves the space background horizontally.
 */
public class SpaceBackgroundDirector implements Director {
    private final Background spaceBackground;

    private final DisplayMetrics displayMetrics;
    private final SpaceBackgroundRenderer renderer;

    public SpaceBackgroundDirector(SpaceDirector director) {
        this.displayMetrics = DisplayHelper.getDisplayMetrics(director.getContext());
        this.spaceBackground = new Background(director.getGameCanvas().getDimension(), new Vector(-1, 0));
        this.renderer = new SpaceBackgroundRenderer(this.spaceBackground, director.getContext());
    }

    @Override
    public void update() {
        this.spaceBackground.moveBy(this.spaceBackground.getSpeed().x, 0);

        if (this.spaceBackground.getLocation().x <= -1 * (this.renderer.getBitmap().getScaledWidth(this.displayMetrics) / 2))
        {
            this.spaceBackground.moveBy(this.renderer.getBitmap().getScaledWidth(this.displayMetrics) / 2, 0);
        }
    }

    @Override
    public void draw(Canvas canvas, float interpolation) {
        this.renderer.draw(canvas, interpolation);
    }

    @Override
    public boolean onInput(MotionEvent event) {
        return false;
    }
}
