package com.alcohol.exception;

public class AlcoholConsumptionNotFound extends Exception {

    public AlcoholConsumptionNotFound() {
        super("Requested alcohol consumption is not found!");
    }
}
