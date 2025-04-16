package com.teknologiinformasitka.restapi.service;

import com.teknologiinformasitka.restapi.config.ProdukRabbitConfig;
import com.teknologiinformasitka.restapi.event.OrderCreatedEvent;
import com.teknologiinformasitka.restapi.model.Produk;
import com.teknologiinformasitka.restapi.repository.ProdukRepository;
import java.util.Optional;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class OrderMessageConsumer {


   private final ProdukRepository productRepository;


   public OrderMessageConsumer(ProdukRepository productRepository) {
       this.productRepository = productRepository;
   }


   // Dengan converter JSON, pesan akan dideserialisasi ke OrderCreatedEvent
   @RabbitListener(queues = ProdukRabbitConfig.ORDER_QUEUE)
   public void receiveOrderEvent(OrderCreatedEvent event) {
       System.out.println("Product Service menerima OrderCreatedEvent: " + event);
      
       // Cari produk berdasarkan productId dari event
       Optional<Produk> productOpt = productRepository.findById(event.getProductId());
       if (productOpt.isPresent()) {
           Produk product = productOpt.get();
           // Kurangi stok produk dengan jumlah order
           int currentStock = product.getStok();
           int newStock = currentStock - event.getQuantity();
          
           // Validasi: stok tidak boleh negatif
           if (newStock < 0) {
               System.out.println("Stok tidak cukup untuk produk ID " + product.getId());
           } else {
               product.setStok(newStock);
               productRepository.save(product);
               System.out.println("Stok untuk produk ID " + product.getId() + " diperbarui: " + newStock);
           }
       } else {
           System.out.println("Produk dengan ID " + event.getProductId() + " tidak ditemukan.");
       }
   }
}
