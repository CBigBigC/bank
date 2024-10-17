package com.watson.bank.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 信用操作枚举类
 * INIT：初始化信用卡额度
 * INCREASE：增加额度
 * DECREASE：扣减额度
 * RESET：重置额度
 */
@Getter
@AllArgsConstructor
public enum CreditOperationEnum {

    INIT("初始化", 0),
    INCREASE("增加额度", 1),
    DECREASE("扣减额度", -1),
    RESET("重置", 2);


    private final String desc;
    private final int code;
}
