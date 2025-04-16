package com.teknologiinformasitka.restapi.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknologiinformasitka.restapi.customer.model.*;
import com.teknologiinformasitka.restapi.customer.controller.*;
import com.teknologiinformasitka.restapi.customer.repository.*;
import com.teknologiinformasitka.restapi.customer.service.*;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {


   @Autowired
   private CustomerRepository customerRepository;


   public List<Customer> getAllcustomer() {
       return customerRepository.findAll();
   }


   public Optional<Customer> getcustomerById(Long id) {
       return customerRepository.findById(id);
   }


   public Customer createcustomer(Customer customer) {
       return customerRepository.save(customer);
   }


   public Customer updatecustomer(Long id, Customer customerDetails) {
       Customer customer = customerRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("customer tidak ditemukan dengan id " + id));
       customer.setNama(customerDetails.getNama());
       customer.setEmail(customerDetails.getEmail());
       customer.setAlamat(customerDetails.getAlamat());
       return customerRepository.save(customer);
   }


   public void deletecustomer(Long id) {
       Customer customer = customerRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("customer tidak ditemukan dengan id " + id));
       customerRepository.delete(customer);
   }

   public boolean existsById(Long productId) {
    return customerRepository.existsById(productId);
   }


public List<Customer> getAllCustomer() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllCustomer'");
}



 
    
}
