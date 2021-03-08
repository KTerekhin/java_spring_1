package ru.geekbrains.context.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.context.hibernate.entity.Product;

@Component
public class ProductRepository {
    SessionFactory factory;

    @Autowired
    public ProductRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public Product getProduct(Long productId) {
        Session session = factory.getCurrentSession();
        Product product = session.get(Product.class, productId);
        session.getTransaction().commit();
        System.out.println(product.toString());
        return product;
    }
}
