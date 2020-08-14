package com.coursecube.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@SpringBootApplication
public class JLCAppConfig {

    @Bean(name = "jpaVendorAdapter")
    public JpaVendorAdapter getJpaVendor() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

        return jpaVendorAdapter;
    }

    @Bean(name = "jlcEntityFactory")
    public LocalContainerEntityManagerFactoryBean entityFactory(DataSource dataSource, JpaVendorAdapter adaptor) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(adaptor);
        factory.setPackagesToScan("com.coursecube.springboot");
        return factory;
    }

    @Bean(name = "jlcJpaTransactionManager")
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory Factory) {
        return new JpaTransactionManager(Factory);
    }

}
