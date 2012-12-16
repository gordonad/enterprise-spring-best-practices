package com.gordondickens.enterprisespring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;

/**
 * @author Gordon Dickens
 */
public class BeansInContext {
    private static final Logger logger = LoggerFactory.getLogger(BeansInContext.class);

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    BeanFactory beanFactory;

    @PostConstruct
    public void showBeansInContext2() {
        DefaultListableBeanFactory factory = (DefaultListableBeanFactory) beanFactory;
        if (factory != null) {
            logger.debug("Bean Factory: '{}'", factory);
        }

        if (applicationContext.getParent() != null) {
            logger.debug("Bean Factory: '{}'", applicationContext.getParentBeanFactory());
        }
        logger.debug("\n\n\n******************************************************************************");
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String o : beans) {
            logger.debug("________________________");
            logger.debug("BEAN id: '{}'", o);
            logger.debug("\tType: '{}'", applicationContext.getType(o));
            String[] aliases = applicationContext.getAliases(o);

            if (factory != null && factory.isFactoryBean(o)) logger.debug("\tFACTORY");
            if (aliases != null && aliases.length > 0) {
                for (String a : aliases) {
                    logger.debug("\tAliased as: '{}'", a);
                }
            }
            if (factory != null && factory.getBeanDefinition(o).isAbstract()) {
                logger.debug("\tABSTRACT");
            } else {
                if (applicationContext.isPrototype(o)) logger.debug("\tScope: 'Prototype'");
                if (applicationContext.isSingleton(o)) logger.debug("\tScope: 'Singleton'");

                Annotation[] annotations = applicationContext.getBean(o).getClass().getAnnotations();
                if (annotations != null && annotations.length > 0) {
                    logger.debug("\tAnnotations:");

                    for (Annotation annotation : annotations) {
                        logger.debug("\t\t'{}'", annotation.annotationType());
                    }
                }
                if (!applicationContext.getBean(o).toString().startsWith(applicationContext.getType(o).toString() + "@")) {
                    logger.debug("\tContents: {}", applicationContext.getBean(o).toString());
                }
            }
        }

        logger.debug("******************************************************************************");
        logger.debug("*** Number of Beans={} ***",
                applicationContext.getBeanDefinitionCount());
        if (factory != null) {
            logger.debug("*** Number of Bean Post Processors={} ***", factory.getBeanPostProcessorCount());
        }
        logger.debug("******************************************************************************\n\n\n");
    }
}
