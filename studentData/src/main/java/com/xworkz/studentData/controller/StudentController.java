package com.xworkz.studentData.controller;


import com.xworkz.studentData.dto.StudentDTO;
import com.xworkz.studentData.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StudentController {
    public StudentController(){
        System.out.println("StudentController is Calledd");
    }

    @Autowired
    StudentService studentService;

    @GetMapping("login")
    public String  LoginStudent(){
        System.out.println("LoginStudent");
        return "index";
    }


    @PostMapping("login")
    public String StudentDta(StudentDTO studentDTO){
        System.out.println("Enter a student data");
        return "index";
    }
}
