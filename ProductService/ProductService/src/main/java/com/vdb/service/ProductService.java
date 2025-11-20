package com.vdb.service;

import com.netflix.discovery.converters.Auto;
import com.vdb.entity.Product;
import com.vdb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

   @Autowired
    private ProductRepository productRepository;

   public Product save(Product product)
   {
       return productRepository.save(product);
   }

   public Optional<Product> findById(long productId)
   {
       return productRepository.findById(productId);
   }

   public Product findByProductName(String productName)
   {
       return productRepository.findByProductName(productName);
   }

   public List<Product> findAll()
   {
       return productRepository.findAll();
   }

   public Product update(Product product)
   {
       return productRepository.save(product);
   }

   public void deleteById(long productId)
   {
       productRepository.deleteById(productId);
   }

}
