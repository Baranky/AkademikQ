package com.example.odev.servis;

import com.example.odev.entity.Product;
import com.example.odev.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private  final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Optional<Product> getById(@PathVariable int id){
        return productRepository.findById(id);
    }

    public void save(@RequestBody Product product){
        productRepository.save(product);
    }

    public  void update(@PathVariable int id, @RequestBody Product product){
        Product newProduct=productRepository.getReferenceById(id);
        newProduct.setId(newProduct.getId());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setStock(product.getStock());
        productRepository.save(newProduct);
    }

    public  void  delete(@PathVariable int id){
        productRepository.deleteById(id);
    }

    public Product getReferenceById(int id) {
         return productRepository.getReferenceById(id);
    }
}
