package com.lyp.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author Liu Yanping
 * @date 2022/8/6 22:28
 */
public class ThreadLocalConstant {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    // 可以将主线程的值传到子线程，但线程池的线程是复用的。会导致变量共享复用
    static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    // 可传递线程变量
    static TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();
}
