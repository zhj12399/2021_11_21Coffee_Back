package com.zhj.coffeeback.entity;

import java.sql.Timestamp;

public class State
{
    private int id;
    private Timestamp time;
    private double caffeine;

    public State()
    {

    }

    public State(int id_, Timestamp time_, double caffeine_)
    {
        this.id = id_;
        this.time = time_;
        this.caffeine = caffeine_;
    }

    public int getId()
    {
        return id;
    }

    public Timestamp getTime()
    {
        return time;
    }

    public double getCaffeine()
    {
        return caffeine;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setCaffeine(double caffeine)
    {
        this.caffeine = caffeine;
    }

    public void setTime(Timestamp time)
    {
        this.time = time;
    }
}
