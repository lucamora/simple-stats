package engines;

import results.Result;
import stats.Stats;
import stats.integer.*;

import java.util.ArrayList;
import java.util.List;

public class IntegerEngine extends Engine {
    private final List<Stats<Integer>> statistics = new ArrayList<>();

    public IntegerEngine() {
        this.statistics.add(new MinValue());
        this.statistics.add(new MaxValue());
        this.statistics.add(new Count());
        this.statistics.add(new CountOver(100));
        this.statistics.add(new Sum());
    }

    @Override
    public boolean ingest(String raw) {
        // parse ingested string
        int number;
        try {
            number = Integer.parseInt(raw);
        }
        catch (NumberFormatException e) {
            return false;
        }

        for (Stats<Integer> stats : this.statistics) {
            stats.update(number);
        }

        return true;
    }

    @Override
    public String type() {
        return "integer";
    }

    @Override
    public Result stats(String name) {
        name = name.trim().toLowerCase();
        for (Stats<Integer> stats : this.statistics) {
            if (stats.name().equals(name)) {
                return new Result(stats.name(), stats.get().toString());
            }
        }
        return null;
    }

    @Override
    public List<Result> export() {
        List<Result> results = new ArrayList<>();
        for (Stats<Integer> stats : this.statistics) {
            results.add(new Result(stats.name(), stats.get().toString()));
        }
        return results;
    }
}
