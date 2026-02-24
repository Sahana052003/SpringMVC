package com.xworkz.facebook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "facebook_table")
@AllArgsConstructor
@NoArgsConstructor
public class FacebookEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
    private String gender;
    private String country;
}
