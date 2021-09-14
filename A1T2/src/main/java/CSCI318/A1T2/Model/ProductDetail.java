/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T2.Model;

import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author liamt
 */

@Table(name = "ProductDetail" )
public class ProductDetail {
    //Variables
    private @Id @GeneratedValue Long productDetaiId;
    private String description;
    private String comment;
    
    @OneToOne(mappedBy = "Product")
    private Product product;
    
    public ProductDetail(){};
    
    //Contstuctor
    public ProductDetail(String description, String comment, Product product) {
        this.description = description;
        this.comment = comment;
        this.product = product;
    }
    
    //Setters
    public void setProductDetaiId(Long productDetaiId) {
        this.productDetaiId = productDetaiId;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    
    //Getters
    public Long getProductDetaiId() {
        return productDetaiId;
    }
    public String getDescription() {
        return description;
    }
    public String getComment() {
        return comment;
    }
    public Product getProduct() {
        return product;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.productDetaiId);
        hash = 41 * hash + Objects.hashCode(this.description);
        hash = 41 * hash + Objects.hashCode(this.comment);
        hash = 41 * hash + Objects.hashCode(this.product);
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
        final ProductDetail other = (ProductDetail) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.productDetaiId, other.productDetaiId)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductDetail{" + "productDetaiId=" + productDetaiId + ", description=" + description + ", comment=" + comment + ", product=" + product + '}';
    }
    
    
    
}
