package com.gordondickens.enterprisespring.logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: gordon
 * Date: 7/5/12
 * Time: 1:37 PM
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class JulAndSysoutTests {
    private static final Logger logger = LoggerFactory.getLogger(JulAndSysoutTests.class);

    java.util.logging.Logger julLogger = java.util.logging.Logger
            .getLogger("com.gordondickens.enterprisespring");

    @Test
    public void logJulMessage() {
        julLogger.info("HERE IS YOUR JUL MESSAGE");

    }

    @Test
    public void logSysout() {
        System.out.println("Holy Crap, Logging SysOut works!!!");
        System.err.println("Holy SysErr Batman, this works too!!!");
    }
}
