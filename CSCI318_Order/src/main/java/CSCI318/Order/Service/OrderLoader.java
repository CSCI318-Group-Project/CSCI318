/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Service;

import CSCI318.Order.Model.OrderEvent;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
//import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 *
 * @author liamt
 */
@Component
public class OrderLoader implements CommandLineRunner {
    private OrderService orderService;
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(OrderLoader.class);
    @Autowired
    private StreamBridge streamBridge;

    
    public OrderLoader(OrderService orderService,StreamBridge streamBridge){
        this.orderService = orderService;
        this.streamBridge = streamBridge;
    }
    
     public OrderEvent randomOrder()throws Exception{
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
       
            OrderEvent orderEvent = orderService.addNewOrder(custID, productID, quantity); 
            
            return orderEvent;
    }
            
    @Transactional
    public void sendOrders(OrderEvent orderEvent1, OrderEvent orderEvent2, OrderEvent orderEvent3){
        try{
            while(!Thread.currentThread().isInterrupted()){
                streamBridge.send("order-outbound", orderEvent1);
                Thread.sleep(1200);
                log.info("Order sent: " + orderEvent1.toString());
                
                streamBridge.send("order-outbound", orderEvent2);
                Thread.sleep(1200);
                log.info("Order sent: " + orderEvent2.toString());
                
                streamBridge.send("order-outbound", orderEvent3);
                Thread.sleep(1200);
                log.info("Order sent: " + orderEvent3.toString());
           }
       }
       catch(InterruptedException ignored){}
    }
    
    @Override
    public void run(String... strings) throws Exception{
        log.info("Adding orders to the database...");
        
        OrderEvent O1 = randomOrder();
        OrderEvent O2 = randomOrder();
        OrderEvent O3 = randomOrder();
        
        
        if(O1 != null && O2 != null && O3 != null){
                sendOrders(O1 , O2, O3);
            }
            else{
                log.error("orderEvent is null");
            }
            
        
        //log.info("Finished adding orders to the database");
    }
    
    public int getRandom() {
        Random random = new Random();
    return random.nextInt(10 - 1) + 1;
    }
}
