package com.teknologiinformasitka.restapi.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teknologiinformasitka.restapi.customer.model.Customer;
import com.teknologiinformasitka.restapi.customer.service.*;
import com.teknologiinformasitka.restapi.customer.repository.*;
import com.teknologiinformasitka.restapi.customer.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {


   @Autowired
   private CustomerService customerService;


   // Endpoint untuk mengambil semua customer
   @GetMapping
   public List<Customer> getAllCustomer() {
       return customerService.getAllCustomer();
   }


   // Endpoint untuk mengambil customer berdasarkan id
   @GetMapping("/{id}")
   public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
       return customerService.getcustomerById(id)
               .map(customer -> ResponseEntity.ok().body(customer))
               .orElse(ResponseEntity.notFound().build());
   }


   // Endpoint untuk membuat customer baru
   @PostMapping
   public Customer createCustomer(@RequestBody Customer customer) {
       return customerService.createcustomer(customer);
   }


   // Endpoint untuk mengupdate customer yang sudah ada
   @PutMapping("/{id}")
   public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
       try {
           Customer updatedCustomer = customerService.updatecustomer(id, customerDetails);
           return ResponseEntity.ok(updatedCustomer);
       } catch (RuntimeException e) {
           return ResponseEntity.notFound().build();
       }
   }


   // Endpoint untuk menghapus customer
  @DeleteMapping("/{id}")
public ResponseEntity<Map<String, String>> deleteCustomer(@PathVariable Long id) {
   try {
       customerService.deletecustomer(id);
       Map<String, String> response = new HashMap<>();
       response.put("message", "Customer berhasil dihapus");
       return ResponseEntity.ok(response);
   } catch (RuntimeException e) {
       Map<String, String> response = new HashMap<>();
       response.put("message", "Customer tidak ditemukan dengan id " + id);
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
   }
}
}
