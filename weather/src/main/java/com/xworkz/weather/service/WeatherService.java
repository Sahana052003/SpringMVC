package com.xworkz.weather.service;

import org.springframework.stereotype.Service;

@Service
public class WeatherService implements Weather{
    @Override
    public void checkTemperature() {
        System.out.println("checking current temperature");
    }

    @Override
    public void checkHumidity() {
        System.out.println("reading humidity levels");
    }

    @Override
    public void checkconditions() {
        System.out.println("checking Condition ");
    }

    @Override
    public void checkPressure() {
        System.out.println(" measure pressure");
    }

    @Override
    public void checkWindSpeed() {
        System.out.println("check Wind Speed");
    }

    @Override
    public void checkResult() {
        System.out.println("reported a weather result");
    }

    @Override
    public void checkRaining() {
        System.out.println("shows is rainy or not");
    }

    @Override
    public void checkTime() {
        System.out.println("updated time to time");
    }

    @Override
    public void updateData() {
        System.out.println("updating a weather data");
    }

    @Override
    public void hasSnow() {
        System.out.println("check is snowy or not");
    }
}
