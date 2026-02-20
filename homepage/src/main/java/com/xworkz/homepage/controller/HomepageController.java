package com.xworkz.homepage.controller;

import com.xworkz.homepage.dao.InsertPageDAO;
import com.xworkz.homepage.dto.HomepageDTO;
import com.xworkz.homepage.exception.InvalidException;
import com.xworkz.homepage.service.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomepageController {
    public HomepageController() {
        System.out.println("HomepageController is Called");
    }

    @Autowired
    private HomepageService homepageService;
    private HomepageDTO homepageDTO;

    //    @PostMapping("/status")
//    public String status(HomepageDTO homepageDTO ){
//        System.out.println("FirstName is : " + homepageDTO.getFirstName() + "LastName is : " + homepageDTO.getLastName()
//        + "Email-id is : " + homepageDTO.getEmail() + "Password is : " + homepageDTO.getPassword() + "Confirm password : " + homepageDTO.getConfirmpassword());
//        return  "signin";
//
//    }
    @PostMapping("/signin")
    public String signin() {
        System.out.println("Signin page loaded");
        return "signin";
    }

    @PostMapping("/signup")
    public String signup() {
        System.out.println("Signup page loaded");
        return "signup";
    }

    @PostMapping("/home")
    public String home() {
        System.out.println("Signin page loaded");
        return "home";
    }

    @PostMapping("/status")
    public String signupStatus(HomepageDTO homepageDTO) {
        try {
            boolean success = homepageService.signupValidate(homepageDTO);
            System.out.println("Signup successfully");
            return "success";
        } catch (InvalidException obj) {
            System.out.println("Failed to signup"+obj.getMessage());
            return "signup";
        }
    }

    @PostMapping("/index")
    public String indexPage() {
        System.out.println("Signup Success");
        return "index";
    }



    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password, Model model) {
        try {
            homepageService.signinValidation(email, password);
            return "home";

        } catch (InvalidException e) {
            System.out.println("Login Failed : " + e.getMessage());
            model.addAttribute("errorMessage", "Invalid email/password");
            return "signin";   // stay on same page
        }
    }
}
