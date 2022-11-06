package com.eugens21.springstatemachine.service;

import com.eugens21.springstatemachine.entity.Bill;
import com.eugens21.springstatemachine.enums.BillEvent;
import com.eugens21.springstatemachine.enums.BillState;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;

import static java.lang.String.valueOf;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class StateMachineService {

    StateMachineFactory<BillState, BillEvent> factory;

    public StateMachine<BillState, BillEvent> getStateMachine (Long id) {
        return factory.getStateMachine(valueOf(id));
    }

    public void sendEventToMachine(StateMachine<BillState, BillEvent> stateMachine, Message<BillEvent> event) {
        boolean b = stateMachine.sendEvent(event);
    }

}
