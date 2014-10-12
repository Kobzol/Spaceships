package kobzol.spaceships.controller;

import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;

import kobzol.spaceships.model.Mover;
import kobzol.spaceships.model.Spaceship;
import kobzol.spaceships.ui.DisplayHelper;

/**
 * Controller taking care of the player's actions.
 */
public class PlayerController implements Controller {
    private final Spaceship playerShip;
    private final SpaceDirector director;

    private PointF lastClick;
    private boolean moveShip = false;

    public PlayerController(Spaceship playerShip, SpaceDirector director) {
        this.playerShip = playerShip;
        this.director = director;

        this.lastClick = playerShip.getLocation();
    }

    @Override
    public void update() {
        if (this.moveShip &&
            DisplayHelper.calculateDistance(this.playerShip.getLocation(), this.lastClick) > 5 &&
            DisplayHelper.isInsideBounds(this.director.getGameCanvas().getDimension(), DisplayHelper.getVectorDelta(this.playerShip.getLocation(), this.lastClick, this.playerShip.getSpeed()), this.playerShip.getDimension()))
        {
            Mover.moveTowards(this.playerShip, this.lastClick);
            Log.i("Player controller update", "moving ship to " + this.lastClick.toString());
        }
    }

    @Override
    public boolean onInput(MotionEvent event) {
        Log.i("Player controller touch", event.getAction() + "");

        if (event.getAction() == MotionEvent.ACTION_MOVE ||
            event.getAction() == MotionEvent.ACTION_DOWN)
        {
            this.lastClick = new PointF(this.playerShip.getLocation().x, event.getRawY());
            this.moveShip = true;
        }
        else this.moveShip = false;

        return true;
    }
}
