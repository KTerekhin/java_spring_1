package ru.geekbrains.spring.data.Lesson_7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.data.Lesson_7.model.Product;
import ru.geekbrains.spring.data.Lesson_7.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findProductUpperThenMinPrice(int price) {
        return productRepository.getAllByPriceIsGreaterThanEqual(price);
    }

    public List<Product> findProductLowerThenMaxPrice(int price) {
        return productRepository.getAllByPriceIsLessThanEqual(price);
    }

    public List<Product> findProductBetweenTwoPrices(int minPrice, int maxPrice) {
        return productRepository.getAllByPriceBetween(minPrice, maxPrice);
    }
}
