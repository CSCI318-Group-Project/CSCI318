/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author liamt
 */
//From spring boot tutorial using the repository
@RestController
class ContactController {

  private final ContactRepository repository;

  ContactController(ContactRepository repository) {
    this.repository = repository;
  }
  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/Contact")
  List<Contact> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/Contact")
  Contact newContact(@RequestBody Contact newContact) {
    return repository.save(newContact);
  }

  // Single item
  
  @GetMapping("/Contact/{id}")
  Contact one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new ContactNotFoundException(id));
  }

  @PutMapping("/Contact/{id}")
  Contact replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {
  
      
    return repository.findById(id)
      .map(contact -> {
        contact.setName(newContact.getName());
        contact.setPhone(newContact.getPhone());
        contact.setEmail(newContact.getEmail());
        contact.setPosition(newContact.getPosition());
        return repository.save(contact);
      })
      .orElseGet(() -> {
        newContact.setId(id);
        return repository.save(newContact);
      });
  }

  @DeleteMapping("/Contact/{id}")
  void deleteContact(@PathVariable Long id) {
    repository.deleteById(id);
  }
}