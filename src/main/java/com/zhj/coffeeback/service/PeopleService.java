package com.zhj.coffeeback.service;

import com.zhj.coffeeback.entity.People;

import java.util.Date;

public interface PeopleService
{
    Boolean ExistPeople(int id);
    String getPasswordByName(String name);
    void addPeople(People people);
    void addPeoplecaffeinelist(People people);
    int getIdByName(String name);
    void addnewState(int id, Date time);
    void updatePasswordById(int id,String password);
    void updateNameById(int id,String name);
    void deletePeopleById(int id);
    String getNameById(int id);
    Boolean SameName(String name);
    int getnewId();
}
