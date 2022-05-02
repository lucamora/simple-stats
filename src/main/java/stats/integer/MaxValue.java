package stats.integer;

import stats.Stats;

/**
 * Maximum of all the ingested data points
 */
public class MaxValue implements Stats<Integer> {
    private int max = 0;
    private boolean first = true;

    @Override
    public void update(Integer value) {
        if (first) {
            max = value;
            first = false;
        }

        if (value > max) {
            max = value;
        }
    }

    @Override
    public Integer get() {
        return max;
    }

    @Override
    public String name() {
        return "max_value";
    }
}
