/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Service;

import CSCI318.Order.Model.OrderEvent;
import static java.lang.Thread.sleep;
import java.util.Random;
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
    //private StreamBridge streamBridge;
    //private KafkaTemplate<String, OrderEvent> kafkaTemplate;
    
    public OrderLoader(OrderService orderService/*,KafkaTemplate<String, OrderEvent> kafkaTemplate StreamBridge streamBridge*/){
        this.orderService = orderService;
        //this.streamBridge = streamBridge;
        //this.kafkaTemplate = kafkaTemplate;
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
       
            OrderEvent orderEvent = orderService.addNewOrder(custID, productID, quantity); 
            if(orderEvent != null){
                //sendOrder(orderEvent);
            }
            else{
                log.error("orderEvent is null");
            }
            i++;
        }
        log.info("Finished adding orders to the database");
    }
    
    public int getRandom() {
        Random random = new Random();
    return random.nextInt(10 - 1) + 1;
    }
    
    /*
    public void sendOrder(OrderEvent orderEvent){
        try{
            while(!Thread.currentThread().isInterrupted()){
                streamBridge.send("order-outbound", orderEvent);
                Thread.sleep(1200);
                log.info("Order sent: " + orderEvent.toString());
           }
       }
        catch(InterruptedException ignored){}
    }
    
   
     public void sendOrder(OrderEvent orderEvent){
                kafkaTemplate.send("order-outbound", orderEvent); 
                log.info("Order sent: " + orderEvent.toString());
    }
     
    
    public void sendOrder(OrderEvent orderEvent) {
            
    ListenableFuture<SendResult<String, OrderEvent>> future = kafkaTemplate.send("order-outbound", orderEvent);
	
    future.addCallback(new ListenableFutureCallback<SendResult<String, OrderEvent>>() {

        @Override
        public void onSuccess(SendResult<String, OrderEvent> result) {
            log.info("Sent order=[" + orderEvent.toString() + 
              "] with offset=[" + result.getRecordMetadata().offset() + "]");
        }
        @Override
        public void onFailure(Throwable ex) {
            log.error("Unable to send message=[" 
              + orderEvent.toString() + "] due to : " + ex.getMessage());
        }
    });
    }
*/
    
}
