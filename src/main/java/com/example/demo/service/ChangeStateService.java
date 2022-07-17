package com.example.demo.service;

import com.example.demo.component.SetStateMachinePersist;
import com.example.demo.dto.EventOrderDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.enums.OrderEvents;
import com.example.demo.enums.OrderStates;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public class ChangeStateService {

    @Autowired
    OrderRepository repository;

    @Autowired
    SetStateMachinePersist setStateMachinePersist;

    @Autowired
    private StateMachine<OrderStates, OrderEvents> stateMachine;

    public OrderDTO getState(Long id){
        var response = repository.findById(id);
        var order =  response.get();
        return OrderDTO.builder()
                .id(order.getId())
                .orderStates(OrderStates.valueOf(order.getOrderStates()))
                .mensagem("Objeto encontrado")
                .build();
    }

    public OrderDTO alterState(EventOrderDTO eventOrderDTO){
        var id = eventOrderDTO.getId();
        var event = eventOrderDTO.getEvent();
        var statePersisted = this.getState(id).getOrderStates();
        if(setStateMachinePersist.setState(statePersisted)){
         if(stateMachine.sendEvent(event)) {
             var states = stateMachine.getState().getId();
             var dto = OrderDTO.builder()
                     .id(id)
                     .orderStates(states)
                     .mensagem("SUCESSO ao alterar o estado de maquina")
                     .build();
             var order = Order.builder()
                     .id(dto.getId())
                     .orderStates(dto.getOrderStates().name())
                     .build();
             repository.save(order);
             return dto;
         }
         } return OrderDTO.builder()
                .id(id)
                .orderStates(statePersisted)
                .mensagem("FALHA ao alterar o estado de maquina")
                .build();
        }


    public OrderDTO add(){
        var order = Order.builder()
                .orderStates(OrderStates.CREATED.name())
                .build();
        var orderPersist =  repository.save(order);
        return OrderDTO.builder()
                .id(orderPersist.getId())
                .orderStates(OrderStates.valueOf(order.getOrderStates()))
                .mensagem("Objeto criado")
                .build();
    }
}
