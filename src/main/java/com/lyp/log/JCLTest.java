package com.lyp.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * jcl 是门面日志框架，只提供相应的api定义，不提供实现
 * @author Liu Yanping
 * @date 2022/8/7 22:59
 */
public class JCLTest {

    @Test
    public void testQuick() {
        /**
         * 门面日志会在内部查找 日志的具体实现类，比如 log4j、jul(jdk自带的)
         */
        Log log = LogFactory.getLog(JCLTest.class);
        log.info("门面日志");
    }
}
