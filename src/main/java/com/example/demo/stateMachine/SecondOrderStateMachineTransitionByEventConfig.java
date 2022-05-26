package com.example.demo.stateMachine;

import com.example.demo.enums.SecondOrderEvents;
import com.example.demo.enums.SecondOrderStates;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@EnableStateMachine(name = "second")
public class SecondOrderStateMachineTransitionByEventConfig extends
        EnumStateMachineConfigurerAdapter<SecondOrderStates, SecondOrderEvents> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<SecondOrderStates, SecondOrderEvents> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<SecondOrderStates, SecondOrderEvents> states) throws Exception {
        states
                .withStates()
                .initial(SecondOrderStates.CREATED)
                .states(EnumSet.allOf(SecondOrderStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<SecondOrderStates, SecondOrderEvents> transitions) throws Exception {
        transitions
                .withExternal()
                .source(SecondOrderStates.CREATED)
                .target(SecondOrderStates.APPROVED)
                .event(SecondOrderEvents.CONFIRMED_PAYMENT)
                .and().withExternal()

                .source(SecondOrderStates.APPROVED)
                .target(SecondOrderStates.INVOICED)
                .event(SecondOrderEvents.INVOICE_ISSUED)
                .and().withExternal()

                .source(SecondOrderStates.APPROVED)
                .target(SecondOrderStates.CANCELLED)
                .event(SecondOrderEvents.CANCEL)
                .and().withExternal()

                .source(SecondOrderStates.INVOICED)
                .target(SecondOrderStates.SHIPPED)
                .event(SecondOrderEvents.SHIP)
                .and().withExternal()

                .source(SecondOrderStates.SHIPPED)
                .target(SecondOrderStates.DELIVERED)
                .event(SecondOrderEvents.DELIVER)
        ;
    }

    @Bean
    @Qualifier(value = "second")
    public StateMachineListener<SecondOrderStates, SecondOrderEvents> listener() {
        return new StateMachineListenerAdapter<SecondOrderStates, SecondOrderEvents>() {
            @Override
            public void stateChanged(State<SecondOrderStates, SecondOrderEvents> from, State<SecondOrderStates, SecondOrderEvents> to) {
                System.out.println("OrderState change from ");
            }
        };
    }
}



