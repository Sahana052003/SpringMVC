package com.xworkz.homepage.dao;

import com.xworkz.homepage.dto.HomepageDTO;
import com.xworkz.homepage.util.EncDec;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class InsertPageDAO {
    String url = "jdbc:mysql://localhost:3306/homepage_db";
    String userName = "root";
    String password = "Ammu@5182603";
    String query="insert into homepage_table values(?,?,?,?,?)";
    public String validateHomePage(HomepageDTO homepageDTO) {
        String encryptedPassword=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(url, userName, password);
             PreparedStatement ps = connection.prepareStatement(query)) {


            encryptedPassword = EncDec.encrypt(homepageDTO.getPassword());

            ps.setString(1, homepageDTO.getFirstName());
            ps.setString(2, homepageDTO.getLastName());
            ps.setString(3, homepageDTO.getEmail());
            ps.setString(4, encryptedPassword);
            ps.setLong(5, homepageDTO.getMobileNumber());
            //ps.setString(5,encryptedPassword);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Executed Successfully");
            }
        }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return encryptedPassword;
    }

    public String validateHomePage(String email, String password) {
   return null;
    }
}