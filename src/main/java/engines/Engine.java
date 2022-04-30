package engines;

import results.Result;
import utils.Observer;

import java.util.List;

/**
 * Strategy interface
 * Reference: https://sourcemaking.com/design_patterns/strategy
 */
public abstract class Engine implements Observer<String> {
    protected abstract void ingest(String raw);

    public abstract String type();

    public abstract List<Result> export();

    @Override
    public void update(String data) {
        data = data.trim();

        // when receiving a valid update: ingest new data
        if (!data.isEmpty()) {
            this.ingest(data);
        }
    }
}
