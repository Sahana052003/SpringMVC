package com.xworkz.instagram.dto;


public class InstagramDTO {
    private int id;
    private String userName;

    public InstagramDTO(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public InstagramDTO() {
        System.out.println("Calling InstagramDTO");
    }
}
