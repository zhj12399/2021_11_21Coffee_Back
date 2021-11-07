package com.zhj.coffeeback.service;

import com.zhj.coffeeback.entity.People;
import com.zhj.coffeeback.mapper.PeopleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PeopleServiceImp implements PeopleService
{
    @Autowired
    PeopleMapper peopleMapper;

    @Override
    public Boolean ExistPeople(int id)
    {
        return peopleMapper.existPeople(id) != 0;
    }

    @Override
    public Boolean ExistPeopleByName(String name)
    {
        return peopleMapper.existPeopleByName(name) != 0;
    }

    @Override
    public String getPasswordByName(String name)
    {
        return peopleMapper.selectPasswordByName(name);
    }

    @Override
    public String GetPasswordById(int id)
    {
        return peopleMapper.SelectPasswordById(id);
    }

    @Override
    public void addPeople(People people)
    {
        peopleMapper.insertaddPeople(new People(0, people.getName(), people.getPassword(), people.getEmail()));
    }

    @Override
    public void addPeoplecaffeinelist(People people)
    {
        peopleMapper.addPeopleCaffeineList(people.getId());
    }

    @Override
    public void addnewState(int id, Date time)
    {
        peopleMapper.newState(id, time);
    }

    @Override
    public void updatePasswordById(int id, String password)
    {
        peopleMapper.updatePasswordById(password, id);
    }

    @Override
    public void updateNameById(int id, String name)
    {
        peopleMapper.updateNameById(name, id);
    }

    @Override
    public void deletePeopleById(int id)
    {
        peopleMapper.deletePeoplePeopleList(id);
        peopleMapper.deletePeopleCoffeeList(id);
        peopleMapper.deletePeopleCaffeineList(id);
    }

    @Override
    public String getNameById(int id)
    {
        return peopleMapper.selectNameById(id);
    }

    @Override
    public int getIdByName(String name)
    {
        return peopleMapper.selectIdByName(name);
    }

    @Override
    public Boolean SameName(String name)
    {//true:have same
        return peopleMapper.selectSameName(name) != 0;
    }

    @Override
    public int getnewId()
    {
        return peopleMapper.selectnewId();
    }

    @Override
    public String GetEmailById(int id)
    {
        return peopleMapper.selectEmailById(id);
    }
}

