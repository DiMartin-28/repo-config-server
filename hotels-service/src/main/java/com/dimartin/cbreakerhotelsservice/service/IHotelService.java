package com.dimartin.cbreakerhotelsservice.service;

import com.dimartin.cbreakerhotelsservice.model.Hotel;

import java.util.List;

public interface IHotelService {

    public List<Hotel> getHotelsByCityId(Long city_id);
}
