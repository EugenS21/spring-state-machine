package com.eugens21.springstatemachine.repository;

import com.eugens21.springstatemachine.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {}
