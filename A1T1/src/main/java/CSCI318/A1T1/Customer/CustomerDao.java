/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Customer;
import CSCI318.A1T1.Customer.Customer;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 *
 * @author liamt
 */
@Component
public class CustomerDao {
    public CustomerDao(){
        System.out.println("CustomerDao no-arg constructor called");
    }
    public List<Customer> getAllCustomers() {
        System.out.println("CustomerDao.getCustomers called");
        return null;
    }
}
