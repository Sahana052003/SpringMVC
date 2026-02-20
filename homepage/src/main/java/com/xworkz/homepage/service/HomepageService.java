package com.xworkz.homepage.service;

import com.xworkz.homepage.dao.HomepageDAO;
import com.xworkz.homepage.dao.InsertPageDAO;
import com.xworkz.homepage.dto.HomepageDTO;
import com.xworkz.homepage.exception.InvalidException;
import com.xworkz.homepage.util.EncDec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomepageService {

    @Autowired
    private InsertPageDAO insertPageDAO;

    @Autowired
    private HomepageDAO homepageDAO;

    public boolean signupValidate(HomepageDTO homepageDTO) {

        // Trim all input fields
        String firstName = homepageDTO.getFirstName() != null ? homepageDTO.getFirstName().trim() : "";
        String lastName = homepageDTO.getLastName() != null ? homepageDTO.getLastName().trim() : "";
        String email = homepageDTO.getEmail() != null ? homepageDTO.getEmail().trim() : "";
        String password = homepageDTO.getPassword() != null ? homepageDTO.getPassword().trim() : "";
        String confirmPassword = homepageDTO.getConfirmpassword() != null ? homepageDTO.getConfirmpassword().trim() : "";
        Long mobile = homepageDTO.getMobileNumber();
        String mobileStr = mobile != null ? String.valueOf(mobile) : "";


        // Single validation if-statement
        if (!firstName.isEmpty() && firstName.length() >= 5 && firstName.matches("^[A-Za-z]+$")
                && !lastName.isEmpty() && lastName.length() >= 1 &&  lastName.matches("^[A-Za-z]+( [A-Za-z]+)*$")
                && !email.isEmpty() && email.contains("@gmail.com")
                && mobile != null && String.valueOf(mobile).matches("^[6-9]\\d{9}$")
                && password.length() >= 6 && password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).+$")
                && password.equals(confirmPassword)) {

            insertPageDAO.validateHomePage(homepageDTO); // Save to DB
            System.out.println("Signup Successful for: " + firstName);
            return true;

        } else {
            throw new InvalidException("Invalid signup data. Please check all fields.");
        }
    }

//    public boolean signinValidation(String email, String password) {
//        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
//            throw new InvalidException("Email or password cannot be empty");
//        }
//
//        String storedEncryptedPassword = homepageDAO.dataEntered(email); // gets encrypted password from DB
//        if (storedEncryptedPassword == null) {
//            throw new InvalidException("Email not found");
//        }
//
//        try {
//            String decryptedPassword = EncDec.decrypt(storedEncryptedPassword); // decrypt
//
//            System.out.println("Encrypted from DB: " + storedEncryptedPassword);
//            System.out.println("Decrypted value: " + decryptedPassword);
//
//            if (!decryptedPassword.equals(password)) {
//                throw new InvalidException("Password mismatch");
//            }
//        } catch (Exception e) {
//            throw new InvalidException("Error decrypting password");
//        }
//
//        System.out.println("Login successful for: " + email);
//        return true;
//    }


    public boolean signinValidation(String email, String password) {

        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidException("Invalid email or password");
        }

        String storedEncryptedPassword = homepageDAO.dataEntered(email);

        // email not found
        if (storedEncryptedPassword == null) {
            throw new InvalidException("Invalid email or password");
        }

        try {
            String decryptedPassword = EncDec.decrypt(storedEncryptedPassword);

            // password mismatch
            if (!decryptedPassword.equals(password)) {
                throw new InvalidException("Invalid email or password");
            }

        } catch (Exception e) {
            throw new InvalidException("Invalid email or password");
        }

        return true;
    }
}
