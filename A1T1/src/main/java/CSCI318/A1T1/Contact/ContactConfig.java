/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Contact;
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
class ContactConfig {

  private static final Logger log = LoggerFactory.getLogger(ContactConfig.class);

  @Bean
  CommandLineRunner ContactinitDatabase(ContactRepository contactRepository) {
    return args -> {
      log.info("Preloading " + contactRepository.save(new Contact("Jim", "0422666552", "Jim@jimsmowing.com", "Gardener")));
      log.info("Preloading " + contactRepository.save(new Contact("Dan Murphy", "0483955344", "Danmurphy@dans.com", "Bottler")));
    };
  }
}