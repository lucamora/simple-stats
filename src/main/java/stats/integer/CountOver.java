package stats.integer;

import stats.Stats;

/**
 * Count of the ingested data points that are greater than the given threshold
 */
public class CountOver implements Stats<Integer> {
    private int count = 0;
    private final int threshold;

    public CountOver(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void update(Integer value) {
        if (value > threshold) {
            count++;
        }
    }

    @Override
    public Integer get() {
        return count;
    }

    @Override
    public String name() {
        return String.format("count_over_%d", threshold);
    }
}
