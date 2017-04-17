package com.alcohol.controller;


import com.alcohol.model.AlcoholConsumption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlcoholConsumptionController {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping("/welcome")
    public ModelAndView helloWorld() {
        return new ModelAndView("index");
    }
}