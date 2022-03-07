package ru.gb.rest.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.rest.dao.ManufacturerDao;
import ru.gb.rest.dto.mapper.ProductMapper;
import ru.gb.rest.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@Component
public class Cart {

    private final List<Product> products = new ArrayList<>();
    private final ProductService productService;
    private final ProductMapper productMapper;
    private final ManufacturerDao manufacturerDao;

    public void addProduct(Long id) {
        if (products.stream().anyMatch((p) -> p.getId().equals(id))) return;
        products.add(productMapper.toProduct(productService.findById(id), manufacturerDao));
    }

    public void removeProduct(Long id) {
        products.stream()
                .filter((p) -> p.getId().equals(id))
                .findAny()
                .ifPresent(products::remove);
    }

}
