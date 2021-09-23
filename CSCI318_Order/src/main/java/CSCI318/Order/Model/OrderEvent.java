/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author liamt
 */
@Entity
public class OrderEvent {
    private @Id @GeneratedValue Long orderId;
    private String supplier;
    private String productName;
    private int orderQuantity;
    
    OrderEvent(){}
    
    public OrderEvent(Order order){
        super();
        this.setSupplier(order.getSupplier());
        this.setOrderQuantity(order.getOrderQuantity());
        this.setProductName(order.getProductName());
    }

    //Getters
    public Long getOrderId() {
        return orderId;
    }
    public String getSupplier() {
        return supplier;
    }
    public String getProductName() {
        return productName;
    }
    public int getOrderQuantity() {
        return orderQuantity;
    }

    //Setters
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
     public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    
}
