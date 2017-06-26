package com.teja.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppIntilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		
		
		AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
		rootContext.register(WebConfig.class);
		rootContext.register(WebSecurityConfig.class);
		
		container.addListener(new ContextLoaderListener(rootContext));
		
		DispatcherServlet dispatcher =new DispatcherServlet(rootContext);
		ServletRegistration.Dynamic registration=container.addServlet("dispatcherservlet", dispatcher);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
		
	}

}
