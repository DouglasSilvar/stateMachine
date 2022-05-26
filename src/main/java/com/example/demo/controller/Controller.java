package com.example.demo.controller;

import com.example.demo.dto.OrderEventsDTO;
import com.example.demo.model.Order;
import com.example.demo.service.ChangeStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/state")
public class Controller {

    @Autowired
    ChangeStateService service;

    @PostMapping
    public ResponseEntity<Order> changeState(@RequestBody OrderEventsDTO orderEventsDTO) {
        var retornos =  service.saveState(orderEventsDTO.getOrderEvents());
        return ResponseEntity.ok(retornos);
    }

    @GetMapping
    public ResponseEntity<Order> getState() {
        var retornos =  service.getState();
        return ResponseEntity.ok(retornos);
    }

}
