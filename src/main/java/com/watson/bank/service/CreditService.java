package com.watson.bank.service;

import com.watson.bank.req.CreditOperateReq;

public interface CreditService {

    Boolean adjustCredit(CreditOperateReq creditOperateReq);

}
