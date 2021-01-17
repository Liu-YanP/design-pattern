package com.lyp.decorator.demo1;

/**
 *
 * 具体装饰的对象
 *
 * @author Liu Yanping
 * @date 2021/1/17 15:57
 */
public class Whip extends BeverageDecorator {
    // 保存被装饰的对象
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Whip";
    }

    @Override
    public double cost() {
        return beverage.cost()+2;
    }
}
