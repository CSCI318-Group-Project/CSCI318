/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSCI318.Order.Service;

import CSCI318.Order.Model.Order;
import CSCI318.Order.Model.OrderEvent;
import CSCI318.Order.Repository.OrderEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author liamt
 */
@Service
public class OrderEventService {
    private final OrderEventRepository orderEventRepository;
    private ApplicationEventPublisher publisher;

    OrderEventService(OrderEventRepository orderEventRepository, ApplicationEventPublisher publisher) {
        this.orderEventRepository = orderEventRepository;
        this.publisher = publisher;
    }

    @EventListener
    public void handle(OrderEvent orderEvent) {
        orderEventRepository.save(orderEvent);
    }

    public void recordOrder(Order order) {
        OrderEvent orderEvent = new OrderEvent(order);
        publisher.publishEvent(orderEvent);
    }
}
