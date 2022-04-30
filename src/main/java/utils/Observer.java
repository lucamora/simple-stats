package utils;

/**
 * Observer interface
 * Reference: https://sourcemaking.com/design_patterns/observer
 * @param <T> type of the data sent to the observer from the observable
 */
public interface Observer<T> {
    void update(T data);
}