package ru.gb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.rest.dao.ProductDao;
import ru.gb.rest.dto.OrderDto;
import ru.gb.rest.dto.mapper.OrderMapper;
import ru.gb.rest.entity.Cart;
import ru.gb.rest.entity.Order;
import ru.gb.rest.entity.Product;
import ru.gb.rest.service.OrderGateway;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final Cart cart;
    private final OrderGateway orderGateway;
    private final OrderMapper orderMapper;
    private final ProductDao productDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder() {
        List<Long> idList = cart.getProducts().stream().map(Product::getId).collect(Collectors.toList());
        return orderGateway.createOrder(idList);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder() {
        orderGateway.deleteOrder();
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto addProduct(@RequestBody String id) {
        return orderGateway.addProduct(id);
    }

    @PutMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto removeProduct(@RequestBody String id) {
        return orderGateway.removeProduct(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Order getOrder() {
        return orderMapper.toOrder(orderGateway.getOrder(), productDao);
    }

}
