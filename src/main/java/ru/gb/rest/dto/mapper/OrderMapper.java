package ru.gb.rest.dto.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import ru.gb.rest.dao.ProductDao;
import ru.gb.rest.dto.OrderDto;
import ru.gb.rest.entity.Order;
import ru.gb.rest.entity.Product;

import java.util.NoSuchElementException;

@Mapper
public interface OrderMapper {

    Order toOrder(OrderDto orderDto, @Context ProductDao productDao);

    default Product getProduct(Long orderId, @Context ProductDao productDao) {
        return productDao.findById(orderId).orElseThrow(NoSuchElementException::new);
    }


}
