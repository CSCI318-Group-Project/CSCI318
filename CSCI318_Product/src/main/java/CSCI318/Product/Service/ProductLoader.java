/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Product.Service;

import CSCI318.Product.Model.Product;
import CSCI318.Product.Model.ProductDetail;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author liamt
 */
@Component
public class ProductLoader implements CommandLineRunner {
    
    private final ProductService productService;
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProductLoader.class);
    
    public ProductLoader(ProductService productService){
        this.productService = productService;
    }
    
    @Override  
    public void run(String... strings) throws Exception{
        log.info("Adding products to the database...");
        productService.addNewProduct(new Product("Shoes" , "Boot", 1, 100 , new ProductDetail("Foot Protection", "Leather")));
        productService.addNewProduct(new Product("Appliances" , "Breville", 1, 100 , new ProductDetail("Cooks toast", "Stainless Steel")));
        productService.addNewProduct(new Product("Drinks" , "Coke", 1, 100 , new ProductDetail("Soft Drink", "Coca Cola 375ml Can")));
        productService.addNewProduct(new Product("Car" , "Rolls Royce", 1, 100 , new ProductDetail("Rolls Royce 1997", "Car")));
        productService.addNewProduct(new Product("Materials" , "Fertiliser", 1, 100 , new ProductDetail("Grass Fertiliser", "Mulch/Fertiliser")));
        log.info("Finished adding products to the database");
    }
    
}
