package com.zhj.coffeeback.mapper;

import com.zhj.coffeeback.entity.People;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value = "PeopleMapper")
public interface PeopleMapper
{
    @Select("select password from people where name=#{name}")
    String selectPasswordByName(String name);

    @Select("select id from people where name=#{name}")
    int selectIdByName(String name);

    @Select("select name from people where id=#{id}")
    String selectNameById(int id);

    @Insert("insert into people(id,name,password)" +
            "values(null,#{name},#{password})")
    void insertaddPeople(People people);

    @Insert("insert into coffee(id,time,caffeine)" +
            "values(#{id},#{time},0)")
    void newState(int id, Date time);

    @Select("select count(*) from people where name=#{name}")
    int selectSameName(String name);

    @Update("create table if not exists caffeine_${id}(time timestamp," +
            " brand char(15)," +
            " type  char(15)," +
            " size char(15)," +
            " percent float," +
            " caffeine float," +
            " primary key(time));")
    void addPeopleCaffeineList(@Param("id") int id);

    @Update("update people set password = #{password} where id = #{id}")
    void updatePasswordById(String password,int id);

    @Update("update people set name = #{name} where id = #{id}")
    void updateNameById(String name,int id);

    @Select("select @@IDENTITY")
    int selectnewId();

    @Update("drop table if exists caffeine_${id}")
    void deletePeopleCaffeineList(@Param("id") int id);

    @Delete("delete from people where id = #{id}")
    void deletePeoplePeopleList(int id);

    @Delete("delete from coffee where id = #{id}")
    void deletePeopleCoffeeList(int id);
}
