/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1;

/**
 *
 * @author liamt
 */

public class Customer {
    
    private final String companyName;
    private final String address;
    private final String country;
    
    public Customer(String companyName, String address, String country){
        this.companyName = companyName;
        this.address = address;
        this.country = country;
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
}
