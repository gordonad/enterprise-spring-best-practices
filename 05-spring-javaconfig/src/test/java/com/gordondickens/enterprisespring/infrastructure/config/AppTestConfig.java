package com.gordondickens.enterprisespring.infrastructure.config;

import com.gordondickens.enterprisespring.infrastructure.Env;
import com.gordondickens.enterprisespring.infrastructure.config.db.DatabaseConfigProfile;
import com.gordondickens.enterprisespring.infrastructure.config.db.JpaHsqlEmbeddedConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Date: 2012-12-12
 * <p/>
 *
 * @author Gordon Dickens
 */
@Configuration
@EnableTransactionManagement
@Import({ApplicationConfig.class, JpaHsqlEmbeddedConfig.class})
@Profile({DatabaseConfigProfile.HSQL_EMBEDDED, Env.TESTING})
public class AppTestConfig {
}
