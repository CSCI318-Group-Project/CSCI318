/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Customer;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liamt
 */
@RestController
class CustomerController {

  private final CustomerService customerService;

  CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/Customer")
  List<Customer> getCustomers() {
    return customerService.getCustomers();
  }
  
  @PostMapping("/Customer/New")
  public void newCustomer(@RequestBody Customer customer){
      customerService.addNewCustomer(customer);
  }
}
