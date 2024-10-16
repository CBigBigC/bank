package com.watson.bank.req;

import com.watson.bank.enums.CreditOperationEnum;
import lombok.Data;

/**
 * 额度调整请求实体类
 */
@Data
public class CreditOperateReq {

    /**
     * 账户id
     */
    private String accountId;

    /**
     * 操作人
     */
    private String operatorId;

    /**
     * 操作类型
     */
    private CreditOperationEnum operation;

}
