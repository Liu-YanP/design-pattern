package com.lyp.decorator.demo1;

/**
 *
 * 装饰类的抽象类 装饰类扩展了基类的功能
 *
 * @author Liu Yanping
 * @date 2021/1/17 15:45
 */
public abstract class BeverageDecorator extends Beverage {

    public abstract String getDescription();
}
