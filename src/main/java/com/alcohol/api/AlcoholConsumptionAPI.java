package com.alcohol.api;

import com.alcohol.model.AlcoholConsumption;
import com.alcohol.repository.AlcoholConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AlcoholConsumptionAPI {

    @Autowired
    AlcoholConsumptionRepository alcoholConsumptionRepository;

    @GetMapping("/consumptions")
    public List getConsumptions() {
        return alcoholConsumptionRepository.findAll(new Sort(Sort.Direction.ASC, "country"));
    }

    @GetMapping("/consumptions/{id}")
    public ResponseEntity getConsumption(@PathVariable("id") String id) {

        AlcoholConsumption alcoholConsumption = alcoholConsumptionRepository.findOne(id);

        if (alcoholConsumption == null) {
            return new ResponseEntity("No Alcohol Consumption found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(alcoholConsumption, HttpStatus.OK);
    }

    @GetMapping("/consumptions/country/{country}")
    public ResponseEntity getConsumptionByCountry(@PathVariable String country) {

        AlcoholConsumption alcoholConsumption = alcoholConsumptionRepository.findByCountry(country);

        if (alcoholConsumption == null) {
            return new ResponseEntity("No Alcohol Consumption found for country " + country, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(alcoholConsumption, HttpStatus.OK);
    }

    @PostMapping("/consumptions")
    public ResponseEntity saveConsumption(@Valid @RequestBody AlcoholConsumption alcoholConsumption) {

        alcoholConsumption.setId(null);
        AlcoholConsumption alcoholConsumptionNew = alcoholConsumptionRepository.insert(alcoholConsumption);

        return new ResponseEntity(alcoholConsumptionNew, HttpStatus.OK);
    }

    @DeleteMapping("/consumptions/{id}")
    public ResponseEntity deleteConsumption(@PathVariable String id) {

        if (!alcoholConsumptionRepository.exists(id)) {
            return new ResponseEntity("No Alcohol Consumption found for ID " + id, HttpStatus.NOT_FOUND);
        }

        alcoholConsumptionRepository.delete(id);

        return new ResponseEntity(id, HttpStatus.OK);

    }

    @PutMapping("/consumptions/{id}")
    public ResponseEntity updateConsumption(@PathVariable String id, @Valid @RequestBody AlcoholConsumption alcoholConsumption) {

        if (!alcoholConsumptionRepository.exists(id)) {
            return new ResponseEntity("No Alcohol Consumption found for ID " + id, HttpStatus.NOT_FOUND);
        }

        alcoholConsumption.setId(id);
        AlcoholConsumption alcoholConsumptionUpdated = alcoholConsumptionRepository.save(alcoholConsumption);

        return new ResponseEntity(alcoholConsumptionUpdated, HttpStatus.OK);
    }
}