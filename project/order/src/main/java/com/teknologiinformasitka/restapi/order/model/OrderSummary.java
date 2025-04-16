package com.teknologiinformasitka.restapi.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "order_summary")
public class OrderSummary {
  
   @Id
   private String orderId;
   private Long productId;
   private int quantity;
   private LocalDateTime orderDate;
   private String orderStatus;
  
   public OrderSummary() {}


   public OrderSummary(String orderId, Long productId, int quantity, LocalDateTime orderDate, String orderStatus) {
       this.orderId = orderId;
       this.productId = productId;
       this.quantity = quantity;
       this.orderDate = orderDate;
       this.orderStatus = orderStatus;
   }


   // Getters & Setters
   public String getOrderId() {
       return orderId;
   }
   public void setOrderId(String orderId) {
       this.orderId = orderId;
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
}



