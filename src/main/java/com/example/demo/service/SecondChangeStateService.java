package com.example.demo.service;

import com.example.demo.enums.SecondOrderEvents;
import com.example.demo.enums.SecondOrderStates;
import com.example.demo.model.SecondOrder;
import com.example.demo.repository.SecondOrderRepository;
import com.example.demo.utils.ConvertStringtoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public class SecondChangeStateService {

    @Autowired
    SecondOrderRepository repository;

    @Autowired
    @Qualifier(value = "second")
    private StateMachine<SecondOrderStates, SecondOrderEvents> stateMachine;

    public SecondOrder getState(){
        return repository.findById(1L).get();
    }

    public SecondOrder saveState(String order){
       var orders =  ConvertStringtoEnum.SecondOrderEvents(order);
         if(stateMachine.sendEvent(orders)){
            var states =  stateMachine.getState().getId();
            var orderers = SecondOrder.builder()
                    .id(1L)
                    .orderStates(states.name())
                    .build();
             return repository.save(orderers);
         }else return null;

    }
}
