package ru.geekbrains.context.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.context.hibernate.entity.Buyer;
import ru.geekbrains.context.hibernate.entity.Product;
import ru.geekbrains.context.hibernate.service.BuyerService;
import ru.geekbrains.context.hibernate.service.ProductService;

@Component(value = "test")
public class Test {

    private BuyerService buyerService;
    private ProductService productService;
    private SessionFactory factory;

    @Autowired
    public Test (BuyerService buyerService, ProductService productService, SessionFactory factory) {
        this.buyerService = buyerService;
        this.productService = productService;
        this.factory = factory;
    }

    public void findProducts() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
                buyerService.getProductList(1L).ifPresent(
                        products -> products.stream()
                        .map(Product::getTitle)
                        .forEach(System.out::println));
        }
    }

    public void findBuyers() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            productService.getBuyersFromId(1L).ifPresent(
                    products -> products.stream()
                            .map(Buyer::getName)
                            .forEach(System.out::println));
        }
    }
}
