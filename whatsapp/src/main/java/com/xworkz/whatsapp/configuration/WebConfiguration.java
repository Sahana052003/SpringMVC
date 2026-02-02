package com.xworkz.whatsapp.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.whatsapp")
public class WebConfiguration {
    public WebConfiguration(){
        System.out.println("called WebConfiguration");
    }

    @Bean
    public ViewResolver viewResolver(){
        System.out.println("Called ViewResolver");
        return new InternalResourceViewResolver("",".jsp");
    }
}
