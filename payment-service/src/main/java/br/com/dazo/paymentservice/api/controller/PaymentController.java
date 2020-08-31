package br.com.dazo.paymentservice.api.controller;

import br.com.dazo.paymentservice.api.entity.Payment;
import br.com.dazo.paymentservice.api.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/")
    public Payment bookOrder(@RequestBody Payment payment) {
        return paymentService.saveOrder(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable Integer orderId) {
        logger.info("Port server is: " + port);
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }

}
