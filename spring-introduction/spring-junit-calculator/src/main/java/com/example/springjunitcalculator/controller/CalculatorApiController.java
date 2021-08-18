package com.example.springjunitcalculator.controller;

import com.example.springjunitcalculator.component.Calculator;
import com.example.springjunitcalculator.component.ICalculator;
import com.example.springjunitcalculator.dto.Req;
import com.example.springjunitcalculator.dto.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y) {
        return calculator.sum(x, y);
    }

    @GetMapping("/minus")
    public int minus(@RequestParam int x, @RequestParam int y) {
        return calculator.subtract(x, y);
    }

    @PostMapping("/sum")
    public int sum(@RequestBody Req req) {
        return calculator.sum(req.getX(), req.getY());
    }

    @PostMapping("/minus")
    public Res minusPost(@RequestBody Req req) {
        int result = calculator.subtract(req.getX(), req.getY());
        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body("OK"));
        return res;
    }
}
