package stats.decimal;

import stats.Stats;

/**
 * Running variance of all the ingested data points
 */
public class RunningVariance implements Stats<Float> {
    private int count = 0;
    private float sum = 0;
    private float sumsq = 0;
    private float variance = 0;

    @Override
    public void update(Float value) {
        count++;
        sum += value;
        sumsq += value * value;
        float average = sum / count;
        variance = (sumsq / count) - (average * average);
    }

    @Override
    public Float get() {
        return variance;
    }

    @Override
    public String name() {
        return "variance";
    }
}
