package com.dimartin.cbreakercitiesservice.service;

import com.dimartin.cbreakercitiesservice.DTO.CityDTO;

import com.dimartin.cbreakercitiesservice.DTO.HotelDTO;
import com.dimartin.cbreakercitiesservice.model.City;

import com.dimartin.cbreakercitiesservice.repository.IHotelsApi;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitiesServiceImp implements  ICitiesService{

    List<City> citiesList = new ArrayList<City>();

    List<HotelDTO> holtelsListDto = new ArrayList<>();

    City ciudad = new City();

    @Autowired
    private IHotelsApi hotelsApi; // devuelve un List hotelDTO

    /*
    * IMPLEMENTACION PROPIA
    */
    // ACA ES DONDE SE IMPLEMENTA EL CRCUIT BRAKER
    @Override
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallbackGetCitiesHotel")
    @Retry(name = "hotels-service")
    public CityDTO getCitiesHotels(String name, String country) {

        City city = this.findCity(name,country);

        this.loadCities();

        CityDTO cityDto = new CityDTO();

        cityDto.setCity_id(city.getCity_id());
        cityDto.setName(city.getName());
        cityDto.setContinent(city.getContinent());
        cityDto.setCountry(city.getCountry());
        cityDto.setState(city.getState());

        holtelsListDto = hotelsApi.getHotelsByCityId(cityDto.getCity_id());

        cityDto.setHotelList(holtelsListDto);

      //  createException();

        return cityDto;
    }

    // METODO QUE VA A DEVOLVER EL CIRCUIT BRAKER EN CASO QUE SE PRODUZCA UN FALLO
    public CityDTO fallbackGetCitiesHotel(Throwable throwable){

        return new CityDTO(9999999L, "null", "null", "null" , "null", null);
    }

    // METODO QUE VA A PROVOCAR EL FALLO
    public void createException(){
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
    }

     @Override
    public City findCity(String name, String country) {

        this.loadCities();

        for(City c : citiesList){
            if(c.getName().equals(name)){
                if(c.getCountry().equals(country)){
                    ciudad = c;
                    return ciudad;

                }
            }
        }
        return null;
    }

    @Override
    public City getCityById(Long city_id) {

        City city = new City();

        this.loadCities();

        for(City c : citiesList){

            if(c.getCity_id()== city_id){

                city = c;

            }
        }
        return city;
    }

    private void loadCities(){

        citiesList.add(new City(1L,"Mar del Plata","South America", "Argentina", "Buenos Aires"));
        citiesList.add(new City(2L,"Puerto Iguazu","South America", "Argentina", "Misiones"));
        citiesList.add(new City(3L,"Buenos Aires","South America", "Argentina", "Buenos Aires"));
        citiesList.add(new City(4L,"Rosario","South America", "Argentina", "Santa Fé"));

    }

}
