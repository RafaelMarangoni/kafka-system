package com.marangoni.purchasingproducer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Document(collection = "payment")
public class PaymentEntity implements Serializable {

    @Id
    private String idInterno;
    private String id;
    private String method;
    private BigDecimal amount;
    private String status;

}