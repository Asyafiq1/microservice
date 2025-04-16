package com.teknologiinformasitka.restapi.order.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.time.LocalDateTime;


public class CreateOrderCommand {
   @TargetAggregateIdentifier
   private String orderId;
   private Long productId;
   private int quantity;
   private LocalDateTime orderDate;
   private String orderStatus;
  
   public CreateOrderCommand(String orderId, Long productId, int quantity) {
       this.orderId = orderId;
       this.productId = productId;
       this.quantity = quantity;
       // Set orderDate dan orderStatus secara default
       this.orderDate = LocalDateTime.now();
       this.orderStatus = "CREATED";
   }


   // Getters (dan setters jika diperlukan)
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

