package stats.string;

import stats.Stats;

/**
 * Word with the most number of distinct symbols
 */
public class MostSymbols implements Stats<String> {
    String mostSymbols;
    long maxCount;

    @Override
    public void update(String value) {
        // count distinct symbols
        // Java Stream: https://italiancoders.it/java-stream-le-basi/
        long symbols = value.chars().distinct().count();

        if (symbols > maxCount) {
            maxCount = symbols;
            mostSymbols = value;
        }
    }

    @Override
    public String get() {
        return mostSymbols;
    }

    @Override
    public String name() {
        return "most_symbols_word";
    }
}
