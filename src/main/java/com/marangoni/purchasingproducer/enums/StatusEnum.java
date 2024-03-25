package com.marangoni.purchasingproducer.enums;

public enum StatusEnum {
    NEW,
    APPROVED,
    FINISHED,
    CANCELLED;


    private static final StatusEnum[] VALUES =
            StatusEnum.values();

    public static StatusEnum getInstanceFromStatus(String status){
        for (StatusEnum canalEnum : VALUES){
            if(canalEnum.name().equalsIgnoreCase(status)){
                return canalEnum;
            }
        }
        throw new IllegalArgumentException(String.format("Code do status not found %s ",status));
    }

    }
