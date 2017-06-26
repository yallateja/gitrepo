package com.teja.mvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.teja.mvc" })
@EnableTransactionManagement
@EnableJpaRepositories("com.teja.mvc.repository")
//@Import({ WebSecurityConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		
//		registry.addViewController("/").setViewName("home");
//		registry.addViewController("/login").setViewName("login");
//	}
	
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
         
        return dataSource;
    }
	
	
	
	@Bean
	public EntityManagerFactory entityManagerFactory(){
		HibernateJpaVendorAdapter vendorAdaptor=new HibernateJpaVendorAdapter();
		vendorAdaptor.setGenerateDdl(true);
		Properties jpaProperties=new Properties();
		jpaProperties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		//jpaProperties.put("hibernate.hbm2ddl.auto","create");
		jpaProperties.put("hibernate.show_sql","true");
		LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setPackagesToScan("com.teja.mvc.entity");
		factory.setJpaVendorAdapter(vendorAdaptor);
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		return factory.getObject();
		
		
	}
	@Bean
	public PlatformTransactionManager transactionManager(){
		
		JpaTransactionManager txmanager =new JpaTransactionManager();
		txmanager.setEntityManagerFactory(entityManagerFactory());
		return txmanager;
	}
	
	@Bean
	public InternalResourceViewResolver internalResolver(){
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
		
	}
	
	
	
}
