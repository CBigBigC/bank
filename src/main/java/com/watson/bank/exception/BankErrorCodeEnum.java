package com.watson.bank.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BankErrorCodeEnum {

    DUPLICATE_REQUEST_ERROR("ERROR-001", "存在进行中的请求"),
    ILLEGAL_PARAM("ERROR-002", "参数不合法");

    private final String code;
    private final String message;
}
