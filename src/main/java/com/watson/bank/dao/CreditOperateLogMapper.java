package com.watson.bank.dao;

import com.watson.bank.domain.CreditOperateLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【credit_operate_log(额度操作日志表)】的数据库操作Mapper
* @createDate 2024-10-15 15:13:53
* @Entity generator.domain.CreditOperateLog
*/
@Mapper
public interface CreditOperateLogMapper extends BaseMapper<CreditOperateLog> {

}




