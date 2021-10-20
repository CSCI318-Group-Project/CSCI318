/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Service;

import static java.lang.Thread.sleep;
import java.util.Random;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

/**
 *
 * @author liamt
 */
@Component
public class OrderLoader implements CommandLineRunner {
    private OrderService orderService;
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(OrderLoader.class);
    
    public OrderLoader(OrderService orderService){
        this.orderService = orderService;
    }
    
    @Override
    public void run(String... strings) throws Exception{
        log.info("Adding orders to the database...");
       
        for(int i = 0; i<5 ; i++){
            int quantity = 1;
            long custID = 0, productID = 0;
            while(custID%2 == 0){ //redo until odd to get correct id between 1-10
                custID = getRandom();
                //log.info("CustID: " + Long.toString(custID));
            }
            while(productID%2 == 0){ //redo until odd to get correct id between 1-10
                productID = getRandom();
                //log.info("ProductID: " + Long.toString(productID));
            }
            quantity = getRandom();
            //log.info("Quantity: " + Integer.toString(quantity));
       
            orderService.addNewOrder(custID, productID, quantity); 
            i++;
        }
        log.info("Finished adding orders to the database");
    }
    
    public int getRandom() {
        Random random = new Random();
    return random.nextInt(10 - 1) + 1;
}
}
