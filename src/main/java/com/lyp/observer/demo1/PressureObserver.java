package com.lyp.observer.demo1;

/**
 * @author Liu Yanping
 * @date 2020/9/5 17:55
 */
public class PressureObserver implements Observer, DisplayElement {

    private float temperature;
    private float pressure;
    private Subject weather;

    public PressureObserver(Subject subject) {
        this.weather = subject;
        weather.registerObserver(this);
    }

    public void update(float temperature, float pressure) {
        this.pressure = pressure;
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("气压状况为:" + pressure);
    }
}
