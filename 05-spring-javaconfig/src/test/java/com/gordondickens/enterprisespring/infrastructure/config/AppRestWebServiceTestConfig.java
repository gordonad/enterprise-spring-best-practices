package com.gordondickens.enterprisespring.infrastructure.config;

import com.gordondickens.enterprisespring.infrastructure.Env;
import com.gordondickens.enterprisespring.infrastructure.config.db.DatabaseConfigProfile;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

/**
 * Date: 2012-12-12
 * <p/>
 *
 * @author Gordon Dickens
 */
@Configuration
@Import({AppTestConfig.class, RestWebServiceTestConfig.class})
@Profile({DatabaseConfigProfile.HSQL_EMBEDDED, Env.TESTING})
public class AppRestWebServiceTestConfig {
}
