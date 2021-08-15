/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author liamt
 */
@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  //private static final Logger conLog = LoggerFactory.getLogger(LoadCustomerDatabase.class);

  @Bean
  CommandLineRunner initDatabase(CustomerRepository customerRepository, ContactRepository contactRepository) {
      

    return args -> {
      log.info("Preloading " + customerRepository.save(new Customer("MonstersInc", "ScareFloor", "ScaryTown")));
      log.info("Preloading " + customerRepository.save(new Customer("Dentist", "42 Wallaby Way", "Australia")));
      log.info("Preloading " + contactRepository.save(new Contact("Jim", "0422666552", "Jim@jimsmowing.com", "Gardener")));
      log.info("Preloading " + contactRepository.save(new Contact("Dan Murphy", "0483955344", "Danmurphy@dans.com", "Bottler")));
    };
  }
}