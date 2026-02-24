package com.xworkz.facebook.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xworkz.facebook.dto.FacebookDTO;
import com.xworkz.facebook.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FacebookController {
    public FacebookController(){
        System.out.println("Facebook Controller is Called");
    }

    @Autowired
    FacebookService facebookService;



    @PostMapping("register")
    public String registerForm(FacebookDTO facebookDTO, Model model){
        boolean validate=facebookService.registerUser(facebookDTO);
        System.out.println("Data is entered : " + facebookDTO);



        if(validate){
            model.addAttribute("message","Register Successfully");
            model.addAttribute("color","green");
        }else {
            model.addAttribute("message","Failed to Register");
            model.addAttribute("color","red");
        }
        return "index";
    }
    }

