package com.zhj.coffeeback.service;

import com.zhj.coffeeback.entity.Caffeine;
import com.zhj.coffeeback.entity.State;
import com.zhj.coffeeback.mapper.CaffeineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CaffeineServiceImp implements CaffeineService
{
    @Autowired

    CaffeineMapper caffeineMapper;

    @Override
    public boolean addCaffeineRecord(Caffeine caffeine, int id)
    {
        try
        {
            //获得上一次的记录，并计算当前的咖啡因剩余量
            State lastState = caffeineMapper.selectStateById(id);
            Timestamp lasttime = lastState.getTime();
            if (lasttime.getTime() < caffeine.getTime().getTime())
            {//新建的晚于最近饮用的
                double lastrecord = lastState.getCaffeine();
                double hoursdifference = (caffeine.getTime().getTime() - lasttime.getTime()) / (double) 3600000;
                double nowCaffeine = lastrecord * Math.pow(0.5, hoursdifference / 4);
                //更新状态表
                caffeineMapper.updateState(caffeine.getTime(), caffeine.getCaffeine() + nowCaffeine, id);
            }
            caffeineMapper.addCaffeineRecord(caffeine.getTime(), caffeine.getBrand(), caffeine.getType(), caffeine.getSize(), caffeine.getPercent(), caffeine.getCaffeine(), id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public void deleteCaffeineRecord(Caffeine caffeine, int id)
    {
        caffeineMapper.deleteCaffeineRecord(caffeine.getTime(), id);
    }

    @Override
    public State getStateById(int id)
    {
        return caffeineMapper.selectStateById(id);
    }

    @Override
    public Caffeine[] getCaffeineRecord(int id)
    {
        return caffeineMapper.selectCaffeineRecord(id);
    }

    @Override
    public Caffeine[] getTodayCaffeineRecord(int id, String timestr)
    {
        return caffeineMapper.seleceTodayCaffeineRecord(id, timestr);
    }

    @Override
    public Caffeine[] getLastMonthRecord(int id)
    {
        return caffeineMapper.selectLastMonthCaffeine(id);
    }
}
