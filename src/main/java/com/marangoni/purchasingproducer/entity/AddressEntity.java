package com.marangoni.purchasingproducer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@Document(collection = "Address")
public class AddressEntity implements Serializable {
    @Id
    private String id;
    private String postalCode;
    private String streetName;
    private String number;
    private String additionalInfo;
}
