package com.dimartin.cbreakerhotelsservice.controller;

import com.dimartin.cbreakerhotelsservice.model.Hotel;
import com.dimartin.cbreakerhotelsservice.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelsController {

    @Autowired
    private IHotelService hotelServ;

    @GetMapping("/{city_id}")
    public List<Hotel> getHotelsByCityId(@PathVariable("city_id") Long city_id){

        return hotelServ.getHotelsByCityId(city_id);

    }
}
