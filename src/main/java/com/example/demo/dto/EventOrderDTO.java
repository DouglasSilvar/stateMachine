package com.example.demo.dto;

import com.example.demo.enums.OrderEvents;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventOrderDTO {

    private Long id;
    private OrderEvents event;
}
