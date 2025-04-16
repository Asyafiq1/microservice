package com.teknologiinformasitka.restapi.order.projection;



import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teknologiinformasitka.restapi.order.event.OrderCreatedEvent;
import com.teknologiinformasitka.restapi.order.event.OrderUpdatedEvent;
import com.teknologiinformasitka.restapi.order.model.OrderSummary;
import com.teknologiinformasitka.restapi.order.repository.OrderSummaryRepository;
@Component
public class OrderProjection {


   @Autowired
   private OrderSummaryRepository orderSummaryRepository;


   @EventHandler
   public void on(OrderCreatedEvent event) {
       OrderSummary orderSummary = new OrderSummary(
           event.getorderId(),
           event.getProductId(),
           event.getQuantity(),
           event.getorderDate(),
           event.getOrderStatus()
       );
       orderSummaryRepository.save(orderSummary);
   }


   @EventHandler
   public void on(OrderUpdatedEvent event) {
       OrderSummary orderSummary = orderSummaryRepository.findById(event.getOrderId()).orElse(null);
       if (orderSummary != null) {
           orderSummary.setProductId(event.getProductId());
           orderSummary.setQuantity(event.getQuantity());
           orderSummary.setOrderDate(event.getOrderDate());
           orderSummary.setOrderStatus(event.getOrderStatus());
           orderSummaryRepository.save(orderSummary);
       }
   }
}
