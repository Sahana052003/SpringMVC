package com.xworkz.nammayatra.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.nammayatra")
public class WebConfiguration {
    public WebConfiguration(){
        System.out.println("Web-Configuration is Called");
    }
}
