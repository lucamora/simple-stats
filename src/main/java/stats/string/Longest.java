package stats.string;

import stats.Stats;

/**
 * Word with the longest length
 */
public class Longest implements Stats<String> {
    String longest = null;

    @Override
    public void update(String value) {
        // store new data if "longest" is null (first value ingested)
        if (longest == null || value.length() > longest.length()) {
            longest = value;
        }
    }

    @Override
    public String get() {
        return longest;
    }

    @Override
    public String name() {
        return "longest_word";
    }
}
