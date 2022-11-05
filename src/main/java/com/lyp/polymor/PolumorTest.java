package com.lyp.polymor;

/**
 * 多态测试
 * @author Liu Yanping
 * @date 2022/5/22 13:02
 */
public class PolumorTest {
    public static void main(String[] args) {
        Fu a = new Zhi();
        a.say();
        System.out.println(a.age);
    }

}
