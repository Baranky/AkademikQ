package com.example.odev.controller;

import com.example.odev.entity.Product;
import com.example.odev.servis.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {
    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<Product> getAll(){
         return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getById(@PathVariable int id){
        return productService.getById(id);
    }

    @PostMapping("/products")
    public void save(@RequestBody Product product){
        productService.save(product);
    }

    @PutMapping("/products/{id}")
    public  void update(@PathVariable int id, @RequestBody Product product){
        Product newProduct= productService.getReferenceById(id);
        newProduct.setId(newProduct.getId());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setStock(product.getStock());
        productService.save(newProduct);
    }

    @DeleteMapping("/products/{id}")
    public  void  delete(@PathVariable int id){
        productService.delete(id);
    }

}
