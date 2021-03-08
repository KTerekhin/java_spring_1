package ru.geekbrains.context.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.context.hibernate.entity.Buyer;
import ru.geekbrains.context.hibernate.entity.Product;
import ru.geekbrains.context.hibernate.repository.BuyerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BuyerService {

    @Autowired
    BuyerRepository buyerRepository;

    public Optional<List<Product>> getProductList(Long id) {
        Buyer buyer = buyerRepository.getBuyer(id);
        if (buyer == null) {
            return null;
        }
        return Optional.of(buyer.getProducts()/*);*/
                .stream().collect(Collectors.toList()));
    }
}
