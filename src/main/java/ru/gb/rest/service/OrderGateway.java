package ru.gb.rest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.gb.rest.dto.OrderDto;

import java.util.List;

@FeignClient(url = "localhost:8735/order", value = "orderGateway")
public interface OrderGateway {

    @PostMapping
    OrderDto createOrder(@RequestBody List<Long> productList);

    @DeleteMapping
    void deleteOrder();

    @PutMapping("/add")
    OrderDto addProduct(@RequestBody String id);

    @PutMapping("/remove")
    OrderDto removeProduct(@RequestBody String id);

    @GetMapping
    OrderDto getOrder();

}
