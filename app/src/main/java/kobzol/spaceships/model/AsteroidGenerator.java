package kobzol.spaceships.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.view.MotionEvent;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import kobzol.spaceships.R;
import kobzol.spaceships.controller.Director;
import kobzol.spaceships.controller.SpaceDirector;
import kobzol.spaceships.ui.DisplayHelper;
import kobzol.spaceships.view.RenderingCollection;

/**
 * Asteroid generator that creates new asteroids randomly.
 */
public class AsteroidGenerator implements Director {
    private static final int GENERATE_ASTEROID_COOLDOWN = 200;
    private static final Dimension ASTEROID_DIMENSION = new Dimension(200, 200);

    private final SpaceDirector director;
    private final List<Asteroid> asteroids;

    private final Bitmap asteroidImage;
    private final Random random;

    private int generate_cooldown = GENERATE_ASTEROID_COOLDOWN;

    public AsteroidGenerator(SpaceDirector director) {
        this.director = director;
        this.asteroids = new CopyOnWriteArrayList<Asteroid>();
        this.asteroidImage = DisplayHelper.loadBitmap(director.getContext(), R.drawable.asteroid);
        this.random = new Random();
    }

    public List<Asteroid> getAsteroids() {
        return this.asteroids;
    }

    /**
     * Generates a random point for an asteroid to spawn.
     * @return random point
     */
    private PointF generateRandomAsteroidLocation() {
        return new PointF(
                this.director.getGameCanvas().getDimension().getWidth(),
                this.random.nextInt((int) this.director.getGameCanvas().getDimension().getHeight() - (int) AsteroidGenerator.ASTEROID_DIMENSION.getHeight() / 2) + AsteroidGenerator.ASTEROID_DIMENSION.getHeight() / 2);
    }

    /**
     * Generates an asteroid and adds it to the asteroid list.
     */
    private void generateAsteroid() {
        boolean findNewPosition;

        Asteroid newAsteroid = new Asteroid(AsteroidGenerator.ASTEROID_DIMENSION.copy());

        do
        {
            PointF asteroidLocation = this.generateRandomAsteroidLocation();
            newAsteroid.moveTo(asteroidLocation.x, asteroidLocation.y);

            findNewPosition = false;

            for (Asteroid asteroid : this.asteroids)
            {
                if (DisplayHelper.getRectangle(asteroid).intersect(DisplayHelper.getRectangle(newAsteroid)))
                {
                    findNewPosition = true;
                    break;
                }
            }
        }
        while (findNewPosition);

        this.asteroids.add(newAsteroid);
    }

    @Override
    public void update() {
        this.generate_cooldown++;

        if (this.generate_cooldown >= AsteroidGenerator.GENERATE_ASTEROID_COOLDOWN)
        {
            this.generateAsteroid();
            this.generate_cooldown = 0;
        }

        for (Asteroid asteroid : this.asteroids)
        {
            asteroid.move();
        }
    }

    @Override
    public boolean onInput(MotionEvent event) {
        return false;
    }

    @Override
    public void draw(Canvas canvas, float interpolation) {
        for (Asteroid asteroid : this.asteroids)
        {
            RenderingCollection.renderCenteredBitmap(asteroid, this.asteroidImage, canvas, interpolation);
        }
    }
}