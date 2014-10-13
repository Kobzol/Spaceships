package kobzol.spaceships.model;

/**
 * Dimension of an object - it's width and height.
 */
public class Dimension implements Copyable<Dimension> {
    private final float width;
    private final float height;

    public Dimension(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return this.width;
    }
    public float getHeight() {
        return this.height;
    }

    @Override
    public Dimension copy() {
        return new Dimension(this.width, this.height);
    }
}
