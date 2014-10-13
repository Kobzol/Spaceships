package kobzol.spaceships.model;

/**
 * Asteroid that floats in space
 */
public class Asteroid extends DisplayableObject {
    public Asteroid(Dimension dimension) {
        super(dimension, new Vector(-2.0f, 0.0f));
    }

    public void move() {
        this.moveBy(this.getSpeed().x, this.getSpeed().y);
    }
}
