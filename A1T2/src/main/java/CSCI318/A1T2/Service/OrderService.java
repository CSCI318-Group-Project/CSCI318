/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T2.Service;

import CSCI318.A1T2.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author liamt
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    
    //Sets the repository for Orders
    @Autowired
    public OrderService(OrderRepository orderRepository) {
       this.orderRepository = orderRepository;
    }
}
