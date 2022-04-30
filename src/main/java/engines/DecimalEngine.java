package engines;

import results.Result;
import stats.Stats;
import stats.decimal.*;

import java.util.ArrayList;
import java.util.List;

public class DecimalEngine extends Engine {
    protected final List<Stats<Float>> statistics = new ArrayList<>();

    public DecimalEngine() {
        this.statistics.add(new RunningAverage());
        this.statistics.add(new RunningVariance());
        this.statistics.add(new Range());
    }

    @Override
    public void ingest(String raw) {
        // parse ingested string
        float number = 0;
        try {
            number = Float.parseFloat(raw);
        }
        catch (NumberFormatException e) {
            System.out.println("> invalid number");
            return;
        }

        for (Stats<Float> stats : this.statistics) {
            stats.update(number);
        }
    }

    @Override
    public String type() {
        return "decimal";
    }

    @Override
    public List<Result> export() {
        List<Result> results = new ArrayList<>();
        for (Stats<Float> stats : this.statistics) {
            results.add(new Result(stats.name(), String.format("%.3f", stats.get())));
        }
        return results;
    }
}
