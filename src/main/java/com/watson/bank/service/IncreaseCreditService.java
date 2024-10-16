package com.watson.bank.service;

import com.watson.bank.enums.CreditOperationEnum;
import com.watson.bank.req.CreditOperateReq;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IncreaseCreditService extends AbstractCreditAdjustService{

    @Override
    public Boolean match(CreditOperationEnum operation) {
        return Objects.equals(operation, CreditOperationEnum.INCREASE);
    }

    @Override
    protected void commonPreCheck(CreditOperateReq creditOperateReq) {

    }

    @Override
    protected void specialPreCheck(CreditOperateReq creditOperateReq) {

    }

    @Override
    protected void executeAdjustment(CreditOperateReq creditOperateReq) {

    }
}
