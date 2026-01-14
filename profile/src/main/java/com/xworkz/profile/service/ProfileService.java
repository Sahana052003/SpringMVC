package com.xworkz.profile.service;

import org.springframework.stereotype.Service;

@Service
public class ProfileService implements Profile {
    @Override
    public void create() {
        System.out.println("Creating a profile class");
    }
}
