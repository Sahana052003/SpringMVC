package com.xworkz.homepage.dto;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;



@Data
public class HomepageDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmpassword;
    private Long mobileNumber;

}