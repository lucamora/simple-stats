package stats.decimal;

import stats.Stats;

public class Range implements Stats<Float> {
    private float min = 0;
    private float max = 0;
    private float range = 0;
    private boolean first = true;

    @Override
    public void update(Float value) {
        if (first) {
            min = value;
            max = value;
            first = false;
        }

        if (value < min) {
            min = value;
        }
        else if (value > max) {
            max = value;
        }

        range = max - min;
    }

    @Override
    public Float get() {
        return range;
    }

    @Override
    public String name() {
        return "range";
    }
}
