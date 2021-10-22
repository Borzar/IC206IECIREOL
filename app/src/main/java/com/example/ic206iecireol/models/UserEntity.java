package com.example.ic206iecireol.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "users", indices = {@Index(value = "user_name", unique = true)})
public class UserEntity implements IUser{
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "first_name")
    private String firsName;

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "birth_Date")
    private Date birthDate;

    @ColumnInfo(name = "height")
    private double height;

    @ColumnInfo(name = "password")
    private String password;

    public UserEntity(long id, String firsName, String userName, String lastName, Date birthDate, double height, String password) {
        this.id = id;
        this.firsName = firsName;
        this.userName = userName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.height = height;
        this.password = password;
    }

    public long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }
}
