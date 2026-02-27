package com.xworkz.facebook.service;

import com.xworkz.facebook.dao.FacebookDAO;
import com.xworkz.facebook.dto.FacebookDTO;
import com.xworkz.facebook.entity.FacebookEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FacebookServiceImpl implements FacebookService{
    @Autowired
    FacebookDAO facebookDAO;


    @Override
    public String registerUser(FacebookDTO facebookDTO) {
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
                && country != null && !country.trim().isEmpty()) {

        FacebookDTO emailExists = checkEmailExists(email);
        if (emailExists != null) {
            return "Email already exists";
        }
        FacebookDTO phoneExists = checkPhoneNumber(phoneNumber);
        if (phoneExists != null) {
            return "Phone number already exists";
        }

        FacebookEntity entity = new FacebookEntity();
        BeanUtils.copyProperties(facebookDTO, entity);

        if (facebookDAO.accessData(entity)) {
            return "Registered successfully";
        }
        return "Not Registered";
    }
         return "Data already exits";
 }




        @Override
    public List<FacebookDTO> getDTO() {
        List<FacebookEntity> facebookEntityList = facebookDAO.getFacebookData();


        if (!facebookEntityList.isEmpty()) {
            List<FacebookDTO> facebookDTOS = new ArrayList<>();
            facebookEntityList.forEach(entity -> {
                FacebookDTO facebookDTO = new FacebookDTO();

                BeanUtils.copyProperties(entity, facebookDTO);
                facebookDTOS.add(facebookDTO);
            });

            return facebookDTOS;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public FacebookDTO checkEmailExists(String emailId) {
        FacebookEntity facebook = facebookDAO.getDetailsBasedOnEmail(emailId);

        if (facebook != null) {
            FacebookDTO facebookDTO = new FacebookDTO();
            BeanUtils.copyProperties(facebook, facebookDTO);
            return facebookDTO;
        }
        return null;
    }



    @Override
    public FacebookDTO checkPhoneNumber(Long phoneNumber) {
        FacebookEntity facebookEntity=facebookDAO.getDetailsBasedOnPhoneNumber(phoneNumber);

        if(facebookEntity!=null){
            FacebookDTO facebookDTO=new FacebookDTO();
            BeanUtils.copyProperties(facebookEntity,facebookDTO);
            return facebookDTO;
        }
        return null;
    }
}
