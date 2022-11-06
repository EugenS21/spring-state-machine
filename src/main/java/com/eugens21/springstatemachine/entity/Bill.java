package com.eugens21.springstatemachine.entity;

import com.eugens21.springstatemachine.enums.BillState;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class Bill {

    @Id
    @GeneratedValue
    Long id;

    @Enumerated(EnumType.STRING)
    BillState billState;

    BigDecimal amount;

}
