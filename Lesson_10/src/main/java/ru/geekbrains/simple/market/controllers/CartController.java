package ru.geekbrains.simple.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.simple.market.dto.ProductDto;
import ru.geekbrains.simple.market.exceptions_handling.ProductNotFoundException;
import ru.geekbrains.simple.market.model.Product;
import ru.geekbrains.simple.market.services.CartService;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<ProductDto> showCart (){
        return cartService.showCart();
    }

    @PostMapping("/add/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addProductIntoCart(@PathVariable Long id) throws ProductNotFoundException {
        cartService.addProductToCart(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductFromCart(@PathVariable Long id) throws ProductNotFoundException {
        cartService.deleteProductFromCart(id);
    }
}
