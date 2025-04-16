package com.teknologiinformasitka.restapi.order.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import java.time.LocalDateTime;


public class UpdateOrderCommand {
   @TargetAggregateIdentifier
   private String orderId;
   private Long productId;
   private int quantity;
   private LocalDateTime orderDate;
   private String orderStatus;
  
   public UpdateOrderCommand(String orderId, Long productId, int quantity, String orderStatus) {
       this.orderId = orderId;
       this.productId = productId;
       this.quantity = quantity;
       this.orderDate = LocalDateTime.now();
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

