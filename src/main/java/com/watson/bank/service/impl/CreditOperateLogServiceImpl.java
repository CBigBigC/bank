package com.watson.bank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watson.bank.domain.CreditOperateLog;
import com.watson.bank.service.CreditOperateLogService;
import com.watson.bank.dao.CreditOperateLogMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【credit_operate_log(额度操作日志表)】的数据库操作Service实现
* @createDate 2024-10-15 15:13:53
*/
@Service
public class CreditOperateLogServiceImpl extends ServiceImpl<CreditOperateLogMapper, CreditOperateLog>
    implements CreditOperateLogService{

}




