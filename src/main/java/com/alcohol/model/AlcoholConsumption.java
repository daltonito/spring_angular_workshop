package com.alcohol.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Document(collection = "alcohol_consumption")
public class AlcoholConsumption {

    @Id
    private String id;

    @NotEmpty
    @Indexed(unique = true)
    private String country;

    @NotNull
    @Field("beer_servings")
    private Integer beerServings;

    @NotNull
    @Field("spirit_servings")
    private Integer spiritServings;

    @NotNull
    @Field("wine_servings")
    private Integer wineServings;

    @Field("total_litres_of_pure_alcohol")
    private Double totalLiters;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getBeerServings() {
        return beerServings;
    }

    public void setBeerServings(Integer beerServings) {
        this.beerServings = beerServings;
    }

    public Integer getSpiritServings() {
        return spiritServings;
    }

    public void setSpiritServings(Integer spiritServings) {
        this.spiritServings = spiritServings;
    }

    public Integer getWineServings() {
        return wineServings;
    }

    public void setWineServings(Integer wineServings) {
        this.wineServings = wineServings;
    }

    public Double getTotalLiters() {
        return totalLiters;
    }

    public void setTotalLiters(Double totalLiters) {
        this.totalLiters = totalLiters;
    }
}