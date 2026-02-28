package com.xworkz.facebook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacebookDTO {

    private int id;
    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
    private String gender;
    private String country;
    private String address;
}
