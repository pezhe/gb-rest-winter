package ru.gb.rest.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class Order {

    private final List<Product> products;

}
