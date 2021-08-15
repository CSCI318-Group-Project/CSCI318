/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Contact;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author liamt
 */
@RestController
class ContactController {

  private final ContactService contactService;

  ContactController(ContactService contactService) {
    this.contactService = contactService;
  }

  @GetMapping("/Contact")
  List<Contact> getContacts() {
    return contactService.getContacts();
  }
  
  @PostMapping("/Contact/New")
  public void newContact(@RequestBody Contact contact){
      contactService.addNewContact(contact);
  }
}
