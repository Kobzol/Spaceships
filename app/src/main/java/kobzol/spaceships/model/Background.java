package kobzol.spaceships.model;

import kobzol.spaceships.view.BitmapRenderer;

/**
 * Background.
 */
public class Background extends DisplayableObject {
    public Background(Dimension dimension, float speed) {
        super(dimension, speed);
    }

    @Override
    public BitmapRenderer getRenderer() {
        return (BitmapRenderer) super.getRenderer();
    }
}
