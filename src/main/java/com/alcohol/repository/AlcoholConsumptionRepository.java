package com.alcohol.repository;

import com.alcohol.model.AlcoholConsumption;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholConsumptionRepository extends MongoRepository<AlcoholConsumption, String> {

    public AlcoholConsumption findByCountry(String country);
}