package stats.string;

import stats.Stats;

import java.util.HashMap;
import java.util.Map;

/**
 * Word that occurs the most number of times
 */
public class MostFrequent implements Stats<String> {
    HashMap<String, Integer> words = new HashMap<>();

    String mostFrequent;

    @Override
    public void update(String value) {
        // update word count
        if (!words.containsKey(value)) {
            words.put(value, 1);
        }
        else {
            Integer oldCount = words.get(value);
            words.put(value, oldCount + 1);
        }

        // get the word with the greater count
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            int count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = entry.getKey();
            }
        }
    }

    @Override
    public String get() {
        return mostFrequent;
    }

    @Override
    public String name() {
        return "most_frequent_word";
    }
}
