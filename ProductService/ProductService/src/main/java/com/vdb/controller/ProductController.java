package com.vdb.controller;

import com.netflix.discovery.converters.Auto;
import com.vdb.entity.Product;
import com.vdb.exception.RecordNotFoundException;
import com.vdb.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@Valid @RequestBody Product product)
    {
        log.info("##### trying to save product{}", product.getProductName());
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/findbyid/{productId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable long productId)
    {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Product>> findAll()
    {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/sortbyproductname")
    public ResponseEntity<List<Product>> sortByProductName()
    {
        return ResponseEntity.ok(productService.findAll().stream().sorted(Comparator.comparing(Product::getProductName).reversed()).toList());
    }

    @GetMapping("/sortbyproductprice")
    public ResponseEntity<List<Product>> sortByProductPrice()
    {
        return ResponseEntity.ok(productService.findAll().stream().sorted(Comparator.comparing(Product::getProductPrice)).toList());
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> update(@PathVariable long productId,@RequestBody @Valid Product product)
    {
        Product product1=productService.findById(productId).orElseThrow(()->new RecordNotFoundException("Product Id Does Not Exists"));

        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setProductLaunchDate(product.getProductLaunchDate());

        return ResponseEntity.ok(productService.update(product1));
    }

    @DeleteMapping("/deletebyid/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable long productId)
    {
        productService.deleteById(productId);

        return ResponseEntity.ok("product deleted successfully");
    }

}
