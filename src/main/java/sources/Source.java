package sources;

import utils.Observable;

/**
 * Defines an input data source
 */
public abstract class Source extends Observable<String> {
    public abstract void setup();

    public abstract void process();
}
