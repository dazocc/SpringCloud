package br.com.dazo.orderservice.api.common;

import br.com.dazo.orderservice.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Order order;

    private Payment payment;
}
