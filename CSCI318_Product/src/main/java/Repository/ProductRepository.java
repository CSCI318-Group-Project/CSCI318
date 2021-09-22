/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

/**
 *
 * @author liamt
 */
import Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//The Product repository
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
