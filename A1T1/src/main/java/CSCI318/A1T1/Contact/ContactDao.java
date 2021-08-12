/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Contact;
import org.springframework.stereotype.Component;
import java.util.List;
/**
 *
 * @author liamt
 */
@Component
public class ContactDao {
    public ContactDao(){
        System.out.println("ContactDao no-arg constructor called");
    }
    public List<Contact> getAllContacts() {
        System.out.println("ContactDao.getContact called");
        return null;
    }
}
