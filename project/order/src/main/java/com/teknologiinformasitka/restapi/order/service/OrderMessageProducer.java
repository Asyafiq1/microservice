package com.teknologiinformasitka.restapi.order.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.teknologiinformasitka.restapi.order.config.OrderRabbitConfig;
import com.teknologiinformasitka.restapi.order.event.OrderCreatedEvent;

@Service
public class OrderMessageProducer {

   private final RabbitTemplate rabbitTemplate;

   public OrderMessageProducer(RabbitTemplate rabbitTemplate) {
       this.rabbitTemplate = rabbitTemplate;
   }

   public void sendOrderCreatedEvent(OrderCreatedEvent event) {
       // Mengirim event ke exchange dengan routing key yang sudah didefinisikan
       rabbitTemplate.convertAndSend(OrderRabbitConfig.ORDER_EXCHANGE, OrderRabbitConfig.ORDER_ROUTING_KEY, event);
       System.out.println("OrderService mengirim event: " + event);
   }
}

