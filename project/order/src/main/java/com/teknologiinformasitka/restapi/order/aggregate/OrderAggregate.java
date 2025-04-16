package com.teknologiinformasitka.restapi.order.aggregate;

import java.time.LocalDateTime;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.teknologiinformasitka.restapi.order.command.CreateOrderCommand;
import com.teknologiinformasitka.restapi.order.command.UpdateOrderCommand;
import com.teknologiinformasitka.restapi.order.event.OrderCreatedEvent;
import com.teknologiinformasitka.restapi.order.event.OrderUpdatedEvent;



@Aggregate
public class OrderAggregate {


   @AggregateIdentifier
   private String orderId;
   private Long productId;
   private int quantity;
   private LocalDateTime orderDate;
   private String orderStatus;


   // Konstruktor kosong wajib ada untuk Axon
   public OrderAggregate() {}


   @CommandHandler
   public OrderAggregate(CreateOrderCommand command) {
       // Validasi command jika diperlukan


       // Terapkan event OrderCreatedEvent
       AggregateLifecycle.apply(new OrderCreatedEvent(
               command.getOrderId(),
               command.getProductId(),
               command.getQuantity(),
               command.getOrderDate(),
               command.getOrderStatus()
       ));
   }


   @EventSourcingHandler
   protected void on(OrderCreatedEvent event) {
       this.orderId = event.getorderId();
       this.productId = event.getProductId();
       this.quantity = event.getQuantity();
       this.orderDate = event.getorderDate();
       this.orderStatus = event.getOrderStatus();
   }


   @CommandHandler
   public void handle(UpdateOrderCommand command) {
       AggregateLifecycle.apply(new OrderUpdatedEvent(
               command.getOrderId(),
               command.getProductId(),
               command.getQuantity(),
               command.getOrderDate(),
               command.getOrderStatus()
       ));
   }


   @EventSourcingHandler
   protected void on(OrderUpdatedEvent event) {
       this.productId = event.getProductId();
       this.quantity = event.getQuantity();
       this.orderDate = event.getOrderDate();
       this.orderStatus = event.getOrderStatus();
   }
}



