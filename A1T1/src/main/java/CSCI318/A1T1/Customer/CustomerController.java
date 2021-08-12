/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 *
 * @author liamt
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService service;
    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }
    public void setService(CustomerService service) {
        System.out.println("CustomerController setter called");
        this.service = service;
    }
    public CustomerController(){
        System.out.println("Customer Controller no-arg constructor called");
    }
    @Autowired
    public CustomerController(CustomerService service) {
        System.out.println("CustomerController arg constructor called");
        this.service = service;
    }
}