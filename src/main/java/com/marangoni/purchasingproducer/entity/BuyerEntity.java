package com.marangoni.purchasingproducer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Document(collection = "buyer")
public class BuyerEntity implements Serializable {
    @Id
    private String idInterno;
    private String id;
    private String name;
    private String email;

}

