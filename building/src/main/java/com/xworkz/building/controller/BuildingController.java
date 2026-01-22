package com.xworkz.building.controller;


import com.xworkz.building.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class BuildingController {
    public BuildingController(){
        System.out.println("Calling BuildingController");
    }
    @Autowired
    BuildingService buildingService;






    @GetMapping("/foundation")
    public String foundation(@RequestParam String structure){
        buildingService.layout();
        System.out.println("strucured with high quality products " + structure);
        return "index";
    }


    @GetMapping("/addDoors")
    public String addDoors(@RequestParam String  noOfDoors){
        System.out.println("Number of Doors are " + noOfDoors);
        return "doors";
    }

    @GetMapping("/activeSecurity")
    public String activeSecurity(@RequestParam String active){
        System.out.println("Have a security for an building " + active);
        return "security";
    }
    @GetMapping("/lockEntries")
    public String lockEntries(@RequestParam String noOfLocks){
        System.out.println("door locks " + noOfLocks);
        return "lockentries";
    }
    @GetMapping("/addWiring")
    public String addWiring(@RequestParam String wires){
        System.out.println("welladded wires " + wires);
        return "wiries";
    }
    @GetMapping("/addColors")
    public String addColors(@RequestParam String colors){
        System.out.println("used different colors to buildings " + colors);
        return "colors";
    }
    @GetMapping("/addRoof")
    public String addRoof(@RequestParam String roofs){
        System.out.println("added a well designed " + roofs);
        return "roofs";
    }
    @GetMapping("/addWindows")
    public String addWindows(@RequestParam String noOfWindows){
        System.out.println("total windows are  " + noOfWindows);
        return "windows";
    }
    @GetMapping("/blueprint")
    public String blueprint(@RequestParam String sketch){
        System.out.println("Have blueprint to build a house " + sketch);
        return "sketch";
    }
    @GetMapping("/demolish")
    public String demolish(@RequestParam String service){
        System.out.println("Reservided again" + service);
        return "services";
    }

}
