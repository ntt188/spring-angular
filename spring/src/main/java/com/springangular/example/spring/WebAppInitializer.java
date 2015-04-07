package com.springangular.example.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebAppInitializer implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
        rootCtx.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootCtx));
        Dynamic reg = servletContext.addServlet("rest", new DispatcherServlet(rootCtx));
        reg.setLoadOnStartup(1);
        reg.addMapping("/");	
	}
}
