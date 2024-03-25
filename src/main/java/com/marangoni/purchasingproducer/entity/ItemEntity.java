package com.marangoni.purchasingproducer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Document(collection = "items")
public class ItemEntity implements Serializable {

    @Id
    private String id;
    private String itemId;
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private String url;


}
