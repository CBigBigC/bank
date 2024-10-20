package com.watson.bank.service.credit.impl;

import com.watson.bank.dao.AccountMapper;
import com.watson.bank.dao.CardMapper;
import com.watson.bank.dao.CreditOperateLogMapper;
import com.watson.bank.domain.Account;
import com.watson.bank.domain.Card;
import com.watson.bank.domain.CreditOperateLog;
import com.watson.bank.exception.BankErrorCodeEnum;
import com.watson.bank.exception.BusinessException;
import com.watson.bank.req.CreditOperateDto;
import com.watson.bank.service.credit.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

@Slf4j
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
        log.info("发起信用卡账户额度调整：{}", creditOperateDto);
        // 查询账户基本信息
        Account account = accountMapper.selectById(creditOperateDto.getAccountId());
        if (Objects.isNull(account)) {
            log.error("额度调整失败：账户不存在：{}", creditOperateDto);
            throw new BusinessException("账户不存在", "000");
        }
        //计算前后额度
        BigDecimal oldCredit = account.getCurrentCredit();
        BigDecimal newCredit = calculateNewCredit(creditOperateDto, account);
        log.info("账户：{}，调整前额度：{}调整后额度：{}", creditOperateDto.getAccountId(), oldCredit, newCredit);
        // 更新账户额度
        account.setCurrentCredit(newCredit);
        int updateResult = accountMapper.updateWithVersion(account);
        // 更新失败，抛出异常（数据库version乐观锁生效）
        if (updateResult != 1) {
            log.error("额度更新失败，DB数据记录更新失败，{}", creditOperateDto);
            throw new BusinessException(BankErrorCodeEnum.DUPLICATE_REQUEST_ERROR);
        }
        // 异步记录日志
        recordOperationLog(creditOperateDto, account, oldCredit, newCredit);
        return Boolean.TRUE;
    }

    private BigDecimal calculateNewCredit(CreditOperateDto creditOperateDto, Account account) {
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
        log.info("记录账户：{}额度调整操作日志", creditOperateDto.getAccountId());
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
