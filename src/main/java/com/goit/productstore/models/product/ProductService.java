package com.goit.productstore.models.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }

    public Product getByUuId(UUID uuid){
        return productRepository.findById(uuid).get();
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public void deleteById(UUID uuid){
        productRepository.deleteById(uuid);
    }
}
