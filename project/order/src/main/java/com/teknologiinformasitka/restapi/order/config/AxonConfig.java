package com.teknologiinformasitka.restapi.order.config;

import javax.sql.DataSource;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.jdbc.JdbcEventStorageEngine;
import org.axonframework.serialization.Serializer;
import org.axonframework.spring.jdbc.SpringDataSourceConnectionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




@Configuration
public class AxonConfig {


   @Bean
public JdbcEventStorageEngine eventStorageEngine(DataSource dataSource, TransactionManager transactionManager, Serializer serializer) {
   return JdbcEventStorageEngine.builder()
       .connectionProvider(new SpringDataSourceConnectionProvider(dataSource))
       .transactionManager(transactionManager)
       .eventSerializer(serializer)
       .snapshotSerializer(serializer)
       .build();
}
   @Bean
   public EmbeddedEventStore eventStore(EventStorageEngine storageEngine) {
       return EmbeddedEventStore.builder()
               .storageEngine(storageEngine)
               .build();
   }
}

