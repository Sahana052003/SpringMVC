package com.xworkz.weather.controller;


import com.xworkz.weather.service.WeatherService;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class WeatherController {
    public WeatherController(){
        System.out.println("Calling WeatherController");
    }

    @Autowired
    WeatherService weatherService;


    @GetMapping("/temperature")
    public String temperature(@RequestParam double temperature){
        weatherService.checkTemperature();
        System.out.println("calculated and displayed the temperature " + temperature);
        return "index";
    }

    @GetMapping("/humidity")
    public String humidity(@RequestParam int humidity){
        weatherService.checkHumidity();
        System.out.println(" Calculate humidity " + humidity);
        return "humidity";
    }
    @GetMapping("/weatherCondition")
    public String weatherCondition(@RequestParam String condition){
        weatherService.checkconditions();
        System.out.println("Check Weather condition " + condition );
        return "condition";
    }
    @GetMapping("/speedOfPressure")
    public String speedOfPressure(@RequestParam String pressure){
        weatherService.checkPressure();
        System.out.println("Calculated the pressure " + pressure);
        return "pressure";
    }
    @GetMapping("/speedOfWeather")
    public String speedOfWeather(@RequestParam String weather){
        weatherService.checkWindSpeed();
        System.out.println("Calculated the speed " + weather);
        return "weather";
    }
    @GetMapping("/result")
    public String result(@RequestParam String update){
        weatherService.checkResult();
        System.out.println("Check the result or status of Weather " + update);
        return "update";
    }
    @GetMapping("/rainy")
    public String rainy(@RequestParam String rain){
        weatherService.checkRaining();
        System.out.println("Get rainy at this time " + rain);
        return "rain";
    }
    @GetMapping("/time")
    public String time(@RequestParam String timings){
        weatherService.checkTime();
        System.out.println("can also see a time for an updates " + timings);
        return "timings";
    }
    @GetMapping("/data")
    public String data(@RequestParam long number){
        weatherService.updateData();
        System.out.println("Get all the data to user " + number);
        return "number";
    }
    @GetMapping("/snow")
    public String snow(@RequestParam String name){
        weatherService.hasSnow();
        System.out.println("IS Snowy " + name);
        return "snow";
    }
}



