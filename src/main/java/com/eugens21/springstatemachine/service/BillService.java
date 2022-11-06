package com.eugens21.springstatemachine.service;

import com.eugens21.springstatemachine.repository.BillRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class BillService {

    BillRepository billRepository;

    public void verifyBill() {

    }

}
