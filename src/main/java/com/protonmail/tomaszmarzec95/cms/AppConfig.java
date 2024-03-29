package com.protonmail.tomaszmarzec95.cms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.protonmail.tomaszmarzec95.cms")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean lemfb = new LocalEntityManagerFactoryBean();
        lemfb.setPersistenceUnitName("cmsPersistenceUnit");
        return lemfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(emf);
        return jpaTransactionManager;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
