/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1;

/**
 *
 * @author liamt
 */
class CustomerNotFoundException extends RuntimeException {

  CustomerNotFoundException(Long id) {
    super("Could not find customer " + id);
  }
}
