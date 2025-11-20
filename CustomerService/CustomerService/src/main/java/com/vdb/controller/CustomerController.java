package com.vdb.controller;

import com.vdb.entity.Customer;
import com.vdb.exception.RecordNotFoundException;
import com.vdb.repository.CustomerRepository;
import com.vdb.service.CustomerService;
import com.vdb.vo.ResponseVo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody @Valid Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId, @PathVariable String custPassword) {
        return ResponseEntity.ok(customerService.signIn(custEmailId, custPassword));
    }

    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<ResponseVo> findById(@PathVariable long custId) {
        return ResponseEntity.ok(customerService.findById(custId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<Customer> update(@PathVariable long custId, @RequestBody @Valid Customer customer) {
        Customer customer1 = customerRepository.findById(custId).orElseThrow(() -> new RecordNotFoundException("Customer Id Does not exists"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustPassword(customer.getCustPassword());

        return ResponseEntity.ok(customerService.update(customer1));
    }

    @DeleteMapping("/findbyid/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable long custId) {
        customerService.deleteById(custId);

        return ResponseEntity.ok("Customer deleted Successfully");
    }


}
