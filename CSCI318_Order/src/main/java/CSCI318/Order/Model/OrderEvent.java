/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author liamt
 */
@Entity
@Table(name = "OrderEventTable")
public class OrderEvent {
    //Variables
    private @Id @GeneratedValue long orderId;
    private String customerId;
    private String customerAddress;
    private String customerPhone;
    private String productId;
    private String productPrice;
    private String quantity;

    //Default contstructor
    public OrderEvent(){};
    
    //contstuctor
    public OrderEvent(Order order) {
        super();
        this.setCustomerId(Long.toString(order.getCustomerId()));
        this.setProductId(Long.toString(order.getProductId()));
        this.setQuantity(Integer.toString(order.getQuantity()));
        this.setCustomerAddress(order.getCustomerAddress());
        this.setCustomerPhone(order.getCustomerPhone());
        this.setProductPrice(Double.toString(order.getProductPrice()));
    }
    
    //Getters
    public long getId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductId() {
        return productId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    
    //setters
    public void setId(long orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setCustomerAddress(String address) {
        this.customerAddress = address;
    }

    public void setCustomerPhone(String phone) {
        this.customerPhone = phone;
    }

    public void setProductPrice(String price) {
        this.productPrice = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    
    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", productId=" + productId + ", quantity=" + quantity + '}';
    }                                                                                                                       
}
