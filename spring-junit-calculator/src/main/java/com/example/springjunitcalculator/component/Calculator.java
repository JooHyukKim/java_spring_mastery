package com.example.springjunitcalculator.component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Calculator {

    private final ICalculator iCalculator;

    public int sum(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.sum(x, y);
    }

    public int subtract(int x, int y) {
        this.iCalculator.init();
        return this.iCalculator.subtract(x, y);
    }
}
