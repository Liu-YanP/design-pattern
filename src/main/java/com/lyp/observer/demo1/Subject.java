package com.lyp.observer.demo1;

/**
 * @author Liu Yanping
 * @date 2020/9/5 17:40
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
