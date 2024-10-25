package com.test.common.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class OrderDto {
    private String name;
    private String customerId;
    private String productType;
    private int quantity;
    private BigDecimal price;
}