package com.maersk.backend.controller;


import com.maersk.backend.model.MaerskCurrency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    @PostMapping
    public ResponseEntity<Map<String, Integer>> getAggregatedCurrencuResponse(@RequestBody  List<MaerskCurrency> currencies){
        Map<String, Integer> map = new HashMap<>();
        if(!currencies.isEmpty()){
            currencies.forEach(maerskCurrency -> {
                if(map.containsKey(maerskCurrency.getCurrency())){
                    map.put(maerskCurrency.getCurrency(), map.get(maerskCurrency.getCurrency())+maerskCurrency.getAmount());
                }else{
                    map.put(maerskCurrency.getCurrency(), maerskCurrency.getAmount());
                }
            });
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
