package com.watson.bank.service.account;

import com.watson.bank.domain.Account;
import com.watson.bank.req.AccountOpenReq;

/**
 * @author watson
 */
public interface AccountService {

    int updateAccount(Account account);

    Boolean openAccount(AccountOpenReq account);
}
