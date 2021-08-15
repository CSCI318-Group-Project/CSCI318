/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Contact;

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
public class ContactService {
    
    private final ContactRepository contactRepository;
    
    //Sets the repository for contacts
    @Autowired
    ContactService(ContactRepository contactRepository) {
       this.contactRepository = contactRepository;
    }
    
    //Returns a list of all contacts
    List<Contact> getContacts() {
        return contactRepository.findAll();
    }
    
    //Returns a single contact
    Optional<Contact> getContact(Long contactid){
        return contactRepository.findById(contactid);
    }
    
    //Function to add a new contact and inject to repository
    public void addNewContact(Contact contact){
        contactRepository.save(contact);
    }
    
    //Function to update contact info in repository
    @Transactional
    public void updateContact(Long contactid, String name, String phone, String email, String position){
        Contact contact = contactRepository.findById(contactid)
                .orElseThrow(()-> new IllegalStateException("contact with id " + contactid + " does not exist" ));
        
        if(name != null && name.length() > 0 && !Objects.equals(contact.getName(), name)){
            contact.setName(name);
        }
        
        if(phone != null && phone.length() > 0 && !Objects.equals(contact.getPhone(), phone)){
            contact.setPhone(phone);
        }
        
        if(email != null && email.length() > 0 && !Objects.equals(contact.getEmail(), email)){
            contact.setEmail(email);
        }
        
        if(position != null && position.length() > 0 && !Objects.equals(contact.getPosition(), position)){
            contact.setPosition(position);
        }
    }
    
    //Function to delete contact from the repository
    public void deleteContact(Long contactid){
        boolean exists = contactRepository.existsById(contactid);
        if(!exists){
            throw new IllegalStateException("contact with id " + contactid + " does not exist" );
        }
        contactRepository.deleteById(contactid);
    }
}
