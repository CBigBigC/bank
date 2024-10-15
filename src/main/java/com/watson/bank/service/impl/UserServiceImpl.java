package com.watson.bank.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watson.bank.domain.User;
import com.watson.bank.service.UserService;
import com.watson.bank.dao.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-10-15 15:13:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




