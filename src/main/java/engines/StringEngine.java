package engines;

import results.Result;
import stats.Stats;
import stats.string.*;

import java.util.ArrayList;
import java.util.List;

public class StringEngine extends Engine {
    private final List<Stats<String>> statistics = new ArrayList<>();

    public StringEngine() {
        this.statistics.add(new Shortest());
        this.statistics.add(new Longest());
        this.statistics.add(new MostFrequent());
    }

    @Override
    public void ingest(String raw) {
        // clean ingested string
        String word = raw.toLowerCase();

        for (Stats<String> stats : this.statistics) {
            stats.update(word);
        }
    }

    @Override
    public String type() {
        return "string";
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
