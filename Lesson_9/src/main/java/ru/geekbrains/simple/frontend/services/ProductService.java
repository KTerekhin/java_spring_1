package ru.geekbrains.simple.frontend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.simple.frontend.dto.ProductDto;
import ru.geekbrains.simple.frontend.model.Product;
import ru.geekbrains.simple.frontend.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<ProductDto> findProductById(Long id) {
        return Optional.of(new ProductDto(productRepository.findById(id).get()));
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public Page<ProductDto> findAll(int page) {
        Page<Product> originalPage = productRepository.findAll(PageRequest.of(page - 1, 10));
        return new PageImpl<>(originalPage.getContent().stream().map(ProductDto::new).collect(Collectors.toList()), originalPage.getPageable(), originalPage.getTotalElements());
    }

    public ProductDto saveOrUpdate(Product product) {
        return new ProductDto(productRepository.save(product));
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
