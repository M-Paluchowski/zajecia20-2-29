package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Product> home() {
//        return productRepository.findAll();
//        return productRepository.findAllByOrderByPriceDesc();
//        return productRepository.findByAvailable(false);
//        return productRepository.findAllByAvailableTrue();
//        return productRepository.findAllByNameStartingWith("m");
//        return productRepository.findAllByNameStartingWithIgnoreCase("m");
//        return productRepository.findAllByPriceIsBetweenAndNameContaining(5.0, 7.5, "lek");
//        Optional<Product> byId = productRepository.findById(1L);

//        productRepository.deleteByName("Komputer");
        productRepository.deleteByNameNative("Komputer");
//        productRepository.save() //MA JUZ W SOBIE ADNOTACJE @RANSACTIONAL
//        return productRepository.findAllByPriceIn(List.of(199.99, 6000.0, 17.87));
//        return productRepository.findAll();
//        return productRepository.getProductsLikeWithPrice("Ma", 3.99);
//        return productRepository.getProductLikeWithPriceNative("Ma", 3.99);
        return productRepository.findAll();
    }
}
