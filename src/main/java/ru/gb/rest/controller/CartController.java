//package ru.gb.rest.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ru.gb.rest.dto.CartDto;
//import ru.gb.rest.entity.Cart;
//
//import java.net.URI;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/cart")
//public class CartController {
//
//    private final Cart cart;
//
//    @GetMapping
//    public ResponseEntity<CartDto> handleGet() {
//        return new ResponseEntity<>(new CartDto(cart.getProducts()), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{productId}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void handleDelete(@PathVariable("productId") Long id) {
//        cart.removeProduct(id);
//    }
//
//    @PutMapping
//    public ResponseEntity<?> handlePut(@RequestBody String id) {
//        cart.addProduct(Long.parseLong(id));
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(URI.create("api/v1/cart/" + id));
//        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
//    }
//
//}
