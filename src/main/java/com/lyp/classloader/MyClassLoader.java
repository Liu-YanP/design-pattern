package com.lyp.classloader;

/**
 * @author Liu Yanping
 * @date 2022/4/3 18:29
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
