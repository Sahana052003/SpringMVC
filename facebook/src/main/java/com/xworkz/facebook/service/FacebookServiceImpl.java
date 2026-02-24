package com.xworkz.facebook.service;

import com.xworkz.facebook.dao.FacebookDAO;
import com.xworkz.facebook.dto.FacebookDTO;
import com.xworkz.facebook.entity.FacebookEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacebookServiceImpl implements FacebookService{
    @Autowired
    FacebookDAO facebookDAO;


    @Override
    public boolean registerUser(FacebookDTO facebookDTO) {
        String name = facebookDTO.getName();
        String email = facebookDTO.getEmail();
        String password = facebookDTO.getPassword();
        Long phoneNumber = facebookDTO.getPhoneNumber();
        String gender = facebookDTO.getGender();
        String country = facebookDTO.getCountry();


        String pwdPattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{6,}$";
        String phonePattern = "^[6-9][0-9]{9}$";

        if (name != null && name.length() >= 3 &&
                email != null && email.endsWith("@gmail.com") &&
                password != null && password.matches(pwdPattern) &&
                phoneNumber != null && String.valueOf(phoneNumber).matches(phonePattern) &&
                gender != null && gender != null &&
                (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))
                && country!=null &&  !country.trim().isEmpty()){

            FacebookEntity facebookEntity=new FacebookEntity();
            BeanUtils.copyProperties(facebookDTO,facebookEntity);

            facebookDAO.accessData(facebookEntity);
            return true;
        }else {
            return false;
        }

    }
}
