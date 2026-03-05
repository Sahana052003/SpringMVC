package com.xworkz.facebook.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xworkz.facebook.dto.FacebookDTO;
import com.xworkz.facebook.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class FacebookController {
    public FacebookController(){
        System.out.println("Facebook Controller is Called");
    }

    @Autowired
    FacebookService facebookService;



    @PostMapping("register")
    public String registerForm(FacebookDTO facebookDTO, Model model) {
        String isVaild = facebookService.registerUser(facebookDTO);
        System.out.println("Data is entered : " + facebookDTO);
        if(isVaild.equalsIgnoreCase("Registered successfully")) {
            model.addAttribute("message",isVaild);
            return "index";
        }else if (isVaild.equalsIgnoreCase("Not Registered")){
            model.addAttribute("errormsg",isVaild);
            return "index";
        }else{
            model.addAttribute("errormsg",isVaild);
            return "index";
        }
    }


    @GetMapping("getDetails")
    public String getDetails(Model model){
        List<FacebookDTO> dtoList=facebookService.getDTO();
        model.addAttribute("message",dtoList);
        return "facebook";
    }



    @GetMapping("getData")
    public String getFacebookDetails(@RequestParam int id,Model model){
        System.out.println("ID is : " + id);
        FacebookDTO dto = facebookService.getId(id);
        if (dto!=null){
            model.addAttribute("info",dto);
            return "facebookDetails";
        }
        return "facebookDetails";
    }



    @PostMapping("update")
    public String updateData(FacebookDTO facebookDTO,Model model){
       facebookService.updateFacebookData(facebookDTO);
        List<FacebookDTO> dto = facebookService.getDTO();
        model.addAttribute("message",dto);
        return "facebook";
    }
    }