/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.BusinessIntelligence.Service;

import CSCI318.BusinessIntelligence.Model.OrderEvent;
import CSCI318.BusinessIntelligence.Model.ProductQuantity;
import java.util.function.Consumer;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import CSCI318.BusinessIntelligence.Model.ProductQuantity;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 *
 * @author liamt
 */
/*
@Configuration
public class ProductConsumer {
    @Bean
    public Consumer<KStream<String, ProductQuantity>> productConsumerService(){
        return kstream-> kstream.foreach((key, productQuantity)-> {
            System.out.println(String.format("Product consumed [%s]", productQuantity.getName()));
        });
    }
               
}


@EnableKafka
@Configuration
public class ProductConsumer {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProductConsumer.class);
    
    @Bean
    public ConsumerFactory<String, OrderEvent> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "OrderEvent");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaConsumerFactory<>(
      props,
      new StringDeserializer(), 
      new JsonDeserializer<>(OrderEvent.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderEvent> KafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, OrderEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
    }
    
    @KafkaListener(topics = "order-outbound", containerFactory = "KafkaListenerContainerFactory")
    public void orderListener(OrderEvent orderEvent) {
        // process greeting message
        log.info("Order Proccessed: "+ orderEvent.toString());
    }
               
}
*/