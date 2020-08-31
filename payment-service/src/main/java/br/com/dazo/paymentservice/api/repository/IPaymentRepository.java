package br.com.dazo.paymentservice.api.repository;

import br.com.dazo.paymentservice.api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findByOrderId(Integer orderId);

}
