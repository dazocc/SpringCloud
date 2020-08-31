package br.com.dazo.orderservice.api.service;

import br.com.dazo.orderservice.api.common.Payment;
import br.com.dazo.orderservice.api.common.TransactionRequest;
import br.com.dazo.orderservice.api.common.TransactionResponse;
import br.com.dazo.orderservice.api.entity.Order;
import br.com.dazo.orderservice.api.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    public static final String SUCCESS = "Success";
    @Autowired
    private IOrderRepository iOrderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest transactionRequest) {

        Order order = transactionRequest.getOrder();

        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/payment/", payment, Payment.class);
        String message = paymentResponse.getStatus().equals(SUCCESS) ? "Payment processing successful" : "Payment processing failure";

        order = iOrderRepository.save(order);

        return new TransactionResponse(order, paymentResponse.getAmount(), payment.getTransaction(), message);
    }

}
