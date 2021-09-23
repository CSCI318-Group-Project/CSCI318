/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Service;


import CSCI318.Order.Model.Order;
import CSCI318.Order.Repository.OrderRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author liamt
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    /*
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    */
    
    //Sets the repository for Orders
    @Autowired
    public OrderService(OrderRepository orderRepository/*, CustomerRepository customerRepository, ProductRepository productRepository*/) {
       this.orderRepository = orderRepository;
       /*
       this.customerRepository = customerRepository;
       this.productRepository = productRepository;
    */
    }
    
    //returns a list of all orders in the repositoy
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    
    //returns a single order from the repository
    public Optional<Order> getOrder(Long orderid){
        return orderRepository.findById(orderid);
    }

    //adds a list of new orders to the repository
    public void addNewOrder(Order[] orders){
        for (Order order : orders) {
            addNewOrder(order);
        }
    }
    
    //adds a new order to the repository
    public void addNewOrder(Order order){
        orderRepository.save(order);
    }
       
}
