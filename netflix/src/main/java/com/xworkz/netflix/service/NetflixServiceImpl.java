package com.xworkz.netflix.service;

import com.xworkz.netflix.dao.NetflixDAO;
import com.xworkz.netflix.dto.NetflixDTO;
import com.xworkz.netflix.entity.NetflixEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class NetflixServiceImpl implements NetflixService {
    @Autowired
    NetflixDAO netflixDAO;


    @Override
    public String registerUser(NetflixDTO netflixDTO) {
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


            NetflixDTO emailExists = checkEmail(email);
            if (emailExists != null) {
                return "Email already exists";
            }
            NetflixDTO phoneExists = checkMobileNumber(mobile);
            if (phoneExists != null) {
                return "Phone number already exists";
            }

            NetflixEntity entity = new NetflixEntity();
            BeanUtils.copyProperties(netflixDTO, entity);

            if (netflixDAO.saveData(entity)) {
                return "Registered successfully";
            }
            return "Not Registered";
        }
        return "Data already exits";
    }

    @Override
    public List<NetflixDTO> getDTO() {
        List<NetflixEntity> netflixEntities = netflixDAO.getNetflixData();


        if (!netflixEntities.isEmpty()) {
            List<NetflixDTO> facebookDTOS = new ArrayList<>();
            netflixEntities.forEach(entity -> {
                NetflixDTO netflixDTO = new NetflixDTO();

                BeanUtils.copyProperties(entity, netflixDTO);
                facebookDTOS.add(netflixDTO);
            });

            return facebookDTOS;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public NetflixDTO checkEmail(String email) {
        NetflixEntity netflixEntity=netflixDAO.getDetailsBasedOnEmail(email);

        if(netflixEntity!=null){
            NetflixDTO netflixDTO1=new NetflixDTO();
            BeanUtils.copyProperties(netflixEntity,netflixDTO1);
            return netflixDTO1;
        }
        return null;
    }



    @Override
    public NetflixDTO checkMobileNumber(Long mobile) {
        NetflixEntity netflixEntity=netflixDAO.getDetailsBasedOnMobile(mobile);

        if(netflixEntity!=null){
            NetflixDTO netflixDTO=new NetflixDTO();
            BeanUtils.copyProperties(netflixEntity,netflixDTO);
            return netflixDTO;
        }
        return null;
    }
}