package stats.decimal;

import stats.Stats;

public class RunningAverage implements Stats<Float> {
    private int count = 0;
    private float sum = 0;
    private float average = 0;

    @Override
    public void update(Float value) {
        count++;
        sum += value;
        average = sum / count;
    }

    @Override
    public Float get() {
        return average;
    }

    @Override
    public String name() {
        return "average";
    }
}
