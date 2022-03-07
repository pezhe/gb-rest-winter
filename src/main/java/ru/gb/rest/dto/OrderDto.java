package ru.gb.rest.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class OrderDto {

    private List<Long> products;

}
