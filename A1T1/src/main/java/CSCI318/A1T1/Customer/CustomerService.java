/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
/**
 *
 * @author liamt
 */
@Component
public class CustomerService {
    private CustomerDao dao;
    public List<Customer> getCustomers() {
        System.out.println("CustomerService.getCustomers called");
        return dao.getAllCustomers();
    }
    public void setDao(CustomerDao dao) {
        System.out.println("CustomerService setter called");
        this.dao = dao;
    }
    public CustomerService(){
        System.out.println("CustomersService no-arg constructor called");
    }
    @Autowired
    public CustomerService(CustomerDao dao) {
        System.out.println("CustomerService arg constructor called");
        this.dao = dao;
    }
}