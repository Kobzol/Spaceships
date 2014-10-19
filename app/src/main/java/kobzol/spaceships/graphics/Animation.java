package kobzol.spaceships.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;

/**
 * Animation that plays a sprite.
 */
public class Animation {
    private final int steps;
    private final Bitmap image;

    private int tick = 0;
    private final int tickMax;

    private int currentStep = 0;

    private final int spriteWidth;
    private final int columns;

    public Animation(Bitmap bitmap, int steps, int tickMax) {
        this.image = bitmap;
        this.steps = steps;
        this.tickMax = tickMax;

        this.columns = (int) Math.sqrt(steps);
        this.spriteWidth = bitmap.getWidth() / this.columns;
    }

    /**
     * Determines if the animation has finished.
     * @return true if the animation has finished, false otherwise
     */
    public boolean isFinished() {
        return this.currentStep == this.steps;
    }

    /**
     * Advances the animation.
     */
    public void advance() {
        this.tick++;

        if (this.tick == this.tickMax)
        {
            this.tick = 0;
            this.currentStep++;
        }
    }

    public Bitmap getImage() {
        return this.image;
    }

    /**
     * Gets the current source rectangle from the animation's image.
     * @return source rectangle
     */
    public Rect getSourceRectangle() {
        int top = (this.currentStep / this.columns) * this.spriteWidth;
        int left = (this.currentStep % this.columns) * this.spriteWidth;

        return new Rect(left, top, left + this.spriteWidth, top + this.spriteWidth);
    }

}
