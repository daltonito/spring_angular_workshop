package com.alcohol.api;

import com.alcohol.exception.AlcoholConsumptionNotFound;
import com.alcohol.model.AlcoholConsumption;
import com.alcohol.service.AlcoholConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlcoholConsumptionController {

    @Autowired
    private AlcoholConsumptionService alcoholConsumptionService;

    @GetMapping("/consumptions")
    public List<AlcoholConsumption> getConsumptions() {
        return alcoholConsumptionService.getAll();
    }

    @GetMapping("/consumptions/{id}")
    public ResponseEntity getConsumption(@PathVariable Long id) throws AlcoholConsumptionNotFound {
        AlcoholConsumption alcoholConsumption = alcoholConsumptionService.getById(id);
        return new ResponseEntity(alcoholConsumption, HttpStatus.OK);
    }

    @GetMapping("/consumptions/country/{country}")
    public ResponseEntity getConsumptionByCountry(@PathVariable String country) throws AlcoholConsumptionNotFound {
        AlcoholConsumption alcoholConsumption = alcoholConsumptionService.getByCountry(country);
        return new ResponseEntity(alcoholConsumption, HttpStatus.OK);
    }

    @PostMapping("/consumptions")
    public ResponseEntity saveConsumption(@RequestBody AlcoholConsumption alcoholConsumption) {
        AlcoholConsumption alcoholConsumptionNew = alcoholConsumptionService.create(alcoholConsumption);
        return new ResponseEntity(alcoholConsumptionNew, HttpStatus.CREATED);
    }

    @DeleteMapping("/consumptions/{id}")
    public ResponseEntity deleteConsumption(@PathVariable Long id) throws AlcoholConsumptionNotFound {
        alcoholConsumptionService.delete(id);
        return new ResponseEntity(id, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/consumptions/{id}")
    public ResponseEntity updateConsumption(@PathVariable Long id,
                                            @RequestBody AlcoholConsumption alcoholConsumption) throws AlcoholConsumptionNotFound {
        AlcoholConsumption alcoholConsumptionUpdated = alcoholConsumptionService.update(id, alcoholConsumption);
        return new ResponseEntity(alcoholConsumptionUpdated, HttpStatus.OK);
    }

    @ExceptionHandler(AlcoholConsumptionNotFound.class)
    public ResponseEntity handleAlcoholConsumptionNotFound(Exception e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDatabaseIntegrityViolationError() {
        return new ResponseEntity("Database error!", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleExceptions() {
        return new ResponseEntity("Something went wrong!", HttpStatus.BAD_REQUEST);
    }
}