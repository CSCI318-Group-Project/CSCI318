/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Order;
import Service.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liamt
 */
@RestController
public class OrderController {
   private final OrderService orderService;

  //Set the order service
  OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  //Get request that returns all orders
  @GetMapping("/Order")
  List<Order> getOrders() {
    return orderService.getOrders();
  }
  
  //Get request that returns a single order from id
  @GetMapping("/Order/{orderid}")
  public Optional<Order> getOrder(@PathVariable("orderid") Long orderid){
      return orderService.getOrder(orderid);
  }
  
  //Post request that creates a new order
  @PostMapping("/Order/New")
  public void newOrders(@RequestBody Order[] orders){
      orderService.addNewOrder(orders);
  }
  
  //Put request that updates order information
  @PutMapping("Order/{orderid}")
  public void updateOrder(
        @PathVariable("orderid") Long orderId,
        @RequestParam(required = false) String supplier,
        @RequestParam(required = false) String productName,
        @RequestParam(required = false) int quantity){
      orderService.updateOrder(orderId, supplier, productName, quantity);
  }
 
  /*
  //Put request that updates customer for the order by id
  @PutMapping("/Order/{id}/Customer/{customerId}")
  public void updateOrderCustomer(@PathVariable Long id, @PathVariable Long customerId) {
        orderService.updateOrderCustomer(id, customerId);
  }
  
  //Put request that updates product for the order by id
  @PutMapping("/Order/{id}/Product/{productId}")
  public void updateOrderProduct(@PathVariable Long id, @PathVariable Long productId) {
        orderService.updateOrderProduct(id, productId);
  }
*/
    
}
