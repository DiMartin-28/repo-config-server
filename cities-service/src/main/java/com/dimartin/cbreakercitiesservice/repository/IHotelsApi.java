package com.dimartin.cbreakercitiesservice.repository;

import com.dimartin.cbreakercitiesservice.DTO.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-service")
public interface IHotelsApi {

    @GetMapping("/hotels/{city_id}")
    public List<HotelDTO> getHotelsByCityId(@PathVariable Long city_id);

}
