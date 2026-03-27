package com.xworkz.studentData.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "std_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    private Integer id;
    private String name;
    private String address;
    private Integer age;
}
