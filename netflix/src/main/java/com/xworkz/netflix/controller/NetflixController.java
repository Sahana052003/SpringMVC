package com.xworkz.netflix.controller;

import com.xworkz.netflix.dto.NetflixDTO;
import com.xworkz.netflix.service.NetflixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class NetflixController {
public NetflixController(){
    System.out.println("NetflixController is Called");
}

@Autowired NetflixService netflixService;



     @PostMapping("login")
      public String saveData(NetflixDTO netflixDTO, Model model){
         String validate=netflixService.registerUser(netflixDTO);
         System.out.println("Data is : " + netflixDTO);

         if(validate.equalsIgnoreCase("Registered successfully")){
             model.addAttribute("information",validate);
             return "index";
         }else if(validate.equalsIgnoreCase("Not Registered")) {
             model.addAttribute("information",validate);
             return "index";
         }else{
             model.addAttribute("errormsg",validate);
             return "index";
         }
    }


    @GetMapping("getDetails")
    public String getDetails(Model model){
        List<NetflixDTO> list=netflixService.getDTO();
        model.addAttribute("information",list);
        return "register";
    }
}
