package engines;

import results.Result;
import utils.Observer;

import java.util.List;

/**
 * Defines a statistical engine
 */
public abstract class Engine implements Observer<String> {
    /**
     * Ingests new data item and update statistics
     * @param raw raw data item
     * @return ingestion status (true if successful)
     */
    protected abstract boolean ingest(String raw);

    /**
     * Returns the type of the statistical engine
     * @return engine type
     */
    public abstract String type();

    /**
     * Returns a statistical value specified by the given stats name
     * @param name name of the statistics
     * @return value of the statistics
     */
    public abstract Result stats(String name);

    /**
     * Returns the list of computed statistical values
     * @return list of statistical values
     */
    public abstract List<Result> export();

    /**
     * Receives an update from a data source
     * @param data raw data item to be ingested
     */
    @Override
    public void update(String data) {
        data = data.trim();

        // when receiving a valid update: ingest new data
        if (!data.isEmpty()) {
            this.ingest(data);
        }
    }
}
