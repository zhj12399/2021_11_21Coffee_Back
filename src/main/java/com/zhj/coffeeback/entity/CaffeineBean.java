package com.zhj.coffeeback.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class CaffeineBean
{
    private int id;
    private Timestamp time;
    private String brand;
    private String type;
    private String size;
    private double percent;
    private double caffeine;

    CaffeineBean()
    {

    }

    CaffeineBean(int id_, Timestamp time_, String brand_, String type_, String size_, double percent_, double caffeine_)
    {
        this.id = id_;
        this.time = time_;
        this.brand = brand_;
        this.type = type_;
        this.size = size_;
        this.percent = percent_;
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

    public String getSize()
    {
        return size;
    }

    public String getType()
    {
        return type;
    }

    public double getPercent()
    {
        return percent;
    }

    public String getBrand()
    {
        return brand;
    }

    public Caffeine getCaffeine()
    {
        return new Caffeine(time, brand, type, size, percent, caffeine);
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

    public void setCaffeine(double caffeine)
    {
        this.caffeine = caffeine;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public void setPercent(double percent)
    {
        this.percent = percent;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
