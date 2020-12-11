package ru.geekbrains.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "prototype")
public class Cart {
    private List<Product> productsInCart;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    @PostConstruct
    public void init() {
        productsInCart = new ArrayList<>();
    }

    public void addProduct(Long id) {
        try {
            productsInCart.add(productRepository.getProductById(id));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(Long id) {
        try {
            productsInCart.remove(productRepository.getProductById(id));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
