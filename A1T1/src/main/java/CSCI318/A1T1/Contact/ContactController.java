/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 *
 * @author liamt
 */
@RestController
@RequestMapping("/contacts")
public class ContactController {
    private ContactService service;
    @GetMapping
    public List<Contact> getContacts() {
        return service.getContacts();
    }
    public void setService(ContactService service) {
        System.out.println("ContactController setter called");
        this.service = service;
    }
    public ContactController(){
        System.out.println("Contact Controller no-arg constructor called");
    }
    @Autowired
    public ContactController(ContactService service) {
        System.out.println("ContactController arg constructor called");
        this.service = service;
    }
}