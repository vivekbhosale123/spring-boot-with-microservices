package com.vdb.service;

import com.vdb.entity.Order;
import com.vdb.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Cacheable(value = "orderId")
    public Optional<Order> findById(long orderId) {
        log.info("#### Tyring to fetch data from DB");
        return orderRepository.findById(orderId);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order update(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(long orderId) {
        orderRepository.deleteById(orderId);
    }

}
