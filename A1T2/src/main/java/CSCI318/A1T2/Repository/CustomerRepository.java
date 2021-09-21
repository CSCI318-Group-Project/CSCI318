/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T2.Repository;

/**
 *
 * @author liamt
 */

import CSCI318.A1T2.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//The customer repository
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}