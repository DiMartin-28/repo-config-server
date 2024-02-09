package com.dimartin.cbreakercitiesservice.controller;

import com.dimartin.cbreakercitiesservice.DTO.CityDTO;
import com.dimartin.cbreakercitiesservice.model.City;
import com.dimartin.cbreakercitiesservice.service.ICitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private ICitiesService citiesServ;

    @GetMapping("/hotels")
    public CityDTO getHotelsCityById(@RequestParam String name, @RequestParam String country){

        CityDTO cityDTO = citiesServ.getCitiesHotels(name,country);

        return cityDTO;
    }

    @GetMapping("/{city_id}")
    public City getCitiById(@PathVariable Long city_id){

        return citiesServ.getCityById(city_id);
    }

    @GetMapping("/")
    public City getCityByNameAndCountry(@RequestParam String name, @RequestParam String country){

        City city = citiesServ.findCity(name, country);

        return city;
    }

}
