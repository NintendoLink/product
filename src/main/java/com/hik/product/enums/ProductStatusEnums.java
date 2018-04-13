package com.hik.product.enums;

public enum ProductStatusEnums {
    UP(1,"上架"),
    DOWN(0,"下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnums() {
    }

    ProductStatusEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
