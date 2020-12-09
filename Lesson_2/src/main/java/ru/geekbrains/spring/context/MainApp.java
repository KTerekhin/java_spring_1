package ru.geekbrains.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductApplicationConfig.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        System.out.println("Товары в магазине:" + "\n" + productRepository.getProducts() + "\n");

        Cart cart = context.getBean("cart", Cart.class);
        System.out.println("Ваша корзина:" + "\n" + cart.getProductsInCart() + "\n");

        Controller Controller = context.getBean("controller", Controller.class);
        Controller.formLogic();

        context.close();
    }
}
