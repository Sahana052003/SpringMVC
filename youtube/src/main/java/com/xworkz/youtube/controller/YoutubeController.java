package com.xworkz.youtube.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class YoutubeController {
    public YoutubeController(){
        System.out.println("YoutubeController is Called");
    }


    @GetMapping("/amountStatus")
    public String amountStatus(){
        System.out.println("Called amountStatus");
        return "amount";
    }
    @GetMapping("/miniStatement")
    public String miniStatement(){
        System.out.println("Called miniStatement");
        return "statement";
    }
    @GetMapping("/validPin")
    public String validPin(){
        System.out.println("Called validPinNumber");
        return "pin";
    }
    @GetMapping("/accountverify")
    public String accountVerify(){
        System.out.println("Called accountVerify");
        return "verifyacc";
    }
    @GetMapping("/depositAmount")
    public String depositAmount(){
        System.out.println("Called depositAmount");
        return "deposite";
    }
}
