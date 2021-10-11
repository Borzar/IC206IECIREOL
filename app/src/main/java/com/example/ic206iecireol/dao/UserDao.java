package com.example.ic206iecireol.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ic206iecireol.models.User;
import com.example.ic206iecireol.models.UserEntity;

@Dao
public interface UserDao {
    @Query("SELECT id, first_name, last_name, user_name, password, height, birth_Date FROM users WHERE user_name = :user_name LIMIT 1")
    UserEntity findByUserName (String user_name);

    @Insert
    long insert(UserEntity user);
}
