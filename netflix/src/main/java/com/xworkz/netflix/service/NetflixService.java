package com.xworkz.netflix.service;

import com.xworkz.netflix.dto.NetflixDTO;

import java.util.List;

public interface NetflixService {
    boolean registerUser(NetflixDTO netflixDTO);
    List<NetflixDTO> getDTO();

}
