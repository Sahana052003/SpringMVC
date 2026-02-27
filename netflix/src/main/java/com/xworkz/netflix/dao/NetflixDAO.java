package com.xworkz.netflix.dao;

import com.xworkz.netflix.entity.NetflixEntity;

import java.util.List;

public interface NetflixDAO {
    boolean saveData(NetflixEntity entity);
    List<NetflixEntity> getNetflixData();
    NetflixEntity getDetailsBasedOnEmail(String email);
    NetflixEntity getDetailsBasedOnMobile(Long mobile);
}
