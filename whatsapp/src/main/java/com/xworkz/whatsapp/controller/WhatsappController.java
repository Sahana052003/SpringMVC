package com.xworkz.whatsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WhatsappController {
    public WhatsappController(){
        System.out.println("Called WhatsappController");
    }

    @GetMapping("/status")
    public String status(){
        System.out.println("called What'sapp status");
        return "status";
    }
    @GetMapping("/sendMessage")
    public String sendMessage(){
        System.out.println("called What'sapp sendMessage");
        return "sendMessage";
    }
    @GetMapping("/receiveMessage")
    public String receiveMessage(){
        System.out.println("called What'sapp receiveMessage");
        return "receiveMessage";
    }
    @GetMapping("/uploadStatus")
    public String uploadStatus(){
        System.out.println("called What'sapp uploadstatus");
        return "uploadStatus";
    }
    @GetMapping("/login")
    public String login(){
        System.out.println("called What'sapp login");
        return "login";
    }
}
