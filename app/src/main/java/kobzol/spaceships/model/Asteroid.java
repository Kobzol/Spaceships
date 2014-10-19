package kobzol.spaceships.model;

/**
 * Asteroid that floats in space
 */
public class Asteroid extends DisplayableObject {
    private boolean exploding;

    public Asteroid(Dimension dimension) {
        super(dimension, new Vector(-2.0f, 0.0f));

        this.exploding = false;
    }

    public boolean isExploding() {
        return this.exploding;
    }

    public void causeExplosion() {
        this.exploding = true;
    }

    public void move() {
        this.moveBy(this.getSpeed().x, this.getSpeed().y);
    }
}
