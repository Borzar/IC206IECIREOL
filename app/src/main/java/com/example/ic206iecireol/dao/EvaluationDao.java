package com.example.ic206iecireol.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.ic206iecireol.models.EvaluationEntity;
import com.example.ic206iecireol.models.UserEntity;

import java.util.List;

@Dao
public interface EvaluationDao {
    @Query("SELECT id, date, weight FROM evaluations")
    List<EvaluationEntity> findAll ();

    @Insert
    long insert(EvaluationEntity evaluation);

    @Query("DELETE FROM evaluations WHERE id = :id")
    void delete(long id);
}
