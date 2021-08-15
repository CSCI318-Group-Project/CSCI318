/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T1.Contact;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author liamt
 */
//Returns an error code for wrong requests
@ControllerAdvice
class ContactNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ContactNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String contactNotFoundHandler(ContactNotFoundException ex) {
    return ex.getMessage();
  }
}