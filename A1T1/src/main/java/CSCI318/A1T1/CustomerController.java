/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CSCI318.A1T1;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.List;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
///**
// *
// * @author liamt
// */
////From spring boot tutorial using the repository
//@RestController
//class CustomerController {
//
//  private final CustomerRepository repository;
//
//  CustomerController(CustomerRepository repository) {
//    this.repository = repository;
//  }
//  // Aggregate root
//  // tag::get-aggregate-root[]
//  @GetMapping("/Customer")
//  List<Customer> all() {
//    return repository.findAll();
//  }
//  // end::get-aggregate-root[]
//
//  @PostMapping("/Customer")
//  Customer newCustomer(@RequestBody Customer newCustomer) {
//    return repository.save(newCustomer);
//  }
//
//  // Single item
//  
//  @GetMapping("/Customer/{id}")
//  Customer one(@PathVariable Long id) {
//    
//    return repository.findById(id)
//      .orElseThrow(() -> new CustomerNotFoundException(id));
//  }
//
//  @PutMapping("/Customer/{id}")
//  Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
//  
//      
//    return repository.findById(id)
//      .map(customer -> {
//        customer.setCompanyName(newCustomer.getCompanyName());
//        customer.setAddress(newCustomer.getAddress());
//        customer.setCountry(newCustomer.getCountry());
//        return repository.save(customer);
//      })
//      .orElseGet(() -> {
//        newCustomer.setId(id);
//        return repository.save(newCustomer);
//      });
//  }
//
//  @DeleteMapping("/Customer/{id}")
//  void deleteCustomer(@PathVariable Long id) {
//    repository.deleteById(id);
//  }
//}