package ru.gb.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.gb.rest.entity.Product;

import java.util.List;

@Getter
@AllArgsConstructor
public class CartDto {

    private List<Product> products;

}
