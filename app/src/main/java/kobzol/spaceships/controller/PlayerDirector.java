package kobzol.spaceships.controller;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.MotionEvent;

import kobzol.spaceships.model.Dimension;
import kobzol.spaceships.model.Mover;
import kobzol.spaceships.model.Spaceship;
import kobzol.spaceships.model.Vector;
import kobzol.spaceships.ui.DisplayHelper;
import kobzol.spaceships.view.SpaceshipRenderer;

/**
 * Controller taking care of the player's actions.
 */
public class PlayerDirector implements Director {
    private final Spaceship playerShip;
    private final SpaceshipRenderer renderer;

    private final SpaceDirector director;

    private PointF lastClick;
    private boolean moveShip = false;

    public PlayerDirector(SpaceDirector director) {
        this.playerShip = new Spaceship(new Dimension(300, 300), new Vector(0.0f, 10.0f));
        this.playerShip.moveTo(300, 300);

        this.renderer = new SpaceshipRenderer(playerShip, director.getContext());
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
        }
    }

    @Override
    public void draw(Canvas canvas, float interpolation) {
        this.renderer.draw(canvas, interpolation);
    }

    @Override
    public boolean onInput(MotionEvent event) {
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
