package com.watson.bank.service.account;

import com.watson.bank.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author watson
*/
public interface AccountService extends IService<Account> {

    int updateAccount(Account account);

}
