package com.watson.bank.service.credit;

import com.watson.bank.req.CreditOperateReq;

/**
 * 额度操作service定义
 * 具体实现下沉到: #AbstractCreditAdjustService
 *
 */
public interface CreditService {

    Boolean adjustCredit(CreditOperateReq creditOperateReq);

}
