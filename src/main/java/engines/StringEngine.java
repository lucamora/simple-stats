package engines;

import results.Result;
import stats.Stats;
import stats.string.*;

import java.util.ArrayList;
import java.util.List;

public class StringEngine extends Engine {
    private final List<Stats<String>> statistics = new ArrayList<>();

    public StringEngine() {
        // register statistics
        this.statistics.add(new Shortest());
        this.statistics.add(new Longest());
        this.statistics.add(new MostFrequent());
    }

    @Override
    public boolean ingest(String raw) {
        // clean ingested data item
        String word = raw.toLowerCase();

        // update statistics
        for (Stats<String> stats : this.statistics) {
            stats.update(word);
        }

        return true;
    }

    @Override
    public String type() {
        return "string";
    }

    @Override
    public Result stats(String name) {
        name = name.trim().toLowerCase();
        for (Stats<String> stats : this.statistics) {
            if (stats.name().equals(name)) {
                return new Result(stats.name(), stats.get());
            }
        }
        return null;
    }

    @Override
    public List<Result> export() {
        List<Result> results = new ArrayList<>();
        for (Stats<String> stats : this.statistics) {
            results.add(new Result(stats.name(), stats.get()));
        }
        return results;
    }
}
