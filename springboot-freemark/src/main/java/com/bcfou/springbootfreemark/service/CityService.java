package com.bcfou.springbootfreemark.service;

import com.bcfou.springbootfreemark.domain.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CityService{
    /**
     * 查询所有
     * @return
     */
    List<City> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);
    Long save(City city);
    Long update(City city);
    Long delete(City city);
}
