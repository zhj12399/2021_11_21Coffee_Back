package com.zhj.coffeeback.mapper;

import com.zhj.coffeeback.entity.Caffeine;
import com.zhj.coffeeback.entity.People;
import com.zhj.coffeeback.entity.State;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value = "CaffeineMapper")
public interface CaffeineMapper
{
    @Insert("insert into caffeine_#{id}(time,brand,type,size,percent,caffeine)" +
            "values(#{time},#{brand},#{type},#{size},#{percent},#{caffeine})")
    int addCaffeineRecord(Date time, String brand, String type, String size, double percent, double caffeine, int id);

    @Select("select * from coffee where id=#{id}")
    State selectStateById(int id);

    @Select("select * from caffeine_#{id} order by time desc limit 50")
    Caffeine[] selectCaffeineRecord(int id);

    @Update("update coffee set caffeine=#{caffeine},time=#{time} where id=#{id}")
    void updateState(Date time, double caffeine, int id);

    @Delete("delete from caffeine_#{id} where time=#{time}")
    void deleteCaffeineRecord(Date time,int id);

    @Select("select * from caffeine_#{id} where DATE_FORMAT(time,'%Y-%c-%e') = #{todaytimestr}")
    Caffeine [] seleceTodayCaffeineRecord(int id,String todaytimestr);

    @Select("select * from caffeine_#{id} where DATE_SUB(CURDATE(), INTERVAL 30 DAY ) <= Date(time)")
    Caffeine [] selectLastMonthCaffeine(int id);
}
