/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author liamt
 */
@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    
    @Autowired
    CustomerService(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
    }
    
    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    
    public void addNewCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
