package com.example.demo.dto;

import com.example.demo.enums.OrderStates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private OrderStates orderStates;
    private String mensagem;
}
