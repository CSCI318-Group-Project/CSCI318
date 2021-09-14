/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T2.Model;

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
@Table(name = "Order")
public class Order {
    //Variables
    private @Id @GeneratedValue Long orderId;
    private String supplier;
    private String product;
    private int quantity;

    //Default contstructor
    public Order(){};
    
    //contstuctor
    public Order(String supplier, String product, int quantity) {
        this.supplier = supplier;
        this.product = product;
        this.quantity = quantity;
    }
    
    //Getters
    public Long getId() {
        return orderId;
    }
    public String getSupplier() {
        return supplier;
    }
    public String getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    
    //Setters
    public void setId(Long orderId) {
        this.orderId = orderId;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.orderId);
        hash = 53 * hash + Objects.hashCode(this.supplier);
        hash = 53 * hash + Objects.hashCode(this.product);
        hash = 53 * hash + this.quantity;
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
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.supplier, other.supplier)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return Objects.equals(this.orderId, other.orderId);
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", supplier=" + supplier + ", product=" + product + ", quantity=" + quantity + '}';
    }                                                                                                                       
}
