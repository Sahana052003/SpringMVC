package com.xworkz.profile.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.profile")
public class WebConfiguration {
    public WebConfiguration(){
        System.out.println("Calling WebConfiguration");
    }
}
