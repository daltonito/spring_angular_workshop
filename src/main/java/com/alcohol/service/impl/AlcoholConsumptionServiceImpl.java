package com.alcohol.service.impl;

import com.alcohol.exception.AlcoholConsumptionNotFound;
import com.alcohol.model.AlcoholConsumption;
import com.alcohol.repository.AlcoholConsumptionRepository;
import com.alcohol.service.AlcoholConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AlcoholConsumptionServiceImpl implements AlcoholConsumptionService {

    @Autowired
    private AlcoholConsumptionRepository repository;

    public List<AlcoholConsumption> getAll() {
        return repository.findAll(new Sort(new Sort.Order("country")));
    }

    public AlcoholConsumption getById(Long id) throws AlcoholConsumptionNotFound {
        checkExistence(id);
        return repository.findOne(id);
    }

    public AlcoholConsumption getByCountry(String country) throws AlcoholConsumptionNotFound {

        AlcoholConsumption alcoholConsumption;

        if ((alcoholConsumption = repository.findByCountry(country)) == null) {
            throw new AlcoholConsumptionNotFound();
        }
        return alcoholConsumption;
    }

    @Transactional
    public AlcoholConsumption create(AlcoholConsumption alcoholConsumption) {
        alcoholConsumption.setId(null);
        return repository.save(alcoholConsumption);
    }

    @Transactional
    public Long delete(Long id) throws AlcoholConsumptionNotFound {
        checkExistence(id);
        repository.delete(id);
        return id;
    }

    @Transactional
    public AlcoholConsumption update(Long id, AlcoholConsumption alcoholConsumption) throws AlcoholConsumptionNotFound {
        checkExistence(id);
        alcoholConsumption.setId(id);
        return  repository.save(alcoholConsumption);
    }

    private void checkExistence(Long id) throws AlcoholConsumptionNotFound {
        if (!repository.exists(id)) {
            throw new AlcoholConsumptionNotFound();
        }
    }
}
