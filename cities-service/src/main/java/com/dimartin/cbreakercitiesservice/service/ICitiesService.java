package com.dimartin.cbreakercitiesservice.service;

import com.dimartin.cbreakercitiesservice.DTO.CityDTO;
import com.dimartin.cbreakercitiesservice.model.City;

import java.util.List;

public interface ICitiesService {

    public CityDTO getCitiesHotels(String name, String country);
    public City getCityById(Long city_id);
    public City findCity(String name, String country);
}
