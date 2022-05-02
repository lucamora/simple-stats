package utils;

import java.util.List;
import java.util.ArrayList;

/**
 * Observable class
 * Reference: https://sourcemaking.com/design_patterns/observer
 * @param <T> type of the data sent to the observer from the observable instance
 */
public abstract class Observable<T> {
    private final List<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> observer){
        observers.add(observer);
    }

    protected void notifyObservers(T data){
        for (Observer<T> observer: observers) {
            observer.update(data);
        }
    }
}