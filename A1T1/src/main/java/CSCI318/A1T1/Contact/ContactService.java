/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
/**
 *
 * @author liamt
 */
@Component
public class ContactService {
    private ContactDao dao;
    public List<Contact> getContacts() {
        System.out.println("ContactService.getContact called");
        return dao.getAllContacts();
    }
    public void setDao(ContactDao dao) {
        System.out.println("ContactService setter called");
        this.dao = dao;
    }
    public ContactService(){
        System.out.println("ContactService no-arg constructor called");
    }
    @Autowired
    public ContactService(ContactDao dao) {
        System.out.println("ContactService arg constructor called");
        this.dao = dao;
    }
}