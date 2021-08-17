/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Customer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author liamt
 */
@Service
public class CustomerService {
    
    private final CustomerRepository customerRepository;
    
    //sets the customer repository
    @Autowired
    CustomerService(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
    }
    
    //returns a list of all customers in the repositoy
    List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    
    //returns a single customer from the repository
    Optional<Customer> getCustomer(Long customerid){
        return customerRepository.findById(customerid);
    }

    //adds a list of new customers to the repository
    public void addNewCustomers(Customer[] customers){
        for (Customer customer : customers) {
            addNewCustomer(customer);
        }
    }
    
    //adds a new customer to the repository
    public void addNewCustomer(Customer customer){
        customerRepository.save(customer);
    }
    
    //updates a customer within the repository
    @Transactional
    public void updateCustomer(Long customerid, String companyName, String address, String country){
        Customer customer = customerRepository.findById(customerid)
                .orElseThrow(()-> new IllegalStateException("customer with id " + customerid + " does not exist" ));
        
        if(companyName != null && companyName.length() > 0 && !Objects.equals(customer.getCompanyName(), companyName)){
            customer.setCompanyName(companyName);
        }
        
        if(address != null && address.length() > 0 && !Objects.equals(customer.getAddress(), address)){
            customer.setAddress(address);
        }
        
        if(country != null && country.length() > 0 && !Objects.equals(customer.getCountry(), country)){
            customer.setCountry(country);
        }
        
    }
    
    //deletes a customer from the repository
    public void deleteCustomer(Long customerid){
        boolean exists = customerRepository.existsById(customerid);
        if(!exists){
            throw new IllegalStateException("customer with id " + customerid + " does not exist" );
        }
        customerRepository.deleteById(customerid);
    }
}
