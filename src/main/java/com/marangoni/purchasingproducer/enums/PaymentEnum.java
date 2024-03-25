package com.marangoni.purchasingproducer.enums;

public enum PaymentEnum {
    PENDING,
    APPROVED,
    REFUSED;

    private static final PaymentEnum[] VALUES =
            PaymentEnum.values();

    public static PaymentEnum getInstanceFromPaymentStatus(String status){
        for (PaymentEnum paymentEnum : VALUES){
            if(paymentEnum.name().equalsIgnoreCase(status)){
                return paymentEnum;
            }
        }
        throw new IllegalArgumentException(String.format("Code do status payment payment not found %s ",status));
    }

}

