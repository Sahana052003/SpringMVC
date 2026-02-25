package com.xworkz.facebook.dao;

import com.xworkz.facebook.entity.FacebookEntity;

import java.util.List;

public interface FacebookDAO {
    void accessData(FacebookEntity facebookEntity);
    List<FacebookEntity> getFacebookData();

}
