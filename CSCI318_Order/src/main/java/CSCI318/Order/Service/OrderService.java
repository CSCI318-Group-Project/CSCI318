/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Service;


import CSCI318.Order.Model.Order;
import CSCI318.Order.Repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;

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
    
    //returns a list of all orders in the repositoy
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
    
    //returns a single order from the repository
    public Optional<Order> getOrder(Long orderid){
        return orderRepository.findById(orderid);
    }

    /*
    //adds a list of new orders to the repository
    public void addNewOrder(Order[] orders){
        for (Order order : orders) {
            addNewOrder(order);
        }
    }
    */
    //adds a new order to the repository
    public void addNewOrder(Order order, Long customerId, Long productId) throws JsonProcessingException{
        RestTemplate restTemplate = new RestTemplate();
        String customerUrl = "http://localhost:1010/Customer";
        ResponseEntity<String> customerResponse = restTemplate.getForEntity(customerUrl + customerId , String.class);
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode custRoot = mapper.readTree(customerResponse.getBody());
        String companyName = custRoot.path("companyName").toString();
        order.setSupplier(companyName);
        
        String productUrl = "http://localhost:1010/Product";
        ResponseEntity<String> productResponse = restTemplate.getForEntity(productUrl + productId , String.class);
        
        JsonNode prodRoot = mapper.readTree(productResponse.getBody());
        String product = prodRoot.path("name").toString();
        order.setProductName(product);
        
        orderRepository.save(order);
    }
       
}
