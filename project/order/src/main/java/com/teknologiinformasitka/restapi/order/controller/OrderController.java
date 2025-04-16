package com.teknologiinformasitka.restapi.order.controller;

import java.util.List;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teknologiinformasitka.restapi.order.command.CreateOrderCommand;
import com.teknologiinformasitka.restapi.order.command.UpdateOrderCommand;
import com.teknologiinformasitka.restapi.order.model.CreateOrderRequest;
import com.teknologiinformasitka.restapi.order.model.OrderSummary;
import com.teknologiinformasitka.restapi.order.model.UpdateOrderRequest;
import com.teknologiinformasitka.restapi.order.repository.OrderSummaryRepository;




@RestController
@RequestMapping("/api/orderss")
public class OrderController {


   @Autowired
   private CommandGateway commandGateway;


   @Autowired
   private OrderSummaryRepository orderSummaryRepository;


    public OrderController(CommandGateway commandGateway, OrderSummaryRepository orderRepository) {
       this.commandGateway = commandGateway;
       this.orderSummaryRepository = orderRepository;
   }
   // Endpoint untuk membuat order (Command)
   @PostMapping
   public String createOrder(@RequestBody CreateOrderRequest request) {
       String orderId = UUID.randomUUID().toString();
       CreateOrderCommand command = new CreateOrderCommand(orderId, request.getProductId(), request.getQuantity());
       commandGateway.sendAndWait(command);
       // Ambil data order yang baru dibuat dari database
   return orderId;
   }


   // Endpoint untuk memperbarui order (Command)
   @PutMapping("/{orderId}")
   public String updateOrder(@PathVariable String orderId, @RequestBody UpdateOrderRequest request) {
       UpdateOrderCommand command = new UpdateOrderCommand(orderId, request.getProductId(), request.getQuantity(), request.getOrderStatus());
       commandGateway.sendAndWait(command);
       return orderId;
   }


  
}
