package ru.gb.manufacturercreator;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManufacturerDto {
    @JsonProperty(value = "id")
    private Long manufacturerId;
    private String name;
}
