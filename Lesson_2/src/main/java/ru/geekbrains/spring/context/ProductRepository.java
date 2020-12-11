package ru.geekbrains.spring.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
//        for (Product s : products) {
//            return s;
//        }
        return Collections.unmodifiableList(products);
    }

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>();
        this.products.add(new Product(1L, "Coffee", 4.99f));
        this.products.add(new Product(2L, "Meat", 9.99f));
        this.products.add(new Product(3L, "Pizza", 7.49f));
        this.products.add(new Product(4L, "Juice", 2.49f));
        this.products.add(new Product(5L, "Ice cream", 0.69f));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Long productId) {
        products.remove(productId);
    }

    public Product getProductById(Long productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        throw new NullPointerException(String.format("Продукта с таким идентификатором не существует [id = %d]", productId));
    }
}
