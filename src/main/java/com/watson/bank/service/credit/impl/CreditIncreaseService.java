package com.watson.bank.service.credit.impl;

import com.watson.bank.domain.Account;
import com.watson.bank.domain.CreditOperateLog;
import com.watson.bank.enums.CreditOperationEnum;
import com.watson.bank.req.CreditOperateReq;
import com.watson.bank.service.account.AccountService;
import com.watson.bank.service.credit.AbstractCreditAdjustService;
import com.watson.bank.service.credit.CreditOperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

@Slf4j
@Service
public class CreditIncreaseService extends AbstractCreditAdjustService {

    @Resource
    private AccountService accountService;

    @Resource
    private CreditOperateLogService creditOperateLogService;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Override
    public Boolean match(CreditOperationEnum operation) {
        return Objects.equals(operation, CreditOperationEnum.INCREASE);
    }

    @Override
    protected void specialPreCheck(CreditOperateReq creditOperateReq) {
        if (!Objects.equals(creditOperateReq.getOperation(), CreditOperationEnum.INCREASE)) {
            throw new IllegalArgumentException("非法：非上调操作");
        }
        if (Objects.isNull(creditOperateReq.getOperateAmount()) ||
                creditOperateReq.getOperateAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("非法：操作金额异常");
        }

    }

    @Override
    protected void executeAdjustment(CreditOperateReq creditOperateReq) {
        Account account = accountService.getById(creditOperateReq.getAccountId());

        // 事务消息（账户更新 + 调整记录）
        transactionTemplate.executeWithoutResult(status -> {
            try {
                BigDecimal newCredit = account.getCurrentCredit().add(creditOperateReq.getOperateAmount());
                CreditOperateLog creditOperateLog = CreditOperateLog.builder()
                        .operatorId(creditOperateReq.getOperatorId())
                        .accountId(account.getId())
                        .creditBefore(account.getCurrentCredit())
                        .creditAfter(newCredit)
                        .operateType(creditOperateReq.getOperation().name())
                        .build();
                account.setCurrentCredit(newCredit);
                int updateSuccess = accountService.updateAccount(account);
                if (updateSuccess != 1) {
                    throw new RuntimeException();
                }
                creditOperateLogService.save(creditOperateLog);
            } catch (Exception e) {
                log.error("额度调整失败", e);
                throw e;
            }
        });
    }

}
