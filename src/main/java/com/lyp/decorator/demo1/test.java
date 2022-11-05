package com.lyp.decorator.demo1;

/**
 * 装饰器模式
 *
 * @author Liu Yanping
 * @date 2021/1/17 16:05
 */
public class test {
    public static void main(String[] args) {
        HouseBlend houseBlend = new HouseBlend();//被装饰的对象
        Mocha mocha = new Mocha(houseBlend);     //被mocha装饰
        System.out.println(mocha.getDescription()+":" + mocha.cost());

        Espresso espresso = new Espresso();
        Whip whip = new Whip(espresso);
        Mocha mocha1 = new Mocha(whip);
        System.out.println(mocha1.getDescription() + ":" + mocha1.cost());
    }
}
