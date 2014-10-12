package kobzol.spaceships.controller;

import android.view.MotionEvent;

import kobzol.spaceships.model.Background;

/**
 * Moves the space background horizontally.
 */
public class SpaceBackgroundController implements Controller {
    private final Background spaceBackground;
    private final SpaceDirector director;

    public SpaceBackgroundController(Background spaceBackground, SpaceDirector director) {
        this.spaceBackground = spaceBackground;
        this.director = director;
    }

    @Override
    public void update() {
        this.spaceBackground.moveBy(-1 * this.spaceBackground.getSpeed(), 0);
    }

    @Override
    public boolean onInput(MotionEvent event) {
        return false;
    }
}
