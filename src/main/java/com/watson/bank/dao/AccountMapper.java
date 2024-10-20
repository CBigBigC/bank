package com.watson.bank.dao;

import com.watson.bank.domain.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author watson
*/
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 乐观锁更新（version字段校验）
     */
    int updateWithVersion(@Param("account") Account account);
}




