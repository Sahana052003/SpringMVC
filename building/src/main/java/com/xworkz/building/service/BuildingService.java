package com.xworkz.building.service;


import org.springframework.stereotype.Service;

@Service
public class BuildingService implements Building{
    @Override
    public void layout() {
        System.out.println("First make a plan to build");
    }
}
