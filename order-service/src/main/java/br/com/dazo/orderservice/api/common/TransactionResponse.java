package br.com.dazo.orderservice.api.common;

import br.com.dazo.orderservice.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    private Order order;

    private BigDecimal amount;

    private String transaction;

    private String message;
}
