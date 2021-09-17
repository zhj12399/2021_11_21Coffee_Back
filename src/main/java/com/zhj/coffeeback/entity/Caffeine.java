package com.zhj.coffeeback.entity;

import java.sql.Timestamp;

public class Caffeine
{
    private Timestamp time;
    private String brand;
    private String type;
    private String size;
    private double percent;
    private double caffeine;

    public Caffeine()
    {

    }

    public Caffeine(Timestamp time_, String brand_, String type_, String size_, double percent_, double caffeine_)
    {
        this.time = time_;
        this.brand = brand_;
        this.type = type_;
        this.size = size_;
        this.percent = percent_;
        this.caffeine = caffeine_;
    }

    public Timestamp getTime()
    {
        return time;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getType()
    {
        return type;
    }

    public String getSize()
    {
        return size;
    }

    public double getPercent()
    {
        return percent;
    }

    public double getCaffeine()
    {
        return caffeine;
    }

    public void setTime(Timestamp time)
    {
        this.time = time;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public void setPercent(double percent)
    {
        this.percent = percent;
    }

    public void setCaffeine(double caffeine)
    {
        this.caffeine = caffeine;
    }
}
