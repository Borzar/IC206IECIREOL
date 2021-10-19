package com.example.ic206iecireol.lib;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.ic206iecireol.dao.EvaluationDao;
import com.example.ic206iecireol.dao.UserDao;
import com.example.ic206iecireol.models.EvaluationEntity;
import com.example.ic206iecireol.models.UserEntity;
import com.example.ic206iecireol.utils.Converters;

@Database(entities = {UserEntity.class, EvaluationEntity.class}, version = 2)
@TypeConverters(Converters.class)
public abstract class GymAppDatabase extends RoomDatabase {
    private static final String DB_NAME = "gym_app_db";
    private static GymAppDatabase instance;

    public static synchronized GymAppDatabase getInstance(Context ctx) {
        if (instance == null) {
            instance = Room.databaseBuilder(ctx.getApplicationContext(), GymAppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract UserDao userDao();
    public abstract EvaluationDao evaluationDao();
}