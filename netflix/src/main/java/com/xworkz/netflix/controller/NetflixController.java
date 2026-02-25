package com.xworkz.netflix.controller;

import com.xworkz.netflix.dto.NetflixDTO;
import com.xworkz.netflix.service.NetflixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class NetflixController {
public NetflixController(){
    System.out.println("NetflixController is Called");
}

@Autowired NetflixService netflixService;



     @PostMapping("login")
      public String saveData(NetflixDTO netflixDTO, Model model){
         boolean validate=netflixService.registerUser(netflixDTO);
         System.out.println("Data is : " + netflixDTO);

         if(validate){
             model.addAttribute("information","Register Successfully");
             model.addAttribute("color","green");
         }else {
             model.addAttribute("information","Failed to Register");
             model.addAttribute("color","red");
         }
        return "index";
    }
}
