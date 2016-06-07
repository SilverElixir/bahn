package com.bahn.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
//import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.bahn.dao")
@PropertySource({ "classpath:database.properties" })
@ComponentScan
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(restDataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.bahn.entity" });
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource restDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));

        return dataSource;
    }

//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(restDataSource());
//        entityManagerFactoryBean.setPackagesToScan(new String[]{"com.bahn.entity"});
//        entityManagerFactoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
//        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        Map<String, Object> jpaProperties = new HashMap<String, Object>();
//        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hb.hbm2ddl.auto"));
//        jpaProperties.put("hibernate.show_sql", env.getProperty("hb.showSql"));
//        jpaProperties.put("hibernate.format_sql", env.getProperty("hb.formatSql"));
//        jpaProperties.put("hibernate.use_sql_comments", env.getProperty("hb.sqlComments"));
//        jpaProperties.put("hibernate.dialect", env.getProperty("hb.dialect"));
//        jpaProperties.put("hibernate.connection.charset",env.getProperty("hb.connection.charset"));
//        jpaProperties.put("hibernate.connection.characterEncoding",env.getProperty("hb.connection.characterEncoding"));
//        jpaProperties.put("hibernate.connection.useUnicode",env.getProperty("hb.connection.useUnicode"));
//        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties);
//
////        HashMap<String, String> map = new HashMap<>();
////        map.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
////        entityManagerFactoryBean.setJpaPropertyMap(map);
//
//        return entityManagerFactoryBean;
//    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.hbm2ddl.auto", env.getProperty("hb.hbm2ddl.auto"));
                setProperty("hibernate.dialect", env.getProperty("hb.dialect"));
                setProperty("hibernate.globally_quoted_identifiers", "true");
            }
        };
    }
}
