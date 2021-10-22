package com.example.ic206iecireol.models;

import java.util.Date;

public interface IUser {
    long getId();

    String getFirsName();

    String getUserName();

    String getLastName();

    Date getBirthDate();

    double getHeight();

    String getPassword();
}
