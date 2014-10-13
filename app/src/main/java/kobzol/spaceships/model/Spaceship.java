package kobzol.spaceships.model;

/**
 * Spaceship.
 */
public class Spaceship extends DisplayableObject {
    public Spaceship(Dimension dimension) {
        this(dimension, Vector.ZERO);
    }
    public Spaceship(Dimension dimension, Vector speed) {
        super(dimension, speed);
    }

}
