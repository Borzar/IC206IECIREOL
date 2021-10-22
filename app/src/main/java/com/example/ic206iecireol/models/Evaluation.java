package com.example.ic206iecireol.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evaluation implements Serializable, IEvaluation {

    private long id;
    private Date date;
    private double weight;
    private long userId;



    public Evaluation(Date date, Double weight, long userId) {
        this.date = date;
        this.weight = weight;
        this.userId = userId;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public double calculateImc (double height) {
        return weight / (height * height);
    }

    public String calculateImcString(double height) {
        return Double.toString(calculateImc(height));
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    public String getStringDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }


}
