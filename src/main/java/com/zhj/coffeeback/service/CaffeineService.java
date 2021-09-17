package com.zhj.coffeeback.service;

import com.zhj.coffeeback.entity.Caffeine;
import com.zhj.coffeeback.entity.People;
import com.zhj.coffeeback.entity.State;

import java.util.Date;

public interface CaffeineService
{
    boolean addCaffeineRecord(Caffeine caffeine, int id);
    void deleteCaffeineRecord(Caffeine caffeine, int id);
    State getStateById(int id);
    Caffeine [] getCaffeineRecord(int id);
    Caffeine [] getTodayCaffeineRecord(int id,String timestr);
    Caffeine [] getLastMonthRecord(int id);
}
