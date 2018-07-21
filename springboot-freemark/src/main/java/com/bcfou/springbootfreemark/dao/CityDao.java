package com.bcfou.springbootfreemark.dao;

import com.bcfou.springbootfreemark.domain.City;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CityDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from city")
    List<City> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Select("select * from city where id=#{id}")
    City findById(@Param("id") Long id);
    @Insert("insert into city values(#{province_id}, #{city_name}, #{description})")
    Long save(City city);
    @Update("update city set province_id=#{province_id},city_name=#{city_name},description=#{description} where id=#{id}")
    Long update(City city);
    @Delete("delete * from city where id=#{id}")
    Long delete(City city);

}
