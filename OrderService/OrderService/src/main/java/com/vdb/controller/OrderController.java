package com.vdb.controller;

import com.vdb.entity.Order;
import com.vdb.exception.RecordNotFoundException;
import com.vdb.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody @Valid Order order)
    {
        log.info("######trying to save orders{}", order.getOrderDescription());
        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping("/findbyid/{orderId}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable long orderId)
    {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Order>> findAll()
    {
        return ResponseEntity.ok(orderService.findAll());
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<Order> update(@PathVariable long orderId,@RequestBody @Valid Order order)
    {
        Order order1=orderService.findById(orderId).orElseThrow(()->new RecordNotFoundException("Order Id Does not exists"));

        order1.setOrderDescription(order.getOrderDescription());
        order1.setOrderStartDate(order.getOrderStartDate());

        return ResponseEntity.ok(orderService.update(order1));

    }

    @PatchMapping("/changedescription/{orderId}/{orderDescription}")
    public ResponseEntity<Order> changeDescription(@PathVariable long orderId,@PathVariable String orderDescription)
    {
        Order order1=orderService.findById(orderId).orElseThrow(()->new RecordNotFoundException("Order Id Does not exists"));

        order1.setOrderDescription(orderDescription);

        return ResponseEntity.ok(order1);

    }

    @DeleteMapping("/deletebyid/{orderId}")
    public ResponseEntity<String> deleteById(@PathVariable long orderId)
    {
        orderService.deleteById(orderId);

        return ResponseEntity.ok("order deleted successfully");
    }

}
