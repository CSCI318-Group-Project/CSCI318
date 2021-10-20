package CSCI318.BusinessIntelligence;

import CSCI318.BuisnessIntelligence.Model.ProductQuantity;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BusinessIntelligenceApplication {

    private static final Logger log = LoggerFactory.getLogger(BusinessIntelligenceApplication.class);
    
	public static void main(String[] args) {
		SpringApplication.run(BusinessIntelligenceApplication.class, args);
	}
        
        @Bean
	public Consumer<ProductQuantity> consume() {
		return input -> log.info(input.toString());
	}

}