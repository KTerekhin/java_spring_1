package ru.geekbrains.spring.boot.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring.boot.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>();
        this.products.add(new Product(1L, "Coffee", 4.99f));
        this.products.add(new Product(2L, "Meat", 9.99f));
        this.products.add(new Product(3L, "Pizza", 7.49f));
        this.products.add(new Product(4L, "Juice", 2.49f));
        this.products.add(new Product(5L, "Ice cream", 0.69f));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product saveOrUpdate(Product p) {
        if (p.getId() != null) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(p.getId())) {
                    products.set(i, p);
                    return p;
                }
            }
        }

        Long newId = products.stream().mapToLong(Product::getId).max().orElseGet(() -> 0L) + 1L;
        p.setId(newId);
        products.add(p);
        return p;
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public Optional<Product> findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
