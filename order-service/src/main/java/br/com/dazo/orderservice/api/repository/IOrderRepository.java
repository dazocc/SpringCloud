package br.com.dazo.orderservice.api.repository;

import br.com.dazo.orderservice.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
