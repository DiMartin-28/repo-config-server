package com.dimartin.cbreakercitiesservice.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private Long city_id;
    private String name;
    private String continent;
    private String country;
    private String state;
    private List<HotelDTO> hotelList;

    /*
    *   @Autowired
    private ICitiesService citiesServ;

    @GetMapping("/hotels")
    public CityDTO getHotelsCityById(@RequestParam String name, @RequestParam String country){

        CityDTO citiDto = citiesServ.getCitiesHotels(name,country);

        return citiDto;
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
    * */


}
