package br.com.dazo.paymentservice.api.service;

import br.com.dazo.paymentservice.api.entity.Payment;
import br.com.dazo.paymentservice.api.repository.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private IPaymentRepository iPaymentRepository;

    public Payment saveOrder(Payment payment) {
        payment.setStatus(paymentProcessing());
        payment.setTransaction(UUID.randomUUID().toString());
        return iPaymentRepository.save(payment);
    }

    public String paymentProcessing() {
        return new Random().nextBoolean() ? "Success" : "Failure";
    }

    public Payment findPaymentHistoryByOrderId(Integer orderId){
        return iPaymentRepository.findByOrderId(orderId);
    }

}
