package kobzol.spaceships.model;

/**
 * Spaceship.
 */
public class Spaceship extends DisplayableObject implements WeaponEmitter {
    private final LaserGun laserGun;

    public Spaceship(Dimension dimension) {
        this(dimension, Vector.ZERO);
    }
    public Spaceship(Dimension dimension, Vector speed) {
        super(dimension, speed);

        this.laserGun = new LaserGun();
    }

    public LaserGun getLaserGun() {
        return this.laserGun;
    }

    @Override
    public void fire() {
        this.laserGun.setLocation(this.getLocation());
        this.laserGun.fire();
    }
}
