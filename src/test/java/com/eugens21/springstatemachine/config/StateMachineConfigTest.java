package com.eugens21.springstatemachine.config;

import com.eugens21.springstatemachine.enums.BillEvent;
import com.eugens21.springstatemachine.enums.BillState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StateMachineConfigTest {

    @Autowired
    StateMachineFactory<BillState, BillEvent> factory;

    @Test
    public void testStateMachine() {
        StateMachine<BillState, BillEvent> stateMachine = factory.getStateMachine(UUID.randomUUID());
        stateMachine.start();
        System.out.println(stateMachine.getState());
        stateMachine.sendEvent(BillEvent.VERIFY);
        System.out.println(stateMachine.getState());
        stateMachine.sendEvent(BillEvent.MATCH);
        System.out.println(stateMachine.getState());
        stateMachine.sendEvent(BillEvent.APPROVE);
        System.out.println(stateMachine.getState());
        stateMachine.sendEvent(BillEvent.REJECT);
        System.out.println(stateMachine.getState());
        stateMachine.sendEvent(BillEvent.REJECT);
        System.out.println(stateMachine.getState());
    }

}