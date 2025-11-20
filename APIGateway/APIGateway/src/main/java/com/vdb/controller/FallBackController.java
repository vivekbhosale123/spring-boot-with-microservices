package com.vdb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {


    @GetMapping("/order")
    public ResponseEntity<String> fallBackOrder()
    {
        return ResponseEntity.ok("Order service is down plz wait");
    }

    @GetMapping("/product")
    public ResponseEntity<String> fallBackProduct()
    {
        return ResponseEntity.ok("Product service is down plz wait");
    }

    @GetMapping("/customer")
    public ResponseEntity<String> fallBackCustomer()
    {
        return ResponseEntity.ok("Customer service is down plz wait");
    }

}
