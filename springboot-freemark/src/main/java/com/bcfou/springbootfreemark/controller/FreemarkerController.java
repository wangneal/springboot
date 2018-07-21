package com.bcfou.springbootfreemark.controller;

import com.bcfou.springbootfreemark.domain.City;
import com.bcfou.springbootfreemark.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class FreemarkerController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable("id") Long id, Model model){
        City city = cityService.findById(id);
        model.addAttribute("city",city);
        return "city";
    }

    @RequestMapping(value = "api/city", method = RequestMethod.GET)
    public String findAll(Model model){
        List<City> cities = cityService.findAll();
        model.addAttribute("cityList", cities);
        return "cityList";
    }
}
