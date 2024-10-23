package com.watson.bank.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BankErrorCodeEnum {

    DUPLICATE_REQUEST_ERROR("DUPLICATE_REQUEST_ERROR", "存在进行中的请求"),
    ACCOUNT_NOT_EXIST("ACCOUNT_NOT_EXIST", "账户不存在"),
    ILLEGAL_PARAM("ILLEGAL_PARAM", "参数不合法");

    private final String code;
    private final String message;
}
