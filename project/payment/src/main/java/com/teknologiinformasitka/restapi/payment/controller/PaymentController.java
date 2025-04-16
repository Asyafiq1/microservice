package com.teknologiinformasitka.restapi.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teknologiinformasitka.restapi.payment.model.Payment;
import com.teknologiinformasitka.restapi.payment.service.PaymentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {

        private static final Logger log = LoggerFactory.getLogger(PaymentController.class);


   @Autowired
   private PaymentService paymentService;


   // GET semua payment
   @GetMapping
   public List<Payment> getAllPayments() {
    log.info("GET /api/payment accessed");
       return paymentService.getAll();
   }


   // GET payment berdasarkan id
   @GetMapping("/{id}")
   public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
    log.info("GET /api/payment/{} accessed", id);
       return paymentService.getById(id)
               .map(payment -> ResponseEntity.ok(payment))
               .orElse(ResponseEntity.notFound().build());
   }


   // POST membuat payment baru
   @PostMapping
   public Payment createPayment(@RequestBody Payment payment) {
    log.info("POST /api/payment accessed with body: {}", payment);
       return paymentService.createPayment(payment);
   }


   // PUT update payment yang ada
   @PutMapping("/{id}")
   public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
    log.info("PUT /api/payment/{} accessed with body: {}", id, paymentDetails);

       try {
           Payment updatedPayment = paymentService.updatePayment(id, paymentDetails);
           return ResponseEntity.ok(updatedPayment);
       } catch (RuntimeException e) {
        log.warn("PUT /api/payment/{} failed: {}", id, e.getMessage());
           return ResponseEntity.notFound().build();
       }
   }


   // DELETE payment
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deletePayment(@PathVariable Long id) {
       log.info("DELETE /api/payment/{} accessed", id);
        Map<String, String> response = new HashMap<>();
       try {
           paymentService.deletePayment(id);
           response.put("message", "Payment berhasil dihapus");
           return ResponseEntity.ok("Payment deleted successfully");
       } catch (RuntimeException e) {
        response.put("message", "Payment tidak ditemukan dengan id " + id);
            log.warn("DELETE /api/payment/{} failed: {}", id, e.getMessage());
           return ResponseEntity.notFound().build();
       }
   }
}
