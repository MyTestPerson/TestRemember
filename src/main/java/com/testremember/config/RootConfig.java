package com.testremember.config;

import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan({"com.testremember.security",
        "com.testremember.repository"})
public class RootConfig implements WebMvcConfigurer {





    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.testremember.model"); // путь до папки где будут лежать наши модели
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }


    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/testremember?serverTimezone=UTC&useSSL=true");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("1234");

        return driverManagerDataSource;

    }


    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {

        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }


    private Properties hibernateProperties() {

        Properties properties = new Properties();

        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "true");
        properties.put(Environment.DEFAULT_SCHEMA, "testremember");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

        return properties;
    }











    /* Запомнить меня */
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource());
        return jdbcTokenRepository;
    }



}