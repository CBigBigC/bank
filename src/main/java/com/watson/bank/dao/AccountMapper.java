package com.watson.bank.dao;

import com.watson.bank.domain.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【account(账户表)】的数据库操作Mapper
* @createDate 2024-10-15 15:12:48
* @Entity generator.domain.Account
*/
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}




