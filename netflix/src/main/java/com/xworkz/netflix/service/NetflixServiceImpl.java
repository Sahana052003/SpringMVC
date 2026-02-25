package com.xworkz.netflix.service;

import com.xworkz.netflix.dao.NetflixDAO;
import com.xworkz.netflix.dto.NetflixDTO;
import com.xworkz.netflix.entity.NetflixEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NetflixServiceImpl implements NetflixService {
    @Autowired
    NetflixDAO netflixDAO;


    @Override
    public boolean registerUser(NetflixDTO netflixDTO) {
        String name = netflixDTO.getName();
        String email = netflixDTO.getEmail();
        String password = netflixDTO.getPassword();
        Long mobile = netflixDTO.getMobile();
        String gender = netflixDTO.getGender();
        String plan = netflixDTO.getPlan();

        String pwdPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{6,}$";
        String phonePattern = "^[6-9][0-9]{9}$";


        if (name != null && name.length() >= 5 &&
                email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") &&
                password != null && password.matches(pwdPattern) &&
                mobile != null && String.valueOf(mobile).matches(phonePattern) &&
                gender != null &&
                (gender.equalsIgnoreCase("male") ||
                        gender.equalsIgnoreCase("female") ||
                        gender.equalsIgnoreCase("other")) &&
                plan != null && !plan.trim().isEmpty()) {


            NetflixEntity entity = new NetflixEntity();
            BeanUtils.copyProperties(netflixDTO, entity);


            netflixDAO.saveData(entity);
            return true;
        }
        return false;
    }
}