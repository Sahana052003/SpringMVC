package com.xworkz.profile.controller;

import com.xworkz.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ProfileController {
    public ProfileController(){
        System.out.println("Profile Controller is Created");
    }

    @Autowired
    ProfileService profileService;



    @GetMapping("/opened")
    public String opened(@RequestParam String name){
        profileService.create();
        System.out.println("Profile is opened to create" + name);
        return "index.jsp";
    }
}


