package com.watson.bank.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.watson.bank.domain.User;
import com.watson.bank.dao.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author watson
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




