package com.xworkz.netflix.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "netflix_tb")
@AllArgsConstructor
@NoArgsConstructor

public class NetflixEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private Long mobile;
    private String gender;
    private String plan;
}
