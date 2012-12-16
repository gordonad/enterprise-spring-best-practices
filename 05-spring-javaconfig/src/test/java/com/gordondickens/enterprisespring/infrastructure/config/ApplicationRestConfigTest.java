package com.gordondickens.enterprisespring.infrastructure.config;

import com.gordondickens.enterprisespring.infrastructure.Env;
import com.gordondickens.enterprisespring.infrastructure.config.db.DatabaseConfigProfile;
import com.gordondickens.enterprisespring.web.ItemController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author Gordon Dickens
 */
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppRestWebServiceTestConfig.class})
@ActiveProfiles(profiles = {DatabaseConfigProfile.HSQL_EMBEDDED, Env.TESTING})
public class ApplicationRestConfigTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    ItemController itemController;

    @Ignore("Need to stub out Servlet config for this to work")
    @Test
    public void verifyAllWiresUpCorrectly() {
        assertThat(applicationContext, notNullValue());
        assertThat(itemController, notNullValue());
    }
}
