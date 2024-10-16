package com.watson.bank.service;

import com.watson.bank.enums.CreditOperationEnum;
import com.watson.bank.req.CreditOperateReq;

/**
 * 额度调整service
 */
public abstract class AbstractCreditAdjustService {

    public abstract Boolean match(CreditOperationEnum operation);

    /**
     * 模板方法：
     */
    public Boolean adjustCredit(CreditOperateReq creditOperateReq) {
        commonPreCheck(creditOperateReq);
        specialPreCheck(creditOperateReq);
        executeAdjustment(creditOperateReq);
        return Boolean.TRUE;
    }

    /**
     * 一般参数检查
     */
    protected abstract void commonPreCheck(CreditOperateReq creditOperateReq);

    /**
     * 特殊参数检查
     */
    protected abstract void specialPreCheck(CreditOperateReq creditOperateReq);

    /**
     * 调整额度逻辑
     */
    protected abstract void executeAdjustment(CreditOperateReq creditOperateReq);
}
