package com.crehana.catalog.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.crehana.catalog.constants.PersistenceConstants;
import com.crehana.catalog.dto.CityDTO;
import com.crehana.catalog.exception.CrehanaException;
import com.crehana.catalog.persistence.CityPersistence;

public class CityServiceTest {
    private static CityPersistence repository;
    private static CityService service;
    private CityDTO city;

    @BeforeAll
    static void setup() {
        repository = new CityPersistence();
        service = new CityService(repository);
    }

    @BeforeEach
    void init() {
        city = new CityDTO();
    }

    @Test
    @DisplayName("Should validate than city doesn't exist")
    public void should_validate_city_not_exist() {
        //Given
        final String caliCityCode = "CLI";
        
        //When
        final Optional<CityDTO> city = service.existCity(caliCityCode);
               
        //Then
        Assertions.assertTrue(city.isEmpty());
    }

    @Test
    @DisplayName("Should validate than city exist")
    public void should_validate_city_exist() {
        //Given
        final String bogotaCityCode = "BOG";
        
        //When
        final Optional<CityDTO> city = service.existCity(bogotaCityCode);
               
        //Then
        Assertions.assertNotNull(city.get());
    }

    @Test
    @DisplayName("Should show exception message because city code is null")
    public void should_show_message_exception_city_code_is_null() {
        //Given
        CityDTO emptyCity = city;
        
        //When
        CrehanaException crehanaException = Assertions.assertThrows(CrehanaException.class, () -> {service.create(emptyCity);}) ;
               
        //Then
        Assertions.assertEquals(PersistenceConstants.CODE_IS_NULL, crehanaException.getMessage());
    }

    @Test
    @DisplayName("Should create a new city")
    public void should_create_new_city() {
        //Given
        city.setCode("CTG");
        city.setName("Cartagena de Indias");
        
        //When
        service.create(city);        
               
        //Then
        //Assertions.assertEquals(city.getCode(), service.existCity("CTG").get().getCode());
        Assertions.assertTrue(city.equals(service.existCity("CTG").get()));
    }

    @Test
    @DisplayName("Shouldn't create a new city because that exist")
    public void should_not_create_city_because_that_exist() {
        //Given
        city.setCode("BOG");
        city.setName("Bogotá");
        
        //When
        CrehanaException crehanaException = Assertions.assertThrows(CrehanaException.class, () -> {service.create(city); });       
               
        //Then
        Assertions.assertEquals(PersistenceConstants.CITY_WITH_THE_SAME_INFORMATION, crehanaException.getMessage());
    }

    @Test
    @DisplayName("Should show business exception when we try to update a city with city code is null")
    public void should_show_exception_when_try_update_city_with_cityCode_null() {
        //Given
        city.setCode(null);
        
        //When
        CrehanaException crehanaException = Assertions.assertThrows(CrehanaException.class, () -> {service.update(city); });       
               
        //Then
        Assertions.assertEquals(PersistenceConstants.CODE_IS_NULL, crehanaException.getMessage());
    }

    @Test
    @DisplayName("Should show business exception when we try to update a city with city code is null")
    public void should_show_exception_when_try_update_existented_city_with_cityCode_noFound() {
        //Given
        city.setCode("MED");
        city.setName("Medellin");
        
        //When
        CrehanaException crehanaException = Assertions.assertThrows(CrehanaException.class, () -> {service.update(city); });       
               
        //Then
        Assertions.assertEquals(PersistenceConstants.CITY_NOT_EXIST, crehanaException.getMessage());
    }

    @Test
    @DisplayName("Should update the name of an existing city")
    public void should_update_city_name() {
        //Given
        city.setCode("CTG");
        city.setName("Cartagena");

        final String ctrCityName = "Cartagena";
        
        //When
        Assertions.assertDoesNotThrow(() -> {service.update(city); });  
        
        //TODO What should i do? XD, Maybe this?
        CityDTO cityMatch = service.getAll().stream()
                                            .filter(cityRow -> cityRow.equals(city))
                                            .findAny()
                                            .orElse(null);
               
        //Then
        Assertions.assertEquals(ctrCityName, cityMatch.getName());
    }

    @Test
    @DisplayName("Shouldn't find any city")
    public void should_not_find_any_city() {
        //Given
        //TODO Manually remove all cities from cities.json file

        //When
        List<CityDTO> cities = service.getAll();

        //Then
        Assertions.assertTrue(cities.size() == 0);
    }

    @Test
    @DisplayName("Should find at least one city")
    public void should_find_at_least_one_city() {
        //Given
        //Don't do anything

        //When
        List<CityDTO> cities = service.getAll();

        //Then
        Assertions.assertTrue(cities.size() >= 1);
    }
}