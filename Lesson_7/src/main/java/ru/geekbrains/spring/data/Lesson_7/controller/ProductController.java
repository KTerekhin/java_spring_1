package ru.geekbrains.spring.data.Lesson_7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.data.Lesson_7.model.Product;
import ru.geekbrains.spring.data.Lesson_7.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/search_by")
    public List<Product> filterProducts(@RequestParam(name = "min_price", required = false) Integer minprice,
                                        @RequestParam(name = "max_price", required = false) Integer maxprice) {
        if (maxprice != null && minprice != null) {
            return productService.findProductBetweenTwoPrices(minprice, maxprice);
        } else if (maxprice == null){
            return productService.findProductUpperThenMinPrice(minprice);
        } else if (minprice == null) {
            return productService.findProductLowerThenMaxPrice(maxprice);
        }
        return productService.getAllProducts();
    }

}
