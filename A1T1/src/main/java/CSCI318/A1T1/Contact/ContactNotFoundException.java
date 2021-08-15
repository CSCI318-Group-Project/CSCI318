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
class ContactNotFoundException extends RuntimeException {

  ContactNotFoundException(Long id) {
    super("Could not find contact " + id);
  }
}
