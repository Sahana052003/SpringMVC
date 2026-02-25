package com.xworkz.netflix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetflixDTO {
    private String name;
    private String email;
    private String password;
    private Long mobile;
    private String gender;
    private String plan;
}
