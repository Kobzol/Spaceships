package kobzol.spaceships.model;

/**
 * Object that has health and that can be killed.
 */
public interface Killable {
    /**
     * Returns the current health.
     * @return current health
     */
    float getHealth();

    /**
     * Takes damage.
     * @param damage amount of damage taken
     */
    void takeDamage(float damage);

    /**
     * Adds a listener that is called when this object dies.
     * @param onObjectDead event listener waiting for this object's death
     */
    void addDeathListener(ObjectDiedListener onObjectDead);
}
