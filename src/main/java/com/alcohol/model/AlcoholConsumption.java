package com.alcohol.model;

import javax.persistence.*;

@Entity
@Table(name = "alcohol_consumption")
public class AlcoholConsumption {

    private Long id;
    private String country;
    private Integer beerServings;
    private Integer spiritServings;
    private Integer wineServings;
    private Double totalLiters;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "country", unique = true, nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "beer_servings", nullable = false)
    public Integer getBeerServings() {
        return beerServings;
    }

    public void setBeerServings(Integer beerServings) {
        this.beerServings = beerServings;
    }

    @Column(name = "spirit_servings", nullable = false)
    public Integer getSpiritServings() {
        return spiritServings;
    }

    public void setSpiritServings(Integer spiritServings) {
        this.spiritServings = spiritServings;
    }

    @Column(name = "wine_servings", nullable = false)
    public Integer getWineServings() {
        return wineServings;
    }

    public void setWineServings(Integer wineServings) {
        this.wineServings = wineServings;
    }

    @Column(name = "total_litres_of_pure_alcohol")
    public Double getTotalLiters() {
        return totalLiters;
    }

    public void setTotalLiters(Double totalLiters) {
        this.totalLiters = totalLiters;
    }
}