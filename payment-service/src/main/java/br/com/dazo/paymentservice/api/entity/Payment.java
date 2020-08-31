package br.com.dazo.paymentservice.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue
    private Integer id;

    private String status;

    private String transaction;

    private Integer orderId;

    private BigDecimal amount;
}

