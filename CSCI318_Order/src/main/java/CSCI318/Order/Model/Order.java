/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Model;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    private String productName;
    private int quantity;
    /*
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName= "customerId")
    private Customer customer;
    
    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "product_id", referencedColumnName= "productId")
    private Product product;
    */

    //Default contstructor
    public Order(){}
    
    //contstuctor
    public Order(String supplier, String productName, int quantity) {
        this.supplier = supplier;
        this.productName = productName;
        this.quantity = quantity;
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
    public int getQuantity() {
        return quantity;
    }
    /*
    public Customer getCustomer(){
        return customer;
    }
    public Product getProduct(){
        return product;
    }
    */
    
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
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /*
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    */

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.orderId);
        hash = 53 * hash + Objects.hashCode(this.supplier);
        hash = 53 * hash + Objects.hashCode(this.productName);
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
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        return Objects.equals(this.orderId, other.orderId);
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", supplier=" + supplier + ", product=" + productName + ", quantity=" + quantity + '}';
    }                                                                                                                       
}
