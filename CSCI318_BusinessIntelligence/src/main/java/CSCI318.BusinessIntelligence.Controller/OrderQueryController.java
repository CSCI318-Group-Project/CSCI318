package CSCI318.BusinessIntelligence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderQueryController {

    @Autowired
    ProductInteractiveQuery productInteractiveQuery;

    @GetMapping("/Product/{productName}")
    long getProductQuantityByName(@PathVariable String productName) {
        return productInteractiveQuery.getProductQuantity(productName);
    }

    @GetMapping("/Product")
    List<String> getAllProduct() {
        return productInteractiveQuery.getProductNames();
    }

}