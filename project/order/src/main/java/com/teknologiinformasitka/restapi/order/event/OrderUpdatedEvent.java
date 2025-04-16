package com.teknologiinformasitka.restapi.order.event;

import java.time.LocalDateTime;


public class OrderUpdatedEvent {
   private String orderId;
   private Long productId;
   private int quantity;
   private LocalDateTime orderDate;
   private String orderStatus;
  
   public OrderUpdatedEvent(String orderId, Long productId, int quantity, LocalDateTime orderDate, String orderStatus) {
       this.orderId = orderId;
       this.productId = productId;
       this.quantity = quantity;
       this.orderDate = orderDate;
       this.orderStatus = orderStatus;
   }


   // Getters
   public String getOrderId() {
       return orderId;
   }
   public Long getProductId() {
       return productId;
   }
   public int getQuantity() {
       return quantity;
   }
   public LocalDateTime getOrderDate() {
       return orderDate;
   }
   public String getOrderStatus() {
       return orderStatus;
   }
}

