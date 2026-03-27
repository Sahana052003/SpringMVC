package com.xworkz.studentData.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
}
