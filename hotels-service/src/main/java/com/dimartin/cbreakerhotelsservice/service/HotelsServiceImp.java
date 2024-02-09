package com.dimartin.cbreakerhotelsservice.service;

import com.dimartin.cbreakerhotelsservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelsServiceImp implements IHotelService{

    List<Hotel> hotelsList = new ArrayList<>();

    @Override
    public List<Hotel> getHotelsByCityId(Long city_id) {

        List<Hotel> hotelCityList = new ArrayList<>();

        this.loadHotels();

        for(Hotel h : hotelsList){
            if(h.getCity_id()== city_id){

                hotelCityList.add(h);
            }
        }
        return hotelCityList;
    }

    public void loadHotels(){
        hotelsList.add(new Hotel(1L, "Paradise", 4, 1L));
        hotelsList.add(new Hotel(2L, "Del Mar", 2, 2L));
        hotelsList.add(new Hotel(3L, "Los Helechos", 3, 3L));
        hotelsList.add(new Hotel(4L, "El Guemble", 4, 1L));
        hotelsList.add(new Hotel(5L, "San Pedro", 1, 2L));
        hotelsList.add(new Hotel(6L, "El hostal", 5, 3L));
        hotelsList.add(new Hotel(7L, "Las Guayabas", 1, 3L));
    }
}