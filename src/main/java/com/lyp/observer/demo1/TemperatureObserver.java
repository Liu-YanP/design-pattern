package com.lyp.observer.demo1;

/**
 * @author Liu Yanping
 * @date 2020/9/5 17:55
 *
 *
 * 继承观察者接口，实现一个观察者
 *
 * 引用所能够调用的方法取决于引用的类型，而如何具体的实现该方法取决于对象的类型。
 *
 * 观察者持有一个主题的对象
 */
public class TemperatureObserver implements Observer, DisplayElement {

    private float temperature;
    private float pressure;

    //引用类型是subject类，里面没有getTemperature 方法，所以不能调用
    private Subject weather;

    /**
     * 观察者持有对应主题的对象
     *
     * @param subject
     */
    public TemperatureObserver(Subject subject) {
        this.weather = subject;
        weather.registerObserver(this);
    }

    /**
     * 观察者触发后的动作
     *
     * @param temperature
     * @param pressure
     */
    public void update(float temperature, float pressure) {
        this.pressure = pressure;
        this.temperature = temperature;
        display();
    }

    public void display() {
        System.out.println("天气状况为:" + temperature+"\n"+pressure);
    }
}
