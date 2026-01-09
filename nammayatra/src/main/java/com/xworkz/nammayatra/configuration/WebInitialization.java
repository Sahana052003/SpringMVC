package com.xworkz.nammayatra.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitialization extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("getRootConfigClasses is Called");
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("getServletConfigClasses is called");
        return new Class[]{WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("getServletMappings is called");
        return new String[]{"/"};
    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer){
        defaultServletHandlerConfigurer.enable();
    }
}
