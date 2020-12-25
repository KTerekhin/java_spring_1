package ru.geekbrains.context.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.context.hibernate.entity.Buyer;
import ru.geekbrains.context.hibernate.entity.Product;
import ru.geekbrains.context.hibernate.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Optional<List<Buyer>> getBuyersFromId(Long id) {
        Product product = productRepository.getProduct(id);
        if (product == null) {
            return null;
        }
        return Optional.of(product.getBuyers()
                .stream().collect(Collectors.toList()));
    }
}
