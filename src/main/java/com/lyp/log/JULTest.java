package com.lyp.log;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

/**
 * jdk自带的日志框架，不需要额外依赖
 *
 * @author Liu Yanping
 * @date 2022/8/7 11:07
 */
public class JULTest {

    @Test
    public void testJul() {
        // 1、获取日志记录器对象
        Logger logger = Logger.getLogger(JULTest.class.getName());
        // 输出日志
        logger.info("JUL 日志");

        logger.log(Level.INFO,"info 日志");
    }

    /**
     * 1,初始化LogManager
     * 1.LogManager加载logging.properties置
     * 2.添Logger到LogManager
     * 2.从单例LogManager获取Logger
     * 3.设置级别儿evel,并指定日志记录LogRecord
     * 4.Filter提供了日志级别之外更细粒度的控制
     * 5.Handler是用来处理日志输出位置
     * 6,Formatter是用来格式化LogRecord的
     * @throws IOException
     */

    @Test
    public void testLogConfig() throws IOException {
        Logger logger = Logger.getLogger(JULTest.class.getName());

        // logger的顶级父元素 java.util.logging.LogManager$RootLogger
        System.out.println(logger.getParent());

        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

        // 控制台日志处理器
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        // 文件日志处理器
        FileHandler fileHandler = new FileHandler("D:\\IdeaProjects\\temp\\log\\jul.log");
        fileHandler.setLevel(Level.ALL);
        // 日志格式转换器
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        consoleHandler.setFormatter(simpleFormatter);
        fileHandler.setFormatter(simpleFormatter);

        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);

        logger.finer("finer");

    }
}
