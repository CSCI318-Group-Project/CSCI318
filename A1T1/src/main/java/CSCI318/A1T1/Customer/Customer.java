/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Customer;

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
    private @Id @GeneratedValue Long id;
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
        return this.id;
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
        this.id = id;
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
    return Objects.equals(this.id, customer.id) &&
           Objects.equals(this.companyName, customer.companyName) &&
           Objects.equals(this.address, customer.address) && 
           Objects.equals(this.country, customer.country);
    }
    
    //Hashcode for Customer
    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.companyName, this.address, this.country);
    }
    
    //ToString for Customer
    @Override
    public String toString() {
      return "Contact{" + "id=" + this.id + 
                          ", companyName='" + this.companyName + '\'' + 
                          ", address='" + this.address + '\'' + 
                          ", country='" + this.country + '\'' + 
                          '}';
    }
}
