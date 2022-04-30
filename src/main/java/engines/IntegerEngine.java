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
    public void ingest(String raw) {
        // parse ingested string
        int number = 0;
        try {
            number = Integer.parseInt(raw);
        }
        catch (NumberFormatException e) {
            System.out.println("> invalid number");
            return;
        }

        for (Stats<Integer> stats : this.statistics) {
            stats.update(number);
        }
    }

    @Override
    public String type() {
        return "integer";
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
