package com.xworkz.facebook.dao;

import com.xworkz.facebook.entity.FacebookEntity;

import java.util.List;

public interface FacebookDAO {
    boolean accessData(FacebookEntity facebookEntity);
    List<FacebookEntity> getFacebookData();
    FacebookEntity getDetailsBasedOnEmail(String email);
    FacebookEntity getDetailsBasedOnPhoneNumber(Long phoneNumber);
    FacebookEntity getDDetaisBasedOnId(int id);

}
