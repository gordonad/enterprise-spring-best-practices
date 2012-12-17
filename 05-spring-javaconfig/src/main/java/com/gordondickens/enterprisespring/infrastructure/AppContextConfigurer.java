package com.gordondickens.enterprisespring.infrastructure;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * Date: 2012-12-05
 * <p/>
 *
 * @author Gordon Dickens
 */
public class AppContextConfigurer implements ApplicationContextInitializer {
    private static final Logger logger = LoggerFactory
            .getLogger(AppContextConfigurer.class);

    //TODO Set Key to Discriminator for connectivity
    private static final String CONNECTION_KEY = "someKey";

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // Extract some value from Platform environment to determine if online or offline
        Map<String, Object> systemEnvironment =
                applicationContext.getEnvironment().getSystemEnvironment();
        Map<String, Object> systemProperties =
                applicationContext.getEnvironment().getSystemProperties();

        logEnvironmentContent(systemEnvironment, systemProperties);

        //TODO Is the key property driven or environment driven?
        //  if (systemsystemProperties.get(CONNECTION_KEY) != null) {
        if (systemEnvironment.get(CONNECTION_KEY) != null) {
            logger.debug("Environment Key found: '{}'='{}'",
                    CONNECTION_KEY, systemEnvironment.get(CONNECTION_KEY));
            logger.info("Setting Environment to '{}'", Env.CONNECTED);
            applicationContext.getEnvironment().setActiveProfiles(Env.CONNECTED);
        } else {
            logger.info("Setting Environment to '{}'", Env.DISCONNECTED);
            applicationContext.getEnvironment().setActiveProfiles(Env.DISCONNECTED);
        }

        logger.info("Application is running {}", applicationContext.getEnvironment().getActiveProfiles());
        applicationContext.refresh();
    }

    /**
     * @param sys   Map of System Environment
     * @param props Map of System Properties
     */
    protected void logEnvironmentContent(final Map<String, Object> sys,
                                         final Map<String, Object> props) {
        if (logger.isDebugEnabled()) {
            if (sys != null) {
                for (Object o : sys.keySet()) {
                    if (o != null) {
                        logger.debug("SYS: {}={}", o, sys.get(o));
                    }
                }
            }
            if (props != null) {
                for (Object o : props.keySet()) {
                    if (o != null) {
                        logger.debug("PROP: {}={}", o, props.get(o));
                    }
                }
            }
        }
    }

}
