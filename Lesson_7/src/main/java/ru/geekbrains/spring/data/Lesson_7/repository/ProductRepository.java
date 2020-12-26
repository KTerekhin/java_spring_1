package ru.geekbrains.spring.data.Lesson_7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.data.Lesson_7.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllByPriceIsGreaterThanEqual(int price);
    List<Product> getAllByPriceIsLessThanEqual(int price);
    List<Product> getAllByPriceBetween(int minPrice, int maxPrice);
}
