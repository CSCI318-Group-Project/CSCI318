/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author liamt
 */
//Configuration to preload customer to repository
@Configuration
class CustomerConfig {

  private static final Logger log = LoggerFactory.getLogger(CustomerConfig.class);

  @Bean
  CommandLineRunner CustomerinitDatabase(CustomerRepository customerRepository) {
    return args -> {
      log.info("Preloading " + customerRepository.save(new Customer("MonstersInc", "ScareFloor", "ScaryTown")));
      log.info("Preloading " + customerRepository.save(new Customer("Dentist", "42 Wallaby Way", "Australia")));
    };
  }
}
