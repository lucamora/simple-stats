package stats.string;

import stats.Stats;

public class Longest implements Stats<String> {
    String longest = null;

    @Override
    public void update(String value) {
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
