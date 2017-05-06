package com.alcohol.service;

import com.alcohol.exception.AlcoholConsumptionNotFound;
import com.alcohol.model.AlcoholConsumption;

import java.util.List;

public interface AlcoholConsumptionService {

    List<AlcoholConsumption> getAll();

    AlcoholConsumption getById(Long id) throws AlcoholConsumptionNotFound;

    AlcoholConsumption getByCountry(String country) throws AlcoholConsumptionNotFound;

    AlcoholConsumption create(AlcoholConsumption alcoholConsumption);

    Long delete(Long id) throws AlcoholConsumptionNotFound;

    AlcoholConsumption update(Long id, AlcoholConsumption alcoholConsumption) throws AlcoholConsumptionNotFound;

}
