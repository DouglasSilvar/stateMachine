package com.example.demo.controller;

import com.example.demo.dto.SecondOrderEventsDTO;
import com.example.demo.model.SecondOrder;
import com.example.demo.service.SecondChangeStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/second")
public class SecondController {

    @Autowired
    SecondChangeStateService service;

    @PostMapping
    public ResponseEntity<SecondOrder> changeState(@RequestBody SecondOrderEventsDTO orderEventsDTO) {
        var retornos =  service.saveState(orderEventsDTO.getOrderEvents());
        return ResponseEntity.ok(retornos);
    }

    @GetMapping
    public ResponseEntity<SecondOrder> getState() {
        var retornos =  service.getState();
        return ResponseEntity.ok(retornos);
    }

}
