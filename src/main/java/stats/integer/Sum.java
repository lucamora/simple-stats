package stats.integer;

import stats.Stats;

public class Sum implements Stats<Integer> {
    private int sum = 0;

    @Override
    public void update(Integer value) {
        sum += value;
    }

    @Override
    public Integer get() {
        return sum;
    }

    @Override
    public String name() {
        return "sum";
    }
}
