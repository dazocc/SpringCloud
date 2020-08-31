package br.com.dazo.orderservice.api.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private Integer id;

    private String status;

    private String transaction;

    private Integer orderId;

    private BigDecimal amount;
}

