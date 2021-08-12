package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDTO {
    private String name;
    @JsonProperty("car_number")
    private String carNumber;

    public CarDTO(String name, String carNumber) {
        this.name = name;
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "name='" + name + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}