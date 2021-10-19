package com.example.ic206iecireol.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName = "evaluations")
public class EvaluationEntity implements IEvaluation {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "weight")
    private Double weight;

    public EvaluationEntity(long id, Date date, Double weight) {
        this.id = id;
        this.date = date;
        this.weight = weight;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
