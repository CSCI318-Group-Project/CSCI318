/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Model;

import com.fasterxml.jackson.databind.JsonNode;
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
@Table(name = "OrderTable")
public class Order {
    //Variables
    private @Id @GeneratedValue Long orderId;
    private String supplier;
    private String productName;
    private int orderQuantity;

    //Default contstructor
    public Order(){};
    
    //contstuctor
    public Order(String supplier, String productName, int orderQuantity) {
        this.supplier = supplier;
        this.productName = productName;
        this.orderQuantity = orderQuantity;
    }
    
    //Getters
    public Long getId() {
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
    public void setId(Long orderId) {
        this.orderId = orderId;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.orderId);
        hash = 53 * hash + Objects.hashCode(this.supplier);
        hash = 53 * hash + Objects.hashCode(this.productName);
        hash = 53 * hash + this.orderQuantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.orderQuantity != other.orderQuantity) {
            return false;
        }
        if (!Objects.equals(this.supplier, other.supplier)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.orderId, other.orderId)) {
            return false;
        }
        return Objects.equals(this.orderId, other.orderId);
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", supplier=" + supplier + ", product=" + productName + ", orderQuantity=" + orderQuantity + '}';
    }                                                                                                                       

    public void setSupplier(JsonNode name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setProductName(JsonNode product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
