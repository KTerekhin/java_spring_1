package ru.geekbrains.simple.market.components;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.simple.market.exceptions_handling.ResourceNotFoundException;
import ru.geekbrains.simple.market.model.OrderItem;
import ru.geekbrains.simple.market.model.Product;
import ru.geekbrains.simple.market.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
@Data
public class Cart {
    private final ProductService productService;
    private List<OrderItem> items;
    private int totalPrice;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>();
    }

    public void addProductToCart(Long id) {
        for (OrderItem o : items) {
            if (o.getProduct().getId().equals(id)) {
                o.incrementQuantity();
                recalculate();
                return;
            }
        }
        Product p = productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + id + " (add to cart)"));
        items.add(new OrderItem(p));
        recalculate();
    }

    public void decrementProductInCart(Long id) {
        for (OrderItem o : items) {
            if (o.getProduct().getId().equals(id)) {
                o.decrementQuantity();
                if (o.isEmpty()) {
                    items.remove(o);
                }
                recalculate();
                return;
            }
        }
    }

    public void clear() {
        items.clear();
        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (OrderItem o : items) {
            totalPrice += o.getPrice();
        }
    }
}
