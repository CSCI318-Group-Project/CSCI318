/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Contact;

/**
 *
 * @author liamt
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Creates a repostiory for contacts
@Repository
interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
