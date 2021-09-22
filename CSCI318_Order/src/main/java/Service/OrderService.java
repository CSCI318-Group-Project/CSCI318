/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Model.Order;
import Repository.OrderRepository;
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
    
    //updates a order within the repository
    @Transactional
    public void updateOrder(Long orderid, String supplier, String productName, int quantity){
        Order order = orderRepository.findById(orderid)
                .orElseThrow(()-> new IllegalStateException("Order with id " + orderid + " does not exist" ));
        
        if(supplier != null && supplier.length() > 0 && !Objects.equals(order.getSupplier(), supplier)){
            order.setSupplier(supplier);
        }
        
        if(productName != null && productName.length() > 0 && !Objects.equals(order.getProductName(), productName)){
            order.setProductName(productName);
        }
        
        if(quantity > 0 && !Objects.equals(order.getQuantity(), quantity)){
            order.setQuantity(quantity);
        }
        
    }
    
    /*
    //updates customer for the order by id
    public Order updateOrderCustomer(@PathVariable Long id, @PathVariable Long customerId) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);       
        Customer customer = customerRepository.findById(customerId).orElseThrow(RuntimeException::new);
        order.setCustomer(customer);
        return orderRepository.save(order);
    }
    
    //updates product for the order by id
    public Order updateOrderProduct(@PathVariable Long id, @PathVariable Long productId) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new);
        order.setProduct(product);
        return orderRepository.save(order);
    }
    */
    
}
