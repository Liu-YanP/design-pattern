package com.lyp.observer.demo1;

/**
 * @author Liu Yanping
 * @date 2020/9/5 18:10
 */
public class ObserverMain {
    public static void main(String[] args) {
        WeatherSubject weatherSubject = new WeatherSubject();  //实现一个主题

        //实例化两个观察者，并在主题中注册
        new TemperatureObserver(weatherSubject);
        new PressureObserver(weatherSubject);
        weatherSubject.measurementChange(3,4);
    }
}
