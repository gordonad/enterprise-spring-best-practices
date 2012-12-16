package com.gordondickens.enterprisespring.infrastructure.config.db;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.HSQLDialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * <p/>
 * Date: 2012-11-20
 * <p/>
 * Embedded HSQL Spring Configuration, only requires DB Driver in ClassPath
 * <p/>
 *
 * @author Gordon Dickens
 */
@Configuration
@Profile(DatabaseConfigProfile.HSQL_EMBEDDED)
public class JpaHsqlEmbeddedConfig extends JpaPersistenceCommonConfig {
    private static final Logger logger = LoggerFactory.getLogger(JpaHsqlEmbeddedConfig.class);

    @Bean
    @Override
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }

    @Override
    protected Class<? extends Dialect> getDatabaseDialect() {
        return HSQLDialect.class;
    }

    @Bean
    public DatabasePopulator databasePopulator(DataSource dataSource) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(true);
        populator.setIgnoreFailedDrops(true);
        populator.addScript(new ClassPathResource("/sql/items.sql"));
        try {
            populator.populate(dataSource.getConnection());
        } catch (SQLException e) {
            logger.error("Exception Populating Database", e);
        }
        return populator;
    }

}
