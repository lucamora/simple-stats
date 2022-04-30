package stats;

public interface Stats<T> {
    void update(T value);

    T get();

    String name();
}
