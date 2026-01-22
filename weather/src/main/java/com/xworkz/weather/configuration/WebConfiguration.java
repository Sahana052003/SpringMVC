package com.xworkz.weather.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.weather")
public class WebConfiguration {
    public WebConfiguration(){
        System.out.println("WebConfiguration is called");
    }



    @Bean
    public ViewResolver report(){
        System.out.println("Checking Weather report");
        return new InternalResourceViewResolver("",".jsp");
    }
}
