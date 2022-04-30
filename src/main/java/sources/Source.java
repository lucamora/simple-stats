package sources;

import utils.Observable;

public abstract class Source extends Observable<String> {
    public abstract void setup();

    public abstract void process();
}
