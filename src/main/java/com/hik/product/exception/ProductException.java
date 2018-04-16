package com.hik.product.exception;

import com.hik.product.enums.ResultEnum;

public class ProductException extends RuntimeException {
    private Integer code;
    private String message;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
