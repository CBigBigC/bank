package com.watson.bank.service.credit.impl;

import com.watson.bank.req.CreditOperateReq;
import com.watson.bank.service.credit.AbstractCreditAdjustService;
import com.watson.bank.service.credit.CreditService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Resource
    private List<AbstractCreditAdjustService> abstractCreditAdjustServiceList;

    @Override
    public Boolean adjustCredit(CreditOperateReq creditOperateReq) {
        AbstractCreditAdjustService matchedCreditAdjustService = abstractCreditAdjustServiceList.stream()
                .filter(a -> a.match(creditOperateReq.getOperation()))
                .findFirst()
                .orElseThrow();
        return matchedCreditAdjustService.adjustCredit(creditOperateReq);
    }
}
