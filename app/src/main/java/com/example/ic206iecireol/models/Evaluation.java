package com.example.ic206iecireol.models;

import java.io.Serializable;
import java.util.Date;

public class Evaluation implements Serializable {

    private long id;
    private Date date;
    private double weight;


    public Evaluation(long id, Date date, double weight) {
        this.id = id;
        this.date = date;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
