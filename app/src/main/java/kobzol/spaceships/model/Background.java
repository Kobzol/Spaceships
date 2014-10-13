package kobzol.spaceships.model;

/**
 * Background.
 */
public class Background extends DisplayableObject {
    public Background(Dimension dimension) {
        this(dimension, Vector.ZERO);
    }
    public Background(Dimension dimension, Vector speed) {
        super(dimension, speed);
    }
}
