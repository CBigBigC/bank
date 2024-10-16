package com.watson.bank.service;

import com.watson.bank.req.CreditOperateReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Resource
    private List<AbstractCreditAdjustService> abstractCreditAdjustServiceList;

    @Override
    public Boolean adjustCredit(CreditOperateReq creditOperateReq) {
        AbstractCreditAdjustService matchedAbstractCreditAdjustService = abstractCreditAdjustServiceList.stream()
                .filter(a -> a.match(creditOperateReq.getOperation()))
                .findFirst()
                .orElseThrow();
        return matchedAbstractCreditAdjustService.adjustCredit(creditOperateReq);
    }
}
