package com.example.demo.controller;

import com.example.demo.dto.EventOrderDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.service.ChangeStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/state")
public class Controller {

    @Autowired
    ChangeStateService service;

    @PostMapping()
    public ResponseEntity<OrderDTO> changeState(@RequestBody EventOrderDTO eventOrderDTO) throws Exception {
        var retornos =  service.alterState(eventOrderDTO);
        return ResponseEntity.ok(retornos);
    }

    @PostMapping("/add")
    public ResponseEntity<OrderDTO> addMachine(){
        return ResponseEntity.ok().body(service.add());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getState(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok().body(service.getState(id));
    }

}
