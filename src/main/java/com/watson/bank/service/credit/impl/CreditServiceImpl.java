package com.watson.bank.service.credit.impl;

import com.watson.bank.dao.AccountMapper;
import com.watson.bank.dao.CardMapper;
import com.watson.bank.dao.CreditOperateLogMapper;
import com.watson.bank.domain.Account;
import com.watson.bank.domain.Card;
import com.watson.bank.domain.CreditOperateLog;
import com.watson.bank.req.CreditOperateDto;
import com.watson.bank.service.credit.CreditService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class CreditServiceImpl implements CreditService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private CardMapper cardMapper;

    @Resource
    private CreditOperateLogMapper creditOperateLogMapper;

    @Override
    public Boolean adjustCredit(CreditOperateDto creditOperateDto) {
        Account account = accountMapper.selectById(creditOperateDto.getAccountId());
        BigDecimal oldCredit = account.getCurrentCredit();
        BigDecimal newCredit = calculateNewAmount(creditOperateDto, account);
        account.setCurrentCredit(newCredit);
        accountMapper.updateWithVersion(account);
        recordOperationLog(creditOperateDto, account, oldCredit, newCredit);
        return Boolean.TRUE;
    }

    private BigDecimal calculateNewAmount(CreditOperateDto creditOperateDto, Account account) {
        BigDecimal newCredit;
        switch (creditOperateDto.getOperation()) {
            case DECREASE:
                newCredit = account.getCurrentCredit().add(creditOperateDto.getOperateAmount());
                break;
            case INCREASE:
                newCredit = account.getCurrentCredit().subtract(creditOperateDto.getOperateAmount());
                break;
            case RESET:
                Card card = cardMapper.selectById(account.getCardId());
                newCredit = card.getDefaultCredit();
                break;
            default:
                newCredit = account.getCurrentCredit();
                break;
        }
        return newCredit;
    }

    @Async
    protected void recordOperationLog(CreditOperateDto creditOperateDto, Account account, BigDecimal oldCredit, BigDecimal newCredit) {
        CreditOperateLog creditOperateLog = CreditOperateLog.builder()
                .accountId(account.getId())
                .operateType(creditOperateDto.getOperation().name())
                .operatorId(creditOperateDto.getOperatorId())
                .creditBefore(oldCredit)
                .creditAfter(newCredit)
                .build();
        creditOperateLogMapper.insert(creditOperateLog);
    }

}
