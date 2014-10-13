package kobzol.spaceships.model;

import android.graphics.PointF;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import kobzol.spaceships.controller.SpaceDirector;
import kobzol.spaceships.sound.SoundManager;
import kobzol.spaceships.ui.DisplayHelper;

/**
 * Laser gun which fires laser bullets.
 */
public class LaserGun implements WeaponEmitter {
    private PointF location;
    private final List<LaserBullet> bullets;

    private static final int cooldown  = 40;
    private int cooldown_timer = cooldown;

    public LaserGun() {
        this.bullets = new CopyOnWriteArrayList<LaserBullet>();
    }

    public void setLocation(PointF location) {
        this.location = location;
    }

    public List<LaserBullet> getBullets() {
        return this.bullets;
    }

    /**
     * Updates the inner cooldown timer and moves all the bullets.
     */
    public void update(SpaceDirector director) {
        this.cooldown_timer++;

        for (LaserBullet bullet : this.bullets)
        {
            bullet.move();

            if (!DisplayHelper.isInsideBounds(director.getGameCanvas().getDimension(), bullet))
            {
                this.bullets.remove(bullet);
            }
        }
    }

    @Override
    public void fire() {
        if (this.cooldown_timer >= LaserGun.cooldown)
        {
            LaserBullet newBullet = new LaserBullet();
            newBullet.moveTo(this.location.x, this.location.y);

            this.bullets.add(newBullet);

            SoundManager.playSound(SoundManager.LASER_SOUND);

            this.cooldown_timer = 0;
        }
    }
}
