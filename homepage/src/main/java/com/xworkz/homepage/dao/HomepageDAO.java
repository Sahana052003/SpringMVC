package com.xworkz.homepage.dao;

import com.xworkz.homepage.dto.HomepageDTO;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class HomepageDAO {
    String url = "jdbc:mysql://localhost:3306/homepage_db";
    String userName = "root";
    String password = "Ammu@5182603";
    String query="select password from homepage_table where email=?";
    public String dataEntered(String email) {
        String name = null;
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,userName,password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
            name=resultSet.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
}