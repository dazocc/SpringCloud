package br.com.dazo.orderservice.api.controller;

import br.com.dazo.orderservice.api.common.Payment;
import br.com.dazo.orderservice.api.common.TransactionRequest;
import br.com.dazo.orderservice.api.common.TransactionResponse;
import br.com.dazo.orderservice.api.entity.Order;
import br.com.dazo.orderservice.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest) {
        return orderService.saveOrder(transactionRequest);
    }

}
