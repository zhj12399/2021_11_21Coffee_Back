package com.zhj.coffeeback.service;

import com.zhj.coffeeback.entity.Caffeine;
import com.zhj.coffeeback.entity.State;

public interface CaffeineService
{
    Boolean ExistPeople(int id);
    boolean addCaffeineRecord(Caffeine caffeine, int id);
    void deleteCaffeineRecord(Caffeine caffeine, int id);
    State getStateById(int id);
    Caffeine [] getCaffeineRecord(int id);
    Caffeine [] getTodayCaffeineRecord(int id,String timestr);
    Caffeine [] getLastMonthRecord(int id);
}
