package com.xworkz.bank.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.bank")
public class WebConfiguration {
    public WebConfiguration() {
        System.out.println("WebConfiguration is called");
    }


    @Bean
    public ViewResolver BankDetails() {
        System.out.println("Bank Details is Called");
        return new InternalResourceViewResolver("", ".jsp");
    }
}
