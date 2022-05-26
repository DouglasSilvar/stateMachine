package com.example.demo.service;

import com.example.demo.enums.OrderEvents;
import com.example.demo.enums.OrderStates;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.utils.ConvertStringtoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public class ChangeStateService {

    @Autowired
    OrderRepository repository;

    @Autowired
    private StateMachine<OrderStates, OrderEvents> stateMachine;

    public Order getState(){
        return repository.findById(1L).get();
    }

    public Order saveState(String order){
       var orders =  ConvertStringtoEnum.orderEvents(order);
         if(stateMachine.sendEvent(orders)){
            var states =  stateMachine.getState().getId();
            var orderers = Order.builder()
                    .id(1L)
                    .orderStates(states.name())
                    .build();
             return repository.save(orderers);
         }else return null;

    }
}
