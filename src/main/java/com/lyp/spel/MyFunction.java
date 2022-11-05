package com.lyp.spel;

import java.util.Collection;

/**
 * @author Liu Yanping
 * @date 2021/9/19 10:36
 */
public class MyFunction {

    public static String IF(Boolean b,String s,String c){
        return b ? s : c;
    }

    public static Boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            System.out.println("字符串");
            return ((String) o).length() < 1;
        } else if (o instanceof Collection) {
            System.out.println("集合");
            return ((Collection) o).size()<1;
        } else if (o instanceof Object[]) {
            System.out.println("数组");
            return ((Object[]) o).length<1;
        }else {
            return o.toString().length()<1;
        }
    }
}
