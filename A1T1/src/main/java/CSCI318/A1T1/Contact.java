/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author liamt
 */
@Entity
public class Contact {
    //Variables
    private @Id @GeneratedValue Long id;
    private String name;
    private String phone;
    private String email;
    private String position;
    
    //Default Constructor
    Contact(){}
    
    //Constructor
    public Contact(String name, String phone, String email, String position){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.position = position;
    }
    
    //Getters for Contact
    public Long getId() {
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPosition(){
        return this.position;
    }
    
    //Setters for Contact
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    
    //Compare Contacts
    @Override
    public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Contact))
      return false;
    Contact contact = (Contact) o;
    return Objects.equals(this.id, contact.id) &&
           Objects.equals(this.name, contact.name) &&
           Objects.equals(this.phone, contact.phone) && 
           Objects.equals(this.email, contact.email) && 
           Objects.equals(this.position, contact.position);
    }
    
    //Hashcode for Contact
    @Override
    public int hashCode() {
      return Objects.hash(this.id, this.name, this.phone, this.email, this.position);
    }
    
    //Tostring for Contact
    @Override
    public String toString() {
      return "Contact{" + "id=" + this.id + 
                          ", name='" + this.name + '\'' + 
                          ", phone='" + this.phone + '\'' + 
                          ", email='" + this.email + '\'' + 
                          ", position='" + this.position + '\'' + 
                          '}';
    }
}
