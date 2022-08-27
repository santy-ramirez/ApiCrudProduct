package com.informatorio.product.controller;

import com.informatorio.product.domain.Product;
import com.informatorio.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private  ProductRepository productRepository;


    @PostMapping
        public Product createProduct(@RequestBody  Product product){
        return productRepository.save(product);
}

    @GetMapping
        public List<Product> getAll(){
        List<Product> products = productRepository.findAll();
        return products;
}
    @DeleteMapping
        public String deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return "deleted correct with id number " + id;
    }

    @PutMapping
    public Product updateProduct(@PathVariable Long id , @RequestBody Product product)  {
       Product productToUpdate = productRepository.findById(id).orElse(null);
       productToUpdate.setId(id);
       productToUpdate.setName(product.getName());
       return productToUpdate;
    }
}
