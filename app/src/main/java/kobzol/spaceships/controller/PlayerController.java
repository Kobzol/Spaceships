package kobzol.spaceships.controller;

import android.graphics.PointF;
import android.view.MotionEvent;

import kobzol.spaceships.model.Mover;
import kobzol.spaceships.model.Spaceship;

/**
 * Controller taking care of the player's actions.
 */
public class PlayerController implements Controller {
    private final Spaceship playerShip;
    private final SpaceDirector director;

    private PointF lastClick;

    public PlayerController(Spaceship playerShip, SpaceDirector director) {
        this.playerShip = playerShip;
        this.director = director;

        this.lastClick = playerShip.getLocation();
    }

    @Override
    public void update() {
        Mover.moveTowards(this.playerShip, this.lastClick);
    }

    @Override
    public boolean onInput(MotionEvent event) {
        this.lastClick = new PointF(event.getRawX(), event.getRawY());

        return true;
    }
}
