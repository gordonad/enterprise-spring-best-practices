package com.gordondickens.enterprisespring.infrastructure.config.db;

import com.gordondickens.enterprisespring.domain.ItemEntity;
import org.hibernate.dialect.Dialect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public abstract class JpaPersistenceCommonConfig {
    private static final Logger logger = LoggerFactory.getLogger(JpaPersistenceCommonConfig.class);

    /*
     * ********************************
     * PUBLIC  METHODS  ARE  @BEANS
     * PUBLIC  METHODS  ARE  @BEANS
     * PUBLIC  METHODS  ARE  @BEANS
     * PUBLIC  METHODS  ARE  @BEANS
     * PUBLIC  METHODS  ARE  @BEANS
     * PUBLIC  METHODS  ARE  @BEANS
     *
     * Method Name is the BEAN ID (without the parenthesis)
     * Return Type is the Bean type
     * ********************************
     */

    @Bean
    public abstract DataSource dataSource();

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        logger.debug("\n\n************ {} ************\n\n",
                getDatabaseDialect().getCanonicalName());
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabasePlatform(getDatabaseDialect().getName());
        vendorAdapter.setShowSql(true);

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(ItemEntity.class.getPackage().getName());
        factory.setDataSource(dataSource());
        if (getJpaProperties() != null) {
            factory.setJpaProperties(getJpaProperties());
        }
        return factory;
    }

    @Bean
    public EntityManager entityManger() {
        return entityManagerFactory().getObject().createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }

    /*
     * ********************************
     * PROTECTED METHODS ARE NOT BEANS
     * PROTECTED METHODS ARE NOT BEANS
     * PROTECTED METHODS ARE NOT BEANS
     * PROTECTED METHODS ARE NOT BEANS
     * PROTECTED METHODS ARE NOT BEANS
     * PROTECTED METHODS ARE NOT BEANS
     * ********************************
     */
    protected abstract Class<? extends Dialect> getDatabaseDialect();

    /**
     * Override if configuring JPA Properties
     * <p/>
     *
     * @return Jpa Properties to be used in Entity Manager Factory
     */
    protected Properties getJpaProperties() {
        return null;
    }


}
