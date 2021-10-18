package CSCI318.Order;

import CSCI318.Order.Model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OrderApplication {

        private static final Logger log = LoggerFactory.getLogger(OrderApplication.class);
	private static final String url = "https://random-data-api.com/api/appliance/random_appliance";
        
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
        
        @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
        
        @Bean
	public CommandLineRunner run(RestTemplate restTemplate, StreamBridge streamBridge) throws Exception {
		return args -> {
			try {
				while (!Thread.currentThread().isInterrupted()){
					Order order = restTemplate.getForObject(url, Order.class);
					assert order != null;
					log.info(order.toString());
					streamBridge.send("order-outbound", order);
					Thread.sleep(1200);
				}
			}
			catch(InterruptedException ignored){}
		};
	}

}
