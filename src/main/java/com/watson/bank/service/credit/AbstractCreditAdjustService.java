package com.watson.bank.service.credit;

import com.watson.bank.enums.CreditOperationEnum;
import com.watson.bank.req.CreditOperateReq;

/**
 * 额度金额调整抽象类
 * 定义额度调整的处理模版：
 * - 参数检查
 * - 特殊检查
 * - 诊室调整
 * 实现类分别需要处理 初始化、上调、下调等金额调整
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
    private void commonPreCheck(CreditOperateReq creditOperateReq) {
        // TODO: 这里一般是初步权限检查、参数校验等
        if (creditOperateReq.getOperatorId() != 0) {
            throw new RuntimeException();
        }
    }

    /**
     * 特殊参数检查
     */
    protected abstract void specialPreCheck(CreditOperateReq creditOperateReq);

    /**
     * 额度调整逻辑
     */
    protected abstract void executeAdjustment(CreditOperateReq creditOperateReq);
}
