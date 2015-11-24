package kobzol.spaceships.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import kobzol.spaceships.event.SideMenuAction;
import kobzol.spaceships.game.Game;
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
    private final Game game;

    private SpaceBackgroundDirector spaceBackgroundDirector;
    private PlayerDirector playerDirector;
    private AsteroidGenerator asteroidGenerator;
    private MenuDirector menuDirector;

    private int playerScore = 0;

    public SpaceDirector(Context context, Game game) {
        this.context = context;
        this.gameCanvas = game.getGameCanvas();
        this.gameCanvas.addInputListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                onInput(motionEvent);
                return true;
            }
        });
        this.game = game;

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
            public void onPauseButtonClicked() {
                if (game.isRunning())
                {
                    game.stop();
                }
                else game.start();
            }

            @Override
            public void onFireButtonClicked() {
                playerDirector.fireWeapon();
            }
        });
    }

    /**
     * Checks collisions of bullets with asteroids.
     */
    private void checkAsteroidWithBulletCollision() {
        for (LaserBullet bullet : this.playerDirector.getBullets())
        {
            for (Asteroid asteroid : this.asteroidGenerator.getAsteroids())
            {
                if (DisplayHelper.getRectangle(bullet).intersect(DisplayHelper.getRectangle(asteroid)) && !asteroid.isExploding())
                {
                    this.asteroidGenerator.onAsteroidHit(asteroid);
                    this.playerDirector.getBullets().remove(bullet);

                    this.onAsteroidDestroyed();

                    break;
                }
            }
        }
    }

    /**
     * Checks collisions of the player's ship with asteroids.
     */
    private void checkAsteroidWithShipCollision() {
        for (Asteroid asteroid : this.asteroidGenerator.getAsteroids())
        {
            if (DisplayHelper.getRectangle(asteroid).intersect(DisplayHelper.getRectangle(this.playerDirector.getPlayerShip())))
            {
                this.onShipDestroyed();
                break;
            }
        }
    }

    /**
     * Increments the player's score and updates the value in the side menu.
     */
    private void onAsteroidDestroyed() {
        this.playerScore++;
        this.menuDirector.setScore(this.playerScore);
    }

    /**
     * Displays notification to the user and restarts the game.
     */
    private void onShipDestroyed() {
        this.initializeWorld();
    }

    @Override
    public void update() {
        this.spaceBackgroundDirector.update();
        this.menuDirector.update();
        this.asteroidGenerator.update();
        this.playerDirector.update();

        this.checkAsteroidWithBulletCollision();
        this.checkAsteroidWithShipCollision();
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
        for (int i = 0; i < event.getPointerCount(); i++)
        {
            if (i < event.getPointerCount())
            {
                int id = event.getPointerId(i);

                try
                {
                    event.setLocation(event.getX(id), event.getY(id));

                    if (!this.menuDirector.onInput(event))
                    {
                        this.playerDirector.onInput(event);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }
}
