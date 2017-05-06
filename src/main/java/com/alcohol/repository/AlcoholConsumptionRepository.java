package com.alcohol.repository;

import com.alcohol.model.AlcoholConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholConsumptionRepository extends JpaRepository<AlcoholConsumption, Long> {

    AlcoholConsumption findByCountry(String country);
}