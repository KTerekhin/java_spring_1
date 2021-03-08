package ru.geekbrains.simple.market.components;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.geekbrains.simple.market.dto.ProductDto;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class Cart {
    private List<ProductDto> productDtoList;

    @PostConstruct
    public void init() {
        productDtoList = new ArrayList<>();
    }

    public boolean addProductToCart(ProductDto productDto){
        return productDtoList.add(productDto);
    }

    public void removeProductById(Long id){
        productDtoList.removeIf(p -> p.getId() == id);
    }
}
