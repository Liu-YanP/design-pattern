package com.lyp.ttl;

import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * 线程池变量传递
 *
 * @author Liu Yanping
 * @date 2022/8/6 21:41
 */
public class TransmitThreadLocalTest {
   // 修饰runnable任务实现
    @Test
    public void testTransmitLocal() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 20, 2, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
        for (int i = 0; i < 10; i++) {
            ThreadLocalConstant.threadLocal.set("ThreadLocal: 这里是主线程信息--"+i);
            ThreadLocalConstant.inheritableThreadLocal.set("InheritableThreadLocal: 这里是主线程信息--"+i);
            ThreadLocalConstant.context.set("TransmittableThreadLocal: 这里是主线程信息--"+i);
            // 通过修饰runnable任务实现变量传递
            TtlRunnable ttlRunnable = TtlRunnable.get(new MyTask());
            poolExecutor.submit(ttlRunnable);
        }
    }

    // 修饰线程池实现
    @Test
    public void testTransmit2() {
        ThreadPoolExecutor poolExecutor2 = new ThreadPoolExecutor(3, 20, 2, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));
        ExecutorService ttlExecutor = TtlExecutors.getTtlExecutorService(poolExecutor2);
        for (int i = 0; i < 10; i++) {
            ThreadLocalConstant.threadLocal.set("ThreadLocal: 这里是主线程信息--"+i);
            ThreadLocalConstant.inheritableThreadLocal.set("InheritableThreadLocal: 这里是主线程信息--"+i);
            ThreadLocalConstant.context.set("TransmittableThreadLocal: 这里是主线程信息--"+i);
            // 通过修饰runnable任务实现变量传递
            ttlExecutor.submit(new MyTask());
        }

    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(ThreadLocalConstant.threadLocal.get());
            System.out.println(ThreadLocalConstant.inheritableThreadLocal.get());
            System.out.println(ThreadLocalConstant.context.get());
        }
    }

}
