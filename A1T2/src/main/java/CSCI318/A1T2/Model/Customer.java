/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T2.Model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author liamt
 */
@Entity
@Table
public class Customer {
    //Variables
    private @Id @GeneratedValue Long customerId;
    private String companyName;
    private String address;
    private String country;
    
    //Default contstructor
    Customer() {}
    
    //Constructor
    public Customer(String companyName, String address, String country){
        this.companyName = companyName;
        this.address = address;
        this.country = country;
    }
    
    //Getters for Customer
    public Long getId() {
        return this.customerId;
    }
    public String getCompanyName(){
        return companyName;
    }
    public String getAddress(){
        return address;
    }
    public String getCountry(){
        return country;
    }
    
    //Setters for Customer
    public void setId(Long id) {
        this.customerId = id;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    
    //Compare Customer
    @Override
    public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Customer))
      return false;
    Customer customer = (Customer) o;
    return Objects.equals(this.customerId, customer.customerId) &&
           Objects.equals(this.companyName, customer.companyName) &&
           Objects.equals(this.address, customer.address) && 
           Objects.equals(this.country, customer.country);
    }
    
    //Hashcode for Customer
    @Override
    public int hashCode() {
      return Objects.hash(this.customerId, this.companyName, this.address, this.country);
    }
    
    //ToString for Customer
    @Override
    public String toString() {
      return "Contact{" + "id=" + this.customerId + 
                          ", companyName='" + this.companyName + '\'' + 
                          ", address='" + this.address + '\'' + 
                          ", country='" + this.country + '\'' + 
                          '}';
    }
}
