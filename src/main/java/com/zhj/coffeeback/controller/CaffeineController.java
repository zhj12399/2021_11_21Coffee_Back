package com.zhj.coffeeback.controller;

import com.zhj.coffeeback.entity.Caffeine;
import com.zhj.coffeeback.entity.CaffeineBean;
import com.zhj.coffeeback.entity.People;
import com.zhj.coffeeback.entity.State;
import com.zhj.coffeeback.service.CaffeineService;
import com.zhj.coffeeback.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/api/Caffeine/")
public class CaffeineController
{
    @Autowired
    CaffeineService caffeineService;

    @RequestMapping(value = "AddCaffeineRecord", method = RequestMethod.POST)
    public boolean addCaffeineRecord(@RequestBody CaffeineBean caffeineBean)
    {
        if(caffeineService.addCaffeineRecord(caffeineBean.getCaffeine(), caffeineBean.getId()))
        {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "getStateById/{idstr:\\d+}", method = RequestMethod.POST)
    public State getNameById(@PathVariable String idstr)
    {
        return caffeineService.getStateById(Integer.parseInt(idstr));
    }

    @RequestMapping(value = "getCaffeineRecordById/{idstr:\\d+}", method = RequestMethod.POST)
    public Caffeine[] getCaffeineRecordById(@PathVariable String idstr)
    {
        return caffeineService.getCaffeineRecord(Integer.parseInt(idstr));
    }

    @RequestMapping(value = "deleteCaffeineRecord", method = RequestMethod.POST)
    public void deleteCaffeineRecord(@RequestBody CaffeineBean caffeineBean)
    {
        caffeineService.deleteCaffeineRecord(caffeineBean.getCaffeine(), caffeineBean.getId());
    }

    @RequestMapping(value = "getTodayCaffeineRecord", method = RequestMethod.POST)
    public Caffeine[] getTodayCaffeineRecord(@RequestParam("id") int id,
                                             @RequestParam("time") String timestr)
    {
        return caffeineService.getTodayCaffeineRecord(id, timestr);
    }

    @RequestMapping(value = "getLastMonthRecord/{idstr:\\d+}" ,method = RequestMethod.POST)
    public Caffeine[] getLastMonthRecord(@PathVariable String idstr)
    {
        return caffeineService.getLastMonthRecord(Integer.parseInt(idstr));
    }
}
