package com.marangoni.purchasingproducer.enums;

public enum MethodPaymentEnum {

    CREDIT,
    DEBIT,
    GIFT_CARD,
    OTHER;

    private static final MethodPaymentEnum[] VALUES =
            MethodPaymentEnum.values();

    public static MethodPaymentEnum getInstanceFromMethodStatus(String status){
        for (MethodPaymentEnum paymentMethodEnum : VALUES){
            if(paymentMethodEnum.name().equalsIgnoreCase(status)){
                return paymentMethodEnum;
            }
        }
        throw new IllegalArgumentException(String.format("Code do method payment not found %s ",status));
    }
}
