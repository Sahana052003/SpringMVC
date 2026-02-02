package com.xworkz.bike.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BikeController {
    public BikeController(){
        System.out.println("BikeController is Called");
    }
    @GetMapping("/horn")
    public String horn(){
        return "horn";
    }

    @GetMapping("/park")
    public String park(){
        return "park";
    }

    @GetMapping("/arefuel")
    public String refuel(){
        return "refuel";
    }
    @GetMapping("/right")
    public String turnRight(){
        return "turnright";
    }

    @GetMapping("/left")
    public String turnLeft(){
        return "turnleft";
    }

}
