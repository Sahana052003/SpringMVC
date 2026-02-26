package com.xworkz.netflix.dao;

import com.xworkz.netflix.entity.NetflixEntity;

import java.util.List;

public interface NetflixDAO {
    void saveData(NetflixEntity entity);
    List<NetflixEntity> getNetflixData();
}
