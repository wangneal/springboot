package com.bcfou.springbootfreemark.service.impl;

import com.bcfou.springbootfreemark.dao.CityDao;
import com.bcfou.springbootfreemark.domain.City;
import com.bcfou.springbootfreemark.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("CityService")
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;
    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityDao.findById(id);
    }

    @Override
    public Long save(City city) {
        return cityDao.save(city);
    }

    @Override
    public Long update(City city) {
        return cityDao.update(city);
    }

    @Override
    public Long delete(City city) {
        return cityDao.delete(city);
    }
}
