package com.zhj.coffeeback.entity;

public class People
{
    private int id;
    private String name;
    private String password;
    private String email;

    public People()
    {

    }

    public People(int id_, String name_, String password_,String email_)
    {
        this.id = id_;
        this.name = name_;
        this.password = password_;
        this.email = email_;
    }

    @Override
    public String toString()
    {
        return "{id= " + id + ", name= " + name;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }
    public String getEmail(){return email;}

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
