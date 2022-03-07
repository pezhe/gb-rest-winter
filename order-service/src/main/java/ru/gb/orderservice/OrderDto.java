package ru.gb.orderservice;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class OrderDto {

    private final List<Long> products = new ArrayList<>();

}
