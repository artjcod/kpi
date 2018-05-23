package com.snaceur.projects.spring5webapp.config;

import com.snaceur.projects.spring5webapp.Sping5WebApp;
import com.snaceur.projects.spring5webapp.domain.kpi.result.QueryOperationResult;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.dialect.MySQL57Dialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;

import javax.sql.DataSource;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class SpringWebAppConfig {
    @Bean
    AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
    @Bean
    DataSource getDataSource(Environment environment) {
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        return dataSource;
    }


    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource) ;
        em.setPackagesToScan(Sping5WebApp.class.getPackage().getName());
        em.setPersistenceProvider(new HibernatePersistenceProvider());
        Map<String, String> p = new HashMap<>();
        p.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        p.put(org.hibernate.cfg.Environment.DIALECT, MySQL57Dialect.class.getName());
        p.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
        em.setJpaPropertyMap(p);
        return em;
    }
    @Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
		
	}

    @Bean
    QueryOperationResult getQueryOperationResult() {
        return new QueryOperationResult();
    }

    
    @Bean
    AtomicInteger atomicInteger() {
      return new AtomicInteger(LocalDateTime.now().getNano());
    }

}

