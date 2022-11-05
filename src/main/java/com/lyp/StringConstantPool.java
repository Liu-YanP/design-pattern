package com.lyp;

/**
 * @author Liu Yanping
 * @date 2021/10/5 16:46
 */
public class StringConstantPool {
    /**
     * 双引号创建的字符串会创建两个对象，1、堆内真正的字符串对象  2、字符串常量池对之储存对象的引用
     *          该种方法创建的对象，在常量池和堆中必然都有
     * new 创建的string对象，1、JVM将不会查询字符串常量池, 它将会直接在堆内存中创建一个字符串对象, 并返回给所属变量
     *
     * https://www.163.com/dy/article/GGCNPJFI0531A3HQ.html  详解
     * @param args
     */
    public static void main(String[] args) {
        String s1 = new String("hello world");
//        String s1 = new String("hello ")+new String("world");
        s1.intern();
        String s2 = "hello world";
        System.out.println(s1 == s2);   //true
    }
}
