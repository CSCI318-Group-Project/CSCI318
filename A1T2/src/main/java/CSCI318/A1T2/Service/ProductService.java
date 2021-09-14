/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.A1T2.Service;

import CSCI318.A1T2.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author liamt
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;
    
    //Sets the repository for product
    @Autowired
    public ProductService(ProductRepository productRepository) {
       this.productRepository = productRepository;
    }
}
