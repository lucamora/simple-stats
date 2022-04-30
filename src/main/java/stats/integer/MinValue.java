package stats.integer;

import stats.Stats;

public class MinValue implements Stats<Integer> {
    private int min = 0;
    private boolean first = true;

    @Override
    public void update(Integer value) {
        if (first) {
            min = value;
            first = false;
        }

        if (value < min) {
            min = value;
        }
    }

    @Override
    public Integer get() {
        return min;
    }

    @Override
    public String name() {
        return "min_value";
    }
}
