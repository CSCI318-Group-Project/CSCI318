/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.BusinessIntelligence.Service;

import CSCI318.BusinessIntelligence.Model.ProductQuantity;
import java.util.function.Consumer;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import CSCI318.BusinessIntelligence.Model.ProductQuantity;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author liamt
 */
@Configuration
public class ProductConsumer {
    @Bean
    public Consumer<KStream<String, ProductQuantity>> productConsumerService(){
        return kstream-> kstream.foreach((key, productQuantity)-> {
            System.out.println(String.format("Product consumed [%s]", productQuantity.getName()));
        });
    }
                
}
