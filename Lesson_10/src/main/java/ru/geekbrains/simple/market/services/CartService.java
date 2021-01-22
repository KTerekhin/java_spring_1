package ru.geekbrains.simple.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.simple.market.dto.ProductDto;
import ru.geekbrains.simple.market.exceptions_handling.ProductNotFoundException;
import ru.geekbrains.simple.market.model.Product;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CartService {
    private List<ProductDto> productInCartList;
    private final ProductService productService;

    @PostConstruct
    public void init() {
        productInCartList = new ArrayList<>();
    }

    public List<ProductDto> showCart() {
        return productInCartList;
    }

    public void addProductToCart(Long id) throws ProductNotFoundException {
        productInCartList.add(productService.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Продукт не найден в магазине")));
    }

    public void deleteProductFromCart(Long id) throws ProductNotFoundException {
        productInCartList.remove(productService.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Продукт не найден в корзине")));
    }
}
