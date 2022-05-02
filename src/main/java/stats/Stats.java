package stats;

/**
 * Stats interface
 * Reference: https://sourcemaking.com/design_patterns/strategy
 * @param <T> type of the statistics
 */
public interface Stats<T> {
    /**
     * Ingests a new data point and update the statistics
     * @param value new data item
     */
    void update(T value);

    /**
     * Returns the current value of the statistics
     * @return current stats value
     */
    T get();

    /**
     * Returns the name of the statistics
     * @return stats name
     */
    String name();
}
