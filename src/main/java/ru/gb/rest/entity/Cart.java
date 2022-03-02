//package ru.gb.rest.entity;
//
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import ru.gb.rest.service.ProductService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Getter
//@RequiredArgsConstructor
//@Component
//public class Cart {
//
//    private final List<Product> products = new ArrayList<>();
//    private final ProductService productService;
//
//    public void addProduct(Long id) {
//        if (products.stream().anyMatch((p) -> p.getId().equals(id))) return;
//        products.add(productService.findById(id));
//    }
//
//    public void removeProduct(Long id) {
//        products.stream()
//                .filter((p) -> p.getId().equals(id))
//                .findAny()
//                .ifPresent(products::remove);
//    }
//
//}
