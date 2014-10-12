package kobzol.spaceships.controller;

import android.util.DisplayMetrics;
import android.view.MotionEvent;

import kobzol.spaceships.model.Background;
import kobzol.spaceships.ui.DisplayHelper;

/**
 * Moves the space background horizontally.
 */
public class SpaceBackgroundController implements Controller {
    private final Background spaceBackground;
    private final SpaceDirector director;
    private final DisplayMetrics displayMetrics;

    public SpaceBackgroundController(Background spaceBackground, SpaceDirector director) {
        this.spaceBackground = spaceBackground;
        this.director = director;
        this.displayMetrics = DisplayHelper.getDisplayMetrics(this.director.getContext());
    }

    @Override
    public void update() {
        this.spaceBackground.moveBy(-1 * this.spaceBackground.getSpeed(), 0);

        if (this.spaceBackground.getLocation().x <= -1 * (this.spaceBackground.getRenderer().getBitmap().getScaledWidth(this.displayMetrics) / 2))
        {
            this.spaceBackground.moveBy(this.spaceBackground.getRenderer().getBitmap().getScaledWidth(this.displayMetrics) / 2, 0);
        }
    }

    @Override
    public boolean onInput(MotionEvent event) {
        return false;
    }
}
