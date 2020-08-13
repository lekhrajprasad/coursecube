package com.coursecube.springboot;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@SpringBootApplication
public class JLCAppConfig {

    @Bean(name="jlcSessionFactory")
   public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
       LocalSessionFactoryBean factory = new LocalSessionFactoryBean();

       Properties props = new Properties();
       props.put("hibernate.show_sql", "true");
       props.put("hibernate.hbm2ddl.auto", "update");

       factory.setHibernateProperties(props);
       factory.setDataSource(dataSource);
       factory.setPackagesToScan("com.coursecube.springboot");

       return factory;
   }

   @Bean(name="jlchibernateTemplate")
   public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory){
        return new HibernateTemplate(sessionFactory);
   }

   @Bean(name = "jlcHibernateTransactionManager")
   public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
   }

}
