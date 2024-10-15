package com.watson.bank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watson.bank.domain.Account;
import com.watson.bank.service.AccountService;
import com.watson.bank.dao.AccountMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【account(账户表)】的数据库操作Service实现
* @createDate 2024-10-15 15:12:48
*/
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account>
    implements AccountService{

}




