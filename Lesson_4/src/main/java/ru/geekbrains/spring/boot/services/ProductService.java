package ru.geekbrains.spring.boot.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.boot.model.Product;
import ru.geekbrains.spring.boot.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        return productRepository.getAllProducts();
    }

    public List<Product> findAll(Integer minCost, Integer maxCost) {
        List<Product> out = findAll();
        if (minCost != null) {
            out = out.stream().filter(p -> p.getCost() >= minCost).collect(Collectors.toList());
        }
        if (maxCost != null) {
            out = out.stream().filter(s -> s.getCost() <= maxCost).collect(Collectors.toList());
        }
        return out;
    }

    public Product saveOrUpdate(Product p) {
        return productRepository.saveOrUpdate(p);
    }

    public void deleteBydId(Long id) {
        productRepository.deleteById(id);
    }
}
