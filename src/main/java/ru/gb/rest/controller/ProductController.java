package ru.gb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.gb.rest.dto.ProductDto;
import ru.gb.rest.dto.ProductManufacturerDto;
import ru.gb.rest.entity.Product;
import ru.gb.rest.service.ProductService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductDto> getProductList() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<? extends ProductDto> getProduct(@PathVariable("productId") Long id) {
        if(id != null) {
            ProductDto productDto = productService.findById(id);
            if (productDto != null) {
                return new ResponseEntity<>(productDto, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> handlePost(@Validated @RequestBody ProductDto productDto) {
        //productDto.setManufacturer(1L);
        ProductDto savedProduct = productService.save(productDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(URI.create("api/v1/product/" + savedProduct.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> handleUpdate(@PathVariable("productId") Long id,
                                          @Validated @RequestBody ProductDto productDto) {
        productDto.setId(id);
        //productDto.setManufacturer(1L);
        productService.save(productDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteById(@PathVariable("productId") Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/info")
    public List<ProductManufacturerDto> getInfoProductList() {
        return productService.findAllInfo();
    }

}
