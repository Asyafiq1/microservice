package com.teknologiinformasitka.restapi.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasitka.restapi.customer.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}