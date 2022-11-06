package com.eugens21.springstatemachine.config;

import com.eugens21.springstatemachine.enums.BillState;
import com.eugens21.springstatemachine.enums.BillEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

import static com.eugens21.springstatemachine.enums.BillEvent.*;
import static com.eugens21.springstatemachine.enums.BillState.*;

@Configuration
@EnableStateMachineFactory
@Slf4j
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<BillState, BillEvent> {

    @Override
    public void configure(StateMachineStateConfigurer<BillState, BillEvent> states) throws Exception {
        states.withStates()
                .initial(DRAFT)
                .states(EnumSet.allOf(BillState.class))
                .end(REJECTED)
                .end(DONE);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<BillState, BillEvent> transitions) throws Exception {
        transitions.withExternal().source(DRAFT).target(NEW).event(VERIFY)
                .and()
                .withExternal().source(NEW).target(MATCHED).event(MATCH)
                .and()
                .withExternal().source(MATCHED).target(APPROVED).event(APPROVE)
                .and()
                .withExternal().source(MATCHED).target(REJECTED).event(REJECT)
                .and()
                .withExternal().source(APPROVED).target(BillState.READY_TO_PAY).event(APPROVE_TO_PAY)
                .and()
                .withExternal().source(READY_TO_PAY).target(PAID).event(PAY)
//                .and()
//                .withExternal().source(READY_TO_PAY).target(UNPAID).event(PAY_WITH_LESS_AMOUNT)
                .and()
                .withExternal().source(PAID).target(DONE).event(APPROVE_PAYMENT);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<BillState, BillEvent> config) throws Exception {
        StateMachineListenerAdapter<BillState, BillEvent> adapter = new StateMachineListenerAdapter<>() {
            @Override
            public void stateChanged(State<BillState, BillEvent> from, State<BillState, BillEvent> to) {
                log.info("State changed from {} to {}", from, to);
            }
        };
        config.withConfiguration().listener(adapter);
    }
}
