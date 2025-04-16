package com.teknologiinformasitka.restapi.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasitka.restapi.payment.model.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
