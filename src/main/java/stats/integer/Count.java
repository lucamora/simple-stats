package stats.integer;

import stats.Stats;

public class Count implements Stats<Integer> {
    private int count = 0;

    @Override
    public void update(Integer value) {
        count++;
    }

    @Override
    public Integer get() {
        return count;
    }

    @Override
    public String name() {
        return "count";
    }
}
