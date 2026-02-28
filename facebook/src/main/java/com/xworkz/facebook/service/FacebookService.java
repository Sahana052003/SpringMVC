package com.xworkz.facebook.service;

import com.xworkz.facebook.dto.FacebookDTO;

import java.util.List;

public interface FacebookService {
    String registerUser(FacebookDTO facebookDTO);

    List<FacebookDTO> getDTO();

    FacebookDTO checkEmailExists(String email);

    FacebookDTO checkPhoneNumber(Long phoneNumber);

    FacebookDTO getId(int id);

}
