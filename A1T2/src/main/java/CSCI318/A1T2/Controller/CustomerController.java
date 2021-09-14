/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T2.Controller;
import CSCI318.A1T2.Model.Contact;
import CSCI318.A1T2.Model.Customer;
import CSCI318.A1T2.Service.CustomerService;
import CSCI318.A1T2.Service.ContactService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liamt
 */
@RestController
class CustomerController {

  private final CustomerService customerService;

  //Set the customer service
  CustomerController(CustomerService customerService, ContactService contactService) {
    this.customerService = customerService;
  }

  //Get request that returns all customers
  @GetMapping("/Customer")
  List<Customer> getCustomers() {
    return customerService.getCustomers();
  }
  
  //Get request that returns a single customer from id
  @GetMapping("/Customer/{customerid}")
  public Optional<Customer> getCustomer(@PathVariable("customerid") Long customerid){
      return customerService.getCustomer(customerid);
  }
  
  //Post request that creates a new customer
  @PostMapping("/Customer/New")
  public void newCustomers(@RequestBody Customer[] customers){
      customerService.addNewCustomers(customers);
  }
  
  //Put request that updates customer information
  @PutMapping("Customer/{customerid}")
  public void updateCustomer(
        @PathVariable("customerid") Long customerid,
        @RequestParam(required = false) String companyName,
        @RequestParam(required = false) String address,
        @RequestParam(required = false) String country){
      customerService.updateCustomer(customerid, companyName, address, country);
  }
 
  
  //Put request that updates contact for the customer by id
  @PutMapping("/Customer/{id}/Contact/{contactId}")
  public void updateCustomerContact(@PathVariable Long id, @PathVariable Long contactId) {
        customerService.updateCustomerContact(id, contactId);
  }
    

  //Delete request that removes a customer
  @DeleteMapping("/Customer/{customerid}/Contact/{contactId}")
  public void deleteCustomer(@PathVariable("customerid") Long customerId, @PathVariable("contactid") Long contactId){
      customerService.deleteCustomer(customerId, contactId);
  }
}
