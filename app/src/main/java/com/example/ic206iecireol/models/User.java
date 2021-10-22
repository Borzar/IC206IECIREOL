package com.example.ic206iecireol.models;

import java.util.Date;

public class User implements IUser{

    private long id;
    private String firsName;
    private String userName;
    private String lastName;
    private Date birthDate;
    private double height;
    private String password;

    public User(String firsName, String userName, String lastName, Date birthDate, double height) {
        this.firsName = firsName;
        this.userName = userName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.height = height;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public double getHeight() {
        return height;
    }

    public String getHeightString() {
        return Double.toString(height);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
       this.password = password;
    }

}
