package com.teknologiinformasitka.restapi.order.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "orders")
public class Order {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   // Menyimpan ID produk dari Product Service
   private Long productId;
  
   private int quantity;
   private LocalDateTime orderDate;
   private String orderStatus;


   public Order() {}


   public Order(Long productId, int quantity, LocalDateTime orderDate, String orderStatus) {
       this.productId = productId;
       this.quantity = quantity;
       this.orderDate = orderDate;
       this.orderStatus = orderStatus;
   }


   // Getters dan Setters
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
       this.id = id;
   }
   public Long getProductId() {
       return productId;
   }
   public void setProductId(Long productId) {
       this.productId = productId;
   }
   public int getQuantity() {
       return quantity;
   }
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
   public LocalDateTime getOrderDate() {
       return orderDate;
   }
   public void setOrderDate(LocalDateTime orderDate) {
       this.orderDate = orderDate;
   }
   public String getOrderStatus() {
       return orderStatus;
   }
   public void setOrderStatus(String orderStatus) {
       this.orderStatus = orderStatus;
   }


public String getorderId() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getorderId'");
}
}
