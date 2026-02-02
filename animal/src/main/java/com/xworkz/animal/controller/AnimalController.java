package com.xworkz.animal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AnimalController {
    public AnimalController(){
        System.out.println("Animal Controller is Called");
    }

    @GetMapping("/eat")
    public String eat(){
        return "eating";
    }

    @GetMapping("/run")
    public String run(){
        return "running";
    }

    @GetMapping("/walk")
    public String walk(){
        return "walking";
    }

    @GetMapping("/makeSound")
    public String makeSound(){
        return "sound";
    }

    @GetMapping("/sleep")
    public String sleep(){
        return "sleeping";
    }

}
