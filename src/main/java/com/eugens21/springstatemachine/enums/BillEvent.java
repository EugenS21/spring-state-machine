package com.eugens21.springstatemachine.enums;

public enum BillEvent {

    VERIFY,
    MATCH,
    APPROVE,
    REJECT,
    APPROVE_TO_PAY,
    PAY,
    PAY_WITH_LESS_AMOUNT,
    APPROVE_PAYMENT;

}
