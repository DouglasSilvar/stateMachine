package com.example.demo.component;

import com.example.demo.enums.OrderEvents;
import com.example.demo.enums.OrderStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

@Component
public class SetStateMachinePersist {

    @Autowired
    private StateMachine<OrderStates, OrderEvents> stateMachine;

    public boolean setState(OrderStates orderStates){
        if(orderStates.equals(OrderStates.CREATED)){
            return true;
        }
        OrderEvents[] orderEvents = OrderEvents.values();
        stateMachine.stop();
        stateMachine.start();
            for(OrderEvents event: orderEvents){
                if (stateMachine.sendEvent(event)) {
                    if (stateMachine.getState().getId().equals(orderStates)) {
                        return true;
                    }
                }
            }
            return false;
    }
}
