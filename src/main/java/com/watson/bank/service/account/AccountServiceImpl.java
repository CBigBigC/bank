package com.watson.bank.service.account;

import com.watson.bank.dao.AccountMapper;
import com.watson.bank.dao.CardMapper;
import com.watson.bank.domain.Account;
import com.watson.bank.domain.Card;
import com.watson.bank.req.AccountOpenReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author watson
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private CardMapper cardMapper;

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateWithVersion(account);
    }

    @Override
    public Boolean openAccount(AccountOpenReq accountOpenReq) {
        Card card = cardMapper.selectById(accountOpenReq.getCardId());
        Account account = Account.builder()
                .userId(accountOpenReq.getUserId())
                .cardId(card.getId())
                .maxCredit(card.getDefaultCredit())
                .currentCredit(card.getDefaultCredit())
                .build();
        accountMapper.insert(account);
        return null;
    }
}




