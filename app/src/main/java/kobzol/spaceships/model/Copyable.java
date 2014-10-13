package kobzol.spaceships.model;

/**
 * Copyable object.
 */
public interface Copyable<T> {
    /**
     * Copies itself.
     * @return copy of itself
     */
    T copy();
}
