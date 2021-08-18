package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

//@JsonNaming(value=PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PutRequestDTO {
    private String account;
    private int age;
    @JsonProperty("car_list")
    private List<CarDTO> carList;

    public PutRequestDTO(String account, int age, List<CarDTO> carList) {
        this.account = account;
        this.age = age;
        this.carList = carList;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CarDTO> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDTO> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "PutRequestDTO{" +
                "account='" + account + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }
}
