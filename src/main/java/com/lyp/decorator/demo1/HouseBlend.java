package com.lyp.decorator.demo1;

/**
 *
 * 其中一个具体被装饰的对象
 *
 * @author Liu Yanping
 * @date 2021/1/17 15:52
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .79;
    }
}
