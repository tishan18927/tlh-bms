package com.tlh.bms.data;

import com.tlh.bms.data.entities.PaymentDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentDetailsEntity, Long> {
}
