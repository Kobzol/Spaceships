package kobzol.spaceships.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import kobzol.spaceships.event.SideMenuAction;
import kobzol.spaceships.model.Asteroid;
import kobzol.spaceships.model.AsteroidGenerator;
import kobzol.spaceships.model.LaserBullet;
import kobzol.spaceships.ui.DisplayHelper;
import kobzol.spaceships.view.GameCanvas;

/**
 * Controls the game.
 */
public class SpaceDirector implements Director {
    private final Context context;
    private final GameCanvas gameCanvas;

    private SpaceBackgroundDirector spaceBackgroundDirector;
    private PlayerDirector playerDirector;
    private AsteroidGenerator asteroidGenerator;
    private MenuDirector menuDirector;

    private int playerScore = 0;

    public SpaceDirector(Context context, GameCanvas gameCanvas) {
        this.context = context;
        this.gameCanvas = gameCanvas;
        this.gameCanvas.addInputListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                onInput(motionEvent);
                return true;
            }
        });

        this.initializeWorld();
    }

    public GameCanvas getGameCanvas() {
        return this.gameCanvas;
    }
    public Context getContext() {
        return this.context;
    }

    private void initializeWorld() {
        this.spaceBackgroundDirector = new SpaceBackgroundDirector(this);
        this.playerDirector = new PlayerDirector(this);
        this.asteroidGenerator = new AsteroidGenerator(this);
        this.menuDirector = new MenuDirector(this, new SideMenuAction() {
            @Override
            public void onFireButtonClicked() {
                playerDirector.fireWeapon();
            }
        });
    }

    private void checkAsteroidCollision() {
        for (LaserBullet bullet : this.playerDirector.getBullets())
        {
            for (Asteroid asteroid : this.asteroidGenerator.getAsteroids())
            {
                if (DisplayHelper.getRectangle(bullet).intersect(DisplayHelper.getRectangle(asteroid)))
                {
                    this.asteroidGenerator.getAsteroids().remove(asteroid);
                    this.playerDirector.getBullets().remove(bullet);

                    this.onAsteroidDestroyed();

                    break;
                }
            }
        }
    }
    private void onAsteroidDestroyed() {
        this.playerScore++;
        this.menuDirector.setScore(this.playerScore);
    }

    @Override
    public void update() {
        this.spaceBackgroundDirector.update();
        this.menuDirector.update();
        this.asteroidGenerator.update();
        this.playerDirector.update();

        this.checkAsteroidCollision();
    }

    @Override
    public void draw(Canvas canvas, float interpolation) {
        canvas.drawColor(Color.BLACK);

        this.spaceBackgroundDirector.draw(canvas, interpolation);
        this.playerDirector.draw(canvas, interpolation);
        this.asteroidGenerator.draw(canvas, interpolation);
        this.menuDirector.draw(canvas, interpolation);
    }

    @Override
    public boolean onInput(MotionEvent event) {
        if (!this.menuDirector.onInput(event))
        {
            this.playerDirector.onInput(event);
        }

        return true;
    }
}
