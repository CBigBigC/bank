package com.watson.bank.controller;

import com.watson.bank.req.AccountOpenReq;
import com.watson.bank.service.account.AccountService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 账户控制类
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @ApiOperation("创建账户/开卡")
    @RequestMapping("open")
    public Boolean openAccount(@RequestBody AccountOpenReq account) {
        return accountService.openAccount(account);
    }
}
