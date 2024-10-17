package com.watson.bank.req;

import com.watson.bank.enums.CreditOperationEnum;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 额度调整请求实体类
 */
@Data
public class CreditOperateDto {

    /**
     * 账户id
     */
    @NotNull
    private Long accountId;

    /**
     * 操作人
     */
    @NotNull
    private Long operatorId;

    /**
     * 操作类型
     */
    @NotNull
    private CreditOperationEnum operation;

    /**
     * 操作基数
     */
    private BigDecimal operateAmount;

}
