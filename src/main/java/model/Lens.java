package model;

/**
 * A lens interface representing a view into a mutable state.
 *
 * @param <S> The type of the value stored in the lens.
 */
public interface Lens<S> {
    /**
     * Gets the value from the {@link Lens}.
     *
     * @return The value stored in the place designated by {@link Lens}.
     */
    S get();

    /**
     * Sets a new value into the {@link Lens}.
     *
     * @param value The new value to set in the place designated by the {@link Lens}.
     */
    void set(S value);
}
