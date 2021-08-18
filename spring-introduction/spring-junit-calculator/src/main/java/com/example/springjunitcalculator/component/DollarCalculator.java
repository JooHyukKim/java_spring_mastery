package com.example.springjunitcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DollarCalculator implements ICalculator {

    private int price = 1;

    private MarketApi marketApi;

    public DollarCalculator(MarketApi marketApi) {
        this.marketApi = marketApi;
    }

    public void init() {
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    @Override
    public int subtract(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }
}
