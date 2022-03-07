package ru.gb.orderservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderDto orderDto;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody List<Long> productList) {
        orderDto.getProducts().addAll(productList);
        return orderDto;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder() {
        orderDto.getProducts().clear();
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto addProduct(@RequestBody String id) {
        orderDto.getProducts().add(Long.parseLong(id));
        return orderDto;
    }

    @PutMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto removeProduct(@RequestBody String id) {
        orderDto.getProducts().remove(Long.parseLong(id));
        return orderDto;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getOrderDto() {
        return orderDto;
    }

}
