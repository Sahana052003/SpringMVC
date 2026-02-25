package com.xworkz.facebook.service;

import com.xworkz.facebook.dto.FacebookDTO;

import java.util.List;

public interface FacebookService {
    boolean registerUser(FacebookDTO facebookDTO);

    List<FacebookDTO> getDTO();

}
