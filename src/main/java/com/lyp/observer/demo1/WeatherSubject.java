package com.lyp.observer.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu Yanping
 * @date 2020/9/5 17:44
 *
 * 实现一个主题，当该主题变动时可以通知内部的观察者列表
 *
 * 这个主题可以注册观察者、删除观察者、通知观察者
 *
 */
public class WeatherSubject implements Subject {

    private List<Observer> observerList = new ArrayList<>();

    private float temperature;

    private float pressure;

    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        int index = observerList.indexOf(observer);
        if (index >= 0) {
            observerList.remove(index);
        }
    }

    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(temperature, pressure);
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public void measurementChange(float temperature, float pressure) {
        this.pressure = pressure;
        this.temperature = temperature;
        notifyObserver();
    }

}
