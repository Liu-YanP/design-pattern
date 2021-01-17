package com.lyp.decorator.demo1;

/**
 *
 * 被装饰对象的抽象类
 *
 * jdk中java.io使用了装饰器模式
 *
 * @author Liu Yanping
 * @date 2021/1/17 15:43
 */
public abstract class Beverage {

    String description = "Unknow Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
