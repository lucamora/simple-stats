package engines;

import results.Result;
import stats.Stats;
import stats.decimal.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DecimalEngine extends Engine {
    protected final List<Stats<Float>> statistics = new ArrayList<>();

    public DecimalEngine() {
        // use dots instead of commas when formatting float
        Locale.setDefault(Locale.US);

        // register statistics
        this.statistics.add(new RunningAverage());
        this.statistics.add(new RunningVariance());
        this.statistics.add(new Range());
    }

    @Override
    public boolean ingest(String raw) {
        // parse ingested data item
        float number;
        try {
            number = Float.parseFloat(raw);
        }
        catch (NumberFormatException e) {
            return false;
        }

        // update statistics
        for (Stats<Float> stats : this.statistics) {
            stats.update(number);
        }

        return true;
    }

    @Override
    public String type() {
        return "decimal";
    }

    @Override
    public Result stats(String name) {
        name = name.trim().toLowerCase();
        for (Stats<Float> stats : this.statistics) {
            if (stats.name().equals(name)) {
                return new Result(stats.name(), String.format("%.3f", stats.get()));
            }
        }
        return null;
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
