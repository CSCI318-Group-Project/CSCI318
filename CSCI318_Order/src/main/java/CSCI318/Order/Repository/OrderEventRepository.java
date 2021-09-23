/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Repository;

import CSCI318.Order.Model.OrderEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author liamt
 */
@Repository
public interface OrderEventRepository extends JpaRepository<OrderEvent, Long> {
    
}
