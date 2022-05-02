package stats.string;

import stats.Stats;

/**
 * Word with the shortest length
 */
public class Shortest implements Stats<String> {
    String shortest = null;

    @Override
    public void update(String value) {
        // store new data if "shortest" is null (first value ingested)
        if (shortest == null || value.length() < shortest.length()) {
            shortest = value;
        }
    }

    @Override
    public String get() {
        return shortest;
    }

    @Override
    public String name() {
        return "shortest_word";
    }
}
