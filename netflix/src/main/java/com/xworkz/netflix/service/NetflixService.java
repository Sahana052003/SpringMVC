package com.xworkz.netflix.service;

import com.xworkz.netflix.dto.NetflixDTO;

import java.util.List;

public interface NetflixService {
    String registerUser(NetflixDTO netflixDTO);
    List<NetflixDTO> getDTO();
    NetflixDTO checkEmail(String email);
    NetflixDTO checkMobileNumber(Long mobile);
}
