package com.lyp.polymor;

/**
 * @author Liu Yanping
 * @date 2022/5/22 13:03
 */
public class Zhi extends Fu {

    public int age = 20;

    @Override
    void say() {
        System.out.println("子类");
    }

    void play() {
        System.out.println("好玩！");
    }
}
