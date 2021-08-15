/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Contact;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author liamt
 */
@Service
public class ContactService {
    
    private final ContactRepository contactRepository;
    
    @Autowired
    ContactService(ContactRepository contactRepository) {
       this.contactRepository = contactRepository;
    }
    
    List<Contact> getContacts() {
        return contactRepository.findAll();
    }
    
    public void addNewContact(Contact contact){
        contactRepository.save(contact);
    }
}
