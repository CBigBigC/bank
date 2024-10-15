package com.watson.bank.service;

import com.watson.bank.domain.Card;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【card(信用卡实体表)】的数据库操作Service
* @createDate 2024-10-15 15:13:48
*/
public interface CardService extends IService<Card> {

    Boolean addCard(Card card);

    List<Card> queryCard(Card card);
}
