package com.watson.bank.service.account;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watson.bank.domain.Account;
import com.watson.bank.dao.AccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author watson
*/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{

    @Resource
    private AccountMapper accountMapper;

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateWithVersion(account);
    }
}




