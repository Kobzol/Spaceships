package kobzol.spaceships.model;

/**
 * Laser bullet.
 */
public class LaserBullet extends DisplayableObject {
    public LaserBullet() {
        super(new Dimension(50, 20), new Vector(15.0f, 0.0f));
    }

    public void move() {
        this.moveBy(this.getSpeed().x, this.getSpeed().y);
    }
}
