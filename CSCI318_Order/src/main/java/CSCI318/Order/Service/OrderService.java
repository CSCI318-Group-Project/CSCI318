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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    //adds a new order to the repository
    public void addNewOrder(Long custID, Long productID, int quantity) throws JsonProcessingException{
        RestTemplate restTemplate = new RestTemplate();

        //validate the customersID and return the customers phone and address
        String customerUrl = "http://localhost:1010/Customer/Validate/";
        ResponseEntity<String> customerResponse = restTemplate.getForEntity(customerUrl + custID , String.class);
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode custRoot = mapper.readTree(customerResponse.getBody());
        
        String customerAddress = custRoot.path("address").toString().replace("\"", "");
        String customerPhone = custRoot.path("phone").toString().replace("\"", "");

        //validate the productID and return the products price if there is enough stock
        String productUrl = "http://localhost:2020/Product/CheckInventory/";
        ResponseEntity<String> productResponse = restTemplate.getForEntity(productUrl + productID + "/" + quantity , String.class);
        System.out.println(productResponse);

        JsonNode prodRoot = mapper.readTree(productResponse.getBody());
        double productPrice = prodRoot.doubleValue();
        
        if (productPrice <= 0) {
               //the productID was not valid or there was not enough stock availible
               return;
        }
        
        //Create the order
        Order order = new Order(custID, productID, quantity, customerAddress, customerPhone, productPrice);
        orderRepository.save(order); 
        
        //Update the product DB to reflect the change in quantity
        String productUpdateUrl = "http://localhost:2020/Product/UpdateStock/";
        ResponseEntity<String> productUpdateResponse = restTemplate.getForEntity(productUpdateUrl + productID + "/" + quantity , String.class);
        System.out.println(productUpdateResponse);
    }
       
}
